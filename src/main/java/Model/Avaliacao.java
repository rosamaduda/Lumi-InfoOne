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
    public LocalDateTime getDataHorario() {
        return dataHorario;
    }
    public String getEmailCliente() {
        return emailCliente;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }

}
