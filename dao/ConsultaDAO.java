package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Consulta;
import model.Paciente;
import model.Medico;

public class ConsultaDAO {

    public void cadastrarConsulta(Consulta consulta) throws ExceptionDAO {
        String sql = "INSERT INTO Consulta (idConsulta, paciente_cpf, medico_crm, dataHora, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, consulta.getIdConsulta());
            stmt.setString(2, consulta.getPaciente().getCpf());
            stmt.setString(3, consulta.getMedico().getCrm());
            stmt.setObject(4, consulta.getDataHora());
            stmt.setString(5, consulta.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar consulta: " + e.getMessage());
        }
    }

    public Consulta consultarConsulta(String idConsulta) throws ExceptionDAO {
        String sql = "SELECT * FROM Consulta WHERE idConsulta = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idConsulta);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Paciente paciente = new PacienteDAO().consultarPaciente(rs.getString("paciente_cpf"));
                Medico medico = new MedicoDAO().consultarMedico(rs.getString("medico_crm"));
                return new Consulta(
                    rs.getString("idConsulta"),
                    paciente,
                    medico,
                    rs.getObject("dataHora", LocalDateTime.class),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar consulta: " + e.getMessage());
        }
        return null; // Se não encontrar
    }

    public void alterarConsulta(Consulta consulta) throws ExceptionDAO {
        String sql = "UPDATE Consulta SET paciente_cpf = ?, medico_crm = ?, dataHora = ?, status = ? WHERE idConsulta = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, consulta.getPaciente().getCpf());
            stmt.setString(2, consulta.getMedico().getCrm());
            stmt.setObject(3, consulta.getDataHora());
            stmt.setString(4, consulta.getStatus());
            stmt.setString(5, consulta.getIdConsulta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar consulta: " + e.getMessage());
        }
    }

    public void excluirConsulta(String idConsulta) throws ExceptionDAO {
        String sql = "DELETE FROM Consulta WHERE idConsulta = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idConsulta);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir consulta: " + e.getMessage());
        }
    }

    public List<Consulta> listarConsultasPorPaciente(String cpfPaciente) throws ExceptionDAO {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM Consulta WHERE paciente_cpf = ?";
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpfPaciente);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Paciente paciente = new PacienteDAO().consultarPaciente(cpfPaciente);
                Medico medico = new MedicoDAO().consultarMedico(rs.getString("medico_crm"));
                Consulta consulta = new Consulta(
                    rs.getString("idConsulta"),
                    paciente,
                    medico,
                    rs.getObject("dataHora", LocalDateTime.class),
                    rs.getString("status")
                );
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao listar consultas do paciente: " + e.getMessage());
        }
        return consultas;
    }
}
