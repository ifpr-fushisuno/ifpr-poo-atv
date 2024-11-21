package dao;

import model.Paciente;
import java.sql.*;

public class PacienteDAO {

    public void createPaciente(Paciente paciente, int idPessoa) throws ExceptionDAO {
        String sql = "INSERT INTO Paciente (idPessoa, etnia, tipoSanguineo, fatorRh, peso, altura, doador, fumante, doencas, limitacoes) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
		Connection conn = null;
        try{
        	conn = new ConexaoBD().getConnection();
			stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idPessoa);
            stmt.setString(2, paciente.getEtnia());
            stmt.setString(3, paciente.getTipoSanguineo());
            stmt.setBoolean(4, paciente.getFatorRh());
            stmt.setDouble(5, paciente.getPeso());
            stmt.setDouble(6, paciente.getAltura());
            stmt.setBoolean(7, paciente.isDoador());
            stmt.setBoolean(8, paciente.isFumante());
            stmt.setString(9, paciente.getDoencas());
            stmt.setString(10, paciente.getLimitacoes());

            // Executa a inserção do Paciente na tabela Paciente
            stmt.executeUpdate();

        } catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao cadastrar Pessoa: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void updatePaciente(Paciente paciente) throws ExceptionDAO {
        String sql = "UPDATE Paciente SET etnia = ?, tipoSanguineo = ?, fatorRh = ?, peso = ?, altura = ?, doador = ?, fumante = ?, doencas = ?, limitacoes = ? WHERE idPaciente = ?";
        try (Connection conn = new ConexaoBD().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, paciente.getEtnia());
            stmt.setString(2, paciente.getTipoSanguineo());
            stmt.setBoolean(3, paciente.getFatorRh());
            stmt.setDouble(4, paciente.getPeso());
            stmt.setDouble(5, paciente.getAltura());
            stmt.setBoolean(6, paciente.isDoador());
            stmt.setBoolean(7, paciente.isFumante());
            stmt.setString(8, paciente.getDoencas());
            stmt.setString(9, paciente.getLimitacoes());
            stmt.setInt(10, paciente.getIdPaciente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar Pessoa: " + e);
        }
    }

	public void deletePaciente(int idPaciente) throws ExceptionDAO {
		String sql = "DELETE FROM Paciente WHERE idPaciente = ?";
		try (Connection conn = new ConexaoBD().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, idPaciente);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao excluir Paciente: " + e);
		}
	}
    
    public Paciente getPacienteByCpf(String cpf) throws ExceptionDAO {
        String sql = "SELECT p.idPessoa, p.nome, p.telefone, p.cpf, a.etnia, a.tipoSanguineo, a.fatorRh, a.peso, a.altura, a.doador, a.fumante, a.doencas, a.limitacoes "
                    + "FROM Pessoa p "
                    + "JOIN Paciente a ON p.idPessoa = a.idPessoa "
                    + "WHERE p.cpf = ?"; 
        
        try (Connection connection = new ConexaoBD().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, cpf);  // Define o valor do CPF para a consulta
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Paciente paciente = new Paciente();
                // Pessoa
                paciente.setIdPessoa(rs.getInt("idPessoa"));
                paciente.setNome(rs.getString("nome"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setCpf(rs.getString("cpf"));
                
                // Paciente
                paciente.setEtnia(rs.getString("etnia"));
                paciente.setTipoSanguineo(rs.getString("tipoSanguineo"));
                paciente.setFatorRh(rs.getBoolean("fatorRh"));
                paciente.setPeso(rs.getDouble("peso"));
                paciente.setAltura(rs.getDouble("altura"));
                paciente.setDoador(rs.getBoolean("doador"));
                paciente.setFumante(rs.getBoolean("fumante"));
                paciente.setDoencas(rs.getString("doencas"));
                paciente.setLimitacoes(rs.getString("limitacoes"));
                
                return paciente;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar Paciente: " + e);
    }
        return null;  
    }

}
