import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {
    public void save(Prontuario prontuario) {
        String sql = "INSERT INTO prontuarios (idProntuario, cpfPaciente, detalhes) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prontuario.getIdProntuario());
            stmt.setString(2, prontuario.getPaciente().getCpf());
            stmt.setString(3, prontuario.getDetalhes());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Prontuario findById(String idProntuario) {
        String sql = "SELECT * FROM prontuarios WHERE idProntuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idProntuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.first()) {
                return new Prontuario(
                    rs.getString("idProntuario"),
                    new Paciente(rs.getString("cpfPaciente"), "", "", ""),
                    rs.getString("detalhes")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Não encontrado
    }

    public List<Prontuario> findAll() {
        List<Prontuario> prontuarios = new ArrayList<>();
        String sql = "SELECT * FROM prontuarios";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                prontuarios.add(new Prontuario(
                    rs.getString("idProntuario"),
                    new Paciente(rs.getString("cpfPaciente"), "", "", ""),
                    rs.getString("detalhes")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prontuarios;
    }
}
