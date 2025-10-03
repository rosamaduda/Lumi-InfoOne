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

    // getter e setters
    public int getId() {
        return id;
    }
    public String getAlergeno() {
        return alergeno;
    }
    public void setAlergeno(String alergeno) {
        this.alergeno = alergeno;
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
} // Alergia
