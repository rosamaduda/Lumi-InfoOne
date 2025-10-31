package com.example.lumi.Model;

public class Favorito {
    // atributos
    private int id;
    private String emailCliente;
    private long codProduto;

    // construtores
    public Favorito(int id,String emailCliente){
        this.id=id;
        this.emailCliente=emailCliente;
    }

    public Favorito(int id,String emailCliente,int cod_prduto) {
        this.id = id;
        this.emailCliente = emailCliente;
        this.codProduto = cod_prduto;
    }

    // getters
    public int getId() {
        return id;
    }
    public String getEmailCliente() {
        return this.emailCliente;
    }
    public long getCodProduto() {return this.codProduto;}
} // Favorito
