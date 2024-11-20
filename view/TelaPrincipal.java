package view;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
// Importando a classe da TelaCadastroPessoa
import view.TelaCadastroPessoa;

public class TelaPrincipal extends JFrame {
    private static final long serialVersionUID = 5420355494474613004L;

    private JMenuBar barMenu; // Cria a barra de menus
    private JMenu cadastroMenu; // Cria o menu Cadastro
    private JMenu compraMenu; // Cria o menu Compra
    private JMenu ajudaMenu; // Cria o menu ajuda
    private JMenuItem clienteMenuItem; // Cria o item de menu cliente
    private JMenuItem fornecedorMenuItem; // Cria o item de menu fornecedor
    private JMenuItem produtoMenuItem; // Cria o item de menu produto
    private JMenuItem sobreMenuItem; // Cria o item de menu sobre
    private JMenuItem sairMenuItem; // Cria o item de menu sair

    public TelaPrincipal() {
        super("Loja IFPR");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.NORMAL);

        setLayout(new BorderLayout());

        barMenu = new JMenuBar();
        cadastroMenu = new JMenu("Cadastro");
        compraMenu = new JMenu("Compra");
        ajudaMenu = new JMenu("Ajuda");

        clienteMenuItem = new JMenuItem("Cliente");
        fornecedorMenuItem = new JMenuItem("Fornecedor");
        produtoMenuItem = new JMenuItem("Produto");
        sobreMenuItem = new JMenuItem("Sobre");
        sairMenuItem = new JMenuItem("Sair");

        cadastroMenu.setMnemonic('C'); // Configura o mnemônico como C
        compraMenu.setMnemonic('o'); // Configura o mnemônico como o
        ajudaMenu.setMnemonic('A'); // Configura o mnemônico como A

        setJMenuBar(barMenu); // Adiciona uma barra de menu na tela
        barMenu.add(cadastroMenu);
        barMenu.add(compraMenu);
        barMenu.add(ajudaMenu);

        cadastroMenu.add(clienteMenuItem);
        cadastroMenu.add(fornecedorMenuItem);
        cadastroMenu.add(produtoMenuItem);
        ajudaMenu.add(sobreMenuItem);
        ajudaMenu.add(sairMenuItem);

        // Ação para mostrar a tela de cadastro de cliente
        clienteMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama a tela de cadastro de pessoa
                new TelaCadastroPessoa();
            }
        });

        // Ação para mostrar a mensagem "Sobre"
        sobreMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent sobre) {
                JOptionPane.showMessageDialog(TelaPrincipal.this, "Este é um exemplo\n"
                        + "do uso de menus.");
            }
        });

        // Ação para sair do aplicativo
        sairMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent sair) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            telaPrincipal.setVisible(true);
        });
    }
}