package model;

import dao.RecepcionistaDAO;

import java.sql.Date;

import dao.ExceptionDAO;

public class Recepcionista extends Funcionario {
    private int idRecepcionista;


    public Recepcionista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recepcionista(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo,
			String profissao, String endereco) {
		super(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
		// TODO Auto-generated constructor stub
	}

	public Recepcionista(String login, String senha, String cargo) {
		super(login, senha, cargo);
		// TODO Auto-generated constructor stub
	}


    public Recepcionista(int idRecepcionista) {
		super();
		this.idRecepcionista = idRecepcionista;
	}
	
	public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }


	public void createRecepcionista(Recepcionista Recepcionista) throws ExceptionDAO {
        new RecepcionistaDAO().createRecepcionista(Recepcionista);
    }

    public void updateRecepcionista(Recepcionista Recepcionista) throws ExceptionDAO {
        new RecepcionistaDAO().updateRecepcionista(Recepcionista);
    }

    public void deleteRecepcionista(int idRecepcionista) throws ExceptionDAO {
        new RecepcionistaDAO().deleteRecepcionista(idRecepcionista);
    }
}