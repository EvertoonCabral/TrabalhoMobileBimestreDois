package com.everton.trabalhomobilebimestre2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.everton.trabalhomobilebimestre2.R;
import com.everton.trabalhomobilebimestre2.model.Aluno;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class notaAdapter extends BaseAdapter {


    private ArrayList<Aluno> listaAluno;
    private Context context;

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
    public View getView(int i, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_aluno, parent, false);
        }
        //Iniciar o aluno e linkar com os componentes xml.
            Aluno aluno = listaAluno.get(i);
            TextView txtMedia = convertView.findViewById(R.id.txtMedia);
            TextView txtMateria = convertView.findViewById(R.id.txtMateria);
            //Bimestres
            TextView txtBi1 = convertView.findViewById(R.id.ItemB1);
            TextView txtBi2 = convertView.findViewById(R.id.ItemB2);
            TextView txtBi3 = convertView.findViewById(R.id.ItemB3);
            TextView txtBi4 = convertView.findViewById(R.id.ItemB4);
//Calcular a media
            int bi1 = aluno.getDisciplina().getPrimeiroBi();
            int bi2 = aluno.getDisciplina().getSegundoBi();
            int bi3 = aluno.getDisciplina().getTerceiroBi();
            int bi4 = aluno.getDisciplina().getQuartoBi();

            int mediaNota;
            mediaNota = aluno.CalcularMedia(bi1, bi2, bi3, bi4);

            txtMateria.setText(aluno.getDisciplina().getNomeDisciplina());
            txtBi1.setText("1° Bim: " + bi1);
            txtBi2.setText("2° Bim: " + bi2);
            txtBi3.setText("3° Bim: " + bi3);
            txtBi4.setText("4° Bim: " + bi4);
            txtMedia.setText("Média: " + mediaNota);

            return convertView;
        }

    }

