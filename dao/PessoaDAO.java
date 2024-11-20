package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pessoa;

public class PessoaDAO {

	public void cadastrarPessoa(Pessoa pessoa) throws ExceptionDAO {
		String sql = "INSERT INTO Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao) values (?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		Connection connection = null;
		try {
			connection = new ConexaoBD().getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getTelefone());
			stmt.setString(3, pessoa.getRg());
			stmt.setString(4, pessoa.getCpf());
			stmt.setDate(5, pessoa.getDataNascimento());
			stmt.setString(6, pessoa.getSexo());
			stmt.setString(7, pessoa.getProfissao());

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao cadastrar pessoa: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Pessoa consultarPessoaNome(String nome) throws ExceptionDAO {
		String sql = "SELECT * FROM Pessoa WHERE nome = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Pessoa Pessoa = new Pessoa();
				Pessoa.setIdPessoa(rs.getInt("idPessoa"));
				Pessoa.setNome(rs.getString("nome"));
				Pessoa.setTelefone(rs.getString("telefone"));
				return Pessoa;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao consultar Pessoa: " + e);
		}
		return null;
	}

	public void alterarPessoa(Pessoa Pessoa) throws ExceptionDAO {
		String sql = "UPDATE Pessoa SET nome = ?, telefone = ? WHERE idPessoa = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, Pessoa.getNome());
			stmt.setString(2, Pessoa.getTelefone());
			stmt.setInt(3, Pessoa.getIdPessoa());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao alterar Pessoa: " + e);
		}
	}

	public void excluirPessoa(int idPessoa) throws ExceptionDAO {
		String sql = "DELETE FROM Pessoa WHERE idPessoa = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, idPessoa);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao excluir Pessoa: " + e);
		}
	}

	public pegarPessoaPorID(int idPessoa){
		String sql = "SELECT * FROM Pessoa WHERE idPessoa = ?";
		try (Connection conn = new ConexaoBD().getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, idPessoa);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				Pessoa pessoa = new Pessoa();

				pessoa.setIdPessoa(rs.getInt("idPessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setTelefone(rs.getString("telefone"));
				pessoa.setRg(rs.getString("rg"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
