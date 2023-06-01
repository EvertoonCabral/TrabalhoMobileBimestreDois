package com.everton.trabalhomobilebimestre2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.everton.trabalhomobilebimestre2.R;
import com.everton.trabalhomobilebimestre2.model.Aluno;
import com.everton.trabalhomobilebimestre2.model.Nota;

import java.util.ArrayList;

public class alunoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Aluno> listaAluno;

    public alunoAdapter(Context context, ArrayList<Aluno> listaAluno) {
        this.context = context;
        this.listaAluno = listaAluno;
    }

    @Override
    public int getCount(){
        return listaAluno.size();
    }

    @Override
    public Object getItem(int i){
        return listaAluno.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item_aluno, parent, false);
        }

        Aluno aluno = listaAluno.get(position);
        TextView tvNome = convertView.findViewById(R.id.txtNomeAluno);
        TextView tvRA = convertView.findViewById(R.id.txtRaAluno);
        TextView tvDisciplina = convertView.findViewById(R.id.txtDisciplina);
        TextView tvNota = convertView.findViewById(R.id.txtNota);

        tvNome.setText("Aluno: " + aluno.getNome()); // Preencher com o nome do aluno
        tvRA.setText("RA: " + aluno.getRa()); // Preencher com o RA do aluno

        // Preencher as disciplinas e notas
        String disciplinasNotas = "";
        for (Nota nota : aluno.getListaNotas()) {
            String disciplina = nota.getDisciplina();
            String bimestre = nota.getBimestre();
            String notaText = nota.getNota();
            disciplinasNotas += "Disciplina: " + disciplina + "\nBimestre: " + bimestre + ", Nota: " + notaText + "\n\n";
        }
        tvDisciplina.setText(disciplinasNotas);

        return convertView;
    }





    public View getRetornoView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(android.R.layout.simple_spinner_item, viewGroup, false);
        }

        Aluno aluno = listaAluno.get(i);
        TextView tvNomeAluno = view.findViewById(android.R.id.text1);

        tvNomeAluno.setText(aluno.getNome()); // vai exibir apenas o nome do aluno

        return view;
    }



}
