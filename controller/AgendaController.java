import java.util.List;

public class AgendaController {
    private Agenda agenda;

    public AgendaController() {
        this.agenda = new Agenda();
    }

    public boolean agendarConsulta(Consulta consulta) {
        return agenda.agendarConsulta(consulta);
    }

    public void cancelarConsulta(String idConsulta) {
        agenda.cancelarConsulta(idConsulta);
    }

    public List<Consulta> listarConsultas() {
        return agenda.listarConsultas();
    }
    
    public List<Consulta> listarConsultasPorMedico(Medico medico) {
        return agenda.listarConsultasPorMedico(medico);
    }
}
