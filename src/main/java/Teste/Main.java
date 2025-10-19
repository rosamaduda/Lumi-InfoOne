package Teste;

import com.example.lumi.Conexao.Conexao;
import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.Model.Alergia;

public class Main {
    public static void main(String[] args) {

        // TESTANDO A CONEXÃO COM O BD

        Conexao conexao = new Conexao();

        if (conexao.conectar() == null) {
            System.out.println("Conexão deu errado\n");
        } else {
            System.out.println("Conexão feita com sucesso.\n");
        }

        // TESTANDO MÉTODOS ALERGIADAO
        AlergiaDAO alergiaDAO = new AlergiaDAO();


        int retorno = alergiaDAO.inserirAlergia(new Alergia(1, "alergia1", "alergia1", "alergia1"));
        if (retorno == 1) {
            System.out.println("1");
        } else if (retorno == 0) {
            System.out.println("0");
        } else {
            System.out.println("-1");
        }

        // TESTANDO MÉTODOS INGREDIENTEDAO

        // TESTANDO MÉTODOS INDUSTRIADAO

        // TESTANDO MÉTODOS CLIENTE DAO

    }
}
