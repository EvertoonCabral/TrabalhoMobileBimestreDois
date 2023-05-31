package com.everton.trabalhomobilebimestre2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.everton.trabalhomobilebimestre2.Adapters.alunoAdapter;
import com.everton.trabalhomobilebimestre2.Util.Globais;
import com.everton.trabalhomobilebimestre2.model.Aluno;

import java.util.ArrayList;

public class TelaDeNota extends AppCompatActivity {

    private ListView lvAlunos;

    private Aluno alunoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_nota);

        lvAlunos = findViewById(R.id.lvListaAluno);

        atualizaLista(Globais.listaAluno);

        lvAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // alunoSelecionado = (Aluno) lvAlunos.getItemAtPosition();

                exibirAlunoSelecionado(alunoSelecionado);

            }
        });


    }

    private void atualizaLista(ArrayList<Aluno> lista){
        alunoAdapter adapter = new alunoAdapter(this, lista);
        lvAlunos.setAdapter(adapter);
    }

    private void exibirAlunoSelecionado(Aluno aluno){

        Toast.makeText(this, "RA: "+aluno.getRa()+" Nome: "+aluno.getNome(),Toast.LENGTH_LONG).show();

    }



}