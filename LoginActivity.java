package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.database.DbHandler;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    TextView signUp, forgotPassword;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().hide();

        username = findViewById(R.id.editTextUserName);
        username.setHint("Username");
        password = findViewById(R.id.editTextPassword);
        password.setHint("Password");
       signUp = findViewById(R.id.textViewSignup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent = new Intent(LoginActivity.this,SignupActivity.class);
                LoginActivity.this.startActivity(signupIntent);
                LoginActivity.this.finish();
            }
        });

        login = findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHandler dbHandler = new DbHandler( LoginActivity.this);
                boolean isExist = dbHandler.checkUserExist(username.getText().toString(), password.getText().toString());

                if(isExist){
                    Intent loginIntent = new Intent(LoginActivity.this,HomeActivity.class);
                    LoginActivity.this.startActivity(loginIntent);
                    LoginActivity.this.finish();
                } else {
                    password.setText(null);
                    Toast.makeText(LoginActivity.this, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPassword = findViewById(R.id.textViewForgotPassword);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotPasswordIntent = new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                LoginActivity.this.startActivity(forgotPasswordIntent);
                LoginActivity.this.finish();
            }
        });
    }
}
