import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PacienteView {
    private JFrame frame;
    private JTextField tfNome, tfCpf, tfEndereco, tfTelefone;
    private PacienteController pacienteController;

    public PacienteView(PacienteController pacienteController) {
        this.pacienteController = pacienteController;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Gerenciar Pacientes");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        JLabel lblCpf = new JLabel("CPF:");
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblEndereco = new JLabel("Endereço:");
        JLabel lblTelefone = new JLabel("Telefone:");

        tfCpf = new JTextField();
        tfNome = new JTextField();
        tfEndereco = new JTextField();
        tfTelefone = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarPaciente();
            }
        });

        frame.add(lblCpf);
        frame.add(tfCpf);
        frame.add(lblNome);
        frame.add(tfNome);
        frame.add(lblEndereco);
        frame.add(tfEndereco);
        frame.add(lblTelefone);
        frame.add(tfTelefone);
        frame.add(btnSalvar);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void salvarPaciente() {
        String cpf = tfCpf.getText();
        String nome = tfNome.getText();
        String endereco = tfEndereco.getText();
        String telefone = tfTelefone.getText();

        Paciente paciente = new Paciente(cpf, nome, endereco, telefone);
        pacienteController.adicionarPaciente(paciente);
        JOptionPane.showMessageDialog(frame, "Paciente salvo com sucesso!");
        limparCampos();
    }

    private void limparCampos() {
        tfCpf.setText("");
        tfNome.setText("");
        tfEndereco.setText("");
        tfTelefone.setText("");
    }
}
