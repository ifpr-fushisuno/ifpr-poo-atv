import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilaEsperaDAO {
    public FilaEspera findByMedico(Medico medico) {
        FilaEspera fila = new FilaEspera(medico);
        String sql = "SELECT * FROM fila_espera WHERE crmMedico = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getCrm());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente(rs.getString("cpfPaciente"), "", "", "");
                fila.adicionarPaciente(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Caso ocorra um erro
        }
        return fila;
    }

    public void adicionarPacienteAFila(Medico medico, Paciente paciente) {
        String sql = "INSERT INTO fila_espera (crmMedico, cpfPaciente) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getCrm());
            stmt.setString(2, paciente.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerPacienteDaFila(Medico medico, Paciente paciente) {
        String sql = "DELETE FROM fila_espera WHERE crmMedico = ? AND cpfPaciente = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getCrm());
            stmt.setString(2, paciente.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
