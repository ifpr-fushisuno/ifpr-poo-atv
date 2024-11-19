package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Teste;

public class TesteDAO {

    public void cadastrarTeste(Teste teste) throws ExceptionDAO {
        String sql = "INSERT INTO teste (id, nome) VALUES (?, ?)";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, teste.getId());
            stmt.setString(2, teste.getNome());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar teste: " + e.getMessage());
        }
    }

    public Teste consultarTeste(int id) throws ExceptionDAO {
        String sql = "SELECT * FROM teste WHERE id = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Teste teste = new Teste();
                teste.setId(rs.getInt("id"));
                teste.setNome(rs.getString("nome"));
                return teste;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar teste: " + e.getMessage());
        }
        return null;
    }

    public void alterarTeste(Teste teste) throws ExceptionDAO {
        String sql = "UPDATE teste SET nome = ? WHERE id = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, teste.getNome());
            stmt.setInt(2, teste.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar teste: " + e.getMessage());
        }
    }

    public void excluirTeste(int id) throws ExceptionDAO {
        String sql = "DELETE FROM teste WHERE id = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir teste: " + e.getMessage());
        }
    }
}
