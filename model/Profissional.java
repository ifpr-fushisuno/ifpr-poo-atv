package model;

import java.sql.Date;

public class Profissional {
    private int idProfissional;
    private String registroConselho;
    private Date dataInscricao;

    public Profissional() {
    }

    public Profissional(int idProfissional, String registroConselho, Date dataInscricao) {
        this.idProfissional = idProfissional;
        this.registroConselho = registroConselho;
        this.dataInscricao = dataInscricao;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
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
    
}
