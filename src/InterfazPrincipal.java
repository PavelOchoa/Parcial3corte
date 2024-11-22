import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfazPrincipal extends JFrame {
    private JTextField NomUsu;
    private JButton VALIDARDATOSButton;
    private JList AeropuertosBD;
    private JButton CONTINUARButton;
    private JButton SALIRButton;
    private JPanel Datos;
    private JTextField IDuni;
    private JTextField NaciUsu;
    private JTextField PasaUsu;
    public static Object SeleccionA;

    BDatos bDatos = new BDatos();
    public InterfazPrincipal() {

        setTitle("Interfaz principal");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setContentPane(Datos);
        VALIDARDATOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             bDatos.Registro(Integer.parseInt(IDuni.getText()), NomUsu.getText(),NaciUsu.getText(),PasaUsu.getText());
                bDatos.MostrarAeropuerispo();
                AeropuertosBD.setModel(bDatos.ModeloAero);
                AeropuertosBD.setVisible(true);

            }
        });

        CONTINUARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SeleccionA != null){
                    AeropuertosBD.setSelectedValue(SeleccionA, true);
                    CompaniasVuelos companias = new CompaniasVuelos();
                    companias.setVisible(true);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Seleccione un Aeropuerto");
                }

            }
        });
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        AeropuertosBD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 1) {
                    SeleccionA = AeropuertosBD.getSelectedValue();
                }
            }
        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfazPrincipal frame = new InterfazPrincipal();
                frame.setVisible(true);
            }
        });

    }
}
