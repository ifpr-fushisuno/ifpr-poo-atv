package dao;

import model.Recepcionista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecepcionistaDAO {

    public void createRecepcionista(Recepcionista recepcionista) throws ExceptionDAO {
        String sql = "INSERT INTO Recepcionista (idFuncionario) VALUES (?);";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, recepcionista.getIdFuncionario());
			stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao criar Recepcionista: " + e.getMessage());
        }
    }


    public void updateRecepcionista(Recepcionista recepcionista) throws ExceptionDAO {
        String sql = "UPDATE Recepcionista SET login = ?, senha = ?, cargo = ? WHERE idRecepcionista = ?;";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, recepcionista.getLogin());
            stmt.setString(2, recepcionista.getSenha());
            stmt.setString(3, recepcionista.getCargo());
            stmt.setInt(4, recepcionista.getIdRecepcionista());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao atualizar Recepcionista: " + e.getMessage());
        }
    }

    public void deleteRecepcionista(int idRecepcionista) throws ExceptionDAO {
        String sql = "DELETE FROM Recepcionista WHERE idRecepcionista = ?;";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idRecepcionista);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir Recepcionista: " + e.getMessage());
        }
    }

    public Recepcionista getRecepcionistaById(int idRecepcionista) throws ExceptionDAO {
        String sql = "SELECT * FROM Recepcionista WHERE idRecepcionista = ?;";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idRecepcionista);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Recepcionista recepcionista = new Recepcionista();
                recepcionista.setIdRecepcionista(rs.getInt("idRecepcionista"));
                recepcionista.setLogin(rs.getString("login"));
                recepcionista.setSenha(rs.getString("senha"));
                recepcionista.setCargo(rs.getString("cargo"));
                // Assumindo que você tem um método para configurar a pessoa associada
                // recepcionista.setPessoaId(rs.getInt("idPessoa"));
                return recepcionista;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao buscar Recepcionista: " + e.getMessage());
        }
        return null; // Se não encontrado
    }

    // Implement other methods as needed, such as getRecepcionistaByCpf
}
