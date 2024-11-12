package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import model.Prontuario;
import model.Paciente;

public class ProntuarioDAO {

    public void cadastrarProntuario(Prontuario prontuario) throws ExceptionDAO {
        String sql = "INSERT INTO Prontuario (idProntuario, paciente_cpf, dataAbertura, detalhes, alergias, limitacoes) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, prontuario.getIdProntuario());
            stmt.setString(2, prontuario.getPaciente().getCpf());
            stmt.setObject(3, prontuario.getDataAbertura());
            stmt.setString(4, prontuario.getDetalhes());
            stmt.setString(5, prontuario.getAlergias());
            stmt.setString(6, prontuario.getLimitacoes());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar prontuário: " + e.getMessage());
        }
    }

    public Prontuario consultarProntuario(String idProntuario) throws ExceptionDAO {
        String sql = "SELECT * FROM Prontuario WHERE idProntuario = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idProntuario);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Paciente paciente = new PacienteDAO().consultarPaciente(rs.getString("paciente_cpf"));
                return new Prontuario(
                    rs.getString("idProntuario"),
                    paciente,
                    rs.getObject("dataAbertura", LocalDateTime.class),
                    rs.getString("detalhes"),
                    rs.getString("alergias"),
                    rs.getString("limitacoes")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar prontuário: " + e.getMessage());
        }
        return null; // Se não encontrar
    }

    public void alterarProntuario(Prontuario prontuario) throws ExceptionDAO {
        String sql = "UPDATE Prontuario SET dataAbertura = ?, detalhes = ?, alergias = ?, limitacoes = ? WHERE idProntuario = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, prontuario.getDataAbertura());
            stmt.setString(2, prontuario.getDetalhes());
            stmt.setString(3, prontuario.getAlergias());
            stmt.setString(4, prontuario.getLimitacoes());
            stmt.setString(5, prontuario.getIdProntuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar prontuário: " + e.getMessage());
        }
    }

    public void excluirProntuario(String idProntuario) throws ExceptionDAO {
        String sql = "DELETE FROM Prontuario WHERE idProntuario = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idProntuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir prontuário: " + e.getMessage());
        }
    }
}
