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
	private String statusConsulta;

	public enum StatusConsulta {
		AGENDADA, CANCELADA, CONCLUIDA;
	}

	public Consulta() {
		super();
	}

	public Consulta(model.Paciente paciente, model.Profissional profissional, Date dataConsulta, Time horaConsulta,
			String statusConsulta) {
		super();
		Paciente = paciente;
		Profissional = profissional;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
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

	public void setPaciente(String string) {
		this.Paciente.setNome(string);
	}

	public Profissional getProfissional() {
		return Profissional;
	}

	public void setProfissional(String string) {
		this.Profissional.setNome(string);
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

	public void setStatusConsulta(String string) {
		this.statusConsulta = string;
	}

	public void createConsulta(Consulta consulta) throws ExceptionDAO {
		new ConsultaDAO().createConsulta(consulta);
	}

	public void updateConsulta(Consulta consulta) throws ExceptionDAO {
		new ConsultaDAO().updateConsulta(consulta);
	}

	public void deleteConsulta(int idConsulta) throws ExceptionDAO {
		new ConsultaDAO().deleteConsulta(idConsulta);
	}
}