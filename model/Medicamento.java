package model;

public class Medicamento {
    private int idMedicamento;
    private String medicamento;
    private String posologia;

    public Medicamento() {
    }

    public Medicamento(int idMedicamento, String medicamento, String posologia) {
        this.idMedicamento = idMedicamento;
        this.medicamento = medicamento;
        this.posologia = posologia;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }
    
    
}
