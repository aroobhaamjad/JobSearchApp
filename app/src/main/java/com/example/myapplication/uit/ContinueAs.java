package com.example.myapplication.uit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityContinueAsBinding;

public class ContinueAs extends AppCompatActivity {
    private ActivityContinueAsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContinueAsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivCompany.setOnClickListener(view -> {
            binding.ivCompany.setImageResource(R.drawable.comp);
            startActivity(new Intent(this,Showcase.class));
            finish();
        });

        binding.ivMembers.setOnClickListener(view -> {
            binding.ivMembers.setImageResource(R.drawable.mem);
            startActivity(new Intent(this,GenderProportion.class));
            finish();
        });

        binding.ivTeamMembers.setOnClickListener(view -> {
            binding.ivTeamMembers.setImageResource(R.drawable.tmem);
        });
    }
}