import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CompaniasVuelos extends JFrame {
    private JList list1;
    private JButton CONFIRMARCOMPAÑIAButton;
    private JList list2;
    private JButton CONFIRMARVUELOButton;
    private JButton SALIRButton;
    private JPanel Vuelos;
    public static Object SeleccionC;
    public static Object SeleccionV;
    BDatos bDatos = new BDatos();

    public CompaniasVuelos() {
        setTitle("Interfaz De vuelo");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bDatos.MostrarCompaniDispo();
        list1.setModel(bDatos.ModeloCompani);
        list1.setVisible(true);

        setContentPane(Vuelos);
        CONFIRMARVUELOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 1) {
                    SeleccionV = list2.getSelectedValue();
                }
            }
        });
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 1) {
                    SeleccionC = list1.getSelectedValue();
                }
            }
        });
        CONFIRMARCOMPAÑIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SeleccionC != null){
                    list1.setSelectedValue(SeleccionC, true);
                    JOptionPane.showMessageDialog(null, "Seleccion existosa");
                    bDatos.MostrarVuelDispo();
                    list2.setModel(bDatos.ModeloV);
                    list2.setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null, "Seleccion Vacia");
                }
            }
        });
        CONFIRMARVUELOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SeleccionV != null){
                    list2.setSelectedValue(SeleccionV, true);
                    JOptionPane.showMessageDialog(null, "Seleccion existosa");
                    InterfazPrincipal interfazPrincipal = new InterfazPrincipal();
                    interfazPrincipal.setVisible(true);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Seleccion Vacia");
                }
            }
        });
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            }
        });
    }
}
