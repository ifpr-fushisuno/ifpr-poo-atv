package model;

import java.sql.Date;

import dao.GerenteDAO;
import dao.ExceptionDAO;

public class Gerente extends Funcionario {
    private int idGerente;

    public Gerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public Gerente(int idFuncionario, String login, String senha, String cargo, int idGerente) {
        super(idFuncionario, login, senha, cargo);
        this.idGerente = idGerente;
    }

    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public void cadastrarCliente(Gerente Gerente) throws ExceptionDAO {
        new GerenteDAO().cadastrarGerente(Gerente);
    }

    public void alterarGerente(Gerente Gerente) throws ExceptionDAO {
        new GerenteDAO().alterarGerente(Gerente);
    }

    public void excluirGerente(int idGerente) throws ExceptionDAO {
        new GerenteDAO().excluirGerente(idGerente);
    }

}
