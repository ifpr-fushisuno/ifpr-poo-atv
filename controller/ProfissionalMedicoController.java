package controller;

import dao.ProntuarioDAO;
import model.Prontuario;
import model.ProfissionalMedico;
import java.util.List;

/**
 * Classe controladora responsável por gerenciar as interações
 * entre a view e o modelo, coordenando a lógica de operações.
 */
public class ProfissionalMedicoController {
    private ProntuarioDAO prontuarioDAO;

    public ProfissionalMedicoController() {
        this.prontuarioDAO = new ProntuarioDAO();
    }

    // Método para cadastrar um prontuário
    public void cadastrarProntuario(Prontuario prontuario) {
        prontuarioDAO.salvarProntuario(prontuario); // Utiliza o DAO para persistir o prontuário
    }

    // Método para listar todos os prontuários
    public List<Prontuario> listarProntuarios() {
        return prontuarioDAO.buscarTodosProntuarios(); // Utiliza o DAO para recuperar os prontuários
    }

    // Método para editar um prontuário
    public void editarProntuario(Prontuario prontuario) {
        prontuarioDAO.atualizarProntuario(prontuario); // Utiliza o DAO para atualizar o prontuário
    }

    // Método para deletar um prontuário
    public void excluirProntuario(int prontuarioId) {
        prontuarioDAO.excluirProntuario(prontuarioId); // Utiliza o DAO para excluir o prontuário
    }

    // Método para visualizar um prontuário específico
    public Prontuario visualizarProntuario(int prontuarioId) {
        return prontuarioDAO.buscarProntuarioPorId(prontuarioId); // Utiliza o DAO para buscar um prontuário específico
    }
}
