package com.example.utixtest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.utixtest.R;
import com.example.utixtest.helper.UserIdDataPasser;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class LoginActivity extends AppCompatActivity {
    private EditText loginEmail, loginPassword;
    private TextView signupRedirect;
    private FirebaseAuth auth;

    private  String userId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageButton btnBack = findViewById(R.id.back_arrow);
        Button btnLoginPage = findViewById(R.id.login);
        TextView regisRedirect = findViewById(R.id.registerRedirect);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        btnLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                String email = loginEmail.getText().toString();
                String pass = loginPassword.getText().toString();
                userId = UserIdDataPasser.getInstance().getUser_id();
                DatabaseReference reference = FirebaseDatabase.getInstance("https://utix-test-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("users");
                Query checkUser = reference.orderByChild(userId).equalTo("user_email");

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
//                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Failed to Log In", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        loginPassword.setError("This field is required");
                    }

                } else if (email.isEmpty()) {
                    loginEmail.setError("This field is required");
                } else {
                    loginEmail.setError("Email is not available");
                }
            }
        });


        regisRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
