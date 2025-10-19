package com.example.lumi.Model;

public class Favorito {
    // atributos
    private int id;
    private String emailCliente;
    private int idProduto;
    private String nomeProduto;
    private String nomeIndustria;

    // construtor
    public Favorito(int id, int idProduto,  String emailCliente) {
        this.id = id;
        this.idProduto = idProduto;
        this.emailCliente = emailCliente;
    }

    public Favorito(int id, String nomeProduto,  String emailCliente, String nomeIndustria) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.emailCliente = emailCliente;
        this.nomeIndustria = nomeIndustria;
    }

    // getters e setters
    public int getId() {
        return id;
    }
    public String getEmailCliente() {
        return emailCliente;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public String getNomeIndustria() {
        return nomeIndustria;
    }
}
