package com.example.lumi.Model;

public class InformacaoNutricional {
    private int id;
    private double valorEnergetico;
    private double proteina;
    private double fibras;
    private double carboidratos;
    private double sodio;
    private double gorduraSaturada;
    private double gorduraTrans;
    private double gordurasTotais;

    public InformacaoNutricional(int id, double valorEnergetico, double proteina, double fibras, double carboidratos, double sodio, double gorduraSaturada, double gorduraTrans, double gordurasTotais) {
        this.id = id;
        this.valorEnergetico = valorEnergetico;
        this.proteina = proteina;
        this.fibras = fibras;
        this.carboidratos = carboidratos;
        this.sodio = sodio;
        this.gorduraSaturada = gorduraSaturada;
        this.gorduraTrans = gorduraTrans;
        this.gordurasTotais = gordurasTotais;
    }


    public int getId() {
        return id;
    }

    public double getValorEnergetico() {
        return valorEnergetico;
    }

    public double getProteina() {
        return proteina;
    }

    public double getFibras() {
        return fibras;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public double getSodio() {
        return sodio;
    }

    public double getGorduraSaturada() {
        return gorduraSaturada;
    }

    public double getGorduraTrans() {
        return gorduraTrans;
    }

    public double getGordurasTotais() {
        return gordurasTotais;
    }
}
