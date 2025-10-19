package com.example.lumi.Model;

import java.time.LocalDate;

public class Cliente {
    // atributos
    private String email;
    private String cpf;
    private String nome;
    private String nomeSobrenome;
    private LocalDate dataNascimento;
    private String senha;
    private double altura;
    private double peso;
    private int diabetes;
    private boolean pressaoAlta;
    private String telefone;
    private String enderecoUf;
    private String enderecoCidade;
    private String enderecoCep;

    // construtor
    public Cliente(String email, String cpf, String nome, String nomeSobrenome, LocalDate dataNascimento, String senha, double altura, double peso, int diabetes, boolean pressaoAlta, String telefone, String enderecoUf, String enderecoCidade, String enderecoCep) {
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
        this.nomeSobrenome = nomeSobrenome;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.altura = altura;
        this.peso = peso;
        this.diabetes = diabetes;
        this.pressaoAlta = pressaoAlta;
        this.telefone = telefone;
        this.enderecoUf = enderecoUf;
        this.enderecoCidade = enderecoCidade;
        this.enderecoCep = enderecoCep;
    }

    public Cliente(String email) {
        this.email = email;
    }

    // getters e setters
    public String getEmail() {
        return email;
    }
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getNomeSobrenome() {
        return nomeSobrenome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public String getSenha() {
        return senha;
    }
    public double getAltura() {
        return altura;
    }
    public double getPeso() {
        return peso;
    }
    public int getDiabetes() {
        return diabetes;
    }
    public boolean isPressaoAlta() {
        return pressaoAlta;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEnderecoUf() {
        return enderecoUf;
    }
    public String getEnderecoCidade() {
        return enderecoCidade;
    }
    public String getEnderecoCep() {
        return enderecoCep;
    }

} // Cliente
