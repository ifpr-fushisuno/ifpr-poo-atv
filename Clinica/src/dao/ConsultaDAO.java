package dao;

import model.Consulta;
import model.Paciente;
import model.Profissional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaDAO {
    private Connection connection;

    public ConsultaDAO() {
        this.connection = new ConexaoBD().getConnection(); // Assumindo que ConexaoBD já está implementada
    }

    public void createConsulta(Consulta consulta, int idPaciente, int idProfissional) throws ExceptionDAO {
        String sql = "INSERT INTO Consulta (idPaciente, idProfissional, dataConsulta, horaConsulta, statusConsulta) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPaciente);
            stmt.setInt(2, idProfissional);
            stmt.setDate(3, consulta.getDataConsulta());
            stmt.setTime(4, consulta.getHoraConsulta());
            stmt.setString(5, consulta.getStatusConsulta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao criar consulta: " + e.getMessage());
        }
    }

    public void updateConsulta(Consulta consulta, int idProfissional) throws ExceptionDAO {
        String sql = "UPDATE Consulta SET idProfissional = ?, dataConsulta = ?, horaConsulta = ?, statusConsulta = ? WHERE idConsulta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProfissional);
            stmt.setDate(2, consulta.getDataConsulta());
            stmt.setTime(3, consulta.getHoraConsulta());
            stmt.setString(4, consulta.getStatusConsulta());
            stmt.setInt(5, consulta.getIdConsulta());
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

    public Consulta getConsultaPorId(int idConsulta) throws ExceptionDAO {
        String sql = "SELECT * FROM Consulta WHERE idConsulta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idConsulta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Crie e retorne um objeto Consulta aqui
                return new Consulta(
                    rs.getInt("idConsulta"),
                    new Paciente(), // Você deve implementar a busca pelo paciente
                    new Profissional(), // Você deve implementar a busca pelo profissional
                    rs.getDate("dataConsulta"),
                    rs.getTime("horaConsulta"),
                    null, // dataHoraConsulta pode não ser diretamente obtida; você pode calcular ou deixá-la null
                    Consulta.StatusConsulta.valueOf(rs.getString("statusConsulta"))
                );
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao buscar consulta: " + e.getMessage());
        }
        return null; // Caso não encontre
    }
}
