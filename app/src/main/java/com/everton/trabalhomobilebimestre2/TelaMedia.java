
package com.everton.trabalhomobilebimestre2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.everton.trabalhomobilebimestre2.databinding.ActivityTelaMediaBinding;

public class TelaMedia extends AppCompatActivity {

    ActivityTelaMediaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaMediaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}