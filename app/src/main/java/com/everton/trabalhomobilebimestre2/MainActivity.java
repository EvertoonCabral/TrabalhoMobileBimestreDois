package com.everton.trabalhomobilebimestre2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.everton.trabalhomobilebimestre2.model.Aluno;

public class MainActivity extends AppCompatActivity {


    private EditText edNome, edRa, edNota;
    private Spinner spDisciplina, spBimestre;
    private Button btnAdicionar, btnverNota, btnverMedia;

    private String[] disciplinas = {"Selecione uma disciplina","POO", "Desenvolvimento Mobile", "Desenvolvimento Web", "Frameworks", "Gestão de Projetos"};
    private String[] bimestres = {"Selecione um Bimestre","1º Bimestre", "2º Bimestre", "3º Bimestre", "4º Bimestre"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IniciarComponents();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, disciplinas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Definir o adaptador no Spinner
        spDisciplina.setAdapter(adapter);

        ArrayAdapter<String> bimestreAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bimestres);
        bimestreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBimestre.setAdapter(bimestreAdapter);


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

                Toast.makeText(MainActivity.this, "Usuário Salvo com Sucesso!", Toast.LENGTH_SHORT).show();

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


public void IniciarComponents(){

    edNome = findViewById(R.id.EdNome);
    edNota = findViewById(R.id.edNota);
    edRa = findViewById(R.id.edRa);
    spBimestre = findViewById(R.id.spBimestre);
    spDisciplina = findViewById(R.id.spDisciplina);
    btnAdicionar = findViewById(R.id.btnAdicionar);
    btnverMedia = findViewById(R.id.btnverMedia);
    btnverNota = findViewById(R.id.btnverNota);

}


}