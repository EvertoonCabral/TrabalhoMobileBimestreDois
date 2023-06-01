package com.everton.trabalhomobilebimestre2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Nota implements Parcelable {
    private String disciplina;
    private String bimestre;
    private String nota;

    public Nota(String disciplina, String bimestre, String nota) {
        this.disciplina = disciplina;
        this.bimestre = bimestre;
        this.nota = nota;
    }

    protected Nota(Parcel in) {
        disciplina = in.readString();
        bimestre = in.readString();
        nota = in.readString();
    }

    public static final Creator<Nota> CREATOR = new Creator<Nota>() {
        @Override
        public Nota createFromParcel(Parcel in) {
            return new Nota(in);
        }

        @Override
        public Nota[] newArray(int size) {
            return new Nota[size];
        }
    };

    public String getDisciplina() {
        return disciplina;
    }

    public String getBimestre() {
        return bimestre;
    }

    public String getNota() {
        return nota;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(disciplina);
        dest.writeString(bimestre);
        dest.writeString(nota);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
