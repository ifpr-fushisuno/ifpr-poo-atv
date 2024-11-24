package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import controller.ProntuarioController;
import controller.PacienteController;;

public class TelaProntuario extends JFrame {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;

    public TelaProntuario() {
        // Configurações da janela
        setTitle("Gerenciamento de Prontuários");
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel superior (Barra de navegação)
        JPanel navBar = new JPanel(new BorderLayout());
        navBar.setBackground(new Color(47, 85, 151));
        navBar.setPreferredSize(new Dimension(0, 60));

        JLabel userInfoLabel = new JLabel("Profissional de Saúde", JLabel.LEFT);
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
        sairButton.addActionListener(e -> new TelaProfissional());

        navBar.add(userInfoLabel, BorderLayout.WEST);
        navBar.add(sairButton, BorderLayout.EAST);
        add(navBar, BorderLayout.NORTH);

        // Painel central (Tabela e botões)
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(240, 248, 255));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titleLabel = new JLabel("Gerenciamento de Prontuários", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(47, 85, 151));
        centerPanel.add(titleLabel, BorderLayout.NORTH);

        // Definir as colunas da tabela para o prontuário
        String[] colunas = {
            "ID Prontuário", "ID Paciente", "ID Profissional", "Diagnóstico", "Prescrição"
        };

        // Dados fictícios para o prontuário (exemplo com 5 registros)
        String[][] prontuariosData = {
            {"101", "2001", "3001", "Gripe", "Repouso e uso de antivirais"},
            {"102", "2002", "3002", "Asma", "Uso de inaladores e medicação"},
            {"103", "2003", "3003", "Hipertensão", "Controle com medicamentos e dieta"},
            {"104", "2004", "3004", "Infecção viral", "Antibióticos e repouso"},
            {"105", "2005", "3005", "Diabetes", "Controle glicêmico e exercício físico"}
        };


        // Atualizar o modelo da tabela
        model = new DefaultTableModel(prontuariosData, colunas);

        JTable prontuarioTable = new JTable(model);
        prontuarioTable.setFont(new Font("Arial", Font.PLAIN, 14));
        prontuarioTable.setRowHeight(25);
        prontuarioTable.setSelectionBackground(new Color(184, 214, 247));
        prontuarioTable.setSelectionForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(prontuarioTable);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonsPanel.setBackground(new Color(240, 248, 255));

        JButton cadastrarButton = new JButton("Novo Prontuario");
        JButton editarButton = new JButton("Editar Prontuario");
        JButton deletarButton = new JButton("Deletar Prontuário");

