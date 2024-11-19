package model;

public class Paciente {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private String tipoSanguineo;
    private boolean fatorRH;
    private Sexo sexo;

    public enum Sexo {
        MASCULINO,
        FEMININO,
        OUTRO
    }

    public Paciente(String cpf, String nome, String endereco, String telefone, String tipoSanguineo, boolean fatorRH, Sexo sexo) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoSanguineo = tipoSanguineo;
        this.fatorRH =fatorRH;
        this.sexo = sexo;
    }
        public Paciente() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setFatorRH(boolean fatorRH) {
        this.fatorRH = fatorRH;
    }

    public boolean getFatorRH() {
        return fatorRH;
    }

    public void setTipoSanguinea(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    // Construtores, getters e setters

}
