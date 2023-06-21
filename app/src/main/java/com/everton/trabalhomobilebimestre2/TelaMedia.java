
package com.everton.trabalhomobilebimestre2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.everton.trabalhomobilebimestre2.Adapters.mediaAdapter;
import com.everton.trabalhomobilebimestre2.Globais.Globais;
import com.everton.trabalhomobilebimestre2.databinding.ActivityTelaMediaBinding;
import com.everton.trabalhomobilebimestre2.model.Aluno;
import com.everton.trabalhomobilebimestre2.model.Disciplina;

import java.util.ArrayList;

public class TelaMedia extends AppCompatActivity {

    ActivityTelaMediaBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaMediaBinding.inflate(getLayoutInflater());
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

        String[] listaDisciplina2 = new String[]{d1.getNomeDisciplina(), d2.getNomeDisciplina(), d3.getNomeDisciplina(), d4.getNomeDisciplina(), d5.getNomeDisciplina()};


        //Criar um adapter para disciplina

        ArrayAdapter adapterDisciplina = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaDisciplina2 );


        binding.spDisciplinaTelaMedia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        ArrayList<Aluno> lista2 = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            String nome = binding.spDisciplinaTelaMedia.getItemAtPosition(x).toString();
            if (lista.get(i).getDisciplina().getNomeDisciplina().equals(nome)) {
                lista2.add(lista.get(i));
            }

        }
        mediaAdapter adapter = new mediaAdapter(this, lista2);
        adapter.notifyDataSetChanged();
        binding.lvListaDisciplina.setAdapter(adapter);
    }



}

