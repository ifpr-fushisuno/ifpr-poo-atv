package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.FuncionarioController;
import controller.GerenteController;
import controller.ProfissionalController;
import controller.RecepcionistaController;
import dao.ExceptionDAO;
import model.Funcionario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TelaGerente extends JFrame {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;

    public TelaGerente() {
        setTitle("Gerenciamento de Funcionários");
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel navBar = new JPanel(new BorderLayout());
        navBar.setBackground(new Color(47, 85, 151));
        navBar.setPreferredSize(new Dimension(0, 60));

        JLabel navTitle = new JLabel("GERENTE - FUNCIONÁRIOS", JLabel.LEFT);
        navTitle.setFont(new Font("Arial", Font.BOLD, 16));
        navTitle.setForeground(Color.WHITE);
        navTitle.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));

        JButton sairButton = new JButton("Sair");
        sairButton.setForeground(Color.WHITE);
        sairButton.setFont(new Font("Arial", Font.PLAIN, 14));
        sairButton.setBackground(new Color(220, 53, 69));
        sairButton.setFocusPainted(false);
        sairButton.setBorderPainted(false);
        sairButton.setPreferredSize(new Dimension(80, 40));
        sairButton.addActionListener(e -> dispose());

        navBar.add(navTitle, BorderLayout.WEST);
        navBar.add(sairButton, BorderLayout.EAST);
        add(navBar, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(240, 248, 255));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Gerenciamento de Funcionários", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(47, 85, 151));
        centerPanel.add(titleLabel, BorderLayout.NORTH);

        String[] colunas = { "Nome", "CPF", "Cargo" };
        String[][] funcionariosData = carregarDados();

        model = new DefaultTableModel(funcionariosData, colunas);
        JTable tabela = new JTable(model);
        tabela.setFont(new Font("Arial", Font.PLAIN, 14));
        tabela.setRowHeight(25);
        tabela.setSelectionBackground(new Color(184, 214, 247));
        tabela.setSelectionForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(tabela);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonsPanel.setBackground(new Color(240, 248, 255));

        JButton btnCadastrar = new JButton("Adicionar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");

        configurarBotao(btnCadastrar, new Color(40, 167, 69), Color.WHITE);
        configurarBotao(btnEditar, new Color(255, 193, 7), Color.BLACK);
        configurarBotao(btnExcluir, new Color(220, 53, 69), Color.WHITE);

        buttonsPanel.add(btnCadastrar);
        buttonsPanel.add(btnEditar);
        buttonsPanel.add(btnExcluir);
        centerPanel.add(buttonsPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> mostrarFormularioCadastro());
        btnEditar.addActionListener(e -> mostrarFormularioEdicao(tabela));
        btnExcluir.addActionListener(e -> excluirFuncionario(tabela));
    }

    private void mostrarFormularioCadastro() {
        JTextField nomeField = new JTextField();
        JTextField telefoneField = new JTextField();
        JTextField rgField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField dataNascimentoField = new JTextField();
        JTextField sexoField = new JTextField();
        JTextField profissaoField = new JTextField();
        JTextField enderecoField = new JTextField();
        JTextField loginField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        JComboBox<String> cargoComboBox = new JComboBox<>(new String[] { "Recepcionista", "Profissional", "Gerente" });
        JTextField especialidadeField = new JTextField();
        JTextField registroConselhoField = new JTextField();
        JTextField dataInscricaoField = new JTextField();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(14, 2, 10, 10));
        formPanel.add(new JLabel("Nome:"));
        formPanel.add(nomeField);
        formPanel.add(new JLabel("Telefone:"));
        formPanel.add(telefoneField);
        formPanel.add(new JLabel("RG:"));
        formPanel.add(rgField);
        formPanel.add(new JLabel("CPF:"));
        formPanel.add(cpfField);
        formPanel.add(new JLabel("Data de Nascimento (yyyy-MM-dd):"));
        formPanel.add(dataNascimentoField);
        formPanel.add(new JLabel("Sexo:"));
        formPanel.add(sexoField);
        formPanel.add(new JLabel("Profissão:"));
        formPanel.add(profissaoField);
        formPanel.add(new JLabel("Endereço:"));
        formPanel.add(enderecoField);
        formPanel.add(new JLabel("Login:"));
        formPanel.add(loginField);
        formPanel.add(new JLabel("Senha:"));
        formPanel.add(senhaField);
        formPanel.add(new JLabel("Cargo:"));
        formPanel.add(cargoComboBox);
        formPanel.add(new JLabel("Especialidade:"));
        formPanel.add(especialidadeField);
        formPanel.add(new JLabel("Registro no Conselho:"));
        formPanel.add(registroConselhoField);
        formPanel.add(new JLabel("Data de Inscrição:"));
        formPanel.add(dataInscricaoField);

        especialidadeField.setVisible(false);
        registroConselhoField.setVisible(false);
        dataInscricaoField.setVisible(false);

        cargoComboBox.addActionListener(event -> {
            String cargoSelecionado = (String) cargoComboBox.getSelectedItem();
            if ("Profissional".equals(cargoSelecionado)) {
                especialidadeField.setVisible(true);
                registroConselhoField.setVisible(true);
                dataInscricaoField.setVisible(true);
            } else {
                especialidadeField.setVisible(false);
                registroConselhoField.setVisible(false);
                dataInscricaoField.setVisible(false);
            }
            formPanel.revalidate();
        });

        int result = JOptionPane.showConfirmDialog(null, formPanel, "Cadastrar Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String nome = nomeField.getText();
                String telefone = telefoneField.getText();
                String rg = rgField.getText();
                String cpf = cpfField.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                if (dataNascimentoField.getText().isEmpty()) {
                    throw new IllegalArgumentException("Data de Nascimento não pode estar vazia.");
                }
                LocalDate dataNascimento = LocalDate.parse(dataNascimentoField.getText(), formatter);
                String sexo = sexoField.getText();
                String profissao = profissaoField.getText();
                String endereco = enderecoField.getText();
                String login = loginField.getText();
                String senha = new String(senhaField.getPassword());
                String cargo = (String) cargoComboBox.getSelectedItem();
                String especialidade = especialidadeField.getText();
                String registroConselho = registroConselhoField.getText();

                LocalDate dataInscricao = null;
                if (cargo.equals("Profissional")) {
                    if (dataInscricaoField.getText().isEmpty()) {
                        throw new IllegalArgumentException("Data de Inscrição não pode estar vazia.");
                    }
                    dataInscricao = LocalDate.parse(dataInscricaoField.getText(), formatter);
                }

                if (nome.isEmpty() || telefone.isEmpty() || rg.isEmpty() || cpf.isEmpty() || sexo.isEmpty()
                        || profissao.isEmpty() || endereco.isEmpty() || login.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos.");
                    return;
                }

                if (cargo.toLowerCase().equals("profissional")) {
                    ProfissionalController profissionalController = new ProfissionalController();
                    profissionalController.createFullProfissional(nome, telefone, rg, cpf, dataNascimento, sexo,
                            profissao, endereco, login, senha, cargo, especialidade, registroConselho, dataInscricao);
                } else if (cargo.toLowerCase().equals("gerente")) {
                    GerenteController gerenteController = new GerenteController();
                    gerenteController.createFullGerente(nome, telefone, rg, cpf, dataNascimento, sexo, profissao,
                            endereco, login, senha, cargo);
                } else {
                    RecepcionistaController recepcionistaController = new RecepcionistaController();
                    recepcionistaController.createFullRecepcionista(nome, telefone, rg, cpf, dataNascimento, sexo,
                            profissao, endereco, login, senha, cargo);
                }

                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Erro ao analisar a data: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário: " + ex.getMessage());
            }
            atualizarTabela();
        }
    }

    private void mostrarFormularioEdicao(JTable tabela) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um funcionário para editar!");
            return;
        }

        String nomeAtual = model.getValueAt(selectedRow, 0).toString();
        String cpfAtual = model.getValueAt(selectedRow, 1).toString();
        String cargoAtual = model.getValueAt(selectedRow, 2).toString();

        JTextField nomeField = new JTextField(nomeAtual);
        JTextField telefoneField = new JTextField();
        JTextField rgField = new JTextField();
        JTextField cpfField = new JTextField(cpfAtual);
        JTextField dataNascimentoField = new JTextField();
        JTextField sexoField = new JTextField();
        JTextField profissaoField = new JTextField();
        JTextField enderecoField = new JTextField();
        JTextField loginField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        JComboBox<String> cargoComboBox = new JComboBox<>(new String[] { "Recepcionista", "Profissional", "Gerente" });
        JTextField especialidadeField = new JTextField();
        JTextField registroConselhoField = new JTextField();
        JTextField dataInscricaoField = new JTextField();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(14, 2, 10, 10));
        formPanel.add(new JLabel("Nome:"));
        formPanel.add(nomeField);
        formPanel.add(new JLabel("Telefone:"));
        formPanel.add(telefoneField);
        formPanel.add(new JLabel("RG:"));
        formPanel.add(rgField);
        formPanel.add(new JLabel("CPF:"));
        formPanel.add(cpfField);
        formPanel.add(new JLabel("Data de Nascimento (yyyy-MM-dd):"));
        formPanel.add(dataNascimentoField);
        formPanel.add(new JLabel("Sexo:"));
        formPanel.add(sexoField);
        formPanel.add(new JLabel("Profissão:"));
        formPanel.add(profissaoField);
        formPanel.add(new JLabel("Endereço:"));
        formPanel.add(enderecoField);
        formPanel.add(new JLabel("Login:"));
        formPanel.add(loginField);
        formPanel.add(new JLabel("Senha:"));
        formPanel.add(senhaField);
        formPanel.add(new JLabel("Cargo:"));
        formPanel.add(cargoComboBox);
        formPanel.add(new JLabel("Especialidade:"));
        formPanel.add(especialidadeField);
        formPanel.add(new JLabel("Registro no Conselho:"));
        formPanel.add(registroConselhoField);
        formPanel.add(new JLabel("Data de Inscrição:"));
        formPanel.add(dataInscricaoField);

        especialidadeField.setVisible(false);
        registroConselhoField.setVisible(false);
        dataInscricaoField.setVisible(false);

        cargoComboBox.addActionListener(event -> {
            String cargoSelecionado = (String) cargoComboBox.getSelectedItem();
            if ("Profissional".equals(cargoSelecionado)) {
                especialidadeField.setVisible(true);
                registroConselhoField.setVisible(true);
                dataInscricaoField.setVisible(true);
            } else {
                especialidadeField.setVisible(false);
                registroConselhoField.setVisible(false);
                dataInscricaoField.setVisible(false);
            }
            formPanel.revalidate();
        });

        int result = JOptionPane.showConfirmDialog(null, formPanel, "Editar Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String nome = nomeField.getText();
                String telefone = telefoneField.getText();
                String rg = rgField.getText();
                String cpf = cpfField.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                if (dataNascimentoField.getText().isEmpty()) {
                    throw new IllegalArgumentException("Data de Nascimento não pode estar vazia.");
                }
                LocalDate dataNascimento = LocalDate.parse(dataNascimentoField.getText(), formatter);
                String sexo = sexoField.getText();
                String profissao = profissaoField.getText();
                String endereco = enderecoField.getText();
                String login = loginField.getText();
                String senha = new String(senhaField.getPassword());
                String cargo = (String) cargoComboBox.getSelectedItem();
                String especialidade = especialidadeField.getText();
                String registroConselho = registroConselhoField.getText();

                LocalDate dataInscricao = null;
                if (cargo.equals("Profissional")) {
                    if (dataInscricaoField.getText().isEmpty()) {
                        throw new IllegalArgumentException("Data de Inscrição não pode estar vazia.");
                    }
                    dataInscricao = LocalDate.parse(dataInscricaoField.getText(), formatter);
                }

                if (cargo.toLowerCase().equals("profissional")) {
                    ProfissionalController profissionalController = new ProfissionalController();
                    profissionalController.updateProfissional(nomeAtual, telefone, cargo, cpf, dataNascimento, sexo,
                            profissao, endereco, login, senha, cargoAtual, especialidade, registroConselho, dataInscricao);
                } else if (cargo.toLowerCase().equals("gerente")) {
                    GerenteController gerenteController = new GerenteController();
                    gerenteController.updateGerente(nomeAtual, telefone, cargo, cpf, dataNascimento, sexo,
                            profissao, endereco, login, senha, cargoAtual);
                } else {
                    RecepcionistaController recepcionistaController = new RecepcionistaController();
                    recepcionistaController.updateRecepcionista(nomeAtual, telefone, cargo, cpf, dataNascimento,
                            sexo, profissao, endereco, login, senha, cargoAtual);
                }

                
                JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Erro ao analisar a data: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao editar funcionário: " + ex.getMessage());
            }
            atualizarTabela();
        }
    }

    private void excluirFuncionario(JTable tabela) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um funcionário para excluir!");
            return;
        }

        String cpfFuncionario = model.getValueAt(selectedRow, 1).toString();
        String cargo = model.getValueAt(selectedRow, 2).toString();

        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este funcionário?",
                "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                if (cargo.toLowerCase().equals("profissional")) {
                    ProfissionalController profissionalController = new ProfissionalController();
                    profissionalController.deleteProfissional(cpfFuncionario);
                } else if (cargo.toLowerCase().equals("gerente")) {
                    GerenteController gerenteController = new GerenteController();
                    gerenteController.deleteGerente(cpfFuncionario);
                } else {
                    RecepcionistaController recepcionistaController = new RecepcionistaController();
                    recepcionistaController.deleteRecepcionista(cpfFuncionario);
                }

                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário: " + ex.getMessage());
            }
        }
    }

    private void atualizarTabela() {
        String[][] funcionariosData = carregarDados();
        model.setRowCount(0);
        for (String[] funcionario : funcionariosData) {
            model.addRow(funcionario);
        }
    }

    private void configurarBotao(JButton botao, Color corFundo, Color corTexto) {
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setBackground(corFundo);
        botao.setForeground(corTexto);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaGerente tela = new TelaGerente();
            tela.setVisible(true);
        });
    }

    public String[][] carregarDados() {
        FuncionarioController funcionarioController = new FuncionarioController();
        List<Funcionario> funcionarios;
        try {
            funcionarios = funcionarioController.getAllFuncionario();
        } catch (ExceptionDAO e1) {
            e1.printStackTrace();
            return new String[0][0];
        }
        String[][] funcionariosData = new String[funcionarios.size()][3];
        for (int i = 0; i < funcionarios.size(); i++) {
            funcionariosData[i][0] = funcionarios.get(i).getNome();
            funcionariosData[i][1] = funcionarios.get(i).getCpf();
            funcionariosData[i][2] = funcionarios.get(i).getCargo();
        }
        return funcionariosData;
    }
}