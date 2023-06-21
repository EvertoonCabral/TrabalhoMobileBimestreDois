package com.everton.trabalhomobilebimestre2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.everton.trabalhomobilebimestre2.Adapters.notaAdapter;
import com.everton.trabalhomobilebimestre2.Globais.Globais;
import com.everton.trabalhomobilebimestre2.databinding.ActivityTelaDeNotaBinding;
import com.everton.trabalhomobilebimestre2.model.Aluno;

import java.util.ArrayList;

public class TelaNota extends AppCompatActivity {

    ActivityTelaDeNotaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaDeNotaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> alunosLista = new ArrayList<>();

        for (int i = 0; i < Globais.listaNotasGlobais.size(); i++) {
            String nome = Globais.listaNotasGlobais.get(i).getNome();
            if (!alunosLista.contains(nome)) {
                alunosLista.add(nome);
            }
        }

        ArrayAdapter adapterAlunos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunosLista);

        binding.spAlunoTelaAluno.setAdapter(adapterAlunos);

        binding.spAlunoTelaAluno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                atualizaLista(Globais.listaNotasGlobais, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void atualizaLista(ArrayList<Aluno> lista, int x) {

        ArrayList<Aluno>lista2 = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            String nome = binding.spAlunoTelaAluno.getItemAtPosition(x).toString();
            if (lista.get(i).getNome().equals(nome)) {
                lista2.add(lista.get(i));
            }
        }

        notaAdapter adapter = new notaAdapter(this, lista2);
        adapter.notifyDataSetChanged();
        binding.lvListaAluno.setAdapter(adapter);
    }



}

