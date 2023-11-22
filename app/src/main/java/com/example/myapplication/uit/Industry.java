package com.example.myapplication.uit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;

public class Industry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView textView;
        boolean[] selectedIndustry;
        ArrayList<Integer> industryList = new ArrayList<>();
        String[] industryArray = {"Tech", "FinTech", "Cyber Security", "Artificial Intelligence", "Hardware", "SaaS"};
        String imageUriString = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry);

        selectedIndustry = new boolean[industryArray.length];

        ImageView imageView = findViewById(R.id.ivIndustry); // Replace with your ImageView ID
        if (getIntent().hasExtra("imageUri")) {
            imageUriString = getIntent().getStringExtra("imageUri");
            Uri imageUri = Uri.parse(imageUriString);

            // Set the image in the ImageView
            imageView.setImageURI(imageUri);
        }

        TextView next_button = findViewById(R.id.tvNextBtnIndustry);
        String finalImageUriString = imageUriString;
        next_button.setOnClickListener(view -> {
            Intent intent = new Intent(this, CompanyBio.class);
            intent.putExtra("imageUri", finalImageUriString);
            startActivity(intent);
            finish();
        });

        ImageView back_button = findViewById(R.id.ivBackBtnIndustry);
        back_button.setOnClickListener(view -> {
            startActivity(new Intent(this, CompanyBio.class));
        });

        textView = findViewById(R.id.tvDropDown);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Industry.this);
                builder.setTitle("Select Industry");

                builder.setCancelable(false);

                builder.setMultiChoiceItems(industryArray, selectedIndustry, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        // check condition
                        if (b) {
                            // when checkbox selected
                            // Add position  in lang list
                            industryList.add(i);
                            // Sort array list
                            Collections.sort(industryList);
                        } else {
                            // when checkbox unselected
                            // Remove position from langList
                            industryList.remove(Integer.valueOf(i));
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int j = 0; j < industryList.size(); j++) {
                            stringBuilder.append(industryArray[industryList.get(j)]);
                            if (j != industryList.size() - 1) {
                                stringBuilder.append(", ");
                            }
                        }
                        textView.setText(stringBuilder.toString());
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dismiss dialog
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // use for loop
                        for (int j = 0; j < selectedIndustry.length; j++) {
                            selectedIndustry[j] = false;
                            industryList.clear();
                            textView.setText("");
                        }
                    }
                });
                builder.show();
            }
        });
    }
}