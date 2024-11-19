package dao;

import java.sql.*;
import model.Usuario;

public class UsuarioDAO {

    // Método para cadastrar um novo usuário
    public void save(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password, tipo) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword()); // Considere usar hashing na senha
            stmt.setString(3, usuario.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para autenticar um usuário
    public boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password); // Considere usar hashing na comparação de senhas
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retorna true se encontrar o usuário
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para buscar um usuário pelo nome de usuário
    public Usuario findByUsername(String username) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getString("username"), rs.getString("password"), rs.getString("tipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
