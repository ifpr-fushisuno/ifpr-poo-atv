package controller;
import dao.PacienteDAO;
import model.Paciente;

public class PacienteController {

    public void cadastrarPaciente(String cpf, String nome, String endereco, String telefone, String tipoSanguineo, boolean fatorRH, Paciente.Sexo sexo) throws Exception {
        if (cpf != null && !cpf.isEmpty() && nome != null && !nome.isEmpty() && endereco != null && !endereco.isEmpty() && telefone != null && !telefone.isEmpty()) {
            Paciente paciente = new Paciente(cpf, nome, endereco, telefone, tipoSanguineo, fatorRH, sexo);
            new PacienteDAO().cadastrarPaciente(paciente);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public Paciente consultarPaciente(String cpf) throws Exception {
        if (cpf != null && !cpf.isEmpty()) {
            return new PacienteDAO().consultarPaciente(cpf);
        } else {
            throw new Exception("CPF inválido!");
        }
    }

    public void alterarPaciente(String cpf, String nome, String endereco, String telefone, String tipoSanguineo, boolean fatorRH, Paciente.Sexo sexo) throws Exception {
        if (nome != null && !nome.isEmpty() && endereco != null && !endereco.isEmpty() && telefone != null && !telefone.isEmpty()) {
            Paciente paciente = new Paciente(cpf, nome, endereco, telefone, tipoSanguineo, fatorRH, sexo);
            new PacienteDAO().alterarPaciente(paciente);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void excluirPaciente(String cpf) throws Exception {
        if (cpf != null && !cpf.isEmpty()) {
            new PacienteDAO().excluirPaciente(cpf);
        } else {
            throw new Exception("CPF inválido!");
        }
    }
}
