package model;

import java.util.ArrayList;
import java.util.List;

public class FilaEspera {
    private Medico medico;
    private List<Paciente> fila;

    public FilaEspera(Medico medico) {
        this.medico = medico;
        this.fila = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        fila.add(paciente);
    }

    public Paciente removerPaciente() {
        if (!fila.isEmpty()) {
            return fila.remove(0);
        }
        return null; // Se a fila estiver vazia
    }

    public List<Paciente> getFila() {
        return fila;
    }

    public int tamanhoFila() {
        return fila.size();
    }
}
