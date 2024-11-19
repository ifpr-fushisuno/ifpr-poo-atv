package model;

import java.sql.Date;
import java.sql.Time;

public class Agenda {
    private int idAgenda;
    private Paciente idPaciente;
    private Profissional idProfissional;
    private Date dataConsulta;
    private Time horario;
    private String tipoConsulta;

    public Agenda(int idAgenda, Paciente idPaciente, Profissional idProfissional, Date dataConsulta, Time horario,
            String tipoConsulta) {
        this.idAgenda = idAgenda;
        this.idPaciente = idPaciente;
        this.idProfissional = idProfissional;
        this.dataConsulta = dataConsulta;
        this.horario = horario;
        this.tipoConsulta = tipoConsulta;
    }

    public Agenda() {
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
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

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    

}
