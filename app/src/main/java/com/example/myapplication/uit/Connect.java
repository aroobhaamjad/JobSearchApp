package com.example.myapplication.uit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityConnectBinding;

public class Connect extends AppCompatActivity {
    private ActivityConnectBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConnectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.llNextBtnConnect.setOnClickListener(view -> {
            startActivity(new Intent(this, CompanyLogo.class));
            finish();
        });
    }
}