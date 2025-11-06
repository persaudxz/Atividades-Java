import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroForm extends JFrame {
    private JLabel lblNome, lblIdade, lblSexo, lblResultado;
    private JTextField txtNome;
    private JSpinner spnIdade;
    private JRadioButton rdbMasculino, rdbFeminino;
    private JButton btnEnviar;
    private ButtonGroup grupoSexo;

    public CadastroForm() {
        super("Cadastro de Cliente");
        setLayout(new GridLayout(6, 2, 5, 5));

        lblNome = new JLabel("Nome:");
        lblIdade = new JLabel("Idade:");
        lblSexo = new JLabel("Sexo:");
        lblResultado = new JLabel("Preencha o formulário e clique em Enviar.");

        txtNome = new JTextField();
        spnIdade = new JSpinner(new SpinnerNumberModel(18, 0, 120, 1));
        rdbMasculino = new JRadioButton("Masculino");
        rdbFeminino = new JRadioButton("Feminino");

        grupoSexo = new ButtonGroup();
        grupoSexo.add(rdbMasculino);
        grupoSexo.add(rdbFeminino);

        btnEnviar = new JButton("Enviar");

        add(lblNome);
        add(txtNome);
        add(lblIdade);
        add(spnIdade);
        add(lblSexo);
        add(rdbMasculino);
        add(new JLabel()); // espaço
        add(rdbFeminino);
        add(new JLabel());
        add(btnEnviar);
        add(new JLabel());
        add(lblResultado);

        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enviarDados();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void enviarDados() {
        String nome = txtNome.getText().trim();
        int idade = (Integer) spnIdade.getValue();
        String sexo = "";

        if (rdbMasculino.isSelected()) sexo = "Masculino";
        else if (rdbFeminino.isSelected()) sexo = "Feminino";

        if (nome.isEmpty() || sexo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(nome, idade, sexo);
        lblResultado.setText(cliente.getResumo());
    }

    public static void main(String[] args) {
        new CadastroForm();
    }
}
