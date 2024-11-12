package controller;

import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioController {

    public void cadastrarFuncionario(String id, String nome, String cargo, String senha) throws Exception {
        if (id != null && !id.isEmpty() && nome != null && !nome.isEmpty() && cargo != null && !cargo.isEmpty() && senha != null && !senha.isEmpty()) {
            Funcionario funcionario = new Funcionario(id, nome, cargo, senha);
            new FuncionarioDAO().cadastrarFuncionario(funcionario);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public Funcionario consultarFuncionario(String id) throws Exception {
        if (id != null && !id.isEmpty()) {
            return new FuncionarioDAO().consultarFuncionario(id);
        } else {
            throw new Exception("ID inválido!");
        }
    }

    public void alterarFuncionario(String id, String nome, String cargo, String senha) throws Exception {
        if (id != null && !id.isEmpty() && nome != null && !nome.isEmpty() && cargo != null && !cargo.isEmpty() && senha != null && !senha.isEmpty()) {
            Funcionario funcionario = new Funcionario(id, nome, cargo, senha);
            new FuncionarioDAO().alterarFuncionario(funcionario);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void excluirFuncionario(String id) throws Exception {
        if (id != null && !id.isEmpty()) {
            new FuncionarioDAO().excluirFuncionario(id);
        } else {
            throw new Exception("ID inválido!");
        }
    }
}
