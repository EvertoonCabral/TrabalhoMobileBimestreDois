package com.everton.trabalhomobilebimestre2.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Aluno  {
    private String ra;
    private String nome;
    private Disciplina disciplina;
    private int id;

    public Aluno() {
    }

    public Aluno(String ra, String nome, Disciplina disciplina, int id) {
        this.ra = ra;
        this.nome = nome;
        this.disciplina = disciplina;
        this.id = id;
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ra='" + ra + '\'' +
                ", nome='" + nome + '\'' +
                ", disciplina=" + disciplina +
                ", id=" + id +
                '}';
    }

    public int CalcularMedia(int b1, int b2,int b3, int b4){

      int media = (b1 + b2 + b3 + b4)/4;

        return media;
    }

}
