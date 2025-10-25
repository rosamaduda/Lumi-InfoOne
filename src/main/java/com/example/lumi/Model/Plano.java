package com.example.lumi.Model;

public class Plano {
    private String nome;
    private String descricao;
    private double preco;
    public Plano(String nome,String descricao,double preco) {
        this.nome = nome;
        this.descricao=descricao;
        this.preco=preco;
    }

    public Plano(String nome){
        this.nome=nome;
    }
    public String getNome(){return this.nome;}

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}
