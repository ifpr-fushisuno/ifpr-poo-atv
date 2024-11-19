package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Medico;

public class MedicoDAO {

    public void cadastrarMedico(Medico medico) throws ExceptionDAO {
        String sql = "INSERT INTO Medico (crm, nome, especialidade) VALUES (?, ?, ?)";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medico.getCrm());
            stmt.setString(2, medico.getNome());
            stmt.setString(3, medico.getEspecialidade());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar médico: " + e.getMessage());
        }
    }

    public Medico consultarMedico(String crm) throws ExceptionDAO {
        String sql = "SELECT * FROM Medico WHERE crm = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, crm);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Medico medico = new Medico();
                medico.setCrm(rs.getString("crm"));
                medico.setNome(rs.getString("nome"));
                medico.setEspecialidade(rs.getString("especialidade"));
                return medico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar médico: " + e.getMessage());
        } 
        return null;
    }

    public void alterarMedico(Medico medico) throws ExceptionDAO {
        String sql = "UPDATE Medico SET nome = ?, especialidade = ? WHERE crm = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getCrm());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar médico: " + e.getMessage());
        } 
    }

    public void excluirMedico(String crm) throws ExceptionDAO {
        String sql = "DELETE FROM Medico WHERE crm = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, crm);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir médico: " + e.getMessage());
        } 
    }
}
