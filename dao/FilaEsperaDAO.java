package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.FilaEspera;
import model.Medico;
import model.Paciente;

public class FilaEsperaDAO {

    public void adicionarPaciente(FilaEspera filaEspera, Paciente paciente) throws ExceptionDAO {
        String sql = "INSERT INTO FilaEspera (medico_crm, paciente_cpf) VALUES (?, ?)";
        
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            //stmt.setString(1, filaEspera.getMedico().getCrm());
            stmt.setString(2, paciente.getCpf());
            stmt.executeUpdate();
            filaEspera.adicionarPaciente(paciente); // Adiciona paciente à fila em memória
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao adicionar paciente à fila: " + e.getMessage());
        }
    }

    public Paciente removerPaciente(FilaEspera filaEspera) throws ExceptionDAO {
        if (filaEspera.tamanhoFila() > 0) {
            Paciente paciente = filaEspera.removerPaciente();
            String sql = "DELETE FROM FilaEspera WHERE medico_crm = ? AND paciente_cpf = ?";
            
            try (Connection connection = new ConexaoBD().getConnection();
                 PreparedStatement stmt = connection.prepareStatement(sql)) {
                //stmt.setString(1, filaEspera.getMedico().getCrm());
                stmt.setString(2, paciente.getCpf());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ExceptionDAO("Erro ao remover paciente da fila: " + e.getMessage());
            }
            return paciente;
        }
        return null;
    }

    public List<Paciente> consultarFila(String medicoCrm) throws ExceptionDAO {
        String sql = "SELECT paciente_cpf FROM FilaEspera WHERE medico_crm = ?";
        List<Paciente> pacientes = new ArrayList<>();
        
        try (Connection connection = new ConexaoBD().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medicoCrm);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Paciente paciente = new PacienteDAO().consultarPaciente(rs.getString("paciente_cpf"));
                if (paciente != null) {
                    pacientes.add(paciente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao consultar fila: " + e.getMessage());
        }
        return pacientes;
    }
}
