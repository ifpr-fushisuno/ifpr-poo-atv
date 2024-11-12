package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Funcionario;

public class FuncionarioDAO {

    public void cadastrarFuncionario(Funcionario funcionario) throws ExceptionDAO {
        String sql = "INSERT INTO Funcionario (id, nome, cargo, senha) VALUES (?, ?, ?, ?)";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCargo());
            stmt.setString(4, funcionario.getSenha());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    public Funcionario consultarFuncionario(String id) throws ExceptionDAO {
        String sql = "SELECT * FROM Funcionario WHERE id = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Funcionario funcionario = new Funcionario(rs.getString("id"), rs.getString("nome"), rs.getString("cargo"), rs.getString("senha"));
                return funcionario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar funcionário: " + e.getMessage());
        } 
        return null;
    }

    public void alterarFuncionario(Funcionario funcionario) throws ExceptionDAO {
        String sql = "UPDATE Funcionario SET nome = ?, cargo = ?, senha = ? WHERE id = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getSenha());
            stmt.setString(4, funcionario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar funcionário: " + e.getMessage());
        } 
    }

    public void excluirFuncionario(String id) throws ExceptionDAO {
        String sql = "DELETE FROM Funcionario WHERE id = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir funcionário: " + e.getMessage());
        } 
    }
}
