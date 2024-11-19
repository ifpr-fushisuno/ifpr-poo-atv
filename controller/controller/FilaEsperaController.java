package controller;
import dao.FilaEsperaDAO;
import model.FilaEspera;
import model.Medico;
import model.Paciente;

import java.util.List;

public class FilaEsperaController {

    private FilaEsperaDAO filaEsperaDAO;

    public FilaEsperaController() {
        this.filaEsperaDAO = new FilaEsperaDAO();
    }

    public void adicionarPaciente(FilaEspera filaEspera, Paciente paciente) throws Exception {
        if (paciente != null) {
            filaEsperaDAO.adicionarPaciente(filaEspera, paciente);
        } else {
            throw new Exception("Paciente não pode ser nulo!");
        }
    }

    public Paciente removerPaciente(FilaEspera filaEspera) throws Exception {
        Paciente paciente = filaEsperaDAO.removerPaciente(filaEspera);
        if (paciente == null) {
            throw new Exception("A fila está vazia!");
        }
        return paciente;
    }

    public List<Paciente> consultarFila(Medico medico) throws Exception {
        if (medico != null) {
            return filaEsperaDAO.consultarFila(medico.getCrm());
        }
        throw new Exception("Médico não pode ser nulo!");
    }
}
