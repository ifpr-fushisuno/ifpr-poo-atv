package dao;

import model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {

    public void createFuncionario(Funcionario funcionario, int idPessoa) throws ExceptionDAO {
        String sql = "INSERT INTO Funcionario (idPessoa, login, senha, cargo) VALUES (?, ?, ?, ?)";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, idPessoa);
            stmt.setString(2, funcionario.getLogin());
            stmt.setString(3, funcionario.getSenha());
            stmt.setString(4, funcionario.getCargo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar Funcionário: " + e);
        }
    }

    public void updateFuncionario(Funcionario funcionario) throws ExceptionDAO {
        String sql = "UPDATE Funcionario SET login = ?, senha = ?, cargo = ? WHERE idFuncionario = ?";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, funcionario.getLogin());
            stmt.setString(2, funcionario.getSenha());
            stmt.setString(3, funcionario.getCargo());
            stmt.setInt(4, funcionario.getIdFuncionario());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar Funcionário: " + e);
        }
    }

    public void deleteFuncionario(int idFuncionario) throws ExceptionDAO {
        String sql = "DELETE FROM Funcionario WHERE idFuncionario = ?";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, idFuncionario);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir Funcionário: " + e);
        }
    }

    public Funcionario getFuncionarioById(int idFuncionario) throws ExceptionDAO {
        String sql = "SELECT p.idPessoa, p.nome, p.telefone, p.cpf, f.login, f.senha, f.cargo "
                     + "FROM Pessoa p "
                     + "JOIN Funcionario f ON p.idPessoa = f.idPessoa "
                     + "WHERE f.idFuncionario = ?";
        
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
             
            stmt.setInt(1, idFuncionario);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                // Pessoa
                funcionario.setIdPessoa(rs.getInt("idPessoa"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCpf(rs.getString("cpf"));

                // Funcionario
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCargo(rs.getString("cargo"));
                
                return funcionario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar Funcionário: " + e);
        }
        return null;
    }
    
    public Funcionario getFuncionarioByCpf(String cpf) throws ExceptionDAO {
        String sql = "SELECT p.idPessoa, p.nome, p.telefone, p.cpf, f.login, f.senha, f.cargo "
                     + "FROM Pessoa p "
                     + "JOIN Funcionario f ON p.idPessoa = f.idPessoa "
                     + "WHERE p.cpf = ?";

        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
             
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                // Pessoa
                funcionario.setIdPessoa(rs.getInt("idPessoa"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCpf(rs.getString("cpf"));

                // Funcionario
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCargo(rs.getString("cargo"));

                return funcionario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar Funcionário: " + e);
        }
        return null;
    }

}
