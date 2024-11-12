package controller;

import dao.AgendaDAO;
import model.Agenda;
import model.Consulta;
import model.Medico;
import model.Paciente;

import java.util.List;

public class AgendaController {

    private AgendaDAO agendaDAO;

    public AgendaController() {
        this.agendaDAO = new AgendaDAO();
    }

    public boolean agendarConsulta(Consulta consulta) throws Exception {
        if (agendaDAO != null) {
            boolean result = agendaDAO.agendarConsulta(consulta);
            return result;
        }
        throw new Exception("Erro ao agendar a consulta.");
    }

    public void cancelarConsulta(String idConsulta) throws Exception {
        if (idConsulta != null && !idConsulta.isEmpty()) {
            agendaDAO.cancelarConsulta(idConsulta);
        } else {
            throw new Exception("ID da consulta inválido!");
        }
    }

    public List<Consulta> listarConsultas() throws Exception {
        return agendaDAO.listarConsultas();
    }

    public List<Consulta> listarConsultasPorMedico(Medico medico) throws Exception {
        if (medico != null) {
            return agendaDAO.listarConsultasPorMedico(medico.getCrm());
        }
        throw new Exception("Médico não pode ser nulo!");
    }
}
