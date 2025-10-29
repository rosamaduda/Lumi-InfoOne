package com.example.lumi.Model;

public class Alergia {
    // atributos
    private int id;
    private String nome;
    private String alergeno;

    private String descricao;

    // construtor
    public Alergia(int id,  String nome,String alergeno, String descricao) {
        this.id = id;
        this.nome = nome;
        this.alergeno = alergeno;
        this.descricao = descricao;
    }
    public Alergia(String alergeno, String nome, String descricao) {
        this.alergeno = alergeno;
        this.nome = nome;
        this.descricao = descricao;
    }
    public Alergia(String nome) {
        this.nome = nome;
    }

    public Alergia() {
    }

    public Alergia(int id) {
        this.id = id;
    }

    // getter
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
