package com.everton.trabalhomobilebimestre2.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Aluno implements Parcelable {
    private String ra;
    private String nome;
    private ArrayList<Nota> listaNotas;

    private String disciplina;

    public Aluno(String ra, String nome) {
        this.ra = ra;
        this.nome = nome;
        this.listaNotas = new ArrayList<>();
    }

    protected Aluno(Parcel in) {
        ra = in.readString();
        nome = in.readString();
        listaNotas = in.createTypedArrayList(Nota.CREATOR);
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

    public String getDisciplina() {
        return disciplina;
    }

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Nota> getListaNotas() {
        return listaNotas;
    }

    public void adicionarNota(String disciplina, String bimestre, String nota) {
        Nota novaNota = new Nota(disciplina, bimestre, nota);
        listaNotas.add(novaNota);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ra);
        dest.writeString(nome);
        dest.writeTypedList(listaNotas);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
