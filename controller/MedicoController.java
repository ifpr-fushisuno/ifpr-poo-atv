import java.util.List;

public class MedicoController {
    private MedicoDAO medicoDAO = new MedicoDAO();

    public void adicionarMedico(Medico medico) {
        medicoDAO.save(medico);
    }

    public Medico buscarMedico(String crm) {
        return medicoDAO.findByCrm(crm);
    }

    public void atualizarMedico(Medico medico) {
        medicoDAO.update(medico);
    }

    public void deletarMedico(String crm) {
        medicoDAO.delete(crm);
    }

    public List<Medico> listarMedicos() {
        return medicoDAO.findAll();
    }
}
