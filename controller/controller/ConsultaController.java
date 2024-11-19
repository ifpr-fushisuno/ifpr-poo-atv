package controller;

import dao.ConsultaDAO;
import model.Consulta;
import model.Paciente;
import model.Medico;

import java.util.List;

public class ConsultaController {

    private ConsultaDAO consultaDAO;

    public ConsultaController() {
        this.consultaDAO = new ConsultaDAO();
    }

    public void cadastrarConsulta(String idConsulta, Paciente paciente, Medico medico, LocalDateTime dataHora, String status) throws Exception {
        if (paciente != null && medico != null && dataHora != null && status != null) {
            Consulta consulta = new Consulta(idConsulta, paciente, medico, dataHora, status);
            consultaDAO.cadastrarConsulta(consulta);
        } else {
            throw new Exception("Dados da consulta inválidos!");
        }
    }

    public Consulta consultarConsulta(String idConsulta) throws Exception {
        if (idConsulta != null && !idConsulta.isEmpty()) {
            return consultaDAO.consultarConsulta(idConsulta);
        } else {
            throw new Exception("ID da consulta inválido!");
        }
    }

    public void alterarConsulta(Consulta consulta) throws Exception {
        if (consulta != null) {
            consultaDAO.alterarConsulta(consulta);
        } else {
            throw new Exception("Consulta inválida!");
        }
    }

    public void excluirConsulta(String idConsulta) throws Exception {
        if (idConsulta != null && !idConsulta.isEmpty()) {
            consultaDAO.excluirConsulta(idConsulta);
        } else {
            throw new Exception("ID da consulta inválido!");
        }
    }

    public List<Consulta> listarConsultasPorPaciente(Paciente paciente) throws Exception {
        if (paciente != null) {
            return consultaDAO.listarConsultasPorPaciente(paciente.getCpf());
        } else {
            throw new Exception("Paciente inválido!");
        }
    }
}
