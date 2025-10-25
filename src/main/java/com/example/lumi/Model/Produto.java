package com.example.lumi.Model;

public class Produto {
    // atributos
    private long codigoBarras;
    private String nome;
    private String fabricante;
    private String descricao;
    private double massa;
    private int idIndustria;
    private int idInfoNutri;

    // construtor


    public Produto(long codigoBarras, String nome, String fabricante, String descricao, double massa, int idIndustria, int idInfoNutri) {
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.fabricante = fabricante;
        this.descricao = descricao;
        this.massa = massa;
        this.idIndustria = idIndustria;
        this.idInfoNutri = idInfoNutri;
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    //pegar código para buscar favorito
    public Produto(long codigoBarras){this.codigoBarras=codigoBarras;}

    // getters
    public String getNome() {
        return this.nome;
    }
}
