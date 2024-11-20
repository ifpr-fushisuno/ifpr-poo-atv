package model;

import dao.RecepcionistaDAO;
import dao.ExceptionDAO;

public class Recepcionista extends Funcionario {
    private int idRecepcionista;
    private int idFuncionario;

    public Recepcionista() {
    }

    public Recepcionista(int idRecepcionista, int idFuncionario) {
        this.idRecepcionista = idRecepcionista;
        this.idFuncionario = idFuncionario;
    }

    public Recepcionista(int idFuncionario, String login, String senha, String cargo, int idRecepcionista,
            int idFuncionario2) {
        super(idFuncionario, login, senha, cargo);
        this.idRecepcionista = idRecepcionista;
        idFuncionario = idFuncionario2;
    }

    public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void cadastrarCliente(Recepcionista Recepcionista) throws ExceptionDAO {
        new RecepcionistaDAO().cadastrarRecepcionista(Recepcionista);
    }

    public void alterarRecepcionista(Recepcionista Recepcionista) throws ExceptionDAO {
        new RecepcionistaDAO().alterarRecepcionista(Recepcionista);
    }

    public void excluirRecepcionista(int idRecepcionista) throws ExceptionDAO {
        new RecepcionistaDAO().excluirRecepcionista(idRecepcionista);
    }
}