package com.example.lumi.Model;

public class Plano {
    // atributos
    private String nome;
    private String descricao;
    private double preco;

    // construtores
    public Plano(String nome){
        this.nome=nome;
    }
    public Plano(String nome,String descricao,double preco) {
        this.nome = nome;
        this.descricao=descricao;
        this.preco=preco;
    }

    // getters
    public String getDescricao() {
        return descricao;
    }
    public double getPreco() {
        return preco;
    }
    public String getNome() {
        return nome;
    }
} // Plano
