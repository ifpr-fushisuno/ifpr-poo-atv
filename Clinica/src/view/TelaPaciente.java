package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.PacienteController;
import controller.RecepcionistaController;
import dao.ExceptionDAO;
import model.Pessoa;
import model.Profissional;
import model.Recepcionista;

public class TelaPaciente extends JFrame {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;

    public TelaPaciente(Object funcionario){
        // Configurações da janela
        setTitle("Gerenciamento de Pacientes");
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel superior (Barra de navegação)
        JPanel navBar = new JPanel(new BorderLayout());
        navBar.setBackground(new Color(47, 85, 151));
        navBar.setPreferredSize(new Dimension(0, 60));

        JLabel userInfoLabel = new JLabel("Dr(a). " + ((Pessoa) funcionario).getNome(), JLabel.LEFT);
        userInfoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userInfoLabel.setForeground(Color.WHITE);
        userInfoLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));

        JButton sairButton = new JButton("Sair");
        sairButton.setForeground(Color.WHITE);
        sairButton.setFont(new Font("Arial", Font.PLAIN, 14));
        sairButton.setBackground(new Color(220, 53, 69));
        sairButton.setFocusPainted(false);
        sairButton.setBorderPainted(false);
        sairButton.setPreferredSize(new Dimension(80, 40));
        sairButton.addActionListener(e -> new TelaProfissional(funcionario));

        navBar.add(userInfoLabel, BorderLayout.WEST);
        navBar.add(sairButton, BorderLayout.EAST);
        add(navBar, BorderLayout.NORTH);

        // Painel central (Tabela e botões)
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(240, 248, 255));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titleLabel = new JLabel("Gerenciamento de Pacientes", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(47, 85, 151));
        centerPanel.add(titleLabel, BorderLayout.NORTH);

        // Novas colunas para a tabela
        String[] colunas = {
            "ID", "Nome", "Etnia", "Tipo Sanguíneo", "Peso (kg)", "Altura (m)", 
            "Doador", "Fumante", "Doenças", "Limitações"
        };


        // Dados iniciais atualizados - substituir pelo método list de pacientes
        String[][] pacientesData = {
            {"2001", "José da Silva", "Branco", "O+", "70.5", "1.75", "Sim", "Não", "Nenhuma", "Nenhuma"},
            {"2002", "Ana Clara", "Parda", "A-", "65.0", "1.65", "Não", "Não", "Asma", "Nenhuma"},
            {"2003", "Pedro Henrique", "Negro", "B+", "85.3", "1.80", "Sim", "Sim", "Hipertensão", "Joelho lesionado"},
            {"2004", "Maria Eduarda", "Branca", "AB-", "50.0", "1.60", "Não", "Não", "Nenhuma", "Nenhuma"},
            {"2005", "Carlos Augusto", "Indígena", "O+", "90.0", "1.70", "Sim", "Não", "Diabetes", "Nenhuma"}
        };

        // Atualizar o modelo da tabela
        model = new DefaultTableModel(pacientesData, colunas);

        JTable pacientesTable = new JTable(model);
        pacientesTable.setFont(new Font("Arial", Font.PLAIN, 14));
        pacientesTable.setRowHeight(25);
        pacientesTable.setSelectionBackground(new Color(184, 214, 247));
        pacientesTable.setSelectionForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(pacientesTable);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonsPanel.setBackground(new Color(240, 248, 255));

        JButton cadastrarButton = new JButton("Cadastrar Paciente");
        JButton editarButton = new JButton("Editar Paciente");
        JButton deletarButton = new JButton("Deletar Paciente");

        configurarBotao(cadastrarButton, new Color(40, 167, 69), Color.WHITE, e -> JOptionPane.showMessageDialog(null, "Cadastrar novo paciente."));
        configurarBotao(editarButton, new Color(255, 193, 7), Color.BLACK, e -> {
            int selectedRow = pacientesTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = (String) model.getValueAt(selectedRow, 0);
                JOptionPane.showMessageDialog(null, "Editar Paciente: ID - " + id);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um paciente para editar.");
            }
        });
        configurarBotao(deletarButton, new Color(220, 53, 69), Color.WHITE, e -> {
            int selectedRow = pacientesTable.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um paciente para deletar.");
            }
        });

        /**
         * Adicionar os métodos com as ações de cada botão
         * ------------ Cadastro -------------
         * Pessoa pessoa, String etnia, String tipoSanguineo, boolean fatorRh, double peso,
			double altura, boolean doador, boolean fumante, String doencas, String limitacoes
         */
        cadastrarButton.addActionListener(e -> {
            // Campos do formulário
            JTextField nomeField = new JTextField();
            JTextField etniaField = new JTextField();
            JTextField tipoSanguineoField = new JTextField();
            JCheckBox fatorRhCheckBox = new JCheckBox("Positivo");
            fatorRhCheckBox.setSelected(true);
            JTextField pesoField = new JTextField();
            JTextField alturaField = new JTextField();
            JCheckBox doadorCheckBox = new JCheckBox("Sim");
            doadorCheckBox.setSelected(false); // Por padrão, não doador
            JCheckBox fumanteCheckBox = new JCheckBox("Sim");
            fumanteCheckBox.setSelected(false); // Por padrão, não fumante
            JTextField doencasField = new JTextField();
            JTextField limitacoesField = new JTextField();
        
            // Painel do formulário
            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(10, 2, 10, 10)); // Ajustado para 10 linhas e 2 colunas, com espaçamento
            formPanel.add(new JLabel("Nome:"));
            formPanel.add(nomeField);
            formPanel.add(new JLabel("Etnia:"));
            formPanel.add(etniaField);
            formPanel.add(new JLabel("Tipo Sanguíneo:"));
            formPanel.add(tipoSanguineoField);
            formPanel.add(new JLabel("Fator RH:"));
            formPanel.add(fatorRhCheckBox);
            formPanel.add(new JLabel("Peso (kg):"));
            formPanel.add(pesoField);
            formPanel.add(new JLabel("Altura (m):"));
            formPanel.add(alturaField);
            formPanel.add(new JLabel("Doador:"));
            formPanel.add(doadorCheckBox);
            formPanel.add(new JLabel("Fumante:"));
            formPanel.add(fumanteCheckBox);
            formPanel.add(new JLabel("Doenças pré-existentes:"));
            formPanel.add(doencasField);
            formPanel.add(new JLabel("Limitações físicas:"));
            formPanel.add(limitacoesField);
        
            // Exibe o formulário em um JOptionPane
            int result = JOptionPane.showConfirmDialog(null, formPanel, "Cadastrar Paciente",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
            // Captura os dados preenchidos
            if (result == JOptionPane.OK_OPTION) {
                String nome = nomeField.getText();
                String etnia = etniaField.getText();
                String tipoSanguineo = tipoSanguineoField.getText();
                boolean fatorRh = fatorRhCheckBox.isSelected();
                double peso = Double.parseDouble(pesoField.getText());
                double altura = Double.parseDouble(alturaField.getText());
                boolean doador = doadorCheckBox.isSelected();
                boolean fumante = fumanteCheckBox.isSelected();
                String doencas = doencasField.getText();
                String limitacoes = limitacoesField.getText();
        
                // Adiciona o novo paciente à tabela
                model.addRow(new Object[]{
                        String.valueOf(model.getRowCount() + 2001), 
                        nome, 
                        etnia, 
                        tipoSanguineo + (fatorRh ? "+" : "-"), 
                        peso, 
                        altura, 
                        doador ? "Sim" : "Não", 
                        fumante ? "Sim" : "Não", 
                        doencas, 
                        limitacoes
                });
            }
        });

        /*
         * --------- Editar Paciente ------------
         */
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Captura da linha selecionada
                    int selectedRow = pacientesTable.getSelectedRow();
                    if (selectedRow != -1) {
                        //talvez retirar
                        //int codPaciente = (int) model.getValueAt(selectedRow, 0); // Supondo que o código está na coluna 0
        
                        // Pegar osdados de acordo com a seleção feita pelo funcionário
                        String etniaAtual = (String) model.getValueAt(selectedRow, 1);
                        String tipoSanguineoAtual = (String) model.getValueAt(selectedRow, 2);
                        boolean fatorRhAtual = "Positivo".equals(model.getValueAt(selectedRow, 3));
                        double pesoAtual = Double.parseDouble((String) model.getValueAt(selectedRow, 4));
                        double alturaAtual = Double.parseDouble((String) model.getValueAt(selectedRow, 5));
                        boolean doadorAtual = "Sim".equals(model.getValueAt(selectedRow, 6));
                        boolean fumanteAtual = "Sim".equals(model.getValueAt(selectedRow, 7));
                        String doencasAtual = (String) model.getValueAt(selectedRow, 8);
                        String limitacoesAtual = (String) model.getValueAt(selectedRow, 9);
        
                        //Para as novas informaçoes
                        String novaEtnia = JOptionPane.showInputDialog("Informe a nova etnia", etniaAtual);
                        String novoTipoSanguineo = JOptionPane.showInputDialog("Informe o novo tipo sanguíneo", tipoSanguineoAtual);
                        String novoFatorRh = JOptionPane.showInputDialog("Informe o fator RH (Positivo/Negativo)", fatorRhAtual ? "Positivo" : "Negativo");
                        String novoPesoStr = JOptionPane.showInputDialog("Informe o novo peso (kg)", pesoAtual);
                        String novoAlturaStr = JOptionPane.showInputDialog("Informe a nova altura (m)", alturaAtual);
                        String novoDoador = JOptionPane.showInputDialog("É doador de órgãos? (Sim/Não)", doadorAtual ? "Sim" : "Não");
                        String novoFumante = JOptionPane.showInputDialog("É fumante? (Sim/Não)", fumanteAtual ? "Sim" : "Não");
                        String novasDoencas = JOptionPane.showInputDialog("Informe as doenças", doencasAtual);
                        String novasLimitacoes = JOptionPane.showInputDialog("Informe as limitações", limitacoesAtual);
        
                        // Convertendo os valores para os tipos corretos
                        boolean novoFatorRhBool = "Positivo".equals(novoFatorRh);
                        double novoPeso = Double.parseDouble(novoPesoStr);
                        double novaAltura = Double.parseDouble(novoAlturaStr);
                        boolean novoDoadorBool = "Sim".equals(novoDoador);
                        boolean novoFumanteBool = "Sim".equals(novoFumante);
        
                        // Chamando o método updatePaciente do controller
                        PacienteController pacienteController = new PacienteController();
                        pacienteController.updatePaciente(novaEtnia, novoTipoSanguineo, novoFatorRhBool, novoPeso, novaAltura,
                                novoDoadorBool, novoFumanteBool, novasDoencas, novasLimitacoes);
        
                        // Atualizar a tabela com os novos valores
                        model.setValueAt(novaEtnia, selectedRow, 1);
                        model.setValueAt(novoTipoSanguineo, selectedRow, 2);
                        model.setValueAt(novoFatorRhBool ? "Positivo" : "Negativo", selectedRow, 3);
                        model.setValueAt(String.valueOf(novoPeso), selectedRow, 4);
                        model.setValueAt(String.valueOf(novaAltura), selectedRow, 5);
                        model.setValueAt(novoDoadorBool ? "Sim" : "Não", selectedRow, 6);
                        model.setValueAt(novoFumanteBool ? "Sim" : "Não", selectedRow, 7);
                        model.setValueAt(novasDoencas, selectedRow, 8);
                        model.setValueAt(novasLimitacoes, selectedRow, 9);
        
                        JOptionPane.showMessageDialog(null, "Paciente alterado com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione um paciente para editar.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });
        

        /*
         * --------- Deletar Paciente -----------
         */
        deletarButton.addActionListener(e -> {
            int selectedRow = pacientesTable.getSelectedRow();
            if (selectedRow != -1) {
                String nome = (String) model.getValueAt(selectedRow, 1);
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Tem certeza que deseja deletar o paciente: " + nome + "?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        // Obtém o ID do paciente a partir da tabela
                        String idPaciente = (String) model.getValueAt(selectedRow, 0); 
                        int id = Integer.parseInt(idPaciente);  

                        // Chama o método deletePaciente do controlador para excluir o paciente
                        PacienteController pacienteController = new PacienteController();
                        pacienteController.deletePaciente(id); 

                        // Após a exclusão, remove a linha da tabela
                        model.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso!");

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir paciente: " + ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um paciente para deletar.");
            }
        });

        
        buttonsPanel.add(cadastrarButton);
        buttonsPanel.add(editarButton);
        buttonsPanel.add(deletarButton);

        centerPanel.add(buttonsPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void configurarBotao(JButton botao, Color corFundo, Color corTexto, ActionListener action) {
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setBackground(corFundo);
        botao.setForeground(corTexto);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        botao.addActionListener(action);
    }



    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            TelaPaciente tela = new TelaPaciente(null);
            tela.setVisible(true);
        });
    }
}
