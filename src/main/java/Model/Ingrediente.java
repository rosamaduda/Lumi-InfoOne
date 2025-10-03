package Model;

public class Ingrediente {
    // atributos
    private int id;
    private String nome;
    private String descricao;

    // construtor
    public Ingrediente(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    // getters e setters
    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
} // Ingrediente
