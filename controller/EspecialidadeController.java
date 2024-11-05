import java.util.List;

public class EspecialidadeController {
    private EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();

    public void adicionarEspecialidade(Especialidade especialidade) {
        especialidadeDAO.save(especialidade);
    }

    public List<Especialidade> listarEspecialidades() {
        return especialidadeDAO.findAll();
    }
}
