package model;

import java.sql.Date;

import dao.ProfissionalDAO;
import dao.ExceptionDAO;

public class Profissional extends Funcionario {
    private int idProfissional;
    private String especialidade;
    private String registroConselho;
    private Date dataInscricao;

    public Profissional(int idProfissional, String especialidade, String registroConselho, Date dataInscricao) {
        this.idProfissional = idProfissional;
        this.especialidade = especialidade;
        this.registroConselho = registroConselho;
        this.dataInscricao = dataInscricao;
    }

    public Profissional(int idFuncionario, String login, String senha, String cargo, int idProfissional,
            String especialidade, String registroConselho, Date dataInscricao) {
        super(idFuncionario, login, senha, cargo);
        this.idProfissional = idProfissional;
        this.especialidade = especialidade;
        this.registroConselho = registroConselho;
        this.dataInscricao = dataInscricao;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    public void setRegistroConselho(String registroConselho) {
        this.registroConselho = registroConselho;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public void cadastrarCliente(Profissional Profissional) throws ExceptionDAO {
        new ProfissionalDAO().cadastrarProfissional(Profissional);
    }

    public void alterarProfissional(Profissional Profissional) throws ExceptionDAO {
        new ProfissionalDAO().alterarProfissional(Profissional);
    }

    public void excluirProfissional(int idProfissional) throws ExceptionDAO {
        new ProfissionalDAO().excluirProfissional(idProfissional);
    }
}
