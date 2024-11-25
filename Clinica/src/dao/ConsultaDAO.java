package dao;

import model.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaDAO {
	private Connection connection;

	public ConsultaDAO() {
		this.connection = new ConexaoBD().getConnection(); // Assumindo que ConexaoBD já está implementada
	}

	public void createConsulta(Consulta consulta) throws ExceptionDAO {
		String sql = "INSERT INTO Consulta (idPaciente, idProfissional, dataConsulta, horaConsulta, statusConsulta) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, consulta.getPaciente().getIdPaciente());
			stmt.setInt(2, consulta.getProfissional().getIdProfissional());
			stmt.setDate(3, consulta.getDataConsulta());
			stmt.setTime(4, consulta.getHoraConsulta());
			stmt.setString(5, consulta.getStatusConsulta());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao criar consulta: " + e.getMessage());
		}
	}

	public void updateConsulta(Consulta consulta) throws ExceptionDAO {
		String sql = "UPDATE Consulta SET idProfissional = ?, dataConsulta = ?, horaConsulta = ?, statusConsulta = ? WHERE idPaciente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, consulta.getProfissional().getIdProfissional());
			stmt.setDate(2, consulta.getDataConsulta());
			stmt.setTime(3, consulta.getHoraConsulta());
			stmt.setString(4, consulta.getStatusConsulta());
			stmt.setInt(5, consulta.getPaciente().getIdPaciente());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao atualizar consulta: " + e.getMessage());
		}
	}

	public void deleteConsulta(int idConsulta) throws ExceptionDAO {
		String sql = "DELETE FROM Consulta WHERE idConsulta = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, idConsulta);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao deletar consulta: " + e.getMessage());
		}
	}

	public Consulta getConsultaByCpf(String cpf) throws ExceptionDAO {
		String sql = "SELECT p.nome nomePaciente, pp.nome nomeProfissional, c.dataConsulta, c.horaConsulta, c.statusConsulta* FROM Pessoa p"
				+ "JOIN Funcionario f ON p.idPessoa = f.idPessoa"
				+ "JOIN Profissional pp ON f.idFuncionario = pp.idFuncionario"
				+ "JOIN Paciente pa ON p.idPessoa = pa.idPessoa"
				+ "JOIN Consulta c ON c.idPaciente = pa.idPaciente AND c.idProfissional = pp.idProfissional  "
				+ "WHERE p.cpf = ?";
		try (Connection conn = new ConexaoBD().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Consulta consulta = new Consulta();
				consulta.setPaciente(rs.getString("nomePaciente"));
				consulta.setProfissional(rs.getString("nomeProfissional"));
				consulta.setDataConsulta(rs.getDate("dataConsulta"));
				consulta.setHoraConsulta(rs.getTime("horaConsulta"));
				consulta.setStatusConsulta(rs.getString("statusConsulta"));

				return consulta;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao buscar Recepcionista: " + e.getMessage());
		}
		return null;
	}
}
