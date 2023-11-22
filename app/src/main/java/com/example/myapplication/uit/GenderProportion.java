package com.example.myapplication.uit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.SeekBar;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityGenderProportionBinding;
import com.example.myapplication.databinding.ActivitySignIn2Binding;

import hearsilent.discreteslider.DiscreteSlider;

public class GenderProportion extends AppCompatActivity {
    private ActivityGenderProportionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenderProportionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupSliderListener(binding.sbMaleSlider);
        setupSliderListener(binding.sbFemaleSlider);
        setupSliderListener(binding.sbNonBinarySlider);
    }

    private void setupSliderListener(final DiscreteSlider slider) {
        slider.setOnValueChangedListener(new DiscreteSlider.OnValueChangedListener(){
            @Override
            public void onValueChanged(int progress, boolean fromUser) {
                updateSum();
            }
        });
    }

    private void updateSum() {
        int sum = binding.sbMaleSlider.getProgress() + binding.sbFemaleSlider.getProgress() + binding.sbNonBinarySlider.getProgress();
        binding.tvSumProgress.setText(sum + "%");
    }

}