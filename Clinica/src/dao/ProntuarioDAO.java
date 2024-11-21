package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Prontuario;

public class ProntuarioDAO {

    public void createProntuario(Prontuario prontuario) throws ExceptionDAO {
        String sql = "INSERT INTO Prontuario (idPaciente, idProfissional, diagnostico, prescricao) VALUES (?, ?, ?, ?)";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, prontuario.getIdPaciente());
            stmt.setInt(2, prontuario.getIdProfissional());
            stmt.setString(3, prontuario.getDiagnostico());
            stmt.setString(4, prontuario.getPrescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao criar Prontuário: " + e.getMessage());
        }
    }

    public void updateProntuario(Prontuario prontuario) throws ExceptionDAO {
        String sql = "UPDATE Prontuario SET idPaciente = ?, idProfissional = ?, diagnostico = ?, prescricao = ? WHERE idProntuario = ?";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, prontuario.getIdPaciente());
            stmt.setInt(2, prontuario.getIdProfissional());
            stmt.setString(3, prontuario.getDiagnostico());
            stmt.setString(4, prontuario.getPrescricao());
            stmt.setInt(5, prontuario.getIdProntuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao atualizar Prontuário: " + e.getMessage());
        }
    }

    public void deleteProntuario(int idProntuario) throws ExceptionDAO {
        String sql = "DELETE FROM Prontuario WHERE idProntuario = ?";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProntuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir Prontuário: " + e.getMessage());
        }
    }

    public Prontuario getProntuarioById(int idProntuario) throws ExceptionDAO {
        Prontuario prontuario = null;
        String sql = "SELECT * FROM Prontuario WHERE idProntuario = ?";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProntuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                prontuario = new Prontuario();
                prontuario.setIdProntuario(rs.getInt("idProntuario"));
                prontuario.setIdPaciente(rs.getInt("idPaciente"));
                prontuario.setIdProfissional(rs.getInt("idProfissional"));
                prontuario.setDiagnostico(rs.getString("diagnostico"));
                prontuario.setPrescricao(rs.getString("prescricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao buscar Prontuário: " + e.getMessage());
        }
        return prontuario;
    }
}
