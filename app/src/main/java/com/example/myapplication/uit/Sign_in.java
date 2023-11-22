package com.example.myapplication.uit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivitySignIn2Binding;

public class Sign_in extends AppCompatActivity {
    private ActivitySignIn2Binding binding;
    private EditText email;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignIn2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        email = binding.editTextTextEmailAddress2;
        password = binding.editTextTextPassword3;

        binding.tvSignUpNow.setOnClickListener(view -> {
            startActivity(new Intent(this, ContinueAs.class));
            finish();
        });

        binding.ivBackSignIn.setOnClickListener(view -> {
            startActivity(new Intent(this,MainActivity.class));
            finish();
        });

        binding.btnLogin.setOnClickListener(view -> {
            if(validateInput()) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        });


    }

    private boolean validateInput(){
        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();

        if(emailInput.isEmpty()){
            email.setError("Field can not be empty");
            if(passwordInput.isEmpty()){
                password.setError("Field can not be empty");
                return false;
            }
        }

        if(emailInput.isEmpty()){
            email.setError("Field can not be empty");
            return false;
        }

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (!emailInput.matches(emailPattern)) {
            email.setError("Invalid email address");
            return false;
        }

        if(passwordInput.isEmpty()){
            password.setError("Field can not be empty");
            return false;
        }

        int minLength = 8;
        if(passwordInput.length() < minLength){
            password.setError("Input must be at least " + minLength + " characters long");
            return false;
        }

        if(checkPasswordStrength(passwordInput)){
            return true;
        }
        else{
            return false;
        }

    }

    private boolean checkPasswordStrength(String passwordInput){
        String strength = PasswordChecker.checkPasswordStrength(passwordInput);

        switch (strength) {
            case "WEAK":
                binding.editTextTextPassword3.setBackground(getDrawable(R.drawable.rounded_corners_border_red));
                password.setError("Weak Password: Add digits and special characters");
                return false;
            case "MEDIUM":
                binding.editTextTextPassword3.setBackground(getDrawable(R.drawable.rounded_corners_border_yellow));
                password.setError("Weak Password: Add special characters");
                return false;
            case "STRONG":
                binding.editTextTextPassword3.setBackground(getDrawable(R.drawable.rounded_corners_borders_green_2));
                return true;
        }
        return true;

    }
}