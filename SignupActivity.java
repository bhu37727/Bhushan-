package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.database.DbHandler;

public class SignupActivity extends AppCompatActivity {

    EditText name, email, phone, userName, password, confirmPassword;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //getSupportActionBar().hide();

        name = findViewById(R.id.editTextName);
        name.setHint("Name");
        email = findViewById(R.id.editTextEmail);
        email.setHint("Email");
        phone = findViewById(R.id.editTextPhone);
        phone.setHint("Phone");
        userName = findViewById(R.id.editTextUserName);
        userName.setHint("User Name");
        password = findViewById(R.id.editTextPassword);
        password.setHint("Password");
        confirmPassword = findViewById(R.id.editTextConfirmPassword);
        confirmPassword.setHint("Confirm Password");
        signUp = findViewById(R.id.buttonSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uName = name.getText().toString()+"\n";
                String uEmail = email.getText().toString();
                String uPhone = phone.getText().toString()+"\n";
                int phoneNumber = Integer.parseInt(phone.getText().toString());
                String username = userName.getText().toString();
                String uPassword = password.getText().toString();
                String confPassword = confirmPassword.getText().toString();
                if(uPassword != confPassword){
                    Toast.makeText(getApplicationContext(), "Passwords don't match",Toast.LENGTH_SHORT).show();
                }

                DbHandler dbHandler = new DbHandler(SignupActivity.this);
                dbHandler.insertUserDetails(uName,uEmail,phoneNumber,username,uPassword);
                Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();
                Intent signupIntent = new Intent(SignupActivity.this,HomeActivity.class);
                SignupActivity.this.startActivity(signupIntent);
                SignupActivity.this.finish();
            }
        });
    }
}
