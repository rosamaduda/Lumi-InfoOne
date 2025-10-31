package com.example.lumi.Model;

public class Alergia {
    // atributos
    private int id;
    private String nome;
    private String alergeno;
    private String descricao;

    // construtores
    public Alergia() {
    }
    public Alergia(String nome) {
        this.nome = nome;
    }
    public Alergia(int id) {
        this.id = id;
    }
    public Alergia(String alergeno, String nome, String descricao) {
        this.alergeno = alergeno;
        this.nome = nome;
        this.descricao = descricao;
    }
    public Alergia(int id,  String nome,String alergeno, String descricao) {
        this.id = id;
        this.nome = nome;
        this.alergeno = alergeno;
        this.descricao = descricao;
    }

    // getters
    public int getId() {
        return id;
    }
    public String getAlergeno() {
        return alergeno;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
} // Alergia
