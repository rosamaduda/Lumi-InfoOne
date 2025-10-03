package Model;

public class Favorito {
    // atributos
    private int id;
    private String emailCliente;
    private String nomeProduto;

    // construtor
    public Favorito(int id, String emailCliente, String nomeProduto) {
        this.id = id;
        this.emailCliente = emailCliente;
        this.nomeProduto = nomeProduto;
    }

    // getters e setters

    public int getId() {
        return id;
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
