package Model;

public class TelefoneIndustria {
    // atributos
    private int id;
    private int telefone;
    private int idIndustria;

   // construtor
   public TelefoneIndustria (int id, int telefone, int idIndustria) {
       this.id = id;
       this.telefone = telefone;
       this.idIndustria = idIndustria;
   }

   // getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTelefone() {
        return telefone;
    }
    public int getIdIndustria() {
        return idIndustria;
    }

} // TelefoneIndustria
