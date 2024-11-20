package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Consulta;
import model.Paciente;
import model.Pessoa;

public class ConsultaDAO {

    public void createConsulta(Consulta Consulta) throws ExceptionDAO {
        String sql = "INSERT INTO Consulta(idPaciente, idProfissional, dataHoraConsulta, statusConsulta) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Consulta.getIdPaciente());
            stmt.setInt(2, Consulta.getIdProfissional());
            // stmt.setTimestamp(3, Consulta.getDataHoraConsulta());
            stmt.setString(4, Consulta.getStatusConsulta());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar Consulta: " + e);
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

    public void updateConsulta(Consulta Consulta) throws ExceptionDAO {
        String sql = "UPDATE Consulta SET idPaciente = ?, idProfissional = ?, dataHoraConsulta = ?, statusConsulta = ? WHERE idConsulta = ?";
        try (Connection conn = new ConexaoBD().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Consulta.getIdPaciente());
            stmt.setInt(2, Consulta.getIdProfissional());
            // stmt.setInt(3, Consulta.getDataHoraConsulta());
            stmt.setString(4, Consulta.getStatusConsulta());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar Consulta: " + e);
        }

    }

    public void deleteConsulta(int idConsulta) throws ExceptionDAO {
        String sql = "DELETE FROM Consulta WHERE idConsulta = ?";
        try (Connection connection = new ConexaoBD().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idConsulta);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir Consulta: " + e);
        }
    }

    public Consulta getConsultaById(int idConsulta) {
        String sql = "SELECT * FROM Consulta WHERE idConsulta = ?";
        try (Connection conn = new ConexaoBD().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idConsulta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Consulta Consulta = new Consulta();

            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

}
