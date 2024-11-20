package model;

import java.sql.Date;

import dao.PessoaDAO;
import dao.ExceptionDAO;

public class Pessoa {
    private int idPessoa;
    private String nome;
    private String telefone;
    private String rg;
    private String cpf;
    private Date dataNascimento;
    private String sexo;
    private String profissao;
    private String endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo,
            String profissao, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.profissao = profissao;
        this.endereco = endereco;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void createPessoa(Pessoa Pessoa) throws ExceptionDAO {
        new PessoaDAO().createPessoa(Pessoa);
    }

    public void updatePessoa(Pessoa Pessoa) throws ExceptionDAO {
        new PessoaDAO().updatePessoa(Pessoa);
    }

    public void deletePessoa(int idPessoa) throws ExceptionDAO {
        new PessoaDAO().deletePessoa(idPessoa);
    }
}
