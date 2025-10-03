package Model;

public class Industria {
    // atributos
    private int id;
    String cnpj;
    String nome;
    String objetivo;
    String email;
    String senha;
    private String enderecoUf;
    private String enderecoCidade;
    private String enderecoCep;
    private String enderecoRua;
    private int enderecoNumero;
    private String nomePlano;

    // construtor

    public Industria(int id, String cnpj, String nome, String objetivo, String email, String senha, String enderecoUf, String enderecoCidade, String enderecoCep, String enderecoRua, int enderecoNumero, String nomePlano) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.objetivo = objetivo;
        this.email = email;
        this.senha = senha;
        this.enderecoUf = enderecoUf;
        this.enderecoCidade = enderecoCidade;
        this.enderecoCep = enderecoCep;
        this.enderecoRua = enderecoRua;
        this.enderecoNumero = enderecoNumero;
        this.nomePlano = nomePlano;
    }

    // getters e setters

    public int getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEnderecoUf() {
        return enderecoUf;
    }

    public void setEnderecoUf(String enderecoUf) {
        this.enderecoUf = enderecoUf;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public int getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(int enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }
} // Industria
