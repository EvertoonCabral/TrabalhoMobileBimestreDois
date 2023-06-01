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

import com.everton.trabalhomobilebimestre2.Globais.Globais;
import com.everton.trabalhomobilebimestre2.model.Aluno;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edNome, edRa, edNota;
    private Spinner spDisciplina, spBimestre;
    private Button btnAdicionar, btnverNota, btnverMedia;

    private String[] disciplinas = {"POO", "Desenvolvimento Mobile", "Desenvolvimento Web", "Frameworks", "Gestão de Projetos"};
    private String[] bimestres = {"1ºBim", "2ºBim", "3ºBim", "4ºBim"};
    private Globais globais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponents();

        globais = new Globais();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, disciplinas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDisciplina.setAdapter(adapter);

        ArrayAdapter<String> bimestreAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bimestres);
        bimestreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBimestre.setAdapter(bimestreAdapter);


        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeAluno = edNome.getText().toString();
                String raAluno = edRa.getText().toString();

                Aluno aluno = new Aluno(raAluno, nomeAluno);
                Globais.listaAlunos.add(aluno);


                Toast.makeText(MainActivity.this, "Usuário Salvo com Sucesso!", Toast.LENGTH_SHORT).show();
                limparCampos();
            }
                    });

        btnverNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, TelaDeNota.class);
                ArrayList<Aluno> listaAlunos = globais.getListaAlunos(); //Ali em cima eu mandei o aluno para a lista aluno no globais, agora to trazendo para esta lista

                if (listaAlunos != null) {
                    intent.putExtra("listaAlunos", listaAlunos);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Lista de alunos vazia", Toast.LENGTH_SHORT).show();
                }
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
    private void limparCampos() {
        edNome.setText("");
        edRa.setText("");
        spDisciplina.setSelection(0);
        spBimestre.setSelection(0);
        edNota.setText("");
    }
}
