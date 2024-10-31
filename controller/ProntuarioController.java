import java.util.List;

public class ProntuarioController {
    private ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

    public void adicionarProntuario(Prontuario prontuario) {
        prontuarioDAO.save(prontuario);
    }

    public Prontuario buscarProntuario(String idProntuario) {
        return prontuarioDAO.findById(idProntuario);
    }

    public List<Prontuario> listarProntuarios() {
        return prontuarioDAO.findAll();
    }
}
