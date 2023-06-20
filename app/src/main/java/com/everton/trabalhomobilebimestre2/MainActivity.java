package com.everton.trabalhomobilebimestre2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.everton.trabalhomobilebimestre2.Globais.Globais;
import com.everton.trabalhomobilebimestre2.databinding.ActivityMainBinding;
import com.everton.trabalhomobilebimestre2.model.Aluno;
import com.everton.trabalhomobilebimestre2.model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private String[] listaBimestres = new String[]{"Escolha...", "1ºB", "2ºB", "3ºB", "4ªB"};
    private Disciplina DisciplinaAux;
    private String aux;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Disciplina d1 = new Disciplina();
        d1.setId(01);
        d1.setNomeDisciplina("Desenvolimento Mobile");

        Disciplina d2 = new Disciplina();
        d2.setId(02);
        d2.setNomeDisciplina("Desenvolimento Baseado em Frameworks");

        Disciplina d3 = new Disciplina();
        d3.setId(03);
        d3.setNomeDisciplina("Desenvolimento Web");

        Disciplina d4 = new Disciplina();
        d4.setId(04);
        d4.setNomeDisciplina("Estagio Obrigatorio");


        Disciplina d5 = new Disciplina();
        d4.setId(05);
        d4.setNomeDisciplina("Empreendedorismo");

        Disciplina[] listaDisciplina = new Disciplina[]{d1, d2, d3, d4, d5};


        ArrayAdapter adapterBimestre = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDisciplina);


        List<String> NomesDisciplinas = new ArrayList<>();
        for (Disciplina disciplina : listaDisciplina) {
            NomesDisciplinas.add(disciplina.getNomeDisciplina());

        }
        ArrayAdapter<String> adapterDisciplina = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NomesDisciplinas);

        binding.spDisciplina.setAdapter(adapterDisciplina);
        binding.spBimestre.setAdapter(adapterBimestre);


        binding.spDisciplina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String nomeDisciplina = (String) binding.spDisciplina.getItemAtPosition(i);

                Disciplina disciplinaSelecionada = null;

                for (Disciplina disciplina : listaDisciplina) {
                    if (disciplina.getNomeDisciplina().equals(nomeDisciplina)) {
                        disciplinaSelecionada = disciplina;
                        DisciplinaAux = disciplinaSelecionada;
                        break;
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.spBimestre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                aux = (String) binding.spBimestre.getItemAtPosition(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if (Globais.listaNotasGlobais == null) {
            Globais.listaNotasGlobais = new ArrayList<>();

            }
           // binding.btnAdicionar.setOnClickListener(view -> AdicionarAluno());

            binding.btnverMedia.setOnClickListener(view -> {

                MostrarMedia();

            });

            binding.btnverNota.setOnClickListener(view -> {

                MostrarNota();

            });

    }


    private void MostrarNota() {

        Intent intent = new Intent(this, TelaNota.class);
        startActivity(intent);
    }
    private void MostrarMedia() {
            Intent intent = new Intent(this, TelaMedia.class);
            startActivity(intent);
    }



    }
