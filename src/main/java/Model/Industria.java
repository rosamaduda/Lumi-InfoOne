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

    public Industria(int id, String cnpj, String nome, String objetivo, String email, String senha,String nomePlano) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.objetivo = objetivo;
        this.email = email;
        this.senha = senha;
        this.nomePlano = nomePlano;
    }

    public Industria(int id, String cnpj, String nome, String objetivo, String email) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.objetivo = objetivo;
        this.email = email;
    }

    // getters e setters
    public int getId() {
        return this.id;
    }
    public String getCnpj() {
        return this.cnpj;
    }
    public String getNome() {
        return this.nome;
    }
    public String getObjetivo() {
        return this.objetivo;
    }
    public String getEmail() {
        return this.email;
    }
    public String getSenha() {
        return this.senha;
    }
    public String getNomePlano(){return this.nomePlano;}
} // Industria
