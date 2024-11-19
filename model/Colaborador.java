package model;

public class Colaborador {
    private int idColaborador;
    private Pessoa idPessoa;
    private String login;
    private String senha;
    private String colaborador;

    public Colaborador() {
    }

    public Colaborador(int idColaborador, Pessoa idPessoa, String login, String senha, String colaborador) {
        this.idColaborador = idColaborador;
        this.idPessoa = idPessoa;
        this.login = login;
        this.senha = senha;
        this.colaborador = colaborador;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    
}
