import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {
    public List<Consulta> findAll() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM consultas";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                consultas.add(new Consulta(
                    rs.getString("idConsulta"),
                    new Paciente(rs.getString("cpfPaciente"), "", "", ""),
                    new Medico(rs.getString("crmMedico"), "", ""),
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
