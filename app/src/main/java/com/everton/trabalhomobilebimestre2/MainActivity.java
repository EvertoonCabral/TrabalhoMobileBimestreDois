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
    private String teste;
    private String aux2;


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
                Disciplina disciplina = (Disciplina) binding.spBimestre.getItemAtPosition(i);
                teste = disciplina.getNomeDisciplina();

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
    private void salvar() {

        int nota = 0;
        if (!binding.edNota.getText().toString().isEmpty()) {
            nota = Integer.parseInt(binding.edNota.getText().toString());
        }
        if (binding.edNome.getText().toString().isEmpty()) {
            binding.edNome.setError("Informe o Nome do Aluno");
        }
        if (binding.edNota.getText().toString().isEmpty()) {
            binding.edNota.setError("Informe a nota");
        }
        if (binding.edRa.getText().toString().isEmpty()) {
            binding.edRa.setError("Informe o RA do Aluno");
        }
        if (nota < 0 || nota > 10) {
            binding.edNota.setError("Informe uma nota entre 0 e 10");
        } else if (!binding.edNome.getText().toString().isEmpty()) {
        }
        try {

            Aluno aluno = new Aluno();

            int posicao= -1;

            for (int i = 0; i < Globais.listaNotasGlobais.size(); i++) {

                if (String.valueOf(Globais.listaNotasGlobais.get(i).getRa()).equals(binding.edRa.getText().toString())
                        && Globais.listaNotasGlobais.get(i).getNome().equals(binding.edNome.getText().toString())
                        && Globais.listaNotasGlobais.get(i).getDisciplina().getNomeDisciplina().equals(DisciplinaAux.getNomeDisciplina())) {

                    posicao = i;
                }
            }

            if (posicao == -1) {
                aluno.setNome(binding.edNome.getText().toString());
                aluno.setRa(binding.edRa.getText().toString());
                aluno.setDisciplina(DisciplinaAux);


                switch (aux2) {
                    case "1 Bi":
                        aluno.getDisciplina().setPrimeiroBi(Integer.parseInt(binding.edNota.getText().toString()));
                        break;
                    case "2 Bi":
                        aluno.getDisciplina().setSegundoBi(Integer.parseInt(binding.edNota.getText().toString()));
                        break;
                    case "3 Bi":
                        aluno.getDisciplina().setTerceiroBi(Integer.parseInt(binding.edNota.getText().toString()));
                        break;
                    case "4 Bi":
                        aluno.getDisciplina().setQuartoBi(Integer.parseInt(binding.edNota.getText().toString()));
                        break;
                }
                Globais.listaNotasGlobais.add(aluno);
                posicao = -1;
            }


            if (posicao != -1) {

                Globais.listaNotasGlobais.get(posicao).setNome(binding.edNome.getText().toString());
                Globais.listaNotasGlobais.get(posicao).setRa(binding.edRa.getText().toString());
                Globais.listaNotasGlobais.get(posicao).setDisciplina(DisciplinaAux);

                switch (aux2) {
                    case "1ºB":
                        Globais.listaNotasGlobais.get(posicao).getDisciplina().setPrimeiroBi(Integer.parseInt(binding.edNota.getText().toString()));
                        break;
                    case "2ºB":
                        Globais.listaNotasGlobais.get(posicao).getDisciplina().setSegundoBi(Integer.parseInt(binding.edNota.getText().toString()));
                        break;
                    case "3ºB":
                        Globais.listaNotasGlobais.get(posicao).getDisciplina().setTerceiroBi(Integer.parseInt(binding.edNota.getText().toString()));
                        break;
                    case "4ºB":
                        Globais.listaNotasGlobais.get(posicao).getDisciplina().setQuartoBi(Integer.parseInt(binding.edNota.getText().toString()));
                        break;
                }
                posicao = -1;
            }
            Toast.makeText(this, "Cadastro concluido.", Toast.LENGTH_LONG).show();


        } catch (Exception ex) {
            Log.e("Cadastro não concluido", ex.getMessage());
        }
    }




}
