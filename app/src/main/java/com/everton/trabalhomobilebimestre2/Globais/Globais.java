package com.everton.trabalhomobilebimestre2.Globais;


import com.everton.trabalhomobilebimestre2.model.Aluno;

import java.util.ArrayList;

public class Globais {
    public static ArrayList<Aluno> listaAlunos = new ArrayList<>();


    public Globais() {
    }

    public static ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public static void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        Globais.listaAlunos = listaAlunos;
    }
}
