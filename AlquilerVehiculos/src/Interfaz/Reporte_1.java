/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Procesos.Reporte_uno;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Anthonny
 */
public class Reporte_1 extends javax.swing.JFrame {
    int prueba=0;
    Reporte_uno imprimir= new Reporte_uno();
     private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;
            

    /**
     * Creates new form Reporte_1
     */
    public Reporte_1() {
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

    
      public String informacion() {
        crearConexionGeneralAnthonny();
         SimpleDateFormat formato2 = new SimpleDateFormat("yyyy/MM/dd");
        String fecha_ini = formato2.format(Fecha_ini.getDate());
        String fecha_fin = formato2.format(Fecha_fin.getDate());
//        ArrayList<String> placa = null;
//        ArrayList<String> id_usuario = null;
//         ArrayList<String> nombre_usuario = null;
//        ArrayList<String> fecha_retiro = null;
//        ArrayList<String> fecha_devolucion = null;
//        placa = new <String>ArrayList();
//        id_usuario = new <String>ArrayList();
//        nombre_usuario = new <String>ArrayList();
//        fecha_retiro = new <String>ArrayList();
//        fecha_devolucion = new <String>ArrayList();
//        ArrayList<String> fecha_alqui = new ArrayList();
//        ArrayList<String> fecha_devo = new ArrayList();
//        ArrayList<String> Info = new ArrayList<String>();
//        String info2 = "";
        
        ArrayList<String> Info = new ArrayList<String>();
        ArrayList<String> placa = new ArrayList();
        ArrayList<String> cedula = new ArrayList();
        ArrayList<String> nombre = new ArrayList();
        ArrayList<String> fecha_alqui = new ArrayList();
        ArrayList<String> fecha_devo = new ArrayList();
        String info2 = "";

        try {

           
            s = connection.createStatement();
            rs = s.executeQuery("SELECT placa_vehiculo, id_usuario, nombre_usuario, fecha_retiro, fecha_devolucion FROM alquiler_vehiculos \n " +
                       "WHERE alquiler_vehiculos.fecha_retiro between cast ('" + fecha_ini + "'  as Date) and cast('" + fecha_fin + "' as Date)");


            while (rs.next()) {
                placa.add(rs.getString("placa_vehiculo"));
                cedula.add(rs.getString("id_usuario"));
                nombre.add(rs.getString("nombre_usuario"));
                fecha_alqui.add(rs.getString("fecha_retiro"));
                fecha_devo.add(rs.getString("fecha_devolucion"));
             }

        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        for (int i = 0; i < placa.size(); i++) {
            Info.add("Placa Vehiculo: " + placa.get(i) + ", Cédula Cliente: " + cedula.get(i) + ", Nombre Cliente: " + nombre.get(i) + "\nFecha Retiro: " + fecha_alqui.get(i)
                    + ", Fecha Devolución: " + fecha_devo.get(i) + ".\n \n");
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
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Fecha_ini = new com.toedter.calendar.JDateChooser();
        Fecha_fin = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Imprimir los vehículos registrados de acuerdo con el estado. Se debe escoger entre disponible u ocupado. La información que se muestra es: placa, marca, modelo y estilo.");

        jButton2.setText("Imprimir Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel2.setText("Fecha Inicio");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel3.setText("Fecha Fin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jButton1)))
                .addContainerGap(241, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Fecha_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(87, 87, 87)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(114, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(53, 53, 53))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(146, 146, 146)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Fecha_ini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(Fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(154, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Reportes ventanaRegresar = new Reportes();
        ventanaRegresar.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (Fecha_ini.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese la Fecha de Inicio!");
        } else if (Fecha_fin.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese la Fecha de Fin!");
        } else {
         prueba += 1;
        try {
            imprimir.creando_PDF_Reporte2("Reporte 1", informacion(), "Desarolladores Anthonny Calderon Y Roger Oporta RENT A CAR",
                    "C:\\Users\\Anthonny\\Desktop\\ProyectoRentCar-master-d006d3472d05d71be0688cbd822eeec2c14572f6\\ProyectoRentCar\\ProyectoRentCar\\AlquilerVehiculos/" + "Reporte 1 " + prueba + ".pdf");
            String file = new String("Reporte 1 " + prueba + ".pdf");
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            Logger.getLogger(Reporte_1.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("" + ex);
        }
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
            java.util.logging.Logger.getLogger(Reporte_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static com.toedter.calendar.JDateChooser Fecha_fin;
    public static com.toedter.calendar.JDateChooser Fecha_ini;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
