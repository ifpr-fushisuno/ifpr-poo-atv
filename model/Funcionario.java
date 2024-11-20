package model;

import java.sql.Date;

import dao.FuncionarioDAO;
import dao.ExceptionDAO;

public class Funcionario extends Pessoa {
    private int idFuncionario;
    private String login;
    private String senha;
    private String cargo;

    public Funcionario() {
    }

    public Funcionario(int idPessoa, String nome, String telefone, String rg, String cpf, Date dataNascimento,
            String sexo, String profissao, String endereco) {
        super(idPessoa, nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
    }

    public Funcionario(int idFuncionario, String login, String senha, String cargo) {
        this.idFuncionario = idFuncionario;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Funcionario(int idPessoa, String nome, String telefone, String rg, String cpf, Date dataNascimento,
            String sexo, String profissao, String endereco, int idFuncionario, String login, String senha,
            String cargo) {
        super(idPessoa, nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
        this.idFuncionario = idFuncionario;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void cadastrarCliente(Funcionario Funcionario) throws ExceptionDAO {
        new FuncionarioDAO().cadastrarFuncionario(Funcionario);
    }

    public void alterarFuncionario(Funcionario Funcionario) throws ExceptionDAO {
        new FuncionarioDAO().alterarFuncionario(Funcionario);
    }

    public void excluirFuncionario(int idFuncionario) throws ExceptionDAO {
        new FuncionarioDAO().excluirFuncionario(idFuncionario);
    }
}
