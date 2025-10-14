package Model;

public class Alergia {
    // atributos
    private int id;
    private String alergeno;
    private String nome;
    private String descricao;

    // construtor
    public Alergia(int id, String alergeno, String nome, String descricao) {
        this.id = id;
        this.alergeno = alergeno;
        this.nome = nome;
        this.descricao = descricao;
    }
    public Alergia(String nome) {
        this.nome = nome;
    }

    // getter e setters
    public int getId() {
        return id;
    }
    public String getAlergeno() {
        return alergeno;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
} // Alergia
