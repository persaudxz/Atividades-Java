import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class PreferenciasUsuario extends JFrame {
    private JLabel lblTema, lblNotif, lblVolume;
    private JComboBox<String> cmbTema;
    private JCheckBox chkNotif;
    private JSlider sldVolume;
    private JButton btnSalvar;
    private JTextArea txtResultado;

    private String temaAtual = "Claro";

    public PreferenciasUsuario() {
        super("Configurações do Usuário");
        setLayout(new GridLayout(6, 2, 5, 5));

        lblTema = new JLabel("Tema:");
        lblNotif = new JLabel("Notificações:");
        lblVolume = new JLabel("Volume:");

        cmbTema = new JComboBox<>(new String[]{"Claro", "Escuro"});
        chkNotif = new JCheckBox("Habilitar notificações", true);
        sldVolume = new JSlider(0, 100, 50);
        sldVolume.setMajorTickSpacing(25);
        sldVolume.setPaintTicks(true);
        sldVolume.setPaintLabels(true);

        btnSalvar = new JButton("Salvar Preferências");
        txtResultado = new JTextArea(5, 20);
        txtResultado.setEditable(false);
        txtResultado.setBorder(BorderFactory.createTitledBorder("Preferências Salvas"));

        add(lblTema);
        add(cmbTema);
        add(lblNotif);
        add(chkNotif);
        add(lblVolume);
        add(sldVolume);
        add(new JLabel());
        add(btnSalvar);
        add(new JLabel());
        add(new JScrollPane(txtResultado));

        cmbTema.addActionListener(e -> alterarTema());
        btnSalvar.addActionListener(e -> salvarPreferencias());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
        aplicarTemaClaro(); // Tema inicial
        setVisible(true);
    }

    private void alterarTema() {
        temaAtual = (String) cmbTema.getSelectedItem();
        if ("Escuro".equals(temaAtual)) {
            aplicarTemaEscuro();
        } else {
            aplicarTemaClaro();
        }
    }

    private void aplicarTemaClaro() {
        getContentPane().setBackground(Color.WHITE);
        for (Component c : getContentPane().getComponents()) {
            c.setBackground(Color.WHITE);
            c.setForeground(Color.BLACK);
        }
    }

    private void aplicarTemaEscuro() {
        getContentPane().setBackground(Color.DARK_GRAY);
        for (Component c : getContentPane().getComponents()) {
            c.setBackground(Color.DARK_GRAY);
            c.setForeground(Color.WHITE);
        }
    }

    private void salvarPreferencias() {
        String tema = temaAtual;
        boolean notif = chkNotif.isSelected();
        int volume = sldVolume.getValue();

        Usuario usuario = new Usuario(tema, notif, volume);
        txtResultado.setText(usuario.getPreferencias());
    }

    public static void main(String[] args) {
        new PreferenciasUsuario();
    }
}
