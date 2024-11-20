package dao;

import model.Paciente;
import java.sql.*;

public class PacienteDAO {
    private PessoaDAO pessoaDAO;

    public PacienteDAO() {
        this.pessoaDAO = new PessoaDAO();
    }

    public void createPaciente(Paciente Paciente) throws ExceptionDAO {
        // Cadastra a pessoa e obtém o idPessoa gerado
        int idPessoa = pessoaDAO.cadastrarPessoa(Paciente); // cadastra a pessoa e obtém o idPessoa
        Paciente.setIdPessoa(idPessoa); // Define o idPessoa no Paciente

        String sql = "INSERT INTO Paciente (idPessoa, etnia, tipoSanguineo, fatorRh, peso, altura, doador, fumante, doencas, limitacoes) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, idPessoa);
            stmt.setString(2, Paciente.getEtnia());
            stmt.setString(3, Paciente.getTipoSanguineo());
            stmt.setBoolean(4, Paciente.isFatorRh());
            stmt.setDouble(5, Paciente.getPeso());
            stmt.setDouble(6, Paciente.getAltura());
            stmt.setBoolean(7, Paciente.isDoador());
            stmt.setBoolean(8, Paciente.isFumante());
            stmt.setString(9, Paciente.getDoencas());
            stmt.setString(10, Paciente.getLimitacoes());

            // Executa a inserção do Paciente na tabela Paciente
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar Paciente: " + e);
        }  
        finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} try {
			if (connection != null) {
				connection.close();
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
