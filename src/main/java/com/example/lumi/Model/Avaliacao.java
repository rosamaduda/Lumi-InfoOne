package com.example.lumi.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Avaliacao {
    // atributos
    private int id;
    private int nota;
    private String avaliacao;
    private LocalDate dataAvaliacao;
    private String emailCliente;
    private int idProduto;
    // construtor
    public Avaliacao(int id, int nota, String avaliacao, LocalDate dataAvaliacao, String emailCliente, int idProduto) {
        this.id = id;
        this.nota=nota;
        this.avaliacao = avaliacao;
        this.dataAvaliacao = dataAvaliacao;
        this.emailCliente = emailCliente;
        this.idProduto = idProduto;
    }

    public Avaliacao(int id, int nota, String avaliacao, LocalDate dataAvaliacao, String emailCliente, String nomeProduto) {
        this.id = id;
        this.nota=nota;
        this.avaliacao = avaliacao;
        this.dataAvaliacao = dataAvaliacao;
        this.emailCliente = emailCliente;
        this.nomeProduto = nomeProduto;
    }

    // getters e setters
    public int getNota() {
        return nota;
    }
    public int getId() {
        return id;
    }
    public String getAvaliacao() {
        return avaliacao;
    }
    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
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
}
