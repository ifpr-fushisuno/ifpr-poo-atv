package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import model.Pessoa;
import model.Profissional;

public class TelaProntuario extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;

    public TelaProntuario(Object profissional) {
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

        JLabel userInfoLabel = new JLabel("Dr(a). " + ((Pessoa) profissional).getNome(), JLabel.LEFT);
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
        sairButton.addActionListener(e -> {
            // Adicione a ação para sair aqui
        });

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
        String[] colunas = { "ID Prontuário", "ID Paciente", "ID Profissional", "Diagnóstico", "Prescrição" };

        // Dados fictícios para o prontuário (exemplo com 5 registros)
        String[][] prontuariosData = {
            { "101", "2001", "3001", "Gripe", "Repouso e uso de antivirais" },
            { "102", "2002", "3002", "Asma", "Uso de inaladores e medicação" },
            { "103", "2003", "3003", "Hipertensão", "Controle com medicamentos e dieta" },
            { "104", "2004", "3004", "Infecção viral", "Antibióticos e repouso" },
            { "105", "2005", "3005", "Diabetes", "Controle glicêmico e exercício físico" }
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
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(240, 248, 255));

        JButton cadastrarButton = new JButton("Novo Prontuário");
        JButton editarButton = new JButton("Editar Prontuário");
        JButton deletarButton = new JButton("Deletar Prontuário");

        /**
         * Adicione as ações para cada botão, conforme necessário
         */

        buttonsPanel.add(cadastrarButton);
        buttonsPanel.add(editarButton);
        buttonsPanel.add(deletarButton);

        centerPanel.add(buttonsPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaProntuario(null).setVisible(true));
    }
}
