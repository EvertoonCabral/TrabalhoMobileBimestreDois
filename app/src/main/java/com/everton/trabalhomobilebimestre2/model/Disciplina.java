package com.everton.trabalhomobilebimestre2.model;

import java.util.List;

public class Disciplina {

    private String nome;
    private List<Aluno>listaDeAlunos;

    public Disciplina(String nome, List<Aluno> listaDeAlunos) {
        this.nome = nome;
        this.listaDeAlunos = listaDeAlunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<Aluno> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }
}
