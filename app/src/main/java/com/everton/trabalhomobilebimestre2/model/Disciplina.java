package com.everton.trabalhomobilebimestre2.model;

import java.util.List;

public class Disciplina {

   private int id;
   private String nomeDisciplina;
   private int primeiroBi =0, segundoBi=0, TerceiroBi=0, QuartoBi=0;

    public Disciplina() {
    }

    public Disciplina(int id, String nomeDisciplina, int primeiroBi, int segundoBi, int terceiroBi, int quartoBi) {
        this.id = id;
        this.nomeDisciplina = nomeDisciplina;
        this.primeiroBi = primeiroBi;
        this.segundoBi = segundoBi;
        this.TerceiroBi = terceiroBi;
        this.QuartoBi = quartoBi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getPrimeiroBi() {
        return primeiroBi;
    }

    public void setPrimeiroBi(int primeiroBi) {
        this.primeiroBi = primeiroBi;
    }

    public int getSegundoBi() {
        return segundoBi;
    }

    public void setSegundoBi(int segundoBi) {
        this.segundoBi = segundoBi;
    }

    public int getTerceiroBi() {
        return TerceiroBi;
    }

    public void setTerceiroBi(int terceiroBi) {
        TerceiroBi = terceiroBi;
    }

    public int getQuartoBi() {
        return QuartoBi;
    }

    public void setQuartoBi(int quartoBi) {
        QuartoBi = quartoBi;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                ", primeiroBi=" + primeiroBi +
                ", segundoBi=" + segundoBi +
                ", TerceiroBi=" + TerceiroBi +
                ", QuartoBi=" + QuartoBi +
                '}';
    }
}
