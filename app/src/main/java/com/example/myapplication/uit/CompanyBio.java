package com.example.myapplication.uit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class CompanyBio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String imageUriString = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_bio);

        ImageView imageView = findViewById(R.id.ivCompanyBio); // Replace with your ImageView ID
        if (getIntent().hasExtra("imageUri")) {
            imageUriString = getIntent().getStringExtra("imageUri");
            Uri imageUri = Uri.parse(imageUriString);

            // Set the image in the ImageView
            imageView.setImageURI(imageUri);
        }

        ImageView back_button = findViewById(R.id.ivBackBtnCompanyBio);
        back_button.setOnClickListener(view -> {
            startActivity(new Intent(this, CompanyName.class));
        });

        TextView next_button = findViewById(R.id.tvNextBtnCompanyBio);
        String finalImageUriString = imageUriString;
        next_button.setOnClickListener(view -> {
            Intent intent = new Intent(this, Industry.class);
            intent.putExtra("imageUri", finalImageUriString);
            startActivity(intent);
            finish();
        });
    }
}