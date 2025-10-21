package Model;

public class Favorito {
    // atributos
    private int id;
    private String emailCliente;
    private int idProduto;
    private int idIndustria;
    // construtor
    public Favorito(int id, String nomeProduto,  String emailCliente, int idProduto,int idIndustria) {
        this.id = id;
        this.idProduto = idProduto;
        this.emailCliente = emailCliente;
        this.idProduto = idProduto;
        this.idIndustria=idIndustria;
    }

    public Favorito(int id,String emailCliente){
        this.id=id;
        this.emailCliente=emailCliente;
    }

    // getters e setters
    public int getId() {
        return id;
    }
    public String getEmailCliente() {
        return this.emailCliente;
    }
    public int getIdProduto() {return this.idProduto;}
    public int getIdIndustria(){return this.idIndustria}
}
