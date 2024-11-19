package model;

import java.sql.Date;

public class Exame {
    private int idExame;
    private String exame;
    private Date dataExame;
    private String resultado;

    public Exame() {
    }

    public Exame(int idExame, String exame, Date dataExame, String resultado) {
        this.idExame = idExame;
        this.exame = exame;
        this.dataExame = dataExame;
        this.resultado = resultado;
    }

    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
}