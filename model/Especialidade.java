package model;

public class Especialidade {
    private int idEspecialidade;
    private String especialidade;
    
    public Especialidade() {
    }

    public Especialidade(int idEspecialidade, String especialidade) {
        this.idEspecialidade = idEspecialidade;
        this.especialidade = especialidade;
    }

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    
}
