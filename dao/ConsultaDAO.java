package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Consulta;

public class ConsultaDAO {
    
    public void createConsulta(Consulta consulta){
        String sql = "INSERT INTO Consulta(idPaciente, idProfissional, dataHoraConsulta, statusConsulta) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = new ConexaoBD().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, consulta.paciente.idPaciente);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
