package com.everton.trabalhomobilebimestre2.Globais;


import com.everton.trabalhomobilebimestre2.model.Aluno;

import java.util.ArrayList;
import java.util.List;

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
    public List<Aluno> filtrarAlunosPorDisciplina(String disciplina) {
        List<Aluno> alunosFiltrados = new ArrayList<>();
        for (Aluno aluno : listaAlunos) {
            if (aluno.getDisciplina().equalsIgnoreCase(disciplina)) {
                alunosFiltrados.add(aluno);
            }
        }
        return alunosFiltrados;
    }

}
