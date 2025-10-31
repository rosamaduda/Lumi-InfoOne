package com.example.lumi.Model;

public class TelefoneIndustria {
    // atributos
    private int id;
    private String telefone;
    private int idIndustria;

   // construtores
   public TelefoneIndustria() {}

    public TelefoneIndustria(String telefone) {
        this.telefone = telefone;
    }
    public TelefoneIndustria(String telefone, int idIndustria) {
       this.telefone = telefone;
       this.idIndustria = idIndustria;
    }
   public TelefoneIndustria (int id, String telefone, int idIndustria) {
       this.id = id;
       this.telefone = telefone;
       this.idIndustria = idIndustria;
   }

    // getters
    public int getId() {
        return id;
    }
    public String getTelefone() {
        return telefone;
    }
    public int getIdIndustria() {
        return idIndustria;
    }
} // TelefoneIndustria
