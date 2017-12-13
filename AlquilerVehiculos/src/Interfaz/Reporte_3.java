/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Procesos.Reporte_tres;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Anthonny
 */
public class Reporte_3 extends javax.swing.JFrame {
    int prueba = 0;
    Reporte_tres imprimir = new Reporte_tres();
    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

    /**
     * Creates new form Reporte_3
     */
    public Reporte_3() {
        initComponents();
         setLocationRelativeTo(null);
        setResizable(false);
        setTitle("TIENDA DE VEHICULOS   ");
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Azul.jpg")).getImage());

        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Imagenes/Azul.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());

    }
    
    public void crearConexionGeneralAnthonny() {
        if (connection != null) {
            return;
        }

        String nombreBaseDatos = "renta_vehiculos";//aqui va el nombre de la base de datos 
        String url = "jdbc:postgresql://localhost:5432/" + nombreBaseDatos;//este es el nombre de la base de datos
        String password = "1414250816ma";//esta es la contraseña del postgrade deñ usuario
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "postgres", password);//este es el nombre sel server
            if (connection != null) {
                System.out.println("Connecting to database... Base Datos Conectada " + nombreBaseDatos);
            }
        } catch (Exception e) {
            System.out.println("Problem when connecting to the database... No se Puede conectar la Base Datos " + nombreBaseDatos);
        }
    }
    
  
     
  public String Info() {

        ArrayList Info = new ArrayList();
        ArrayList<String> placa = null;
        ArrayList<String> marca = null;
        ArrayList<String> modelo = null;
        ArrayList<String> estilo = null;
        ArrayList<String> trans = null;
        ArrayList<String> año = null;
        ArrayList<String> precio = null;
        ArrayList<String> estado = null;

        ArrayList<String> cedula = null;
        ArrayList<String> nombre = null;
        ArrayList<String> telefono = null;
        ArrayList<String> dire = null;
        ArrayList<String> tipo = null;

        String info2 = "";

       crearConexionGeneralAnthonny();
        try {
            placa = new <String>ArrayList();
            marca = new <String>ArrayList();
            modelo = new <String>ArrayList();
            estilo = new <String>ArrayList();
            trans = new <String>ArrayList();
            año = new <String>ArrayList();
            precio = new <String>ArrayList();
            estado = new <String>ArrayList();

            cedula = new <String>ArrayList();
            nombre = new <String>ArrayList();
            telefono = new <String>ArrayList();
            dire = new <String>ArrayList();
            tipo = new <String>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT us.cedula, us.nombre, us.telefono ,us.direccion, us.tipo, vehiculo.placa,  marcas.nombre AS marca,modelo.nombre AS modelo,estilo.nombre AS estilo,vehiculo.transmision,\n"
                    + "vehiculo.año, vehiculo.precio, vehiculo.estado, FROM usuario as us\n"
                    + "INNER JOIN alquiler_vehiculo on alquiler_vehiculo.cedula = us.cedula\n"
                    + "INNER JOIN vehiculo on vehiculo.placa = alquiler.placa\n"
                    + "INNER JOIN marcas on marcas.id_marca = vehiculo.id_marca \n"
                    + "INNER JOIN modelo on modelo.id_modelo = vehiculo.id_modelo \n"
                    + "INNER JOIN estilo on estilo.id_estilo = vehiculo.id_estilo\n"
                    + "WHERE vehiculo.estado = 'Ocupado' GROUP BY us.cedula, vehiculo.placa, marcas.nombre,modelo.nombre,estilo.nombre;");

            while (rs.next()) {

                placa.add(rs.getString("placa"));
                marca.add(rs.getString("marca"));
                modelo.add(rs.getString("modelo"));
                estilo.add(rs.getString("estilo"));
                trans.add(rs.getString("transmision"));
                año.add(rs.getString("año"));
                precio.add(rs.getString("precio"));
                estado.add(rs.getString("estado"));
                cedula.add(rs.getString("cedula"));
                nombre.add(rs.getString("nombre"));
                telefono.add(rs.getString("telefono"));
                tipo.add(rs.getString("tipo"));
                dire.add(rs.getString("direccion"));

            }

        } catch (SQLException e) {
            System.out.println("Error de conexión" + e);
        }
        for (int i = 0; i < placa.size(); i++) {

            Info.add("Placa Vehiculo: " + placa.get(i) + ", Marca Vehiculo: " + marca.get(i) + ", Modelo Vehiculo: " + modelo.get(i) + "\nEstilo Vehiculo: " + estilo.get(i)
                    + ", Transmisión: " + trans.get(i) + ", Año: " + año.get(i) + ", Precio: " + precio.get(i) + ", Estado: " + estado.get(i) + "\n"
                    + "Cédula: " + cedula.get(i) + ", Nombre: " + nombre.get(i) + ", Teléfono: " + telefono.get(i) + " Dirección: " + dire.get(i)
                    + ", Tipo: " + tipo.get(i) + ".\n \n");
            info2 += Info.get(i);
        }

        return info2;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Imprimir Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButton1))
                    .addComponent(jButton2))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Reportes r = new Reportes();
        r.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         prueba += 1;
        try {
            imprimir.creando_PDF_Reporte3("Reporte 3", Info(), "Desarolladores Anthonny Calderon Y Roger Oporta RENT A CAR",
                    "C:\\Users\\Anthonny\\Desktop\\ProyectoRentCar-master-d006d3472d05d71be0688cbd822eeec2c14572f6\\ProyectoRentCar\\ProyectoRentCar\\AlquilerVehiculos/" + "Reporte 2 " + prueba + ".pdf");
            String file = new String("Reporte 2 " + prueba + ".pdf");
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            Logger.getLogger(Reporte_1.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("" + ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reporte_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte_3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
