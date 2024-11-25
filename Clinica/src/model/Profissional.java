package model;

import java.sql.Date;
import java.time.LocalDate;

import dao.ProfissionalDAO;
import dao.ExceptionDAO;

public class Profissional extends Funcionario {
    private int idProfissional;
    private int idFuncionario;
    private String especialidade;
    private String registroConselho;
    private LocalDate dataInscricao;
    
 

	public Profissional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profissional(String nome, String telefone, String rg, String cpf, LocalDate dataNascimento, String sexo,
			String profissao, String endereco) {
		super(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
		// TODO Auto-generated constructor stub
	}

	public Profissional(String login, String senha, String cargo) {
		super(login, senha, cargo);
		// TODO Auto-generated constructor stub
	}
	
	public Profissional(int idFuncionario, String especialidade, String registroConselho,
			LocalDate dataInscricao) {
		super();
		this.idFuncionario = idFuncionario;
		this.especialidade = especialidade;
		this.registroConselho = registroConselho;
		this.dataInscricao = dataInscricao;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    public void setRegistroConselho(String registroConselho) {
        this.registroConselho = registroConselho;
    }

    public LocalDate getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public void createProfissional(Profissional Profissional) throws ExceptionDAO {
        new ProfissionalDAO().createProfissional(Profissional);
    }

    public void updateProfisssional(Profissional Profissional) throws ExceptionDAO {
        new ProfissionalDAO().updateProfisssional(Profissional);
    }

    public void deleteProfissional(int idProfissional) throws ExceptionDAO {
        new ProfissionalDAO().deleteProfissional(idProfissional);
    }
}
