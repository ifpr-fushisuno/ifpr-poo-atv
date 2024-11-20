package model;

import java.sql.Date;

import dao.PacienteDAO;
import dao.ExceptionDAO;

public class Paciente extends Pessoa {
    private int idPaciente;
    private String etnia;
    private String tipoSanguineo;
    private boolean fatorRh;
    private double peso;
    private double altura;
    private boolean doador;
    private boolean fumante;
    private String doencas;
    private String limitacoes;

    public Paciente(int idPessoa, String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo,
            String profissao, String endereco, int idPaciente, int idPessoa2, String etnia, String tipoSanguineo,
            boolean fatorRh, double peso, double altura, boolean doador, boolean fumante, String doencas,
            String limitacoes) {
        super(idPessoa, nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
        this.idPaciente = idPaciente;
        this.etnia = etnia;
        this.tipoSanguineo = tipoSanguineo;
        this.fatorRh = fatorRh;
        this.peso = peso;
        this.altura = altura;
        this.doador = doador;
        this.fumante = fumante;
        this.doencas = doencas;
        this.limitacoes = limitacoes;
    }

    public Paciente(int idPaciente, int idPessoa, String etnia, String tipoSanguineo, boolean fatorRh, double peso,
            double altura, boolean doador, boolean fumante, String doencas, String limitacoes) {
        this.idPaciente = idPaciente;
        this.etnia = etnia;
        this.tipoSanguineo = tipoSanguineo;
        this.fatorRh = fatorRh;
        this.peso = peso;
        this.altura = altura;
        this.doador = doador;
        this.fumante = fumante;
        this.doencas = doencas;
        this.limitacoes = limitacoes;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public boolean isFatorRh() {
        return fatorRh;
    }

    public void setFatorRh(boolean fatorRh) {
        this.fatorRh = fatorRh;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean isDoador() {
        return doador;
    }

    public void setDoador(boolean doador) {
        this.doador = doador;
    }

    public boolean isFumante() {
        return fumante;
    }

    public void setFumante(boolean fumante) {
        this.fumante = fumante;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getLimitacoes() {
        return limitacoes;
    }

    public void setLimitacoes(String limitacoes) {
        this.limitacoes = limitacoes;
    }

    public void cadastrarCliente(Paciente Paciente) throws ExceptionDAO {
        new PacienteDAO().cadastrarPaciente(Paciente);
    }

    public void alterarPaciente(Paciente Paciente) throws ExceptionDAO {
        new PacienteDAO().alterarPaciente(Paciente);
    }

    public void excluirPaciente(int idPaciente) throws ExceptionDAO {
        new PacienteDAO().excluirPaciente(idPaciente);
    }

}
