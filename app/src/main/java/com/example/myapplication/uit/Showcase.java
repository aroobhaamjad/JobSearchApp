package com.example.myapplication.uit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityShowcaseBinding;

public class Showcase extends AppCompatActivity {
    private ActivityShowcaseBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowcaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivSkipShowcase.setOnClickListener(view -> {
            startActivity(new Intent(this, CompanyLogo.class));
            finish();
        });

        binding.llNextBtnShowcase.setOnClickListener(view -> {
            startActivity(new Intent(this, PostJobs.class));
            finish();
        });
    }
}