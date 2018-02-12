package com.example.kevin.juegomuseo;

/**
 * Created by Daniela on 12/18/2017.
 */

public class Ecosistema {

    int codEcosistema;
    String nomEcosistema;
    String descEcosistema;
    String regEcosistema;
    String imgEcosistema;

    public int getCodEcosistema() {return codEcosistema;}

    public void setCodEcosistema(int codEcosistema) {
        this.codEcosistema = codEcosistema;
    }

    public String getNomEcosistema() {
        return nomEcosistema;
    }

    public void setNomEcosistema(String nomEcosistema) {
        this.nomEcosistema = nomEcosistema;
    }

    public String getDescEcosistema() {
        return descEcosistema;
    }

    public void setDescEcosistema(String descEcosistema) {
        this.descEcosistema = descEcosistema;
    }

    public String getRegEcosistema() {
        return regEcosistema;
    }

    public void setRegEcosistema(String regEcosistema) {
        this.regEcosistema = regEcosistema;
    }

    public String getImgEcosistema() {
        return imgEcosistema;
    }

    public void setImgEcosistema(String imgEcosistema) {
        this.imgEcosistema = imgEcosistema;
    }

    public Ecosistema(){    }

    public Ecosistema(int codEcosistema, String nomEcosistema, String descEcosistema, String regEcosistema, String imgEcosistema) {
        this.codEcosistema = codEcosistema;
        this.nomEcosistema = nomEcosistema;
        this.descEcosistema = descEcosistema;
        this.regEcosistema = regEcosistema;
        this.imgEcosistema = imgEcosistema;
    }

    public Ecosistema(String nomEcosistema, String descEcosistema, String regEcosistema, String imgEcosistema) {
        this.nomEcosistema = nomEcosistema;
        this.descEcosistema = descEcosistema;
        this.regEcosistema = regEcosistema;
        this.imgEcosistema = imgEcosistema;
    }
}