        configurarBotao(cadastrarButton, new Color(40, 167, 69), Color.WHITE, e -> JOptionPane.showMessageDialog(null, "Adicionar Novo Prontuário."));
        configurarBotao(editarButton, new Color(255, 193, 7), Color.BLACK, e -> {
            int selectedRow = prontuarioTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = (String) model.getValueAt(selectedRow, 0);
                JOptionPane.showMessageDialog(null, "Editar Prontuário: ID - " + id);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um prontuário para editar.");
            }
        });
        configurarBotao(deletarButton, new Color(220, 53, 69), Color.WHITE, e -> {
            int selectedRow = prontuarioTable.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um prontuário para deletar.");
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
            JTextField idPacienteField = new JTextField();
            JTextField idProfissionalField = new JTextField();
            JTextField diagnosticoField = new JTextField();
            JTextField prescricaoField = new JTextField();
        
            // Painel do formulário
            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(5, 2, 10, 10)); // Ajustado para 5 linhas e 2 colunas, com espaçamento
            formPanel.add(new JLabel("ID do Paciente:"));
            formPanel.add(idPacienteField);
            formPanel.add(new JLabel("ID do Profissional:"));
            formPanel.add(idProfissionalField);
            formPanel.add(new JLabel("Diagnóstico:"));
            formPanel.add(diagnosticoField);
            formPanel.add(new JLabel("Prescrição:"));
            formPanel.add(prescricaoField);
        
            // Exibe o formulário em um JOptionPane
            int result = JOptionPane.showConfirmDialog(null, formPanel, "Cadastrar Prontuário",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
            // Captura os dados preenchidos
            if (result == JOptionPane.OK_OPTION) {
                try {
                    // Captura os valores dos campos
                    int idPaciente = Integer.parseInt(idPacienteField.getText());
                    int idProfissional = Integer.parseInt(idProfissionalField.getText());
                    String diagnostico = diagnosticoField.getText();
                    String prescricao = prescricaoField.getText();
        
                    // Cria um novo prontuário
                    ProntuarioController prontuarioController = new ProntuarioController();
                    prontuarioController.createProntuario(idPaciente, idProfissional, diagnostico, prescricao);
        
                    // Adiciona o novo prontuário à tabela (supondo que o idProntuario será gerado automaticamente)
                    model.addRow(new Object[]{
                            String.valueOf(model.getRowCount() + 1),  // Geração simples do ID (por exemplo, se for automático, pode ser ajustado)
                            idPaciente,
                            idProfissional,
                            diagnostico,
                            prescricao
                    });
        
                    JOptionPane.showMessageDialog(null, "Prontuário cadastrado com sucesso");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar prontuário: " + ex.getMessage());
                } catch (Exception e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                }
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
                    int selectedRow = prontuarioTable.getSelectedRow();
                    if (selectedRow != -1) {
                        // ID do prontuário
                        int idProntuario = (int) model.getValueAt(selectedRow, 0);
        
                        // Pegar os dados de acordo com a seleção feita pelo funcionário
                        int idPacienteAtual = (int) model.getValueAt(selectedRow, 1);
                        int idProfissionalAtual = (int) model.getValueAt(selectedRow, 2);
                        String diagnosticoAtual = (String) model.getValueAt(selectedRow, 3);
                        String prescricaoAtual = (String) model.getValueAt(selectedRow, 4);
        
                        // Para as novas informações
                        String novoDiagnostico = JOptionPane.showInputDialog("Informe o novo diagnóstico", diagnosticoAtual);
                        String novaPrescricao = JOptionPane.showInputDialog("Informe a nova prescrição", prescricaoAtual);
        
                        // Chamando o método updateProntuario do controller
                        ProntuarioController prontuarioController = new ProntuarioController();
                        prontuarioController.updateProntuario(idProntuario, idPacienteAtual, idProfissionalAtual, novoDiagnostico, novaPrescricao);
        
                        // Atualizar a tabela com os novos valores
                        model.setValueAt(novoDiagnostico, selectedRow, 3);
                        model.setValueAt(novaPrescricao, selectedRow, 4);
        
                        JOptionPane.showMessageDialog(null, "Prontuário alterado com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione um prontuário para editar.");
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
            int selectedRow = prontuarioTable.getSelectedRow();
            if (selectedRow != -1) {
                String nomePaciente = (String) model.getValueAt(selectedRow, 1);  // Nome do paciente do prontuário
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Tem certeza que deseja deletar o prontuário do paciente: " + nomePaciente + "?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
        
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        // Obtém o ID do prontuário a partir da tabela (presumindo que o ID do prontuário esteja na primeira coluna)
                        String idProntuarioStr = (String) model.getValueAt(selectedRow, 0); 
                        int idProntuario = Integer.parseInt(idProntuarioStr);  // Converte para inteiro
        
                        // Chama o método deleteProntuario do controlador para excluir o prontuário
                        ProntuarioController prontuarioController = new ProntuarioController();
                        prontuarioController.deleteProntuario(idProntuario); 
        
                        // Após a exclusão, remove a linha da tabela
                        model.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Prontuário excluído com sucesso!");
        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir prontuário: " + ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um prontuário para deletar.");
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
            TelaProntuario tela = new TelaProntuario();
            tela.setVisible(true);
        });
    }
}
