package com.everton.trabalhomobilebimestre2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.everton.trabalhomobilebimestre2.R;
import com.everton.trabalhomobilebimestre2.model.Aluno;

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

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.list_item_aluno, viewGroup, false);
        }

        Aluno aluno = listaAluno.get(i);
        TextView tvNomeAluno = view.findViewById(R.id.txtNome);
        TextView tvRaAluno = view.findViewById(R.id.txtRA);

        tvRaAluno.setText(String.valueOf(aluno.getRa()));
        tvNomeAluno.setText(aluno.getNome());

        return view;
    }


}
