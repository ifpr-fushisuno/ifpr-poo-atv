package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Paciente;

public class PacienteDAO {

    public void cadastrarPaciente(Paciente paciente) throws ExceptionDAO {
        String sql = "INSERT INTO Paciente (cpf, nome, endereco, telefone, tipoSanguineo, fatorRH, sexo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getCpf());
            stmt.setString(2, paciente.getNome());
            stmt.setString(3, paciente.getEndereco());
            stmt.setString(4, paciente.getTelefone());
            stmt.setBoolean(6, paciente.getFatorRH());
            //stmt.setString(7, paciente.getSexo().name());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar paciente: " + e.getMessage());
        }
    }

    public Paciente consultarPaciente(String cpf) throws ExceptionDAO {
        String sql = "SELECT * FROM Paciente WHERE cpf = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setCpf(rs.getString("cpf"));
                paciente.setNome(rs.getString("nome"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setTipoSanguinea(rs.getString("tipoSanguineo"));
                paciente.setFatorRH(rs.getBoolean("fatorRH"));
                //paciente.setSexo(Paciente.Sexo.valueOf(rs.getString("sexo")));
                return paciente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar paciente: " + e.getMessage());
        } 
        return null;
    }

    public void alterarPaciente(Paciente paciente) throws ExceptionDAO {
        String sql = "UPDATE Paciente SET nome = ?, endereco = ?, telefone = ?, tipoSanguineo = ?, fatorRH = ?, sexo = ? WHERE cpf = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getEndereco());
            stmt.setString(3, paciente.getTelefone());
            stmt.setString(4, paciente.getTipoSanguineo());
            stmt.setBoolean(5, paciente.getFatorRH());
            //stmt.setString(6, paciente.getSexo().name());
            stmt.setString(7, paciente.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar paciente: " + e.getMessage());
        } 
    }

    public void excluirPaciente(String cpf) throws ExceptionDAO {
        String sql = "DELETE FROM Paciente WHERE cpf = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir paciente: " + e.getMessage());
        } 
    }
}
