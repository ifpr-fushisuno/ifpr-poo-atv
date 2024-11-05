import java.util.List;

public class PacienteController {
    private PacienteDAO pacienteDAO = new PacienteDAO();

    public void adicionarPaciente(Paciente paciente) {
        pacienteDAO.save(paciente);
    }

    public Paciente buscarPaciente(String cpf) {
        return pacienteDAO.findByCpf(cpf);
    }
    
    public void atualizarPaciente(Paciente paciente) {
        pacienteDAO.update(paciente);
    }

    public void deletarPaciente(String cpf) {
        pacienteDAO.delete(cpf);
    }

    public List<Paciente> listarPacientes() {
        return pacienteDAO.findAll();
    }
}
