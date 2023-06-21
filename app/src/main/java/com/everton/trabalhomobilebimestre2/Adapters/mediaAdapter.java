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

public class mediaAdapter  extends BaseAdapter {


    public mediaAdapter(Context context, ArrayList<Aluno> lista) {
        this.context = context;
        this.listaMedia = lista;
    }

    private ArrayList<Aluno> listaMedia;
    private Context context;
    private int mediaNota;
    private String aprovado;


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_media, parent, false);
        }

        Aluno aluno = listaMedia.get(position);

        mediaNota = (listaMedia.get(position).getDisciplina().getPrimeiroBi()
                + listaMedia.get(position).getDisciplina().getSegundoBi()
                + listaMedia.get(position).getDisciplina().getTerceiroBi()
                + listaMedia.get(position).getDisciplina().getQuartoBi())
                / 4;

        if (mediaNota >= 6) {
            aprovado = "Aprovado!";
        } else {
            aprovado = "Reprovado!";
        }

        TextView txtAluno = view.findViewById(R.id.txtNome);
        TextView txtRa = view.findViewById(R.id.txtRA);
        TextView txtAprovacao = view.findViewById(R.id.txtAprovado);
        TextView tvMediaFinal = view.findViewById(R.id.txtMediaAdapter);

        txtAluno.setText(aluno.getNome());
        txtRa.setText(txtRa.getText().toString() + aluno.getRa());
        txtAprovacao.setText(aprovado);
        tvMediaFinal.setText("Média Final: " + String.valueOf(mediaNota));

        return view;

    }
}
