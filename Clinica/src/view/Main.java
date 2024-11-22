package view;

import java.sql.Date;
import java.util.Scanner;

import controller.PessoaController;
import controller.PacienteController;
import controller.FuncionarioController;
import controller.GerenteController;
import controller.RecepcionistaController; // Importando o controlador de Recepcionista
import model.Pessoa;
import model.Paciente;
import model.Funcionario;
import model.Gerente;
import model.Recepcionista; // Importando o model de Recepcionista

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaController pessoaController = new PessoaController();
        PacienteController pacienteController = new PacienteController();
        FuncionarioController funcionarioController = new FuncionarioController();
        RecepcionistaController recepcionistaController = new RecepcionistaController();
        GerenteController gerenteController = new GerenteController();


        while (true) {
            System.out.println("=== Menu de Opções ===");
            System.out.println("1. Menu de Pessoas");
            System.out.println("2. Menu de Pacientes");
            System.out.println("3. Menu de Funcionários");
            System.out.println("4. Menu de Recepcionistas");
            System.out.println("5. Menu de Gerentes");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Menu de Pessoas
                    while (true) {
                        System.out.println("=== Menu de Pessoas ===");
                        System.out.println("1. Cadastrar Pessoa");
                        System.out.println("2. Atualizar Pessoa");
                        System.out.println("3. Excluir Pessoa");
                        System.out.println("4. Buscar Pessoa por ID");
                        System.out.println("5. Buscar Pessoa por CPF");
                        System.out.println("6. Sair");
                        System.out.print("Escolha uma opção: ");

                        int pessoaOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (pessoaOption) {
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
                                // Atualizar Pessoa
                                System.out.println("=== Atualizar Pessoa ===");
                                System.out.print("ID da Pessoa a ser atualizada: ");
                                int idAtualizar = scanner.nextInt();
                                scanner.nextLine(); // consume newline
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
                                    pessoaController.updatePessoa(idAtualizar, nome, telefone, rg, cpf, dataNascimento, sexo, profissao);
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
                                // Sair do menu de pessoas
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }

                        System.out.println();
                        if (pessoaOption == 6) {
                            break; // sair do menu de pessoas
                        }
                    }
                    break;

                case 2:
                    // Menu de Pacientes
                    while (true) {
                        System.out.println("=== Menu de Pacientes ===");
                        System.out.println("1. Cadastrar Paciente");
                        System.out.println("2. Atualizar Paciente");
                        System.out.println("3. Excluir Paciente");
                        System.out.println("4. Buscar Paciente por CPF");
                        System.out.println("5. Sair");
                        System.out.print("Escolha uma opção: ");

                        int pacienteOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (pacienteOption) {
                            case 1:
                                // Cadastrar Paciente
                                System.out.println("=== Cadastrar Paciente ===");
                                System.out.print("CPF da Pessoa: ");
                                String cpfPessoa = scanner.nextLine();

                                try {
                                    Pessoa pessoa = pessoaController.getPessoaByCpf(cpfPessoa);
                                    if (pessoa != null) {
                                        System.out.print("Etnia: ");
                                        String etnia = scanner.nextLine();
                                        System.out.print("Tipo Sanguíneo: ");
                                        String tipoSanguineo = scanner.nextLine();
                                        System.out.print("Fator Rh (true/false): ");
                                        boolean fatorRh = scanner.nextBoolean();
                                        System.out.print("Peso: ");
                                        double peso = scanner.nextDouble();
                                        System.out.print("Altura: ");
                                        double altura = scanner.nextDouble();
                                        System.out.print("É doador (true/false): ");
                                        boolean doador = scanner.nextBoolean();
                                        System.out.print("É fumante (true/false): ");
                                        boolean fumante = scanner.nextBoolean();
                                        scanner.nextLine(); // consume newline
                                        System.out.print("Doenças: ");
                                        String doencas = scanner.nextLine();
                                        System.out.print("Limitações: ");
                                        String limitacoes = scanner.nextLine();

                                        pacienteController.createPaciente(pessoa, etnia, tipoSanguineo, fatorRh, peso, altura, doador, fumante, doencas, limitacoes);
                                        System.out.println("Paciente cadastrado com sucesso!");
                                    } else {
                                        System.out.println("Pessoa não encontrada. Verifique o CPF.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 2:
                                // Atualizar Paciente
                                System.out.println("=== Atualizar Paciente ===");
                                System.out.print("ID do Paciente a ser atualizado: ");
                                int idAtualizarPaciente = scanner.nextInt();
                                scanner.nextLine(); // consume newline
                                System.out.print("Etnia: ");
                                String etnia = scanner.nextLine();
                                System.out.print("Tipo Sanguíneo: ");
                                String tipoSanguineo = scanner.nextLine();
                                System.out.print("Fator Rh (true/false): ");
                                boolean fatorRh = scanner.nextBoolean();
                                System.out.print("Peso: ");
                                double peso = scanner.nextDouble();
                                System.out.print("Altura: ");
                                double altura = scanner.nextDouble();
                                System.out.print("É doador (true/false): ");
                                boolean doador = scanner.nextBoolean();
                                System.out.print("É fumante (true/false): ");
                                boolean fumante = scanner.nextBoolean();
                                scanner.nextLine(); // consume newline
                                System.out.print("Doenças: ");
                                String doencas = scanner.nextLine();
                                System.out.print("Limitações: ");
                                String limitacoes = scanner.nextLine();

                                try {
                                    pacienteController.updatePaciente(etnia, tipoSanguineo, fatorRh, peso, altura, doador, fumante, doencas, limitacoes);
                                    System.out.println("Paciente atualizado com sucesso!");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 3:
                                // Excluir Paciente
                                System.out.println("=== Excluir Paciente ===");
                                System.out.print("ID do Paciente a ser excluído: ");
                                int idExcluirPaciente = scanner.nextInt();

                                try {
                                    pacienteController.deletePaciente(idExcluirPaciente);
                                    System.out.println("Paciente excluído com sucesso!");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 4:
                                // Buscar Paciente por CPF
                                System.out.println("=== Buscar Paciente por CPF ===");
                                System.out.print("CPF do Paciente a ser buscado: ");
                                String cpfBuscar = scanner.nextLine();

                                try {
                                    Paciente paciente = pacienteController.getPacienteByCpf(cpfBuscar);
                                    if (paciente != null) {
                                        System.out.println("Paciente encontrado: Etnia: " + paciente.getEtnia());
                                    } else {
                                        System.out.println("Paciente não encontrado.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 5:
                                // Sair do menu de pacientes
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }

                        System.out.println();
                        if (pacienteOption == 5) {
                            break; // sair do menu de pacientes
                        }
                    }
                    break;

                case 3:
                    // Menu de Funcionários
                    while (true) {
                        System.out.println("=== Menu de Funcionários ===");
                        System.out.println("1. Cadastrar Funcionário");
                        System.out.println("2. Atualizar Funcionário");
                        System.out.println("3. Excluir Funcionário");
                        System.out.println("4. Buscar Funcionário por CPF");
                        System.out.println("5. Sair");
                        System.out.print("Escolha uma opção: ");

                        int funcionarioOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (funcionarioOption) {
                            case 1:
                                // Cadastrar Funcionário
                                System.out.println("=== Cadastrar Funcionário ===");
                                System.out.print("CPF da Pessoa: ");
                                String cpfFuncionario = scanner.nextLine();

                                try {
                                    Pessoa pessoa = pessoaController.getPessoaByCpf(cpfFuncionario);
                                    if (pessoa != null) { // Verifica se a pessoa existe
                                        System.out.print("Login: ");
                                        String login = scanner.nextLine();
                                        System.out.print("Senha: ");
                                        String senha = scanner.nextLine();
                                        System.out.print("Cargo: ");
                                        String cargo = scanner.nextLine();

                                        funcionarioController.createFuncionario(pessoa, login, senha, cargo);
                                        System.out.println("Funcionário cadastrado com sucesso!");
                                    } else {
                                        System.out.println("Pessoa não encontrada. Verifique o CPF.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 2:
                                // Atualizar Funcionário
                                System.out.println("=== Atualizar Funcionário ===");
                                System.out.print("ID do Funcionário a ser atualizado: ");
                                int idAtualizarFuncionario = scanner.nextInt();
                                scanner.nextLine(); // consume newline
                                System.out.print("Login: ");
                                String login = scanner.nextLine();
                                System.out.print("Senha: ");
                                String senha = scanner.nextLine();
                                System.out.print("Cargo: ");
                                String cargo = scanner.nextLine();

                                try {
                                    funcionarioController.updateFuncionario(idAtualizarFuncionario, login, senha, cargo);
                                    System.out.println("Funcionário atualizado com sucesso!");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 3:
                                // Excluir Funcionário
                                System.out.println("=== Excluir Funcionário ===");
                                System.out.print("ID do Funcionário a ser excluído: ");
                                int idExcluirFuncionario = scanner.nextInt();

                                try {
                                    funcionarioController.deleteFuncionario(idExcluirFuncionario);
                                    System.out.println("Funcionário excluído com sucesso!");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 4:
                                // Buscar Funcionário por CPF
                                System.out.println("=== Buscar Funcionário por CPF ===");
                                System.out.print("CPF do Funcionário a ser buscado: ");
                                String cpfBuscarFuncionario = scanner.nextLine();

                                try {
                                    Funcionario funcionario = funcionarioController.getFuncionarioByCpf(cpfBuscarFuncionario);
                                    if (funcionario != null) {
                                        System.out.println("Funcionário encontrado: " + funcionario.getCargo());
                                    } else {
                                        System.out.println("Funcionário não encontrado.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 5:
                                // Sair do menu de funcionários
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }

                        System.out.println();
                        if (funcionarioOption == 5) {
                            break; // sair do menu de funcionários
                        }
                    }
                    break;

                case 4:
                    // Menu de Recepcionistas
                    while (true) {
                        System.out.println("=== Menu de Recepcionistas ===");
                        System.out.println("1. Cadastrar Recepcionista");
                        System.out.println("2. Atualizar Recepcionista");
                        System.out.println("3. Excluir Recepcionista");
                        System.out.println("4. Buscar Recepcionista por CPF");
                        System.out.println("5. Sair");
                        System.out.print("Escolha uma opção: ");

                        int recepcionistaOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (recepcionistaOption) {
                            case 1:
                            	// Cadastrar Recepcionista
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
            					System.out.print("Endereço: ");
            					String endereco = scanner.nextLine();
            					System.out.print("Login: ");
            					String login = scanner.nextLine();
            					System.out.print("Senha: ");
            					String senha = scanner.nextLine();
            					System.out.print("Cargo: ");
            					String cargo = scanner.nextLine();
            					try {
            						recepcionistaController.createFullRecepcionista(nome, telefone, rg, cpf, dataNascimento, sexo,
            								profissao, endereco, login, senha, cargo);
            					} catch (Exception e) {
            						System.out.println("Erro: " + e.getMessage());
            					}
            					break;

                            case 2:
                                // Atualizar Recepcionista

                                break;

                            case 3:
                                // Excluir Recepcionista
                                System.out.println("=== Excluir Recepcionista ===");
                                System.out.print("ID do Recepcionista a ser excluído: ");
                                int idExcluirRecepcionista = scanner.nextInt();

                                try {
                                    recepcionistaController.deleteRecepcionista(idExcluirRecepcionista);
                                    System.out.println("Recepcionista excluído com sucesso!");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 4:
                                // Buscar Recepcionista por CPF
                                System.out.println("=== Buscar Recepcionista por CPF ===");
                                System.out.print("CPF do Recepcionista a ser buscado: ");
                                String cpfBuscarRecepcionista = scanner.nextLine();

                                try {
                                    Recepcionista recepcionista = recepcionistaController.getRecepcionistaByCpf(cpfBuscarRecepcionista);
                                    if (recepcionista != null) {
                                        System.out.println("Recepcionista encontrado: " + recepcionista.getNome());
                                    } else {
                                        System.out.println("Recepcionista não encontrado.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 5:
                                // Sair do menu de recepcionistas
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }

                        System.out.println();
                        if (recepcionistaOption == 5) {
                            break; // sair do menu de recepcionistas
                        }
                    }
                    break;
                
                case 5:
                    // Menu de Gerentes
                    while (true) {
                        System.out.println("=== Menu de Gerentes ===");
                        System.out.println("1. Cadastrar Gerente");
                        System.out.println("2. Atualizar Gerente");
                        System.out.println("3. Excluir Gerente");
                        System.out.println("4. Buscar Gerente por CPF");
                        System.out.println("5. Sair");
                        System.out.print("Escolha uma opção: ");

                        int gerenteOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (gerenteOption) {
                            case 1:
                                // Cadastrar Gerente
                                System.out.println("=== Cadastrar Gerente ===");
                                System.out.print("Nome: ");
                                String nomeGerente = scanner.nextLine();
                                System.out.print("Telefone: ");
                                String telefoneGerente = scanner.nextLine();
                                System.out.print("RG: ");
                                String rgGerente = scanner.nextLine();
                                System.out.print("CPF: ");
                                String cpfGerente = scanner.nextLine();
                                System.out.print("Data de Nascimento (YYYY-MM-DD): ");
                                String dataNascimentoInputGerente = scanner.nextLine();
                                Date dataNascimentoGerente = Date.valueOf(dataNascimentoInputGerente);
                                System.out.print("Sexo: ");
                                String sexoGerente = scanner.nextLine();
                                System.out.print("Profissão: ");
                                String profissaoGerente = scanner.nextLine();
                                System.out.print("Endereço: ");
                                String enderecoGerente = scanner.nextLine();
                                System.out.print("Login: ");
                                String loginGerente = scanner.nextLine();
                                System.out.print("Senha: ");
                                String senhaGerente = scanner.nextLine();
                                System.out.print("Cargo: ");
                                String cargoGerente = scanner.nextLine();

                                try {
                                    gerenteController.createFullGerente(nomeGerente, telefoneGerente, rgGerente, cpfGerente, dataNascimentoGerente, sexoGerente, profissaoGerente, enderecoGerente, loginGerente, senhaGerente, cargoGerente);
                                    System.out.println("Gerente cadastrado com sucesso!");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 2:
                                // Atualizar Gerente
                                System.out.println("=== Atualizar Gerente ===");
                                System.out.print("ID do Gerente a ser atualizado: ");
                                int idAtualizarGerente = scanner.nextInt();
                                scanner.nextLine(); // consume newline
                                System.out.print("Login: ");
                                String login = scanner.nextLine();
                                System.out.print("Senha: ");
                                String senha = scanner.nextLine();
                                System.out.print("Cargo: ");
                                String cargo = scanner.nextLine();

                                try {
                                    gerenteController.updateGerente(idAtualizarGerente, login, senha, cargo);
                                    System.out.println("Gerente atualizado com sucesso!");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 3:
                                // Excluir Gerente
                                System.out.println("=== Excluir Gerente ===");
                                System.out.print("ID do Gerente a ser excluído: ");
                                int idExcluirGerente = scanner.nextInt();

                                try {
                                    gerenteController.deleteGerente(idExcluirGerente);
                                    System.out.println("Gerente excluído com sucesso!");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 4:
                                // Buscar Gerente por CPF
                                System.out.println("=== Buscar Gerente por CPF ===");
                                System.out.print("CPF do Gerente a ser buscado: ");
                                String cpfBuscarGerente = scanner.nextLine();

                                try {
                                    Gerente gerente = gerenteController.getGerenteByCpf(cpfBuscarGerente);
                                    if (gerente != null) {
                                        System.out.println("Gerente encontrado: " + gerente.getCargo());
                                    } else {
                                        System.out.println("Gerente não encontrado.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 5:
                                // Sair do menu de gerentes
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }

                        System.out.println();
                        if (gerenteOption == 5) {
                            break; // sair do menu de gerentes
                        }
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
