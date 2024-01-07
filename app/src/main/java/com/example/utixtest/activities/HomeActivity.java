package com.example.utixtest.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.utixtest.R;
import com.example.utixtest.fragments.FragmentTicket;
import com.example.utixtest.fragments.FragmentAccount;
import com.example.utixtest.fragments.FragmentHome;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;

    private FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment homeFragment = new FragmentHome();

    private Fragment accountFragment = new FragmentAccount();

    private Fragment ticketFragment = new FragmentTicket();

    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        navigationView = findViewById(R.id.navigation);

        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        fragmentManager.beginTransaction().add(R.id.fragment_container_main, homeFragment)
                .hide(homeFragment).commit();

        fragmentManager.beginTransaction().add(R.id.fragment_container_main, accountFragment)
                .hide(accountFragment).commit();

        fragmentManager.beginTransaction().add(R.id.fragment_container_main, ticketFragment)
                .hide(ticketFragment).commit();

        activeFragment = homeFragment;

        showIntialFragment(activeFragment);

}

    private void showIntialFragment(Fragment fragment) {
        if (fragment == activeFragment) {
            fragmentManager.beginTransaction()
                    .show(fragment)
                    .commit();
            activeFragment = fragment;
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.navigation_bar_home){
            fragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(homeFragment)
                    .commit();
            activeFragment = homeFragment;
            return true;
        } else if (item.getItemId() == R.id.navigation_bar_account) {
            fragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(accountFragment)
                    .commit();
            activeFragment = accountFragment;
            return true;
        } else if (item.getItemId() == R.id.navigation_bar_ticket) {
            fragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(ticketFragment)
                    .commit();
            activeFragment = ticketFragment;
            return true;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}