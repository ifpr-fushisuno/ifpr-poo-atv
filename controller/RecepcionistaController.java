package controller;

import dao.PacienteDAO;
import model.Paciente;
import model.Recepcionista;
import java.util.List;

/**
 * Classe controladora responsável por gerenciar as interações
 * entre a view e o modelo, coordenando a lógica de operações.
 */
public class RecepcionistaController {
    private PacienteDAO pacienteDAO;

    public RecepcionistaController() {
        this.pacienteDAO = new PacienteDAO();
    }

    // Método para cadastrar um paciente
    public void cadastrarPaciente(Paciente paciente) {
        pacienteDAO.salvarPaciente(paciente); // Utiliza o DAO para persistir o paciente
    }

    // Método para listar todos os pacientes
    public List<Paciente> listarPacientes() {
        return pacienteDAO.listarTodosPacientes(); // Utiliza o DAO para recuperar pacientes
    }

    // Método para editar um paciente
    public void editarPaciente(Paciente paciente) {
        pacienteDAO.atualizarPacientes(paciente); // Utiliza o DAO para atualizar o paciente
    }

    // Método para deletar um paciente
    public void excluirPaciente(int pacienteId) {
        pacienteDAO.deletarPacientes(pacienteId); // Utiliza o DAO para excluir o paciente
    }
}
