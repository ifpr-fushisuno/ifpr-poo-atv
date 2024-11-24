package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import model.Consulta.StatusConsulta;

public class TelaConsulta extends JFrame {

    private static final long serialVersionUID = 1L;

    // Labels e Campos de Entrada
    private JLabel lblPaciente, lblData, lblHora, lblStatus;
    private JTextField txtPaciente, txtData, txtHora;
    private JComboBox<StatusConsulta> cmbStatus;

    // Botões
    private JButton btnCadastrar, btnConsultar, btnAlterar, btnExcluir, btnLimpar, btnVoltar;

    public TelaConsulta() {
        super("Gerenciar Consultas");

        // Configuração da Janela
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Painel Principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(200, 230, 255));

        // Título
        JLabel titleLabel = new JLabel("Gerenciar Consultas", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 80, 120));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Painel de Campos
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(5, 2, 10, 10));
        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(50, 150, 20, 150));
        fieldsPanel.setBackground(new Color(240, 240, 240));

        lblPaciente = new JLabel("Paciente:");
        lblData = new JLabel("Data (AAAA-MM-DD):");
        lblHora = new JLabel("Hora (HH:MM:SS):");
        lblStatus = new JLabel("Status:");

        lblPaciente.setFont(new Font("Arial", Font.BOLD, 18));
        lblData.setFont(new Font("Arial", Font.BOLD, 18));
        lblHora.setFont(new Font("Arial", Font.BOLD, 18));
        lblStatus.setFont(new Font("Arial", Font.BOLD, 18));

        txtPaciente = new JTextField();
        txtData = new JTextField();
        txtHora = new JTextField();
        cmbStatus = new JComboBox<>(StatusConsulta.values());

        // Define o tamanho fixo para as caixas de texto
        Dimension textFieldSize = new Dimension(2, 2);
        txtPaciente.setPreferredSize(new Dimension(2, 2));
        txtData.setPreferredSize(textFieldSize);
        txtHora.setPreferredSize(textFieldSize);

        // Encapsula as caixas de texto em painéis individuais
        JPanel pacientePanel = new JPanel(new BorderLayout());
        pacientePanel.add(txtPaciente, BorderLayout.CENTER);

        JPanel dataPanel = new JPanel(new BorderLayout());
        dataPanel.add(txtData, BorderLayout.CENTER);

        JPanel horaPanel = new JPanel(new BorderLayout());
        horaPanel.add(txtHora, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.add(cmbStatus, BorderLayout.CENTER);

        // Adiciona os rótulos e painéis ao fieldsPanel
        fieldsPanel.add(lblPaciente);
        fieldsPanel.add(pacientePanel);
        fieldsPanel.add(lblData);
        fieldsPanel.add(dataPanel);
        fieldsPanel.add(lblHora);
        fieldsPanel.add(horaPanel);
        fieldsPanel.add(lblStatus);
        fieldsPanel.add(statusPanel);

        // Painel de Botões
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 6, 10, 10)); // Ajustado para incluir 6 botões
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonsPanel.setBackground(new Color(240, 240, 240));

        btnCadastrar = new JButton("Cadastrar");
        btnConsultar = new JButton("Consultar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnLimpar = new JButton("Limpar");
        btnVoltar = new JButton("Voltar");

        JButton[] buttons = {btnCadastrar, btnConsultar, btnAlterar, btnExcluir, btnLimpar, btnVoltar};
        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setBackground(new Color(100, 150, 200));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            buttonsPanel.add(button);
        }
        btnVoltar.setBackground(new Color(200, 100, 100)); // Cor especial para "Voltar"

         // Limpar campos
         btnLimpar.addActionListener(e -> limparCampos());
         // Voltar para a tela profissional
         btnVoltar.addActionListener(e -> voltarParaTelaProfissional());

        // Adicionar os painéis ao mainPanel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(fieldsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);


        // Adicionar Painel Principal à Janela
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void voltarParaTelaProfissional() {
        dispose();
        new TelaProfissional().setVisible(true);
    }

    /*
     * Métodos para a funcionalidade dos botões
     */




    private void limparCampos() {
        txtPaciente.setText("");
        txtData.setText("");
        txtHora.setText("");
        cmbStatus.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaConsulta().setVisible(true));
    }
}
