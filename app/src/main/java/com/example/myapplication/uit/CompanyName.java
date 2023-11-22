package com.example.myapplication.uit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class CompanyName extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String imageUriString = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_name);

        ImageView imageView = findViewById(R.id.ivCompanyLogo); // Replace with your ImageView ID
        if (getIntent().hasExtra("imageUri")) {
            imageUriString = getIntent().getStringExtra("imageUri");
            Uri imageUri = Uri.parse(imageUriString);

            // Set the image in the ImageView
            imageView.setImageURI(imageUri);
        }

        TextView next_button = findViewById(R.id.tvNextBtnCompanyName);
        String finalImageUriString = imageUriString;
        next_button.setOnClickListener(view -> {
            Intent intent = new Intent(this, CompanyBio.class);
            intent.putExtra("imageUri", finalImageUriString);
            startActivity(intent);
            finish();
        });

        ImageView back_button = findViewById(R.id.ivBackBtnCompanyName);
        back_button.setOnClickListener(view -> {
            startActivity(new Intent(this, CompanyLogo.class));
        });

    }
}