package model;

import java.sql.Date;
import java.time.LocalDate;

import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.ExceptionDAO;

public class Funcionario extends Pessoa {
    private int idFuncionario;
    private String login;
    private String senha;
    private String cargo;

  

    public Funcionario() {
		super();
	}

	public Funcionario(String nome, String telefone, String rg, String cpf, LocalDate dataNascimento, String sexo,
			String profissao, String endereco) {
		super(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
	}

	public Funcionario(String login, String senha, String cargo) {
		super();
		this.login = login;
		this.senha = senha;
		this.cargo = cargo;
	}

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
	public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) { 
        this.cargo = cargo;
    }

    public void createFuncionario(Funcionario Funcionario, int idPessoa) throws ExceptionDAO {
        new FuncionarioDAO().createFuncionario(Funcionario, idPessoa);
    }

    public void updateFuncionario(Funcionario Funcionario) throws ExceptionDAO {
        new FuncionarioDAO().updateFuncionario(Funcionario);
    }

    public void deleteFuncionario(int idFuncionario) throws ExceptionDAO {
        new FuncionarioDAO().deleteFuncionario(idFuncionario);
    }
    
}
