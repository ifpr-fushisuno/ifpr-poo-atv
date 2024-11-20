package model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import dao.ConsultaDAO;
import dao.ExceptionDAO;

/**
 * Representa uma consulta médica agendada.
 */
public class Consulta {
    private int idConsulta;
    private Paciente Paciente;
    private Profissional Profissional;
    private Date dataConsulta;
    private Time horaConsulta;
    private LocalDateTime dataHoraConsulta;
    private StatusConsulta statusConsulta;

    public enum StatusConsulta {
        AGENDADA,
        CANCELADA,
        CONCLUIDA;
    }

    public Consulta() {
    }

    public Consulta(int idConsulta, model.Paciente paciente, model.Profissional profissional,
            LocalDateTime dataHoraConsulta, StatusConsulta statusConsulta) {
        this.idConsulta = idConsulta;
        Paciente = paciente;
        Profissional = profissional;
        this.dataHoraConsulta = dataHoraConsulta;
        this.statusConsulta = statusConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Paciente getPaciente() {
        return Paciente;
    }

    public int getIdPaciente() {
        return Paciente.getIdPaciente();
    }

    public void setPaciente(Paciente paciente) {
        Paciente = paciente;
    }

    public Profissional getProfissional() {
        return Profissional;
    }

    public int getIdProfissional() {
        return Profissional.getIdProfissional();
    }

    public void setProfissional(Profissional profissional) {
        Profissional = profissional;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public String getStatusConsulta() {
        return "" + statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public void cadastrarCliente(Consulta consulta) throws ExceptionDAO {
        new ConsultaDAO().createConsulta(consulta);
    }

    public void alterarConsulta(Consulta consulta) throws ExceptionDAO {
        new ConsultaDAO().alterarConsulta(consulta);
    }

    public void excluirConsulta(int idConsulta) throws ExceptionDAO {
        new ConsultaDAO().excluirConsulta(idConsulta);
    }
}