package controller;

import java.sql.SQLException;

import dao.ExceptionDAO;
import dao.PacienteDAO;

import model.Paciente;
import model.Pessoa;

public class PacienteController {
	public void createPaciente(Pessoa pessoa, String etnia, String tipoSanguineo, boolean fatorRh, double peso,
			double altura, boolean doador, boolean fumante, String doencas, String limitacoes) throws Exception {
		if (pessoa.getIdPessoa() > 0 && etnia != null && tipoSanguineo != null) {
			Paciente paciente = new Paciente(etnia, tipoSanguineo, fatorRh, peso, altura, doador, fumante, doencas,
					limitacoes);
			paciente.createPaciente(paciente, pessoa.getIdPessoa());
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}

	public void updatePaciente(String etnia, String tipoSanguineo, boolean fatorRh, double peso, double altura,
			boolean doador, boolean fumante, String doencas, String limitacoes) throws Exception {
		if (etnia != null && tipoSanguineo != null) {
			Paciente paciente = new Paciente(etnia, tipoSanguineo, fatorRh, peso, altura, doador, fumante, doencas,
					limitacoes);
			paciente.updatePaciente(paciente);
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}

	public void deletePaciente(int idPaciente) throws Exception {
		if (idPaciente > 0) {
			Paciente paciente = new Paciente();
			paciente.deletePaciente(idPaciente);
		} else {
			throw new Exception("ID do Paciente é inválido!");
		}
	}

	public Paciente getPacienteByCpf(String cpf) throws Exception {
		if (cpf != null && cpf.length() > 0) {
			Paciente paciente = new PacienteDAO().getPacienteByCpf(cpf);
			return paciente;
		} else {
			throw new Exception("ID do Paciente é inválido!");
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

}
