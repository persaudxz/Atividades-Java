import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceSwing extends JFrame {
    private Empresa empresa;
    private JTextArea areaTexto;

    public InterfaceSwing() {
        super("Sistema de Empresa");
        empresa = new Empresa("Minha Empresa");

        setLayout(new BorderLayout());
        areaTexto = new JTextArea(15, 40);
        areaTexto.setEditable(false);

        JPanel painelBotoes = new JPanel(new GridLayout(3, 2, 10, 10));
        JButton btnAddCliente = new JButton("Adicionar Cliente");
        JButton btnAddFuncionario = new JButton("Adicionar Funcionário");
        JButton btnVerClientes = new JButton("Exibir Clientes");
        JButton btnVerFuncionarios = new JButton("Exibir Funcionários");
        JButton btnFolha = new JButton("Calcular Folha Salarial");
        JButton btnMedia = new JButton("Exibir Média Salarial");

        painelBotoes.add(btnAddCliente);
        painelBotoes.add(btnAddFuncionario);
        painelBotoes.add(btnVerClientes);
        painelBotoes.add(btnVerFuncionarios);
        painelBotoes.add(btnFolha);
        painelBotoes.add(btnMedia);

        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Ações
        btnAddCliente.addActionListener(e -> adicionarCliente());
        btnAddFuncionario.addActionListener(e -> adicionarFuncionario());
        btnVerClientes.addActionListener(e -> areaTexto.setText(empresa.exibirClientes()));
        btnVerFuncionarios.addActionListener(e -> areaTexto.setText(empresa.exibirFuncionarios()));
        btnFolha.addActionListener(e -> areaTexto.setText("Total da Folha Salarial: R$ " + empresa.calcularFolhaSalarial()));
        btnMedia.addActionListener(e -> areaTexto.setText(empresa.exibirMediaSalarial()));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionarCliente() {
        String nome = JOptionPane.showInputDialog("Nome do cliente:");
        String email = JOptionPane.showInputDialog("Email do cliente:");
        if (empresa.adicionarCliente(nome, email))
            JOptionPane.showMessageDialog(this, "Cliente adicionado com sucesso!");
        else
            JOptionPane.showMessageDialog(this, "Limite de clientes atingido!");
    }

    private void adicionarFuncionario() {
        String nome = JOptionPane.showInputDialog("Nome do funcionário:");
        String cargo = JOptionPane.showInputDialog("Cargo do funcionário:");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Salário do funcionário:"));
        if (empresa.adicionarFuncionario(nome, cargo, salario))
            JOptionPane.showMessageDialog(this, "Funcionário adicionado com sucesso!");
        else
            JOptionPane.showMessageDialog(this, "Limite de funcionários atingido!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfaceSwing::new);
    }
}
