package controller;

import java.sql.Date;
import java.sql.SQLException;

import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.RecepcionistaDAO;
import dao.ExceptionDAO;

import model.Recepcionista;
import model.Funcionario;
import model.Pessoa;

public class RecepcionistaController {

    public void createSimpleRecepcionista(int idFuncionario) throws Exception {
        if (idFuncionario > 0) {
            Recepcionista recepcionista = new Recepcionista(idFuncionario);
            recepcionista.createRecepcionista(recepcionista);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }
    
    public void createFullRecepcionista(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo, String profissao, String endereco, String login, String senha, String cargo) throws Exception {
        if (nome != null) {
        	Pessoa pessoa = new Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
        	pessoa.createPessoa(pessoa);
        	pessoa = new PessoaDAO().getPessoaByCpf(pessoa.getCpf());
        	
        	Funcionario funcionario = new Funcionario(login, senha, cargo);
        	funcionario.createFuncionario(funcionario, pessoa.getIdPessoa());
        	funcionario = new FuncionarioDAO().getFuncionarioByCpf(pessoa.getCpf());
        	
        	
        	Recepcionista recepcionista = new Recepcionista(funcionario.getIdFuncionario());
            
            recepcionista.createRecepcionista(recepcionista);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void updateRecepcionista(int idRecepcionista, String login, String senha, String cargo) throws Exception {
        if (idRecepcionista > 0 && login != null && senha != null && cargo != null) {
            Recepcionista recepcionista = new Recepcionista();
            recepcionista.setIdRecepcionista(idRecepcionista);
            recepcionista.setLogin(login);
            recepcionista.setSenha(senha);
            recepcionista.setCargo(cargo);
            recepcionista.updateRecepcionista(recepcionista);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void deleteRecepcionista(int idRecepcionista) throws Exception {
        if (idRecepcionista > 0) {
            Recepcionista recepcionista = new Recepcionista();
            recepcionista.deleteRecepcionista(idRecepcionista);
        } else {
            throw new Exception("ID do Recepcionista é inválido!");
        }
    }

    public Recepcionista getRecepcionistaByCpf(String cpf) throws Exception {
        if (cpf != null && !cpf.isEmpty()) {
        	Recepcionista recepcionista = new RecepcionistaDAO().getRecepcionistaByCpf(cpf);
            return recepcionista;
        } else {
            throw new Exception("CPF é inválido!");
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

    // Implement other methods as needed for fetching by CPF, etc.
}
