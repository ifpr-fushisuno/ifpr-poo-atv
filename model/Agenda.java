package model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Consulta> consultas;

    public Agenda() {
        this.consultas = new ArrayList<>();
    }

    public boolean agendarConsulta(Consulta consulta) {
        for (Consulta c : consultas) {
            if (c.getDataHora().equals(consulta.getDataHora()) && c.getMedico().equals(consulta.getMedico())) {
                return false; // Horário já está ocupado
            }
        }
        consultas.add(consulta);
        return true; // Consulta agendada com sucesso
    }

    public void cancelarConsulta(String idConsulta) {
        consultas.removeIf(c -> c.getIdConsulta().equals(idConsulta));
    }

    public List<Consulta> listarConsultas() {
        return consultas;
    }

    public List<Consulta> listarConsultasPorMedico(Medico medico) {
        List<Consulta> consultasMedico = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getMedico().equals(medico)) {
                consultasMedico.add(c);
            }
        }
        return consultasMedico;
    }
}
