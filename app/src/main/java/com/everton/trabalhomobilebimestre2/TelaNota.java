package com.everton.trabalhomobilebimestre2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.everton.trabalhomobilebimestre2.databinding.ActivityTelaDeNotaBinding;

public class TelaNota extends AppCompatActivity {

    ActivityTelaDeNotaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaDeNotaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}