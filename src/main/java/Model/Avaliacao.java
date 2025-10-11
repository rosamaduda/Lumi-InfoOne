package Model;

import java.time.LocalDateTime;
import java.util.Date;

public class Avaliacao {
    // atributos
    private int id;
    private int nota;
    private String avaliacao;
    private Date dataHorario;
    private String emailCliente;
    private int idProduto;

    // construtor
    public Avaliacao(int id, int nota, String avaliacao, Date dataHorario, String emailCliente, int nomeProduto) {
        this.id = id;
        this.nota=nota;
        this.avaliacao = avaliacao;
        this.dataHorario = dataHorario;
        this.emailCliente = emailCliente;
        this.idProduto = idProduto;
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

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Date getDataHorario() {
        return dataHorario;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public int getNomeProduto() {
        return idProduto;
    }

}
