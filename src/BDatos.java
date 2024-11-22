import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class BDatos {


    ArrayList DatoAeropuerto = new ArrayList();
    DefaultListModel ModeloAero = new DefaultListModel();

    ArrayList DatoCompania = new ArrayList();
    DefaultListModel  ModeloCompani = new DefaultListModel();

    ArrayList DatoVuelo = new ArrayList();
    DefaultListModel  ModeloV = new DefaultListModel();


    static String url = "jdbc:mysql://82.197.82.62:3306/u984447967_op2024b";
    static String user = "u984447967_unipaz";
    static String pass = "estudiantesPoo2024B.*";

    public static Connection BDdat()
    {
        Connection BDdat=null;
        try
        {
            BDdat= DriverManager.getConnection(url,user,pass);
            System.out.println("Conexión exitosa");
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

        return BDdat;

    }
    public boolean Registro( int idPasajero, String nombrepasajero, String pasaportePa, String nacionalidad){
        String Registro = "INSERT INTO  u984447967_op2024b.pasajeros (idPasajero, nombre, pasaporte, nacionalidad) VALUES (?,?,?,?)";
        try {
            Connection BDdata= BDdat();
            PreparedStatement ps = BDdata.prepareStatement(Registro);;
            ps.setInt(1, idPasajero);
            ps.setString(2, nombrepasajero);
            ps.setString(3, pasaportePa);
            ps.setString(4, nacionalidad);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario registrado");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario " + e.getMessage());
            e.printStackTrace();
            return false;
        }


    }

    public InterfazPrincipal MostrarAeropuerispo(){
        String Aeropuerto = "SELECT * FROM u984447967_op2024b.aeropuertos LIMIT 15";
        try {
            Connection BDdata= BDdat();
            PreparedStatement ps = BDdata.prepareStatement(Aeropuerto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idAeropuerto");
                String nombre = rs.getString("nombre");
                String ciudad = rs.getString("ciudad");
                String pais = rs.getString("pais");
                int privado = rs.getInt("privado");
                int publico = rs.getInt("publico");
                int subvencion = rs.getInt("subvencion");
                if(privado == 1){
                    DatoAeropuerto.add("Aeropuerto Privado: " + "ID" + id + " " + nombre +  "Ubicado en: " + pais + " / " +
                            ciudad + " " );
                }else if (publico == 1){
                    DatoAeropuerto.add("Aeropuerto Publico: " + "ID" + id + " " + nombre +" " +"Ubicado en: " + pais + " / " +
                            ciudad + " " + subvencion );
                }

            }

            for (int i = 0; i < DatoAeropuerto.size() ; i++) {
                ModeloAero.addElement(DatoAeropuerto.get(i));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Aeropuertos " + e.getMessage());
            e.printStackTrace();

        }
        return null;
    }

    public InterfazPrincipal MostrarCompaniDispo(){
        String Compa = "SELECT * FROM u984447967_op2024b.companias LIMIT 10";
        try {
            Connection BDdata= BDdat();
            PreparedStatement ps = BDdata.prepareStatement(Compa);
            ModeloCompani.removeAllElements();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idCompania");
                String nombre = rs.getString("nombre");
                DatoCompania.add("ID: " +id +" Compañias: " + nombre);
            }
            for (int i = 0; i <DatoCompania.size() ; i++) {
                ModeloCompani.addElement(DatoCompania.get(i));
            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar las Compañias " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public InterfazPrincipal MostrarVuelDispo(){
        String VueloDispo = "SELECT * FROM u984447967_op2024b.vuelos LIMIT 8";
        try {
            Connection BDdata= BDdat();
            PreparedStatement ps = BDdata.prepareStatement(VueloDispo);
            ModeloV.removeAllElements();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idVuelo");
                String identificador = rs.getString("identificador");
                String ciudadOrigen = rs.getString("ciudadOrigen");
                String ciudadDestino = rs.getString("ciudadDestino");
                String precio = rs.getString("precio");
                String numMaxPasajero = rs.getString("numMaxPasajeros");
                DatoVuelo.add("ID" + id + " Identificador: " + identificador + " " + " Ciudad Origen: " + ciudadOrigen +
                        " " + " Ciudad Destino: " + ciudadDestino + " " + " Precio : " + precio + " " +
                        " Numero Maximo de Pasajeros: " + numMaxPasajero);
            }
            for (int i = 0; i <DatoVuelo.size() ; i++) {
                ModeloV.addElement(DatoVuelo.get(i));
            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar Vuelos " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


}
