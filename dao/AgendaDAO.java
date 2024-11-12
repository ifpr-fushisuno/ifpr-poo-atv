package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Agenda;
import model.Consulta;
import model.Medico;

public class AgendaDAO {

    public void agendarConsulta(Consulta consulta) throws ExceptionDAO {
        String sql = "INSERT INTO Consulta (idConsulta, dataHora, medico_crm, paciente_cpf) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, consulta.getIdConsulta());
            stmt.setObject(2, consulta.getDataHora());
            stmt.setString(3, consulta.getMedico().getCrm());
            stmt.setString(4, consulta.getPaciente().getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao agendar consulta: " + e.getMessage());
        }
    }

    public void cancelarConsulta(String idConsulta) throws ExceptionDAO {
        String sql = "DELETE FROM Consulta WHERE idConsulta = ?";
        
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idConsulta);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cancelar consulta: " + e.getMessage());
        }
    }

    // public List<Consulta> listarConsultas() throws ExceptionDAO {
    //     String sql = "SELECT * FROM Consulta";
    //     List<Consulta> consultas = new ArrayList<>();
        
    //     try (Connection connection = new ConexaoBD().getConnection();
    //          PreparedStatement stmt = connection.prepareStatement(sql);
    //          ResultSet rs = stmt.executeQuery()) {
            
    //         while (rs.next()) {
    //             Consulta consulta = new Consulta(
    //                 rs.getString("idConsulta"),
    //                 //rs.getObject("dataHora", LocalDateTime.class),
    //                 new Medico(rs.getString("medico_crm"), "", ""), // Supondo que você terá método para preencher os dados do médico
    //                 // Aqui, você também deve instanciar o paciente de forma semelhante, utilizando um método que preencha os dados.
    //             );
    //             consultas.add(consulta);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         throw new ExceptionDAO("Erro ao listar consultas: " + e.getMessage());
    //     }
    //     return consultas;
    // }

    // public List<Consulta> listarConsultasPorMedico(String crm) throws ExceptionDAO {
    //     String sql = "SELECT * FROM Consulta WHERE medico_crm = ?";
    //     List<Consulta> consultas = new ArrayList<>();
        
    //     try (Connection connection = new ConexaoBD().getConnection();
    //          PreparedStatement stmt = connection.prepareStatement(sql)) {
    //         stmt.setString(1, crm);
    //         ResultSet rs = stmt.executeQuery();
            
    //         while (rs.next()) {
    //             // Preencher instâncias de Consulta conforme o padrão anterior
    //             Consulta consulta = new Consulta(
    //                 rs.getString("idConsulta"),
    //                 rs.getObject("dataHora", LocalDateTime.class),
    //                 new Medico(rs.getString("medico_crm"), "", "") // Atualizar conforme necessário
    //                 // Preencher o paciente
    //             );
    //             consultas.add(consulta);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         throw new ExceptionDAO("Erro ao listar consultas por médico: " + e.getMessage());
    //     }
    //     return consultas;
    // }
}
