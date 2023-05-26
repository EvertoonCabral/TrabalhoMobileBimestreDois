package com.everton.trabalhomobilebimestre2.model;

import java.util.ArrayList;

public class Aluno {

    private int ra;
    private String nome;
    private ArrayList<Disciplina> listadisciplina;


    public Aluno(int ra, String nome, ArrayList<Disciplina> listadisciplina) {
        this.ra = ra;
        this.nome = nome;
        this.listadisciplina = listadisciplina;
    }

    public Aluno() {
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Disciplina> getListadisciplina() {
        return listadisciplina;
    }

    public void setListadisciplina(ArrayList<Disciplina> listadisciplina) {
        this.listadisciplina = listadisciplina;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                ", listadisciplina=" + listadisciplina +
                '}';
    }
}
