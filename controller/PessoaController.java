package controller;

import java.sql.Date;

import model.Pessoa;

public class PessoaController {
    	
	public void cadastrarPessoa(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo, String profissao) throws Exception{
		if (nome != null && nome.length() > 0 && telefone != null && telefone.length() > 0) {
			Pessoa pessoa = new Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao);

			pessoa.cadastrarPessoa(pessoa);
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}
    
	public Pessoa consultarPessoa(String nome) throws Exception{
		if (nome != null && nome.length() > 0) {
			Pessoa Pessoa = new PessoaDAO().consultarPessoa(nome);
			return Pessoa;
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}
	public void alterarPessoa(int codCli, String nome, String telefone) throws Exception{
		if (nome != null && nome.length() > 0 && telefone != null && telefone.length() > 0) { 
			Pessoa Pessoa = new Pessoa(nome, telefone);
			Pessoa.setCodCli(codCli);
			Pessoa.alterarPessoa(Pessoa);
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}
	
	public void excluirPessoa(int codCli) throws Exception{
		if (codCli > 0) {
			Pessoa Pessoa = new Pessoa();
			Pessoa.excluirPessoa(codCli);
		} else {
			throw new Exception("ID do Pessoa é inválido!");
		}
	}
}
