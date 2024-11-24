package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.ProfissionalDAO;
import dao.ConexaoBD;
import dao.ExceptionDAO;

import model.Profissional;
import model.Funcionario;
import model.Pessoa;

public class ProfissionalController {

    public void createProfissional(Pessoa pessoa, String especialidade, String registroConselho, java.sql.Date dataInscricao) throws Exception {
        if (pessoa.getIdPessoa() > 0 && especialidade != null && registroConselho != null && dataInscricao != null) {
            Profissional profissional = new Profissional();
            profissional.setIdFuncionario(pessoa.getIdPessoa());
            profissional.setEspecialidade(especialidade);
            profissional.setRegistroConselho(registroConselho);
            profissional.setDataInscricao(dataInscricao);

            new ProfissionalDAO().createProfissional(profissional);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }
    
    public void createFullProfissional(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo, String profissao, String endereco, String login, String senha, String cargo, String especialidade, String registroConselho, Date dataInscricao) throws Exception {
        if (nome != null) {
        	Pessoa pessoa = new Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
        	pessoa.createPessoa(pessoa);
        	pessoa = new PessoaDAO().getPessoaByCpf(pessoa.getCpf());
        	
        	Funcionario funcionario = new Funcionario(login, senha, cargo);
        	funcionario.createFuncionario(funcionario, pessoa.getIdPessoa());
        	funcionario = new FuncionarioDAO().getFuncionarioByCpf(pessoa.getCpf());
        	
        	
        	Profissional Profissional = new Profissional(funcionario.getIdFuncionario(), especialidade, registroConselho, dataInscricao);
            
            Profissional.createProfissional(Profissional);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void updateProfissional(int idProfissional, String especialidade, String registroConselho, java.sql.Date dataInscricao) throws Exception {
        if (idProfissional > 0 && especialidade != null && registroConselho != null && dataInscricao != null) {
            Profissional profissional = new Profissional();
            profissional.setIdProfissional(idProfissional);
            profissional.setEspecialidade(especialidade);
            profissional.setRegistroConselho(registroConselho);
            profissional.setDataInscricao(dataInscricao);
            profissional.updateProfisssional(profissional);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void deleteProfissional(int idProfissional) throws Exception {
        if (idProfissional > 0) {
            new ProfissionalDAO().deleteProfissional(idProfissional);
        } else {
            throw new Exception("ID do Profissional é inválido!");
        }
    }

    public Profissional getProfissionalById(int idProfissional) throws Exception {
        if (idProfissional > 0) {
            return new ProfissionalDAO().getProfissionalById(idProfissional);
        } else {
            throw new Exception("ID do Profissional é inválido!");
        }
    }

    public Profissional getProfissionalByRegistro(String registroConselho) throws Exception {
        if (registroConselho != null && !registroConselho.isEmpty()) {
            return new ProfissionalDAO().getProfissionalByRegistro(registroConselho);
        } else {
            throw new Exception("Registro de conselho é inválido!");
        }
    }

    public boolean autenticarUsuario(String username, String password) throws ExceptionDAO, SQLException {
	    Connection connection = null;
	    PreparedStatement pStatement = null;
	    ResultSet rs = null;

	    try {
	        connection = new ConexaoBD().getConnection();
	        String sql = "SELECT * FROM Usuario WHERE username = ? AND password = ?";
	        pStatement = connection.prepareStatement(sql);
	        pStatement.setString(1, username);
	        pStatement.setString(2, password);
	        rs = pStatement.executeQuery();

	        return rs.next(); // Retorna true se encontrar o usuário
	    } catch (SQLException e) {
	        throw new ExceptionDAO("Erro ao autenticar usuário: " + e.getMessage());
	    } finally {
	        if (rs != null) rs.close();
	        if (pStatement != null) pStatement.close();
	        if (connection != null) connection.close();
	    }
	}

    public List<Profissional> getAllProfissionais() throws ExceptionDAO {
        try {
            return new ProfissionalDAO().getAllProfissionais();
        } catch (ExceptionDAO e) {
            throw e;
        }
    }
}
