package com.everton.trabalhomobilebimestre2.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Aluno implements Parcelable {

    private String ra;
    private String nome;
    private ArrayList<String> listadisciplina;
    private ArrayList<String> listaNotas;

    public Aluno(String ra, String nome, String disciplina, String nota) {
        this.ra = ra;
        this.nome = nome;
        this.listadisciplina = new ArrayList<>();
        this.listadisciplina.add(disciplina);
        this.listaNotas = new ArrayList<>();
        this.listaNotas.add(nota);
    }

    protected Aluno(Parcel in) {
        ra = in.readString();
        nome = in.readString();
        listadisciplina = in.createStringArrayList();
        listaNotas = in.createStringArrayList();
    }

    public static final Creator<Aluno> CREATOR = new Creator<Aluno>() {
        @Override
        public Aluno createFromParcel(Parcel in) {
            return new Aluno(in);
        }

        @Override
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getListadisciplina() {
        return listadisciplina;
    }

    public ArrayList<String> getListaNotas() {
        return listaNotas;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ra);
        dest.writeString(nome);
        dest.writeStringList(listadisciplina);
        dest.writeStringList(listaNotas);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
