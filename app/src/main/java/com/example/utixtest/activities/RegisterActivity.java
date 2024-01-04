package com.example.utixtest.activities;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText registerEmail, registerPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnSignIn = findViewById(R.id.signin);
        ImageButton btnBackRegis = findViewById(R.id.back_arrow_regis);
        auth = FirebaseAuth.getInstance();
        registerEmail = findViewById(R.id.email_regis);
        registerPassword = findViewById(R.id.password_regis);
        TextView loginRedirect = findViewById(R.id.txt_loginRedirect);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = registerEmail.getText().toString().trim();
                String pass = registerPassword.getText().toString().trim();
                if (user.isEmpty()){
                    registerEmail.setError("Email cannot be empty");
                }
                if (pass.isEmpty()){
                    registerPassword.setError("Password cannot be empty");
                } else{
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Your Account is Succesfully Register", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                            }else {
                                Toast.makeText(RegisterActivity.this, "Register Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        btnBackRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

        loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });


    }
}
