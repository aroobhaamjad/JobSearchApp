package com.example.myapplication.uit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMain2Binding;

public class MainActivity extends AppCompatActivity {
    private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCreateAccount.setOnClickListener(view -> {
            startActivity(new Intent(this, ContinueAs.class));
            finish();
        });

        binding.tvSignIn.setOnClickListener(view -> {
            startActivity(new Intent(this, Sign_in.class));
            finish();
        });
    }
}