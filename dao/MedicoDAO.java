import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
    public void save(Medico medico) {
        String sql = "INSERT INTO medicos (crm, nome, especialidade) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getCrm());
            stmt.setString(2, medico.getNome());
            stmt.setString(3, medico.getEspecialidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Medico findByCrm(String crm) {
        String sql = "SELECT * FROM medicos WHERE crm = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, crm);
            ResultSet rs = stmt.executeQuery();
            if (rs.first()) {
                return new Medico(
                    rs.getString("crm"),
                    rs.getString("nome"),
                    rs.getString("especialidade")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Não encontrado
    }

    public void update(Medico medico) {
        String sql = "UPDATE medicos SET nome = ?, especialidade = ? WHERE crm = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getCrm());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String crm) {
        String sql = "DELETE FROM medicos WHERE crm = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, crm);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medico> findAll() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medicos";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                medicos.add(new Medico(
                    rs.getString("crm"),
                    rs.getString("nome"),
                    rs.getString("especialidade")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }
}
