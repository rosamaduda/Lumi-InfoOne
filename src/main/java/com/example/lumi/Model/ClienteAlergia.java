package com.example.lumi.Model;

public class ClienteAlergia {
    // atributos
    private int id;
    private int idAlergia;
    private String emailCliente;

    // construtor
    public ClienteAlergia(int id,  int idAlergia,String emailCliente) {
        this.id = id;
        this.idAlergia = idAlergia;
        this.emailCliente = emailCliente;
    }
    
    public ClienteAlergia(int idAlergia) {
        this.idAlergia = idAlergia;
    }

    // getters
    public int getId() {
        return id;
    }
    public String getEmailCliente() {
        return emailCliente;
    }
    public int getIdAlergia() {
        return idAlergia;
    }
} // ClienteAlergia
