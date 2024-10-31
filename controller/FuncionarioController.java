import java.util.List;

public class FuncionarioController {
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarioDAO.save(funcionario);
    }

    public Funcionario buscarFuncionario(String id) {
        return funcionarioDAO.findById(id);
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        funcionarioDAO.update(funcionario);
    }
    
    public void deletarFuncionario(String id) {
        funcionarioDAO.delete(id);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioDAO.findAll();
    }
}
