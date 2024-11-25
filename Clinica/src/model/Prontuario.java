package model;

import dao.ProntuarioDAO;
import dao.ExceptionDAO;

public class Prontuario {
    private int idProntuario;
    private int idPaciente;
    private int idProfissional;
    private String diagnostico;
    private String prescricao;


	public Prontuario() {
	}

	public Prontuario(int idPaciente, int idProfissional, String diagnostico, String prescricao) {
		super();
		this.idPaciente = idPaciente;
		this.idProfissional = idProfissional;
		this.diagnostico = diagnostico;
		this.prescricao = prescricao;
	}

	public int getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(int idProntuario) {
        this.idProntuario = idProntuario;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public void createProntuario(Prontuario Prontuario) throws ExceptionDAO {
        new ProntuarioDAO().createProntuario(Prontuario);
    }

    public void updateProntuario(Prontuario Prontuario) throws ExceptionDAO {
        new ProntuarioDAO().updateProntuario(Prontuario);
    }

    public void deleteProntuario(int idProntuario) throws ExceptionDAO {
        new ProntuarioDAO().deleteProntuario(idProntuario);
    }
}
