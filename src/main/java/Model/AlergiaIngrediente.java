package Model;

public class AlergiaIngrediente {
    // atributos
    private int id;
    private String nomeAlergia;
    private String nomeIngrediente;

    // construtor
    public AlergiaIngrediente(int id, String nomeAlergia, String nomeIngrediente) {
        this.id = id;
        this.nomeAlergia = nomeAlergia;
        this.nomeIngrediente = nomeIngrediente;
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public String getNomeAlergia() {
        return nomeAlergia;
    }

    public void setNomeAlergia(String nomeAlergia) {
        this.nomeAlergia = nomeAlergia;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }
}
