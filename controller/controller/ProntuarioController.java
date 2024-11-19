package controller;

import dao.ProntuarioDAO;
import model.Prontuario;
import model.Paciente;

import java.time.LocalDateTime;

public class ProntuarioController {

    private ProntuarioDAO prontuarioDAO;

    public ProntuarioController() {
        this.prontuarioDAO = new ProntuarioDAO();
    }

    public void cadastrarProntuario(String idProntuario, Paciente paciente, LocalDateTime dataAbertura, String detalhes, String alergias, String limitacoes) throws Exception {
        if (idProntuario != null && paciente != null && dataAbertura != null) {
            Prontuario prontuario = new Prontuario(idProntuario, paciente, dataAbertura, detalhes, alergias, limitacoes);
            prontuarioDAO.cadastrarProntuario(prontuario);
        } else {
            throw new Exception("Dados do prontuário não podem ser nulos!");
        }
    }

    public Prontuario consultarProntuario(String idProntuario) throws Exception {
        if (idProntuario != null && !idProntuario.isEmpty()) {
            return prontuarioDAO.consultarProntuario(idProntuario);
        } else {
            throw new Exception("ID do prontuário inválido!");
        }
    }

    public void alterarProntuario(Prontuario prontuario) throws Exception {
        if (prontuario != null && prontuario.getIdProntuario() != null) {
            prontuarioDAO.alterarProntuario(prontuario);
        } else {
            throw new Exception("Dados do prontuário não podem ser nulos!");
        }
    }

    public void excluirProntuario(String idProntuario) throws Exception {
        if (idProntuario != null && !idProntuario.isEmpty()) {
            prontuarioDAO.excluirProntuario(idProntuario);
        } else {
            throw new Exception("ID do prontuário inválido!");
        }
    }
}
