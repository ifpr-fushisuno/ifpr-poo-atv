package model;

import java.time.LocalDateTime;

public class Prontuario {
    private String idProntuario;
    private Paciente paciente;
    private LocalDateTime dataAbertura;
    private String detalhes;
    private String alergias;
    private String limitacoes;

    public Prontuario(String idProntuario, Paciente paciente, LocalDateTime dataAbertura, String detalhes,
            String alergias, String limitacoes) {
        this.idProntuario = idProntuario;
        this.paciente = paciente;
        this.dataAbertura = dataAbertura;
        this.detalhes = detalhes;
        this.alergias = alergias;
        this.limitacoes = limitacoes;
    }

    public String getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(String idProntuario) {
        this.idProntuario = idProntuario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getLimitacoes() {
        return limitacoes;
    }

    public void setLimitacoes(String limitacoes) {
        this.limitacoes = limitacoes;
    }

}