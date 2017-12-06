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
public class eliminar_Modelo extends javax.swing.JFrame {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

    ConexionBaseDatos con = Principal.conectando;
    private Connection conexion = null;

    /**
     * Creates new form eliminar_Marca
     */
    public eliminar_Modelo() {
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
        
        Cargar_tablaeliminar();
        

    }

    public void crearConexionGeneralEliminar() {
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
    
    
    
     public void Cargar_tablaeliminar() {
        
        ArrayList<String> id_marca = null;
        ArrayList<String> marca = null;
        crearConexionGeneralEliminar();
        
        try {
            id_marca = new <String>ArrayList();
            marca = new <String>ArrayList();
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_modelo, nombre_modelo FROM modelo ORDER BY nombre_modelo ASC");
            
            while (rs.next()) {
                id_marca.add(rs.getString("id_modelo"));
                marca.add(rs.getString("nombre_modelo"));
                
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        
        for (int i = 0; i < id_marca.size(); i++) {
            Eliminar_marca.setValueAt(id_marca.get(i), i, 0);
            Eliminar_marca.setValueAt(marca.get(i), i, 1);
            
            if (id_marca.size() >= Eliminar_marca.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Eliminar_marca.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }
            
        }
        if (Eliminar_marca.getRowCount() > id_marca.size()) {
            
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
                   crearConexionGeneralEliminar();
                    try {
                        
                        s = connection.createStatement();
                        int z = s.executeUpdate("DELETE FROM modelo WHERE id_modelo = '" + strResultado + "'");
                        if (z == 1) {
                            JOptionPane.showMessageDialog(null, "Se eliminó el registro de manera exitosa");
                            Cargar_tablaeliminar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                        }
                    } catch (Exception e) {
                        System.out.println("Error de conexión"+e);
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
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código Modelo", "Modelo"
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(eliminar_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(eliminar_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(eliminar_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eliminar_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eliminar_Modelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Eliminar_marca;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
