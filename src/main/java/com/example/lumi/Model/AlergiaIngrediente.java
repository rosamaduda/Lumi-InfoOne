package com.example.lumi.Model;

public class AlergiaIngrediente {
    // atributos
    private int id;
    private int idAlergia;
    private String nomeAlergia;

    // construtor
    public AlergiaIngrediente(int id, int idAlergia, String nomeAlergia) {
        this.id = id;
        this.idAlergia = idAlergia;
        this.nomeAlergia = nomeAlergia;
    }



    // getters e setters
    public int getId() {
        return id;
    }
    public int getIdAlergia() {
        return idAlergia;
    }
    public String getNomeAlergia() {
        return nomeAlergia;
    }
}
