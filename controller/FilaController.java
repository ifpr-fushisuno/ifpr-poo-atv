import java.util.List;

public class FilaEsperaController {
    private FilaEsperaDAO filaEsperaDAO = new FilaEsperaDAO();

    public void adicionarPacienteAFila(Medico medico, Paciente paciente) {
        FilaEspera fila = filaEsperaDAO.findByMedico(medico);
        if (fila != null) {
            fila.adicionarPaciente(paciente);
        }
    }

    public Paciente removerPacienteDaFila(Medico medico) {
        FilaEspera fila = filaEsperaDAO.findByMedico(medico);
        return fila != null ? fila.removerPaciente() : null;
    }

    public List<Paciente> listarPacientesDaFila(Medico medico) {
        FilaEspera fila = filaEsperaDAO.findByMedico(medico);
        return fila != null ? fila.getFila() : null;
    }
}
