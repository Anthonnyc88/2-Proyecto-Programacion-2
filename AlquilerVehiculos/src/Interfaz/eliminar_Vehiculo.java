/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Datos.ConexionBaseDatos;
import Proyecto.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Anthonny
 */
public class eliminar_Vehiculo extends javax.swing.JFrame {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

    ConexionBaseDatos con = Principal.conectando;
    private Connection conexion = null;

    /**
     * Creates new form eliminar_Marca
     */
    public eliminar_Vehiculo() {
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

        Cargar_tabla_eliminar();

    }

    public void crearConexionGeneralEliminarAnthonny() {
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

    public void crearConexionGeneralEliminarRoger() {
        if (connection != null) {
            return;
        }

        String nombreBaseDatos = "renta_vehiculos";//aqui va el nombre de la base de datos 
        String url = "jdbc:postgresql://localhost:5432/" + nombreBaseDatos;//este es el nombre de la base de datos
        String password = "Saborio17";//esta es la contraseña del postgrade deñ usuario
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
    
    public void Cargar_tabla_eliminar() {

        ArrayList<String> id_placa = null;
        ArrayList<String> marca = null;
        ArrayList<String> modelo = null;
        ArrayList<String> estilo = null;
        ArrayList<String> transmision = null;
        ArrayList<String> año = null;
        ArrayList<String> precio = null;
        ArrayList<String> estado = null;

        crearConexionGeneralEliminarAnthonny();
        //crearConexionGeneralEliminarRoger();
        
        try {
            id_placa = new <String>ArrayList();
            marca = new <String>ArrayList();
            modelo = new <String>ArrayList();
            estilo = new <String>ArrayList();
            transmision = new <String>ArrayList();
            año = new <String>ArrayList();
            precio = new <String>ArrayList();
            estado = new <String>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT placa, marca, modelo, estilo, transmision, año, precio , estado FROM vehiculo ORDER BY marca ASC");

            while (rs.next()) {
                id_placa.add(rs.getString("placa"));
                marca.add(rs.getString("marca"));
                modelo.add(rs.getString("modelo"));
                estilo.add(rs.getString("estilo"));
                transmision.add(rs.getString("transmision"));
                año.add(rs.getString("año"));
                precio.add(rs.getString("precio"));
                estado.add(rs.getString("estado"));

            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }

        for (int i = 0; i < id_placa.size(); i++) {
            Eliminar_marca.setValueAt(id_placa.get(i), i, 0);
            Eliminar_marca.setValueAt(marca.get(i), i, 1);
            Eliminar_marca.setValueAt(modelo.get(i), i, 2);
            Eliminar_marca.setValueAt(estilo.get(i), i, 3);
            Eliminar_marca.setValueAt(transmision.get(i), i, 4);
            Eliminar_marca.setValueAt(año.get(i), i, 5);
            Eliminar_marca.setValueAt(precio.get(i), i, 6);
            Eliminar_marca.setValueAt(estado.get(i), i, 7);

            if (id_placa.size() >= Eliminar_marca.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Eliminar_marca.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (Eliminar_marca.getRowCount() > id_placa.size()) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) Eliminar_marca.getModel();
                Eliminar_marca.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

    }

    public void Eliminar_marca() {

        TableModel tablaModelo;
        tablaModelo = (TableModel) Eliminar_marca.getModel();
        boolean avanzar = true;
        int registro = Eliminar_marca.getSelectedRow();
        int columna = Eliminar_marca.getSelectedColumn();

        if (registro == -1) {

            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }

        if (avanzar) {
            try {
                String strResultado = tablaModelo.getValueAt(Eliminar_marca.getSelectedRow(), 0).toString();
                int opcion = JOptionPane.showConfirmDialog(null, "Eliminar : " + strResultado);
                if (opcion == 0) {
                    crearConexionGeneralEliminarAnthonny();
                    //crearConexionGeneralEliminarRoger();
                    try {

                        s = connection.createStatement();
                        int z = s.executeUpdate("DELETE FROM vehiculo WHERE placa = '" + strResultado + "'");
                        if (z == 1) {
                            JOptionPane.showMessageDialog(null, "Se eliminó el registro de manera exitosa");
                            Cargar_tabla_eliminar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                        }
                    } catch (Exception e) {
                        System.out.println("Error de conexión" + e);
                    }
                }
            } catch (java.lang.NullPointerException e) {
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un registro");

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Eliminar_marca = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Eliminar_marca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Placa", "Marca", "Modelo", "Estilo", "Transmision", "Año", "Precio", "estado"
            }
        ));
        Eliminar_marca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Eliminar_marcaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Eliminar_marca);

        jButton1.setText("Regresar menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Eliminar_marcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Eliminar_marcaMouseClicked
        Eliminar_marca();
    }//GEN-LAST:event_Eliminar_marcaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menu_Admnistrador regresar = new Menu_Admnistrador();
        regresar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(eliminar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(eliminar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(eliminar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eliminar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eliminar_Vehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Eliminar_marca;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
