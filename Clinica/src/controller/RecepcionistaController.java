package controller;

import model.Recepcionista;
import model.Pessoa;
import dao.RecepcionistaDAO;

public class RecepcionistaController {

    public void createRecepcionista(Pessoa pessoa, String login, String senha, String cargo) throws Exception {
        if (pessoa.getIdPessoa() > 0 && login != null && senha != null && cargo != null) {
            Recepcionista recepcionista = new Recepcionista();
            recepcionista.setLogin(login);
            recepcionista.setSenha(senha);
            recepcionista.setCargo(cargo);
            recepcionista.setIdPessoa(pessoa.getIdPessoa()); // Associando a pessoa
            recepcionista.createRecepcionista(recepcionista);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void updateRecepcionista(int idRecepcionista, String login, String senha, String cargo) throws Exception {
        if (idRecepcionista > 0 && login != null && senha != null && cargo != null) {
            Recepcionista recepcionista = new Recepcionista();
            recepcionista.setIdRecepcionista(idRecepcionista);
            recepcionista.setLogin(login);
            recepcionista.setSenha(senha);
            recepcionista.setCargo(cargo);
            recepcionista.updateRecepcionista(recepcionista);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void deleteRecepcionista(int idRecepcionista) throws Exception {
        if (idRecepcionista > 0) {
            Recepcionista recepcionista = new Recepcionista();
            recepcionista.deleteRecepcionista(idRecepcionista);
        } else {
            throw new Exception("ID do Recepcionista é inválido!");
        }
    }

    public Recepcionista getRecepcionistaById(int idRecepcionista) throws Exception {
        if (idRecepcionista > 0) {
            return new RecepcionistaDAO().getRecepcionistaById(idRecepcionista);
        } else {
            throw new Exception("ID do Recepcionista é inválido!");
        }
    }

    // Implement other methods as needed for fetching by CPF, etc.
}
