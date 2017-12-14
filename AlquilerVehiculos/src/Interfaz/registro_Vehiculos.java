/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Datos.ConexionBaseDatos;
import Proyecto.Principal;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Procesos.Marca;
import Procesos.Estilo;
import Procesos.Modelo;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import Procesos.Vehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthonny
 */
public class registro_Vehiculos extends javax.swing.JFrame {

    FileInputStream fis;
    int longitudBytes;
    //ConexionBaseDatos conectando = new ConexionBaseDatos();
    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;
    ConexionBaseDatos conectar = Principal.conectando;

    /**
     * Creates new form Registro_Vehiculos
     */
    public registro_Vehiculos() {
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
        mostrarMarca();
        mostrarModelo();
        mostrarEstilo();
    }

    public void crearConexionAnthonny() {
        if (connection != null) {
            return;
        }

        String url = "jdbc:postgresql://localhost:5432/renta_vehiculos";
        String password = "1414250816ma";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "postgres", password);
            if (connection != null) {
                System.out.println("Connecting to database...");
            }
        } catch (Exception e) {
            System.out.println("Problem when connecting to the database..."+e);
        }
    }
    
    

    public void crearConexionRoger() {
        if (connection != null) {
            return;
        }

        String url = "jdbc:postgresql://localhost:5432/renta_vehiculos";
        String password = "Saborio17";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "postgres", password);
            if (connection != null) {
                System.out.println("Connecting to database...");
            }
        } catch (Exception e) {
            System.out.println("Problem when connecting to the database..."+e);
        }
    }
    
    public void conexionParaLoginRoger() {
        if (connection != null) {
            return;
        }
    }

    public void mostrarMarca() {
        crearConexionAnthonny();
        //crearConexionRoger();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre_marca FROM marca");

            while (rs.next()) {
                comboMarcas.addItem(rs.getString("nombre_marca"));
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
    }

    }

    public int id_Marca() {
        int id_materia = 0;
        String nombre = comboMarcas.getSelectedItem().toString();
        crearConexionAnthonny();
        //crearConexionRoger();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_marca FROM marca WHERE nombre_marca = '" + nombre + "'");

            while (rs.next()) {
                id_materia = rs.getInt("id_marca");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
        return id_materia;

    }

    public void mostrarModelo() {
        crearConexionAnthonny();
        //crearConexionRoger();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre_modelo FROM modelo");

            while (rs.next()) {
                ComboModelo.addItem(rs.getString("nombre_modelo"));
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

    }

    public int id_Modelo() {
        int id_materia = 0;
        String nombre = ComboModelo.getSelectedItem().toString();
        crearConexionAnthonny();
        //crearConexionRoger();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_modelo FROM modelo WHERE nombre_modelo = '" + nombre + "'");

            while (rs.next()) {
                id_materia = rs.getInt("id_modelo");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
        return id_materia;

    }

    public void mostrarEstilo() {
        crearConexionAnthonny();
        //crearConexionRoger();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre_estilo FROM estilo");

            while (rs.next()) {
                ComboEstilos.addItem(rs.getString("nombre_estilo"));
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

    }

    public int id_Estilo() {
        int id_materia = 0;
        String nombre = ComboEstilos.getSelectedItem().toString();
        crearConexionAnthonny();
        //crearConexionRoger();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_estilo FROM estilo WHERE nombre_estilo = '" + nombre + "'");

            while (rs.next()) {
                id_materia = rs.getInt("id_estilo");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
        return id_materia;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TextPlaca = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ComboModelo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        ComboEstilos = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        ComboTransmision = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ComboEstado = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        bntRegistrar = new javax.swing.JButton();
        bntRegresar = new javax.swing.JButton();
        lblfotos = new javax.swing.JLabel();
        btnAgregarImagen = new javax.swing.JButton();
        comboMarcas = new javax.swing.JComboBox();
        textAño = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cedula");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro de Vehiculos");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Modelo");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Marca");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Placa");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Año");

        ComboModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboModeloActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Estilo");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Transmisiòn");

        ComboTransmision.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manual", "Automatica" }));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Precio");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Estado");

        ComboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponible", "Ocupado" }));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Foto");

        bntRegistrar.setText("Registrar");
        bntRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRegistrarActionPerformed(evt);
            }
        });

        bntRegresar.setText("Regresar");
        bntRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRegresarActionPerformed(evt);
            }
        });

        lblfotos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnAgregarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_Foto.png"))); // NOI18N
        btnAgregarImagen.setText("Imagen");
        btnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagenActionPerformed(evt);
            }
        });

        comboMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMarcasActionPerformed(evt);
            }
        });

        jMenu1.setText("Opciones");

        jMenuItem1.setText("Eliminar Vehiculo");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Modificar Vehiculo");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel11))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(bntRegresar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(bntRegistrar)
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboEstilos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboModelo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboMarcas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textAño)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel16)))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblfotos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarImagen)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addGap(37, 37, 37)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(ComboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(ComboEstilos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblfotos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addComponent(jLabel15))
                        .addGap(70, 70, 70)
                        .addComponent(bntRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(ComboTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(ComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntRegresar)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        lblfotos.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lblfotos.getWidth(), lblfotos.getHeight(), Image.SCALE_DEFAULT);
                    lblfotos.setIcon(new ImageIcon(icono));
                    lblfotos.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarImagenActionPerformed

    private void bntRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRegresarActionPerformed
        // TODO add your handling code here:

        Menu_Admnistrador ventanaRegresar = new Menu_Admnistrador();
        ventanaRegresar.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bntRegresarActionPerformed

    private void bntRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRegistrarActionPerformed

        try {
            int placa = Integer.parseInt(TextPlaca.getText());
            String transmisiones = ComboTransmision.getSelectedItem().toString();
            int años = Integer.parseInt(textAño.getText());
            double precio = Double.parseDouble(textPrecio.getText());
            String estado = ComboEstado.getSelectedItem().toString();

            Statement s = connection.createStatement();
            String sql = "INSERT INTO vehiculo (placa, marca, modelo, estilo, transmision, año, precio, estado, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conectar.getConexion().prepareStatement(sql);

            ps.setInt(1, placa);
            ps.setInt(2, id_Marca());
            ps.setInt(3, id_Modelo());
            ps.setInt(4, id_Estilo());
            ps.setString(5, transmisiones);
            ps.setInt(6, años);
            ps.setDouble(7, precio);
            ps.setString(8, estado);
            ps.setBinaryStream(9, fis, longitudBytes);
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(rootPane, " Vehiculo Registrado correctamente");
            lblfotos.setIcon(null);
            TextPlaca.setText("");
            textAño.setText("");
            textPrecio.setText("");

//
        } catch (SQLException | NumberFormatException | HeadlessException x) {
            JOptionPane.showMessageDialog(rootPane, "exception 2 " + x);

        }
    }//GEN-LAST:event_bntRegistrarActionPerformed

    private void ComboModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboModeloActionPerformed

    private void comboMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMarcasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMarcasActionPerformed

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
            java.util.logging.Logger.getLogger(registro_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registro_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registro_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registro_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registro_Vehiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboEstado;
    private javax.swing.JComboBox ComboEstilos;
    private javax.swing.JComboBox ComboModelo;
    private javax.swing.JComboBox ComboTransmision;
    private javax.swing.JTextField TextPlaca;
    private javax.swing.JButton bntRegistrar;
    private javax.swing.JButton bntRegresar;
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JComboBox comboMarcas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblfotos;
    private javax.swing.JTextField textAño;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables
}
