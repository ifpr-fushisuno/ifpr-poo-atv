package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Especialidade;

public class EspecialidadeDAO {

    public void cadastrarEspecialidade(Especialidade especialidade) throws ExceptionDAO {
        String sql = "INSERT INTO Especialidade (nome) VALUES (?)";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, especialidade.getNome());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar especialidade: " + e.getMessage());
        }
    }

    public Especialidade consultarEspecialidade(String nome) throws ExceptionDAO {
        String sql = "SELECT * FROM Especialidade WHERE nome = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Especialidade(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar especialidade: " + e.getMessage());
        }
        return null; // Se não encontrar
    }

    public void alterarEspecialidade(Especialidade especialidade) throws ExceptionDAO {
        String sql = "UPDATE Especialidade SET nome = ? WHERE nome = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, especialidade.getNome());
            stmt.setString(2, especialidade.getNome()); // Assume que o nome é a chave para atualizar
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar especialidade: " + e.getMessage());
        }
    }

    public void excluirEspecialidade(String nome) throws ExceptionDAO {
        String sql = "DELETE FROM Especialidade WHERE nome = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir especialidade: " + e.getMessage());
        }
    }
}
