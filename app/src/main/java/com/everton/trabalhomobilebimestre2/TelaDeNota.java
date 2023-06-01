package com.everton.trabalhomobilebimestre2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.everton.trabalhomobilebimestre2.Adapters.alunoAdapter;
import com.everton.trabalhomobilebimestre2.Globais.Globais;
import com.everton.trabalhomobilebimestre2.model.Aluno;
import com.everton.trabalhomobilebimestre2.model.Nota;

import java.util.ArrayList;

public class TelaDeNota extends AppCompatActivity {

    private ListView lvAlunos;
    private Spinner spAlunoTelaAluno;
    private ArrayList<Aluno> listaAlunos;
    private Aluno alunoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_nota);

        spAlunoTelaAluno = findViewById(R.id.spAlunoTelaAluno);
        lvAlunos = findViewById(R.id.lvListaAluno);

        ArrayList<Aluno> listaAlunos = Globais.getListaAlunos();
        alunoAdapter adapter = new alunoAdapter(this, listaAlunos);
        spAlunoTelaAluno.setAdapter(adapter);
        spAlunoTelaAluno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoSelecionado = (Aluno) parent.getItemAtPosition(position);
                filtrarAlunosPorDisciplina(alunoSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Implementação necessária aqui se nada for selecionado
            }
        });

        Intent intent = getIntent();
        listaAlunos = (ArrayList<Aluno>) intent.getSerializableExtra("listaAlunos");

        atualizaLista(listaAlunos);

        lvAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                alunoSelecionado = (Aluno) parent.getItemAtPosition(position);
                exibirAlunoSelecionado(alunoSelecionado);
            }
        });
    }

    private void filtrarAlunosPorDisciplina(Aluno aluno) {
        ArrayList<Aluno> alunosFiltrados = new ArrayList<>();
        alunosFiltrados.add(aluno);

        alunoAdapter adapter = new alunoAdapter(this, alunosFiltrados);
        lvAlunos.setAdapter(adapter);
    }

    private void atualizaLista(ArrayList<Aluno> lista) {
        alunoAdapter adapter = new alunoAdapter(this, lista);
        lvAlunos.setAdapter(adapter);
    }

    private void exibirAlunoSelecionado(Aluno aluno) {
        StringBuilder notas = new StringBuilder();
        for (Nota nota : aluno.getListaNotas()) {
            notas.append("Disciplina: ").append(nota.getDisciplina())
                    .append(", Bimestre: ").append(nota.getBimestre())
                    .append(", Nota: ").append(nota.getNota())
                    .append("\n");
        }

        String mensagem = "RA: " + aluno.getRa() + "\nNome: " + aluno.getNome() + "\nNotas:\n" + notas.toString();
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
