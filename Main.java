import dao.ExceptionDAO;
import dao.TesteDAO;
import model.Teste;

public class Main {
    public static void main(String[] args) {
        // Criação de uma instância de Teste
        Teste teste = new Teste();
        teste.setId(1); // ID do teste (por exemplo)
        teste.setNome("Teste Exemplo"); // Nome do teste

        // Criação de uma instância de TesteDAO
        TesteDAO testeDAO = new TesteDAO();

        try {
            // Cadastrando o teste no banco de dados
            testeDAO.cadastrarTeste(teste);
            System.out.println("Teste cadastrado com sucesso!");
        
            // Consultando o teste cadastrado
            Teste testeConsulta = testeDAO.consultarTeste(teste.getId());
            if (testeConsulta != null) {
                System.out.println("Teste encontrado: " + testeConsulta.getNome());
            } else {
                System.out.println("Teste não encontrado.");
            }

            // Alterando o teste
            teste.setNome("Teste Alterado");
            testeDAO.alterarTeste(teste);
            System.out.println("Teste alterado com sucesso!");

            // Excluindo o teste
            testeDAO.excluirTeste(teste.getId());
            System.out.println("Teste excluído com sucesso!");

        } catch (ExceptionDAO e) {
            e.printStackTrace();
        } 
    }
}
