package Model;

public class Produto {
    // atributos
    private int codigoBarras;
    private String nome;
    private String fabricante;
    private String descricao;
    private double massa;
    private int idIndustria;
    private int idInfoNutri;

    // construtor


    public Produto(int codigoBarras, String nome, String fabricante, String descricao, double massa, int idIndustria, int idInfoNutri) {
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.fabricante = fabricante;
        this.descricao = descricao;
        this.massa = massa;
        this.idIndustria = idIndustria;
        this.idInfoNutri = idInfoNutri;
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    // getters
    public String getNome() {
        return this.nome;
    }
}
