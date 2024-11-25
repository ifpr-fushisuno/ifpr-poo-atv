package model;

import dao.RecepcionistaDAO;

import java.sql.Date;
import java.time.LocalDate;

import dao.ExceptionDAO;

public class Recepcionista extends Funcionario {
	private int idRecepcionista;
	private int idFuncionario;

	public Recepcionista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recepcionista(String nome, String telefone, String rg, String cpf, LocalDate dataNascimento, String sexo,
			String profissao, String endereco) {
		super(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
		// TODO Auto-generated constructor stub
	}

	public Recepcionista(String login, String senha, String cargo) {
		super(login, senha, cargo);
		// TODO Auto-generated constructor stub
	}

	public Recepcionista(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo,
			String profissao, String endereco, String login, String senha, String cargo) {
		super();

	}

	public Recepcionista(int idFuncionario) {
		super();
		this.idFuncionario = idFuncionario;
	}

	public int getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(int idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public void createRecepcionista(Recepcionista recepcionista) throws ExceptionDAO {
		new RecepcionistaDAO().createRecepcionista(recepcionista);
	}


	public void updateRecepcionista(Recepcionista recepcionista) throws ExceptionDAO {
		new RecepcionistaDAO().updateRecepcionista(recepcionista);
	}

	public void deleteRecepcionista(int idRecepcionista) throws ExceptionDAO {
		new RecepcionistaDAO().deleteRecepcionista(idRecepcionista);
	}
}