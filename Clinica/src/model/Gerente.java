package model;

import java.sql.Date;

import dao.GerenteDAO;
import dao.ExceptionDAO;

public class Gerente extends Funcionario {
    private int idGerente;

    public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gerente(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo,
			String profissao, String endereco) {
		super(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
		// TODO Auto-generated constructor stub
	}

	public Gerente(String login, String senha, String cargo) {
		super(login, senha, cargo);
		// TODO Auto-generated constructor stub
	}

	public Gerente(int idGerente) {
		super();
		this.idGerente = idGerente;
	}

	public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public void createGerente(Gerente Gerente) throws ExceptionDAO {
        new GerenteDAO().createGerente(Gerente);
    }

    public void updateGerente(Gerente Gerente) throws ExceptionDAO {
        new GerenteDAO().updateGerente(Gerente);
    }

    public void deleteGerente(int idGerente) throws ExceptionDAO {
        new GerenteDAO().deleteGerente(idGerente);
    }

}
