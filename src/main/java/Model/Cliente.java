package Model;

import java.time.LocalDate;

public class Cliente {
    // atributos
    private String email;
    private String cpf;
    private String nome;
    private String nomeSobrenome;
    private LocalDate dataNascimento;
    private String senha;
    private double altura;
    private double peso;
    private int diabetes;
    private boolean pressaoAlta;
    private String telefone;
    private String enderecoUf;
    private String enderecoCidade;
    private String enderecoCep;
    private String enderecoRua;
    private int enderecoNumero;

    // construtor

    public Cliente(String email, String cpf, String nome, String nomeSobrenome, LocalDate dataNascimento, String senha, double altura, double peso, int diabetes, boolean pressaoAlta, String telefone, String enderecoUf, String enderecoCidade, String enderecoCep, String enderecoRua, int enderecoNumero) {
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
        this.nomeSobrenome = nomeSobrenome;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.altura = altura;
        this.peso = peso;
        this.diabetes = diabetes;
        this.pressaoAlta = pressaoAlta;
        this.telefone = telefone;
        this.enderecoUf = enderecoUf;
        this.enderecoCidade = enderecoCidade;
        this.enderecoCep = enderecoCep;
        this.enderecoRua = enderecoRua;
        this.enderecoNumero = enderecoNumero;
    }

    // getters e setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeSobrenome() {
        return nomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        this.nomeSobrenome = nomeSobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isPressaoAlta() {
        return pressaoAlta;
    }

    public void setPressaoAlta(boolean pressaoAlta) {
        this.pressaoAlta = pressaoAlta;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
} // Cliente
