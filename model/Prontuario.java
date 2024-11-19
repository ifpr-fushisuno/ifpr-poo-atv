package model;

import java.sql.Date;

public class Prontuario {
    private int idProntuario;
    private Paciente idPaciente;
    private Profissional idProfissional;
    private Exame idExame;
    private Date dataAbertura;
    private String observacoes;
    private String diagnostico;

    public Prontuario() {
    }
   
    public Prontuario(int idProntuario, Paciente idPaciente, Profissional idProfissional, Exame idExame,
            Date dataAbertura, String observacoes, String diagnostico) {
        this.idProntuario = idProntuario;
        this.idPaciente = idPaciente;
        this.idProfissional = idProfissional;
        this.idExame = idExame;
        this.dataAbertura = dataAbertura;
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
    }

    public int getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(int idProntuario) {
        this.idProntuario = idProntuario;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Profissional getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Profissional idProfissional) {
        this.idProfissional = idProfissional;
    }

    public Exame getIdExame() {
        return idExame;
    }

    public void setIdExame(Exame idExame) {
        this.idExame = idExame;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    } 
    
}
