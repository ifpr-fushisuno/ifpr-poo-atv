public class Funcionario {
    private String id;
    private String nome;
    private String cargo; // Ex: recepcionista, médico
    private String senha;

    public Funcionario(String id, String nome, String cargo, String senha) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.senha = senha;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
