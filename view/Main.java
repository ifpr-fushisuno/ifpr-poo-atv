package view;

import java.sql.Date;
import java.util.Scanner;

import controller.PessoaController;
import model.Pessoa;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaController pessoaController = new PessoaController();

        while (true) {
            System.out.println("=== Menu de Opções ===");
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Atualizar Pessoa");
            System.out.println("3. Excluir Pessoa");
            System.out.println("4. Buscar Pessoa por ID");
            System.out.println("5. Buscar Pessoa por CPF");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Cadastrar Pessoa
                    System.out.println("=== Cadastrar Pessoa ===");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("RG: ");
                    String rg = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Data de Nascimento (YYYY-MM-DD): ");
                    String dataNascimentoInput = scanner.nextLine();
                    Date dataNascimento = Date.valueOf(dataNascimentoInput);
                    System.out.print("Sexo: ");
                    String sexo = scanner.nextLine();
                    System.out.print("Profissão: ");
                    String profissao = scanner.nextLine();

                    try {
                        pessoaController.createPessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao);
                        System.out.println("Pessoa cadastrada com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("=== Atualizar Pessoa ===");
                    System.out.print("ID da Pessoa a ser atualizada: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    telefone = scanner.nextLine();
                    System.out.print("RG: ");
                    rg = scanner.nextLine();
                    System.out.print("CPF: ");
                    cpf = scanner.nextLine();
                    System.out.print("Data de Nascimento (YYYY-MM-DD): ");
                    dataNascimentoInput = scanner.nextLine();
                    dataNascimento = Date.valueOf(dataNascimentoInput);
                    System.out.print("Sexo: ");
                     sexo = scanner.nextLine();
                    System.out.print("Profissão: ");
                    profissao = scanner.nextLine();

                    try {
                        pessoaController.updatePessoa(idAtualizar, nome, telefone, rg, cpf, dataNascimento, sexo,
                                profissao);
                        System.out.println("Pessoa atualizada com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Excluir Pessoa
                    System.out.println("=== Excluir Pessoa ===");
                    System.out.print("ID da Pessoa a ser excluída: ");
                    int idExcluir = scanner.nextInt();

                    try {
                        pessoaController.deletePessoa(idExcluir);
                        System.out.println("Pessoa excluída com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Buscar Pessoa por ID
                    System.out.println("=== Buscar Pessoa por ID ===");
                    System.out.print("ID da Pessoa a ser buscada: ");
                    int idBuscar = scanner.nextInt();

                    try {
                        Pessoa pessoa = pessoaController.getPessoaById(idBuscar);
                        if (pessoa != null) {
                            System.out.println("Pessoa encontrada: " + pessoa.getNome());
                        } else {
                            System.out.println("Pessoa não encontrada.");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 5:
                    // Buscar Pessoa por CPF
                    System.out.println("=== Buscar Pessoa por CPF ===");
                    System.out.print("CPF da Pessoa a ser buscada: ");
                    String cpfBuscar = scanner.nextLine();

                    try {
                        Pessoa pessoa = pessoaController.getPessoaByCpf(cpfBuscar);
                        if (pessoa != null) {
                            System.out.println("Pessoa encontrada: " + pessoa.getNome());
                        } else {
                            System.out.println("Pessoa não encontrada.");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 6:
                    // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }
    }
}