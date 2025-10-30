package com.example.lumi.Model;

public class Industria {
    // atributos
    private int id;
    private String cnpj;
    private String nome;
    private String objetivo;
    private String email;
    private String senha;
    private String nomePlano;

    // construtor
    public Industria() {
    }

    public Industria(int id) {
        this.id = id;
    }

    public Industria(String nome) {
        this.nome = nome;
    }

    public Industria(int id, String cnpj, String nome, String objetivo, String email) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.objetivo = objetivo;
        this.email = email;
    }

    public Industria(String cnpj, String nome, String objetivo, String email, String nomePlano, String senha) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.objetivo = objetivo;
        this.email = email;
        this.nomePlano = nomePlano;
        this.senha = senha;
    }

    public Industria(int id, String cnpj, String nome, String objetivo, String email, String senha, String nomePlano) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.objetivo = objetivo;
        this.email = email;
        this.senha = senha;
        this.nomePlano = nomePlano;
    }

    // getters
    public int getId() {
        return id;
    }
    public String getCnpj() {
        return cnpj;
    }
    public String getNome() {
        return nome;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public String getNomePlano() {
        return nomePlano;
    }
} // Industria
