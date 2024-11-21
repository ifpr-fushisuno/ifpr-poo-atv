package controller;

import java.sql.Date;

import dao.PessoaDAO;
import model.Pessoa;

public class PessoaController {
    	
	public void createPessoa(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo, String profissao) throws Exception{
		if (nome != null && nome.length() > 0 && telefone != null && telefone.length() > 0) {
			Pessoa pessoa = new Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, profissao);
			pessoa.createPessoa(pessoa);
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}

	public void updatePessoa(int idPessoa, String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo, String profissao) throws Exception{
		if (nome != null && nome.length() > 0 && telefone != null && telefone.length() > 0) { 
			Pessoa pessoa = new Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, profissao);
			pessoa.setIdPessoa(idPessoa);
			pessoa.updatePessoa(pessoa);
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}
	
	public void deletePessoa(int idPessoa) throws Exception{
		if (idPessoa > 0) {
			Pessoa pessoa = new Pessoa();
			pessoa.deletePessoa(idPessoa);
		} else {
			throw new Exception("ID do Pessoa é inválido!");
		}
	}

	public Pessoa getPessoaById(int idPessoa) throws Exception{
		if (idPessoa > 0) {
			Pessoa pessoa = new PessoaDAO().getPessoaById(idPessoa);
			return pessoa;
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}

	public Pessoa getPessoaByCpf(String cpf) throws Exception{
		if (cpf.length() > 0 && cpf != null) {
			Pessoa pessoa = new PessoaDAO().getPessoaByCpf(cpf);
			return pessoa;
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}
}