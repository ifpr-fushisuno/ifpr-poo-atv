import javax.swing.*;

import controller.FuncionarioController;
import model.Funcionario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioView {
    private JFrame frame;
    private JTextField tfId, tfNome, tfCargo, tfSenha;
    private FuncionarioController funcionarioController;

    public FuncionarioView(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Gerenciar Funcionários");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        JLabel lblId = new JLabel("ID:");
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblCargo = new JLabel("Cargo:");
        JLabel lblSenha = new JLabel("Senha:");

        tfId = new JTextField();
        tfNome = new JTextField();
        tfCargo = new JTextField();
        tfSenha = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarFuncionario();
            }
        });

        frame.add(lblId);
        frame.add(tfId);
        frame.add(lblNome);
        frame.add(tfNome);
        frame.add(lblCargo);
        frame.add(tfCargo);
        frame.add(lblSenha);
        frame.add(tfSenha);
        frame.add(btnSalvar);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void salvarFuncionario() {
        String id = tfId.getText();
        String nome = tfNome.getText();
        String cargo = tfCargo.getText();
        String senha = tfSenha.getText();

        Funcionario funcionario = new Funcionario(id, nome, cargo, senha);
        funcionarioController.adicionarFuncionario(funcionario);
        JOptionPane.showMessageDialog(frame, "Funcionário salvo com sucesso!");
        limparCampos();
    }

    private void limparCampos() {
        tfId.setText("");
        tfNome.setText("");
        tfCargo.setText("");
        tfSenha.setText("");
    }
}

