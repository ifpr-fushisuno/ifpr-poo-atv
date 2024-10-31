import java.util.List;

public class ConsultaController {
    private ConsultaDAO consultaDAO = new ConsultaDAO();

    public void agendarConsulta(Consulta consulta) {
        consultaDAO.save(consulta);
    }

    public void cancelarConsulta(String idConsulta) {
        consultaDAO.delete(idConsulta);
    }

    public List<Consulta> listarConsultas() {
        return consultaDAO.findAll();
    }

    public List<Consulta> listarConsultasPorPaciente(Paciente paciente) {
        return consultaDAO.findByPaciente(paciente);
    }
}
