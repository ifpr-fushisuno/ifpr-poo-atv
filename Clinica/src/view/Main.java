package view;

import java.sql.Date;
import java.util.Scanner;

import controller.*;
import model.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PessoaController pessoaController = new PessoaController();
		PacienteController pacienteController = new PacienteController();
		FuncionarioController funcionarioController = new FuncionarioController();
		RecepcionistaController recepcionistaController = new RecepcionistaController();

		while (true) {
			System.out.println("=== Menu de Opções ===");
			System.out.println("1. Menu de Pessoas");
			System.out.println("2. Menu de Pacientes");
			System.out.println("3. Menu de Funcionários");
			System.out.println("4. Menu de Recepcionista");
			System.out.println("5. Sair");
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
						scanner.nextLine();
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

					default:
						System.out.println("Opção inválida. Tente novamente.");
					}

					System.out.println();
					if (pessoaOption == 6) {
						break;
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
								scanner.nextLine();
								System.out.print("Doenças: ");
								String doencas = scanner.nextLine();
								System.out.print("Limitações: ");
								String limitacoes = scanner.nextLine();

								pacienteController.createPaciente(pessoa, etnia, tipoSanguineo, fatorRh, peso, altura,
										doador, fumante, doencas, limitacoes);
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
						scanner.nextLine();
						System.out.print("Etnia: ");
						String etnia = scanner.nextLine();
						System.out.print("Tipo Sanguíneo: ");
						String tipoSanguineo = scanner.nextLine();
						System.out.print("Fator Rh (true/false): ");
						boolean fatorRh = scanner.nextBoolean();
						System.out.print("Peso: ");
						double peso = scanner.nextDouble();
						System.out.print("Altura: ");
						Double altura = scanner.nextDouble();
						System.out.print("É doador (true/false): ");
						boolean doador = scanner.nextBoolean();
						System.out.print("É fumante (true/false): ");
						boolean fumante = scanner.nextBoolean();
						scanner.nextLine();
						System.out.print("Doenças: ");
						String doencas = scanner.nextLine();
						System.out.print("Limitações: ");
						String limitacoes = scanner.nextLine();

						try {
							pacienteController.updatePaciente(etnia, tipoSanguineo, fatorRh, peso, altura, doador,
									fumante, doencas, limitacoes);
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

					default:
						System.out.println("Opção inválida. Tente novamente.");
					}

					System.out.println();
					if (pacienteOption == 5) {
						break;
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
							if (pessoa != null) {
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
						scanner.nextLine();
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

					default:
						System.out.println("Opção inválida. Tente novamente.");
					}

					System.out.println();
					if (funcionarioOption == 5) {
						break;
					}
				}
				break;

			case 4:
				System.out.println("=== Menu de Recepcionista ===");
				System.out.println("1. Cadastrar Recepcionista");
				System.out.print("Escolha uma opção: ");

				int pessoaOption = scanner.nextInt();
				scanner.nextLine();

				switch (pessoaOption) {
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

				case 5:
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

		// Uma ideia pra resolver o problema de cadatro dos usuario seria realizar um
		// metodo que pega uma pessoa e sua respectiva funcao usando JOIN
	}
}
