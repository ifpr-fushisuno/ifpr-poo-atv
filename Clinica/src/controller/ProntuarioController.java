package controller;

import dao.ProntuarioDAO;
import model.Prontuario;

public class ProntuarioController {

    public void createProntuario(int idPaciente, int idProfissional, String diagnostico, String prescricao) throws Exception {
        if (idPaciente > 0 && idProfissional > 0 && diagnostico != null && prescricao != null) {
            Prontuario prontuario = new Prontuario(idPaciente, idProfissional, diagnostico, prescricao);
            prontuario.createProntuario(prontuario);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void updateProntuario(int idProntuario, int idPaciente, int idProfissional, String diagnostico, String prescricao) throws Exception {
        if (idProntuario > 0 && idPaciente > 0 && idProfissional > 0 && diagnostico != null && prescricao != null) {
            Prontuario prontuario = new Prontuario(idPaciente, idProfissional, diagnostico, prescricao);
            prontuario.setIdProntuario(idProntuario);
            prontuario.updateProntuario(prontuario);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void deleteProntuario(int idProntuario) throws Exception {
        if (idProntuario > 0) {
            new Prontuario().deleteProntuario(idProntuario);
        } else {
            throw new Exception("ID do Prontuário é inválido!");
        }
    }

    public Prontuario getProntuarioById(int idProntuario) throws Exception {
        if (idProntuario > 0) {
            return new ProntuarioDAO().getProntuarioById(idProntuario);
        } else {
            throw new Exception("ID do Prontuário é inválido!");
        }
    }
}

