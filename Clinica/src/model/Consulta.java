package model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import dao.ConsultaDAO;
import dao.ExceptionDAO;

public class Consulta {
	private int idConsulta;
	private Paciente Paciente;
	private Profissional Profissional;
	private Date dataConsulta;
	private Time horaConsulta;
	private LocalDateTime dataHoraConsulta;
	private StatusConsulta statusConsulta;

	public enum StatusConsulta {
		AGENDADA, CANCELADA, CONCLUIDA;
	}

	public Consulta() {
		super();
	}

	public Consulta(int idConsulta, model.Paciente paciente, model.Profissional profissional, Date dataConsulta,
			Time horaConsulta, LocalDateTime dataHoraConsulta, StatusConsulta statusConsulta) {
		super();
		this.idConsulta = idConsulta;
		Paciente = paciente;
		Profissional = profissional;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
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

	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}

	public Profissional getProfissional() {
		return Profissional;
	}

	public void setProfissional(Profissional profissional) {
		Profissional = profissional;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Time getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(Time horaConsulta) {
		this.horaConsulta = horaConsulta;
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

	public void createConsulta(Consulta consulta, int idPaciente, int idProfissional) throws ExceptionDAO {
		new ConsultaDAO().createConsulta(consulta, idPaciente, idProfissional);
	}

	public void updateConsulta(Consulta consulta, int idProfissional) throws ExceptionDAO {
		new ConsultaDAO().updateConsulta(consulta, idProfissional);
	}

	public void deleteConsulta(int idConsulta) throws ExceptionDAO {
		new ConsultaDAO().deleteConsulta(idConsulta);
	}
}