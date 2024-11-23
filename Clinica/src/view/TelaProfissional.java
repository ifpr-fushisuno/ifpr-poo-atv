package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TelaProfissional extends JFrame {

    private static final long serialVersionUID = 1L;

    // Inicialização dos botões para acessar outras telas
    private JButton btnTelaConsultas, btnTelaProntuarios;

    public TelaProfissional() {
        super("Área do Profissional de Saúde");

        // Configuração da janela
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(200, 230, 255));

        // Título
        JLabel titleLabel = new JLabel("Bem-vindo, Profissional de Saúde", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 80, 120));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Painel de botões
        JPanel btnJPanel = new JPanel();
        btnJPanel.setLayout(new GridLayout(2, 1, 20, 20));
        btnJPanel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        btnJPanel.setBackground(new Color(200, 230, 255));

        // Botões
        btnTelaConsultas = new JButton("Gerenciar Consultas");
        btnTelaProntuarios = new JButton("Gerenciar Prontuários");

        btnTelaConsultas.setFont(new Font("Arial", Font.BOLD, 18));
        btnTelaProntuarios.setFont(new Font("Arial", Font.BOLD, 18));

        btnTelaConsultas.setBackground(new Color(100, 150, 200));
        btnTelaProntuarios.setBackground(new Color(100, 150, 200));

        btnTelaConsultas.setForeground(Color.WHITE);
        btnTelaProntuarios.setForeground(Color.WHITE);

        btnTelaConsultas.setFocusPainted(false);
        btnTelaProntuarios.setFocusPainted(false);

        // Ações dos botões
        btnTelaConsultas.addActionListener(e -> abrirTelaConsultas());
        btnTelaProntuarios.addActionListener(e -> abrirTelaProntuarios());

        // Botões ao painel
        btnJPanel.add(btnTelaConsultas);
        btnJPanel.add(btnTelaProntuarios);

        //Adição dos componentes na tela
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(btnJPanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Métodos para abrir as telas de Consultas e Prontuários
    private void abrirTelaConsultas() {
        dispose();
        new TelaConsulta().setVisible(true); 
    }

    private void abrirTelaProntuarios() {
        dispose(); 
        new TelaProntuario().setVisible(true); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaProfissional().setVisible(true));
    }
}