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
    public String getDescricao() {
        return descricao;
    }
} // Ingrediente
