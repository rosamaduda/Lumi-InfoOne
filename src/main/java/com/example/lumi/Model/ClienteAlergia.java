package com.example.lumi.Model;

public class ClienteAlergia {
    // atributos
    private int id;
    private String emailCliente;
    private String nomeAlergia;

    // construtor
    public ClienteAlergia(int id, String emailCliente, String nomeAlergia) {
        this.id = id;
        this.emailCliente = emailCliente;
        this.nomeAlergia = nomeAlergia;
    }

    // getters e setters

    public int getId() {
        return id;
    }
    public String getEmailCliente() {
        return emailCliente;
    }
    public String getNomeAlergia() {
        return nomeAlergia;
    }
}
