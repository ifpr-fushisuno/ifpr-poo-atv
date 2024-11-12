package controller;

import dao.MedicoDAO;
import model.Medico;

public class MedicoController {

    public void cadastrarMedico(String crm, String nome, String especialidade) throws Exception {
        if (crm != null && !crm.isEmpty() && nome != null && !nome.isEmpty() && especialidade != null && !especialidade.isEmpty()) {
            Medico medico = new Medico(crm, nome, especialidade);
            new MedicoDAO().cadastrarMedico(medico);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public Medico consultarMedico(String crm) throws Exception {
        if (crm != null && !crm.isEmpty()) {
            return new MedicoDAO().consultarMedico(crm);
        } else {
            throw new Exception("CRM inválido!");
        }
    }

    public void alterarMedico(String crm, String nome, String especialidade) throws Exception {
        if (crm != null && !crm.isEmpty() && nome != null && !nome.isEmpty() && especialidade != null && !especialidade.isEmpty()) {
            Medico medico = new Medico(crm, nome, especialidade);
            new MedicoDAO().alterarMedico(medico);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void excluirMedico(String crm) throws Exception {
        if (crm != null && !crm.isEmpty()) {
            new MedicoDAO().excluirMedico(crm);
        } else {
            throw new Exception("CRM inválido!");
        }
    }
}
