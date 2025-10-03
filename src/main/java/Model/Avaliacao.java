package Model;

import java.time.LocalDateTime;

public class Avaliacao {
    // atributos
    private int id;
    private String avaliacao;
    private LocalDateTime dataHorario;
    private String emailCliente;
    private String nomeProduto;

    // construtor
    public Avaliacao(int id, String avaliacao, LocalDateTime dataHorario, String emailCliente, String nomeProduto) {
        this.id = id;
        this.avaliacao = avaliacao;
        this.dataHorario = dataHorario;
        this.emailCliente = emailCliente;
        this.nomeProduto = nomeProduto;
    }

    // getters e setters

    public int getId() {
        return id;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDateTime getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
