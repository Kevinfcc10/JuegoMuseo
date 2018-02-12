package com.example.kevin.juegomuseo;

/**
 * Created by Daniela on 12/18/2017.
 */

public class Animal {

    int codAnimal;
    String nomAnimal;
    String descAnimal;
    String imgAnimal;
    String codEcosistema;


    public int getCodAnimal() {return codAnimal;}

    public void setCodAnimal(int codAnimal) {
        this.codAnimal = codAnimal;
    }

    public String getNomAnimal() {
        return nomAnimal;
    }

    public void setNomAnimal(String nomAnimal) {
        this.nomAnimal = nomAnimal;
    }

    public String getDescAnimal() {
        return descAnimal;
    }

    public void setDescAnimal(String descAnimal) {
        this.descAnimal = descAnimal;
    }

    public String getImgAnimal() {
        return imgAnimal;
    }

    public void setImgAnimal(String imgAnimal) {
        this.imgAnimal = imgAnimal;
    }

    public String getCodEcosistema() {
        return codEcosistema;
    }

    public void setCodEcosistema(String codEcosistema) {
        this.codEcosistema = codEcosistema;
    }

    public Animal(){    }


    public Animal(int codAnimal, String nomAnimal, String descAnimal, String imgAnimal, String codEcosistema) {
        this.codAnimal = codAnimal;
        this.nomAnimal = nomAnimal;
        this.descAnimal = descAnimal;
        this.imgAnimal = imgAnimal;
        this.codEcosistema = codEcosistema;
    }

    public Animal(String nomAnimal, String descAnimal, String imgAnimal, String codEcosistema) {
        this.nomAnimal = nomAnimal;
        this.descAnimal = descAnimal;
        this.imgAnimal = imgAnimal;
        this.codEcosistema = codEcosistema;
    }
}
