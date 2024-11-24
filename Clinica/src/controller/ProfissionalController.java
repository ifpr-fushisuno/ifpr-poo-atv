package controller;

import java.sql.Date;

import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.ProfissionalDAO;
import model.Profissional;
import model.Funcionario;
import model.Pessoa;

public class ProfissionalController {

    public void createProfissional(Pessoa pessoa, String especialidade, String registroConselho, java.sql.Date dataInscricao) throws Exception {
        if (pessoa.getIdPessoa() > 0 && especialidade != null && registroConselho != null && dataInscricao != null) {
            Profissional profissional = new Profissional();
            profissional.createProfissional(profissional);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }
    
    public void createFullProfissional(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo, String profissao, String endereco, String login, String senha, String cargo, String especialidade, String registroConselho, Date dataInscricao) throws Exception {
        if (nome != null) {
        	Pessoa pessoa = new Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
        	pessoa.createPessoa(pessoa);
        	pessoa = new PessoaDAO().getPessoaByCpf(pessoa.getCpf());
        	
        	Funcionario funcionario = new Funcionario(login, senha, cargo);
        	funcionario.createFuncionario(funcionario, pessoa.getIdPessoa());
        	funcionario = new FuncionarioDAO().getFuncionarioByCpf(pessoa.getCpf());
        	
        	
        	Profissional Profissional = new Profissional(funcionario.getIdFuncionario(), especialidade, registroConselho, dataInscricao);
            Profissional.createProfissional(Profissional);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void updateProfissional(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo, String profissao, String endereco, String login, String senha, String cargo, String especialidade, String registroConselho, Date dataInscricao) throws Exception {
        if (nome != null) {
        	Pessoa pessoa = new Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
        	pessoa.setIdPessoa(new PessoaDAO().getPessoaByCpf(pessoa.getCpf()).getIdPessoa());
        	pessoa.updatePessoa(pessoa);
        	
        	Funcionario funcionario = new Funcionario(login, senha, cargo);
        	funcionario.setIdFuncionario(new FuncionarioDAO().getFuncionarioByCpf(pessoa.getCpf()).getIdFuncionario());
        	funcionario.updateFuncionario(funcionario);
        	
        	
        	Profissional profissional = new Profissional(funcionario.getIdFuncionario(), especialidade, registroConselho, dataInscricao);
        	profissional.updateProfisssional(profissional);
        } else {
             throw new Exception("Preencha os campos corretamente!");
         }
    }

    public void deleteProfissional(String cpf) throws Exception {
    	Profissional profissional = new ProfissionalDAO().getProfissionalByCpf(cpf);
        if (profissional.getIdProfissional() > 0) {
            new ProfissionalDAO().deleteProfissional(profissional.getIdProfissional());
        } else {
            throw new Exception("ID do Recepcionista é inválido!");
        }
    }

    public Profissional getProfissionalByRegistro(String registroConselho) throws Exception {
        if (registroConselho != null && !registroConselho.isEmpty()) {
            return new ProfissionalDAO().getProfissionalByRegistro(registroConselho);
        } else {
            throw new Exception("Registro de conselho é inválido!");
        }
    }
    
    public Profissional getProfissionalByCpf(String cpf) throws Exception {
        if (cpf != null && !cpf.isEmpty()) {
            return new ProfissionalDAO().getProfissionalByCpf(cpf);
        } else {
            throw new Exception("CPF é inválido!");
        }
    }
    
    public Profissional getProfissionalByLogin(String username) throws Exception {
        if (username != null && !username.isEmpty()) {
            return new ProfissionalDAO().getProfissionalByLogin(username);
        } else {
            throw new Exception("CPF é inválido!");
        }
    }
}
