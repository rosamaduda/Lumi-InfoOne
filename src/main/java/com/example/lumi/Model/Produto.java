package com.example.lumi.Model;

public class Produto {
    // atributos
    private String codigoBarras;
    private String nome;
    private String fabricante;
    private String descricao;
    private double massa;
    private int idIndustria;
    private int idInfoNutri;

    // construtor


    public Produto(String codigoBarras, String nome, String fabricante, String descricao, double massa, int idIndustria, int idInfoNutri) {
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.fabricante = fabricante;
        this.descricao = descricao;
        this.massa = massa;
        this.idIndustria = idIndustria;
        this.idInfoNutri = idInfoNutri;
    }


    public Produto(String codigoBarras){this.codigoBarras=codigoBarras;}

    // getters
    public String getNome() {
        return this.nome;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getMassa() {
        return massa;
    }

    public int getIdIndustria() {
        return idIndustria;
    }

    public int getIdInfoNutri() {
        return idInfoNutri;
    }
}
