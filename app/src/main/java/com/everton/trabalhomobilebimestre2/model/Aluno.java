package com.everton.trabalhomobilebimestre2.model;

import java.util.ArrayList;

public class Aluno {

    private String ra;
    private String nome;
    private ArrayList<String>listadisciplina;
    private ArrayList<String> listaNotas;


    public Aluno(String ra, String nome, String disciplina, String nota) {
        this.ra = ra;
        this.nome = nome;
        this.listadisciplina = new ArrayList<>();
        this.listadisciplina.add(disciplina);
        this.listaNotas = new ArrayList<>();
        this.listaNotas.add(nota);
    }

    public Aluno() {
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getListadisciplina() {
        return listadisciplina;
    }

    public void setListadisciplina(ArrayList<String> listadisciplina) {
        this.listadisciplina = listadisciplina;
    }

    public ArrayList<String> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(ArrayList<String> listaNotas) {
        this.listaNotas = listaNotas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                ", listadisciplina=" + listadisciplina +
                ", listaNotas=" + listaNotas +
                '}';
    }

    public void AdicionarAluno(String materia){

    listadisciplina.add(materia);

    }
}
