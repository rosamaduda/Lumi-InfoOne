package Model;

public class Alergia {
    // atributos
    private int id;
    private String nome;
    private String alergeno;

    private String descricao;

    // construtor
    public Alergia(int id,  String nome,String alergeno, String descricao) {
        this.id = id;
        this.nome = nome;
        this.alergeno = alergeno;
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
