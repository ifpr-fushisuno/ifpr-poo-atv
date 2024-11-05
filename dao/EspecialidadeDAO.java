import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO {
    public void save(Especialidade especialidade) {
        String sql = "INSERT INTO especialidades (nome) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, especialidade.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Especialidade> findAll() {
        List<Especialidade> especialidades = new ArrayList<>();
        String sql = "SELECT * FROM especialidades";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                especialidades.add(new Especialidade(rs.getString("nome")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especialidades;
    }
}
