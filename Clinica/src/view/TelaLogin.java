package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.LoginController;
import dao.ExceptionDAO;

public class TelaLogin extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private LoginController loginController;

    public TelaLogin() {
        loginController = new LoginController();

        // Configurações da janela
        setTitle("Sistema de Login");
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setResizable(false);

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(240, 248, 255)); // Fundo claro
        mainPanel.setLayout(new BorderLayout());

        // Painel do título
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 102, 204)); // Fundo azul
        JLabel titleLabel = new JLabel("Login do Sistema");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        // Painel do formulário
        JPanel formPanel = new JPanel();
        formPanel.setBackground(new Color(240, 248, 255));
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // utlizado para alinhar os campos no formulario
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Campos do formulário
        JLabel lblUsername = new JLabel("Usuário:");
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        txtUsername = new JTextField(20);

        JLabel lblPassword = new JLabel("Senha:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        txtPassword = new JPasswordField(20);

        JLabel lblUserType = new JLabel("Tipo de Usuário:");
        lblUserType.setFont(new Font("Arial", Font.PLAIN, 16));
        String[] userTypes = { "Profissional", "Gerente", "Recepcionista" };
        JComboBox<String> userTypeComboBox = new JComboBox<>(userTypes);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setBackground(new Color(0, 102, 204));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);

        /**
         * Anotação:
         * A classe GridBagConstraints permite adicionar as coordenadas da grid que você prefere que seu
         * elemento do JFrame fique localizado
         */
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lblUsername, gbc);

        gbc.gridx = 1;
        formPanel.add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lblPassword, gbc);

        gbc.gridx = 1;
        formPanel.add(txtPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(lblUserType, gbc);

        gbc.gridx = 1;
        formPanel.add(userTypeComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(btnLogin, gbc);

       
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                String userType = (String) userTypeComboBox.getSelectedItem();

                try {
                    if (loginController.autenticar(username, password, userType)) {
                        JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");

                        // Redirecionando para a tela de acordo com o tipo de usuário
                        switch (userType) {
                            case "Profissional":
                                new TelaProfissional().setVisible(true);
                                break;
                            case "Gerente":
                                new TelaGerente().setVisible(true);
                                break;
                            case "Recepcionista":
                                new TelaRecepcionista().setVisible(true);
                                break;
                        }
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
                    }
                } catch (SQLException | ExceptionDAO ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao autenticar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adiciona os painéis ao JFrame
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public static void main(String[] args) {
        /* Anotação:
         * O método SwingUtilities.invokeLater é usado para garantir que atualizações na GUI sejam realizadas na thread que é responsável
         * pela manipularção de todos os componentes da interface gráfica no Swing.
         */
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}
