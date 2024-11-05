import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    public void save(Consulta consulta) {
        String sql = "INSERT INTO consultas (idConsulta, cpfPaciente, crmMedico, dataHora, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, consulta.getIdConsulta());
            stmt.setString(2, consulta.getPaciente().getCpf());
            stmt.setString(3, consulta.getMedico().getCrm());
            stmt.setTimestamp(4, Timestamp.valueOf(consulta.getDataHora()));
            stmt.setString(5, consulta.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> findByPaciente(Paciente paciente) {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM consultas WHERE cpfPaciente = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getCpf());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consultas.add(new Consulta(
                    rs.getString("idConsulta"),
                    paciente, // Associar o paciente
                    new Medico(rs.getString("crmMedico"), "", ""), // O médico pode ser recuperado depois se necessário
                    rs.getTimestamp("dataHora").toLocalDateTime(),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public void delete(String idConsulta) {
        String sql = "DELETE FROM consultas WHERE idConsulta = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idConsulta);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> findAll() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM consultas";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                consultas.add(new Consulta(
                    rs.getString("idConsulta"),
                    new Paciente(rs.getString("cpfPaciente"), "", "", ""), // Você pode obter os detalhes do paciente se necessário
                    new Medico(rs.getString("crmMedico"), "", ""), // O médico pode ser recuperado depois se necessário
                    rs.getTimestamp("dataHora").toLocalDateTime(),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }
}
