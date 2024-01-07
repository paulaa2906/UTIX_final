package com.example.utixtest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.utixtest.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText registerEmail, registerPassword, registerUsername;
    private UserModel userModel;
    DatabaseReference database;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnSignIn = findViewById(R.id.signin);
        ImageButton btnBackRegis = findViewById(R.id.back_arrow_regis);
        auth = FirebaseAuth.getInstance();
        registerEmail = findViewById(R.id.email_regis);
        registerPassword = findViewById(R.id.password_regis);
        registerUsername = findViewById(R.id.name_regis);
        TextView loginRedirect = findViewById(R.id.txt_loginRedirect);

        database = FirebaseDatabase.getInstance("https://utix-test-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = registerUsername.getText().toString().trim();
                String user = registerEmail.getText().toString().trim();
                String pass = registerPassword.getText().toString().trim();

                if (user.isEmpty()) {
                    registerEmail.setError("Email cannot be empty");
                }
                if (pass.isEmpty()) {
                    registerPassword.setError("Password cannot be empty");
                } else {
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Registration successful
                                String userId = auth.getCurrentUser().getUid();
                                userModel = new UserModel(username, user, userId, pass);
                                UserIdDataPasser.getInstance().setUser_id(userId);
                                Log.d("Klee", "onComplete: " + userId);
                                // Store user data in Realtime Database under "users" node
                                DatabaseReference userRef = database.child("users").child(userId);
                                userRef.setValue(userModel);

                                Toast.makeText(RegisterActivity.this, "Your Account is Successfully Registered", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                            } else {
                                // Registration failed
                                Toast.makeText(RegisterActivity.this, "Register Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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

