package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.Date; // Para usar a data de nascimento

import controller.PessoaController;
import model.Pessoa;

public class TelaCadastroPessoa extends JFrame {

    private static final long serialVersionUID = 5756598100844974336L;

    private JLabel nomeJLabel;
    private JTextField nomeJTxtField;
    private JLabel foneJLabel;
    private JTextField foneJTxtField;
    private JLabel rgJLabel;
    private JTextField rgJTxtField;
    private JLabel cpfJLabel;
    private JTextField cpfJTxtField;
    private JLabel dataNascJLabel;
    private JTextField dataNascJTxtField; // Exemplo de campo para data
    public JButton incluirBtn;
    public JButton limparBtn;
    public JButton cancelarBtn;
    public JButton consultarBtn;
    public JButton alterarBtn;
    public JButton excluirBtn;

    public TelaCadastroPessoa() {
        super("Cadastro de Pessoas");

        // Inicialização dos componentes
        nomeJLabel = new JLabel("Nome");
        nomeJTxtField = new JTextField();
        foneJLabel = new JLabel("Telefone");
        foneJTxtField = new JTextField();
        rgJLabel = new JLabel("RG");
        rgJTxtField = new JTextField();
        cpfJLabel = new JLabel("CPF");
        cpfJTxtField = new JTextField();
        dataNascJLabel = new JLabel("Data Nasc (YYYY-MM-DD)");
        dataNascJTxtField = new JTextField();
        
        incluirBtn = new JButton("Incluir");
        alterarBtn = new JButton("Alterar");
        limparBtn = new JButton("Limpar");
        cancelarBtn = new JButton("Cancelar");
        consultarBtn = new JButton("Consultar");
        excluirBtn = new JButton("Excluir");

        // Configurações da tela
        setSize(450, 300);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);

        // Definindo as posições dos componentes
        nomeJLabel.setBounds(10, 10, 100, 25);
        nomeJTxtField.setBounds(70, 10, 200, 25);
        foneJLabel.setBounds(10, 50, 100, 25);
        foneJTxtField.setBounds(90, 50, 200, 25);
        rgJLabel.setBounds(10, 90, 100, 25);
        rgJTxtField.setBounds(70, 90, 200, 25);
        cpfJLabel.setBounds(10, 130, 100, 25);
        cpfJTxtField.setBounds(70, 130, 200, 25);
        dataNascJLabel.setBounds(10, 170, 150, 25);
        dataNascJTxtField.setBounds(160, 170, 110, 25);

        incluirBtn.setBounds(20, 210, 70, 25);
        limparBtn.setBounds(100, 210, 70, 25);
        cancelarBtn.setBounds(180, 210, 80, 25);
        consultarBtn.setBounds(270, 210, 90, 25);
        alterarBtn.setBounds(360, 210, 80, 25);
        excluirBtn.setBounds(360, 210, 80, 25);

        // Adicionando os componentes à tela
        add(nomeJLabel);
        add(nomeJTxtField);
        add(foneJLabel);
        add(foneJTxtField);
        add(rgJLabel);
        add(rgJTxtField);
        add(cpfJLabel);
        add(cpfJTxtField);
        add(dataNascJLabel);
        add(dataNascJTxtField);
        add(incluirBtn);
        add(limparBtn);
        add(cancelarBtn);
        add(consultarBtn);
        add(alterarBtn);
        add(excluirBtn);

        alterarBtn.setEnabled(false);
        excluirBtn.setEnabled(false);

        // Ações dos botões
        incluirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PessoaController pessoaController = new PessoaController();
                    String nome = nomeJTxtField.getText();
                    String telefone = foneJTxtField.getText();
                    String rg = rgJTxtField.getText();
                    String cpf = cpfJTxtField.getText();
                    Date dataNascimento = Date.valueOf(dataNascJTxtField.getText());
                    String sexo = ""; // Adicione o campo de sexo se necessário
                    String profissao = ""; // Adicione o campo de profissão se necessário
                    pessoaController.createPessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao);
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                    limparCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });

        // AÇÕES DOS OUTROS BOTÕES
        // Implemente as funcionalidades de consultar, alterar, limpar e excluir como necessário...
        // Exemplo para o botão limpar que já está definido:
        limparBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
    }

    private void limparCampos() {
        nomeJTxtField.setText("");
        foneJTxtField.setText("");
        rgJTxtField.setText("");
        cpfJTxtField.setText("");
        dataNascJTxtField.setText("");
        alterarBtn.setEnabled(false);
        excluirBtn.setEnabled(false);
    }
}