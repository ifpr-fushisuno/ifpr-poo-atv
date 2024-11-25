package controller;

import java.sql.Date;
import java.sql.Time;
import dao.ConsultaDAO;
import model.Consulta;
import model.Paciente;
import model.Profissional;
import model.Consulta.StatusConsulta;

public class ConsultaController {
	 public void createConsulta(String cpfPaciente, String cpfMedico, Date dataConsulta,
				Time horaConsulta, String statusConsulta) throws Exception {
	        if (cpfPaciente != null && cpfMedico != null) {
	            Paciente paciente = new PacienteController().getPacienteByCpf(cpfPaciente);
	            Profissional profissional = new ProfissionalController().getProfissionalByCpf(cpfMedico);
	            
	            Consulta consulta = new Consulta(paciente, profissional, dataConsulta, horaConsulta, statusConsulta);
	            consulta.createConsulta(consulta);
	        } else {
	            throw new Exception("Preencha os campos corretamente!");
	        }
	    }

	    public void updateConsulta(String cpfPaciente, String cpfMedico, Date dataConsulta,
				Time horaConsulta, StatusConsulta statusConsulta) throws Exception {
	        if (cpfPaciente != null && cpfMedico != null) {
	        	Consulta consulta = new Consulta();
	        	consulta.updateConsulta(consulta);
	        } else {
	            throw new Exception("Preencha os campos corretamente!");
	        }
	    }

	    public void deleteConsulta(int idConsulta) throws Exception {
	        if (idConsulta > 0) {
	            Consulta consulta = new Consulta();
	            consulta.deleteConsulta(idConsulta);
	        } else {
	            throw new Exception("ID do Funcionário é inválido!");
	        }
	    }

	    public Consulta getConsultaByCpf(String cpf) throws Exception {
	        if (cpf != null && !cpf.isEmpty()) {
	        	Consulta consulta = new ConsultaDAO().getConsultaByCpf(cpf);
	            return consulta;
	        } else {
	            throw new Exception("CPF é inválido!");
	        }
	    }
}
