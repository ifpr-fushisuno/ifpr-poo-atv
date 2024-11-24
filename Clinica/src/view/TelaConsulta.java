package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dao.ConsultaDAO;
import dao.ExceptionDAO;
import model.Paciente;
import model.Profissional;
import model.Consulta;
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

        // Métodos para que os botões chamem as funcionalidades
        btnCadastrar.addActionListener(e -> cadastrarConsulta());
        btnConsultar.addActionListener(e -> consultarConsulta());
        btnAlterar.addActionListener(e -> alterarConsulta());
        btnExcluir.addActionListener(e -> excluirConsulta());

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

    private void limparCampos() {
        txtPaciente.setText("");
        txtData.setText("");
        txtHora.setText("");
        cmbStatus.setSelectedIndex(0);
    }

    private void cadastrarConsulta() {
        try {
            // Pega os dados
            String pacienteCpf = txtPacienteCpf.getText();
            String pacienteNome = txtPaciente.getText();
            String dataConsultaStr = txtDataConsulta.getText();
            String horaConsultaStr = txtHoraConsulta.getText();
            
            // Pega o status
            StatusConsulta statusConsulta = (StatusConsulta) cmbStatus.getSelectedItem();

            // Valida as etradas
            if (pacienteCpf.isEmpty() || pacienteNome.isEmpty() || dataConsultaStr.isEmpty() || horaConsultaStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
                return;
            }

            // Busca o paciente por CPF
            Paciente paciente = pacienteDAO.getPacienteByCpf(pacienteCpf);
            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "Paciente não encontrado.");
                return;
            }

            // Cria o objeto LocalDateTime a partir dos dados
            Date dataConsulta = Date.valueOf(dataConsultaStr);
            Time horaConsulta = Time.valueOf(horaConsultaStr);
            LocalDateTime dataHoraConsulta = LocalDateTime.of(dataConsulta.toLocalDate(), horaConsulta.toLocalTime());

            // Acessa ou cria Paciente e Profissional
            Paciente paciente = new Paciente();
            Profissional profissional = new Profissional();

            // Cria o objeto Consulta
            Consulta novaConsulta = new Consulta(0, paciente, profissional, dataConsulta, horaConsulta, dataHoraConsulta, statusConsulta);

            // Salva a consulta
            novaConsulta.createConsulta(novaConsulta, paciente.getIdPaciente())

            // Limpa os campos depois de salvar
            limparCampos();

            JOptionPane.showMessageDialog(this, "Consulta cadastrada com sucesso!");
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar consulta: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + ex.getMessage());
        }

    }

    private void consultarConsulta() {
        try {
            String pacienteCpf = txtPacienteCpf.getText();

            if (pacienteCpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, informe o CPF do paciente.");
                return;
            }

            List<Consulta> consultas = new ConsultaDAO().getConsultasPorCpfPaciente(pacienteCpf);
            
            if (consultas == null || consultas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhuma consulta encontrada para o paciente com CPF " + pacienteCpf);
            } else {
                StringBuilder sb = new StringBuilder("Consultas encontradas:\n");
                for (Consulta c : consultas) {
                    sb.append("Data: ").append(c.getDataConsulta()).append(" Hora: ").append(c.getHoraConsulta()).append("\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString());
            }
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar consulta: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + ex.getMessage());
        }
    }

    private void alterarConsulta() {
        try {
            String pacienteCpf = txtPacienteCpf.getText();
    
            if (pacienteCpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, informe o CPF do paciente.");
                return;
            }
    
            Consulta consultaToEdit = new ConsultaDAO().getConsultaPorCpfPaciente(pacienteCpf);
    
            if (consultaToEdit != null) {
                txtData.setText(consultaToEdit.getDataConsulta().toString());
                txtHora.setText(consultaToEdit.getHoraConsulta().toString());
                cmbStatus.setSelectedItem(consultaToEdit.getStatusConsulta());
    
                StatusConsulta status = (StatusConsulta) cmbStatus.getSelectedItem();
                consultaToEdit.setDataConsulta(Date.valueOf(txtData.getText()));
                consultaToEdit.setHoraConsulta(Time.valueOf(txtHora.getText()));
                consultaToEdit.setStatusConsulta(status);
    
                consultaToEdit.updateConsulta(consultaToEdit, consultaToEdit.getProfissional().getIdProfissional());
    
                JOptionPane.showMessageDialog(this, "Consulta atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Consulta não encontrada para o CPF fornecido.");
            }
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar consulta: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + ex.getMessage());
        }
    }

    private void excluirConsulta() {
        try {
            String pacienteCpf = txtPacienteCpf.getText();
    
    
            if (pacienteCpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, insira o CPF do paciente.");
                return;
            }
    
            
            Consulta consultaToDelete = new ConsultaDAO().getConsultaPorCpfPaciente(pacienteCpf);
    
            if (consultaToDelete != null) {
                new ConsultaDAO().deleteConsulta(consultaToDelete.getIdConsulta());
    
                JOptionPane.showMessageDialog(this, "Consulta excluída com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Consulta não encontrada para o CPF fornecido.");
            }
        } catch (ExceptionDAO ex) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir consulta: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaConsulta().setVisible(true));
    }
}