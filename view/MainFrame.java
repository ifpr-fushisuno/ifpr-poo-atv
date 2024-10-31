import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Sistema de Agendamento de Consultas");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Adicionar componentes da interface principal
        JMenuBar menuBar = new JMenuBar();
        JMenu menuAgendamentos = new JMenu("Agendamentos");
        JMenuItem itemAgenda = new JMenuItem("Agenda");
        itemAgenda.addActionListener(e -> openAgendaView());
        menuAgendamentos.add(itemAgenda);

        JMenu menuPacientes = new JMenu("Pacientes");
        JMenuItem itemPaciente = new JMenuItem("Gerenciar Pacientes");
        itemPaciente.addActionListener(e -> openPacienteView());
        menuPacientes.add(itemPaciente);

        menuBar.add(menuAgendamentos);
        menuBar.add(menuPacientes);
        setJMenuBar(menuBar);
    }

    private void openAgendaView() {
        new AgendaView(new AgendaController());
    }

    private void openPacienteView() {
        new PacienteView(new PacienteController());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
