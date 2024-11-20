package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pessoa;

public class PessoaDAO {

	public void createPessoa(Pessoa Pessoa) throws ExceptionDAO {
		String sql = "INSERT INTO Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco) values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = new ConexaoBD().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, Pessoa.getNome());
			stmt.setString(2, Pessoa.getTelefone());
			stmt.setString(3, Pessoa.getRg());
			stmt.setString(4, Pessoa.getCpf());
			stmt.setDate(5, Pessoa.getDataNascimento());
			stmt.setString(6, Pessoa.getSexo());
			stmt.setString(7, Pessoa.getProfissao());
			stmt.setString(8, Pessoa.getEndereco());

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao cadastrar Pessoa: " + e);
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
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePessoa(Pessoa Pessoa) throws ExceptionDAO {
		String sql = "UPDATE Pessoa SET nome = ?, telefone = ?, rg = ?, cpf = ?, dataNascimento = ?, sexo = ?, profissao = ?, endereco = ? WHERE idPessoa = ?";
		try (Connection conn = new ConexaoBD().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, Pessoa.getNome());
			stmt.setString(2, Pessoa.getTelefone());
			stmt.setString(3, Pessoa.getRg());
			stmt.setString(4, Pessoa.getCpf());
			stmt.setDate(5, Pessoa.getDataNascimento());
			stmt.setString(6, Pessoa.getSexo());
			stmt.setString(7, Pessoa.getProfissao());
			stmt.setString(8, Pessoa.getEndereco());
			stmt.setInt(9, Pessoa.getIdPessoa());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao alterar Pessoa: " + e);
		}
	}

	public void deletePessoa(int idPessoa) throws ExceptionDAO {
		String sql = "DELETE FROM Pessoa WHERE idPessoa = ?";
		try (Connection conn = new ConexaoBD().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, idPessoa);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao excluir Pessoa: " + e);
		}
	}

	public Pessoa getPessoaById(int idPessoa) throws ExceptionDAO {
		String sql = "SELECT * FROM Pessoa WHERE idPessoa = ?";
		try (Connection connn = new ConexaoBD().getConnection();
				PreparedStatement stmt = connn.prepareStatement(sql)) {
			stmt.setInt(1, idPessoa);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Pessoa Pessoa = new Pessoa();

				Pessoa.setIdPessoa(rs.getInt("idPessoa"));
				Pessoa.setNome(rs.getString("nome"));
				Pessoa.setTelefone(rs.getString("telefone"));
				Pessoa.setRg(rs.getString("rg"));
				Pessoa.setCpf(rs.getString("cpf"));
				Pessoa.setDataNascimento(rs.getDate("dataNascimento"));
				Pessoa.setSexo(rs.getString("sexo"));
				Pessoa.setProfissao(rs.getString("profissao"));
				Pessoa.setEndereco(rs.getString("endereco"));

				return Pessoa;
			}

		} catch (SQLException  e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao consultar cliente: " + e);
		}
		return null;
	}

	public Pessoa getPessoaByCpf(String cpf) throws ExceptionDAO {
		String sql = "SELECT * FROM Pessoa WHERE cpf = ?";
		try (Connection conn = new ConexaoBD().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Pessoa Pessoa = new Pessoa();

				Pessoa.setIdPessoa(rs.getInt("idPessoa"));
				Pessoa.setNome(rs.getString("nome"));
				Pessoa.setTelefone(rs.getString("telefone"));
				Pessoa.setRg(rs.getString("rg"));
				Pessoa.setCpf(rs.getString("cpf"));
				Pessoa.setDataNascimento(rs.getDate("dataNascimento"));
				Pessoa.setSexo(rs.getString("sexo"));
				Pessoa.setProfissao(rs.getString("profissao"));
				Pessoa.setEndereco(rs.getString("endereco"));

				return Pessoa;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao connsultar Pessoa: " + e);
		}
		return null;
	}

}
