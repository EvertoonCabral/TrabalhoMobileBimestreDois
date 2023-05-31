package com.everton.trabalhomobilebimestre2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.everton.trabalhomobilebimestre2.model.Aluno;

public class MainActivity extends AppCompatActivity {


    private EditText edNome, edRa, edNota;
    private Spinner spDisciplina, spBimestre;
    private Button btnAdicionar, btnverNota, btnverMedia;

    private ListView lvListaAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();



        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nomeAluno = edNome.getText().toString();
                String raAluno = edRa.getText().toString();
                String notaAluno = edNota.getText().toString();
                String bimestreAluno = spBimestre.getSelectedItem().toString();
                String disciplinaAluno = spDisciplina.getSelectedItem().toString();

                Aluno aluno = new Aluno(raAluno, nomeAluno, disciplinaAluno, notaAluno);
                //ra nome discplina e nota



            }
        });


        btnverNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, TelaDeNota.class);
                startActivity(intent);
            }
        });


        btnverMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaDeNota.class);
                startActivity(intent);
            }
        });

    }



    public void iniciarComponentes(){

        edNome.findViewById(R.id.edNome);
        edNota.findViewById(R.id.edNota);
        edRa.findViewById(R.id.edRa);
        spBimestre.findViewById(R.id.spBimestre);
        spDisciplina.findViewById(R.id.spDisciplina);
        btnAdicionar.findViewById(R.id.btnAdicionar);
        btnverMedia.findViewById(R.id.btnverMedia);
        btnverNota.findViewById(R.id.btnverNota);
        lvListaAluno.findViewById(R.id.lvListaAluno);
    }

}