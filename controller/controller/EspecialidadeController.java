package controller;
import dao.EspecialidadeDAO;
import model.Especialidade;

public class EspecialidadeController {

    private EspecialidadeDAO especialidadeDAO;

    public EspecialidadeController() {
        this.especialidadeDAO = new EspecialidadeDAO();
    }

    public void cadastrarEspecialidade(String nome) throws Exception {
        if (nome != null && !nome.isEmpty()) {
            Especialidade especialidade = new Especialidade(nome);
            especialidadeDAO.cadastrarEspecialidade(especialidade);
        } else {
            throw new Exception("Nome da especialidade não pode ser vazio!");
        }
    }

    public Especialidade consultarEspecialidade(String nome) throws Exception {
        if (nome != null && !nome.isEmpty()) {
            return especialidadeDAO.consultarEspecialidade(nome);
        } else {
            throw new Exception("Nome da especialidade inválido!");
        }
    }

    public void alterarEspecialidade(String nome) throws Exception {
        if (nome != null && !nome.isEmpty()) {
            Especialidade especialidade = new Especialidade(nome);
            especialidadeDAO.alterarEspecialidade(especialidade);
        } else {
            throw new Exception("Nome da especialidade não pode ser vazio!");
        }
    }

    public void excluirEspecialidade(String nome) throws Exception {
        if (nome != null && !nome.isEmpty()) {
            especialidadeDAO.excluirEspecialidade(nome);
        } else {
            throw new Exception("Nome da especialidade inválido!");
        }
    }
}
