package Model;

public class Favorito {
    // atributos
    private int id;
    private String emailCliente;
    private int idProduto;

    // construtor
    public Favorito(int id, int idProduto,  String emailCliente) {
        this.id = id;
        this.idProduto = idProduto;
        this.emailCliente = emailCliente;
    }

    // getters e setters
    public int getId() {
        return id;
    }
    public String getEmailCliente() {
        return emailCliente;
    }
    public int getIdProduto() {
        return idProduto;
    }
}
