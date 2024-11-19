package view;

import javax.swing.*;

import controller.AgendaController;
import model.Consulta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AgendaView {
    private JFrame frame;
    private JTable tabelaConsultas;
    private AgendaController agendaController;

    public AgendaView(AgendaController agendaController) {
        this.agendaController = agendaController;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Gerenciar Agenda de Consultas");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JButton btnListar = new JButton("Listar Consultas");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listarConsultas();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        
        JPanel painel = new JPanel();
        painel.add(btnListar);
        frame.add(painel, BorderLayout.NORTH);
        
        // Adicionar a tabela para exibir as consultas
        tabelaConsultas = new JTable();
        frame.add(new JScrollPane(tabelaConsultas), BorderLayout.CENTER);
        
        frame.setVisible(true);
    }

    private void listarConsultas() throws Exception {
        List<Consulta> consultas = agendaController.listarConsultas();
        // Atualize a tabela com as consultas aqui (você pode usar algum modelo de tabela para exibir os dados)
    }
}
