package Model;

public class Industria {
    // atributos
    private int id;
    private String cnpj;
    private String nome;
    private String objetivo;
    private String email;
    private String senha;
    private String nomePlano;

    // construtor

    public Industria(int id, String cnpj, String nome, String objetivo, String email, String senha, String nomePlano) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.objetivo = objetivo;
        this.email = email;
        this.senha = senha;
        this.nomePlano = nomePlano;
    }

    // getters e setters

    public int getId() {
        return id;
    }
    public String getCnpj() {
        return cnpj;
    }
    public String getNome() {
        return nome;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public String getNomePlano() {
        return nomePlano;
    }
} // Industria
