package dao;

import model.Paciente;
import java.sql.*;

public class PacienteDAO {
    private PessoaDAO pessoaDAO;

    public PacienteDAO() {
        this.pessoaDAO = new PessoaDAO();
    }

    public void createPaciente(Paciente paciente, int idPessoa) throws ExceptionDAO {
        String sql = "INSERT INTO Paciente (idPessoa, etnia, tipoSanguineo, fatorRh, peso, altura, doador, fumante, doencas, limitacoes) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING idPessoa";
        PreparedStatement stmt = null;
		Connection conn = null;
        try{
        	conn = new ConexaoBD().getConnection();
			stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idPessoa);
            stmt.setString(2, paciente.getEtnia());
            stmt.setString(3, paciente.getTipoSanguineo());
            stmt.setBoolean(4, paciente.isFatorRh());
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
                Paciente Paciente = new Paciente();
                // Pessoa
                Paciente.setIdPessoa(rs.getInt("idPessoa"));
                Paciente.setNome(rs.getString("nome"));
                Paciente.setTelefone(rs.getString("telefone"));
                Paciente.setCpf(rs.getString("cpf"));
                
                // Paceinte
                Paciente.setEtnia(rs.getString("etnia"));
                Paciente.setTipoSanguineo(rs.getString("tipoSanguineo"));
                Paciente.setFatorRh(rs.getBoolean("fatorRh"));
                Paciente.setPeso(rs.getDouble("peso"));
                Paciente.setAltura(rs.getDouble("altura"));
                Paciente.setDoador(rs.getBoolean("doador"));
                Paciente.setFumante(rs.getBoolean("fumante"));
                Paciente.setDoencas(rs.getString("doencas"));
                Paciente.setLimitacoes(rs.getString("limitacoes"));
                
                return Paciente;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar Paciente: " + e);
    }
        return null;  
    }

    
}
