package com.example.myapplication.uit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityPostJobsBinding;

public class PostJobs extends AppCompatActivity {
    private ActivityPostJobsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostJobsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivSkip.setOnClickListener(view -> {
            startActivity(new Intent(this, CompanyLogo.class));
            finish();
        });

        binding.llNextBtn.setOnClickListener(view -> {
            startActivity(new Intent(this, Connect.class));
            finish();
        });
    }
}