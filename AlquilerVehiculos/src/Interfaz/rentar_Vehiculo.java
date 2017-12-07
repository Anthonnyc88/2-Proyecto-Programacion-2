/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import Datos.ConexionBaseDatos;
import javax.swing.JOptionPane;
import Procesos.InformacionAlquiler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Anthonny
 */
public class rentar_Vehiculo extends javax.swing.JFrame {

    ConexionBaseDatos conectando = new ConexionBaseDatos();
    InformacionAlquiler informacionAlquiler = new InformacionAlquiler();
    
    //atributos del objeto alquiler
    String placa;
    String idUsuario;
    String nombreUsuario;
    int oficinaRetiro;
    int oficinaDevolucion;
    String fechaRetiro;
    int horaRetiro;
    String fechaDevolucion;
    int horaDevolucion;
    double precioAlquiler;
    
    int diasAlquiler;
    
    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;
    
    /**
     * Creates new form rentar_Vehiculo
     */
    public rentar_Vehiculo() {
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
        llenarPlacas();
        llenarOficinasDevolucion();
        llenarOficinasRetiro();
        
    }
    
    public void conexionRoger() {
        if (connection != null) {
            return;
        }

        String nombreBaseDatos="renta_vehiculos";//aqui va el nombre de la base de datos 
        String url = "jdbc:postgresql://localhost:5433/"+nombreBaseDatos;//este es el nombre de la base de datos
        String password = "Saborio17";//esta es la contraseña del postgrade deñ usuario
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,"postgres", password);//este es el nombre sel server
            if (connection != null) {
                System.out.println("Connecting to database... Base Datos Conectada "+nombreBaseDatos);
            }
        } catch (Exception e) {
            System.out.println("Problem when connecting to the database... No se Puede conectar la Base Datos "+nombreBaseDatos);
        }
    }
    
    /**
     * Metodo que retorna la cantidad
     * de dias que se va a alquilar un 
     * vehiculo
     * 
     * @param fechaRetiro 1 fecha
     * @param fechaDevolucion 2 fecha
     * @return la cantidad de dias
     * @throws ParseException 
     */
    public int diasAlquiler(String fechaRetiro , String fechaDevolucion) throws ParseException{
    
        int diasTotales=0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        Date fechaInicial=dateFormat.parse(fechaRetiro);//la fecha inicial 
	Date fechaFinal=dateFormat.parse(fechaDevolucion);//la fecha final
 
	diasTotales=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);//Se hace la operacion
 
	System.out.println("Hay "+diasTotales+" dias de diferencia");
        
        return  diasTotales;
    }
    
    /**
     * Metodo que retorna el precio por dia
     * de un vehiculo en base a una placa dada
     * @param placa vehiculo
     * @return  el precio de alquiler por dia
     */
    public double obtenerPrecioAlquiler(String placa){
    
    conexionRoger();
    double precioDia=0;

     try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM vehiculo WHERE placa='"+placa+"'");

            while (rs.next()) {
                precioDia = Double.parseDouble(rs.getString("precio"));
            }
        } catch (Exception e) {
            System.out.println("Error de conexión "+e);
        }
    
    
    return precioDia;
} 
    
    public ArrayList<String> obtenerVehiculos() {
        ArrayList<String> listaVehiculos = new ArrayList();

        //conectando.crearConexionGeneral();
        conexionRoger();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM vehiculo");

            while (rs.next()) {
                String placas = rs.getString("placa");
                listaVehiculos.add(placas);
                
          
            }
        } catch (Exception e) {
            System.out.println("Error de conexión "+e);
        }

        return listaVehiculos;
    }
    
     public void llenarPlacas() {

        for (int i = 0; i < obtenerVehiculos().size(); i++) {
         
            optsPlacasVehiculos.addItem(obtenerVehiculos().get(i).toString());
        }

    }
     
     public ArrayList<String> obtenerOficinas() {
        ArrayList<String> listaOficinas = new ArrayList();

        conectando.crearConexionGeneral();
        
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM oficinas");

            while (rs.next()) {
                String nombre = rs.getString("nombre_oficina");
                listaOficinas.add(nombre);
                //System.out.println("se llena la lista de oficinas");
          
            }
        } catch (Exception e) {
            System.out.println("Error de conexión "+e);
        }

        return listaOficinas;
    }
    
     public void llenarOficinasRetiro() {

        for (int i = 0; i < obtenerOficinas().size(); i++) {
         
            optsOficinasRetiro.addItem(obtenerOficinas().get(i).toString());
        }

    }
     
     public void llenarOficinasDevolucion() {

        for (int i = 0; i < obtenerOficinas().size(); i++) {
         
            optsOficinasDevolucion.addItem(obtenerOficinas().get(i).toString());
        }
    }

     public int obtenerIDOficina(String nombreOficina){
     
         int idOficina=0;
     
         conexionRoger();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM oficinas WHERE nombre_oficina ='"+nombreOficina+"'");

            while (rs.next()) {
                 idOficina = Integer.parseInt(rs.getString("id_oficina"));
           
            }
        } catch (Exception e) {
            System.out.println("Error de conexión "+e);
        }
         
         return  idOficina;
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        optsPlacasVehiculos = new javax.swing.JComboBox<>();
        btnVerDetalles = new javax.swing.JButton();
        panelDetallesDevolucion = new javax.swing.JPanel();
        optsOficinasDevolucion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textHoraDevolucion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textDiaDevolucion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textMesDevolucion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textAñoDevolucion = new javax.swing.JTextField();
        panelDetallesRetiro = new javax.swing.JPanel();
        optsOficinasRetiro = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textHoraRetiro1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textDiaRetiro1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        textMesRetiro1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        textAñoRetiro1 = new javax.swing.JTextField();
        panelExtras = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        optExtraGPS = new javax.swing.JRadioButton();
        optExtraBooster = new javax.swing.JRadioButton();
        optExtraSillaBebe = new javax.swing.JRadioButton();
        optGuardarDetallesRenta = new javax.swing.JButton();
        btnRentarVehiculo = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        textNombreCliente = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        textCedulaCliente = new javax.swing.JTextField();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rentar Vehiculo");

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Placa:");

        btnVerDetalles.setText(" Detalles Vehiculo");
        btnVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetallesActionPerformed(evt);
            }
        });

        jLabel3.setText("Oficina Devolucion");

        jLabel4.setText("Detalles Devolucion:");

        jLabel5.setText("Hora Devolucion:");

        jLabel6.setText("Fecha Devolucion:");

        jLabel7.setText("Dia:");

        jLabel8.setText("Mes:");

        jLabel9.setText("Año:");

        javax.swing.GroupLayout panelDetallesDevolucionLayout = new javax.swing.GroupLayout(panelDetallesDevolucion);
        panelDetallesDevolucion.setLayout(panelDetallesDevolucionLayout);
        panelDetallesDevolucionLayout.setHorizontalGroup(
            panelDetallesDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesDevolucionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelDetallesDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetallesDevolucionLayout.createSequentialGroup()
                        .addGroup(panelDetallesDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(panelDetallesDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetallesDevolucionLayout.createSequentialGroup()
                                .addGap(0, 21, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(120, 120, 120))
                            .addGroup(panelDetallesDevolucionLayout.createSequentialGroup()
                                .addGroup(panelDetallesDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(optsOficinasDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textHoraDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelDetallesDevolucionLayout.createSequentialGroup()
                        .addGroup(panelDetallesDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDetallesDevolucionLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(textDiaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(textMesDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textAñoDevolucion))
                            .addComponent(jLabel6))
                        .addContainerGap())))
        );
        panelDetallesDevolucionLayout.setVerticalGroup(
            panelDetallesDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesDevolucionLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addGroup(panelDetallesDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optsOficinasDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24)
                .addGroup(panelDetallesDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textHoraDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addGroup(panelDetallesDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textDiaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(textMesDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(textAñoDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setText("Oficina Retiro");

        jLabel11.setText("Detalles Retiro:");

        jLabel12.setText("Hora Retiro:");

        jLabel13.setText("Fecha Retiro:");

        jLabel14.setText("Dia:");

        jLabel15.setText("Mes:");

        jLabel16.setText("Año:");

        javax.swing.GroupLayout panelDetallesRetiroLayout = new javax.swing.GroupLayout(panelDetallesRetiro);
        panelDetallesRetiro.setLayout(panelDetallesRetiroLayout);
        panelDetallesRetiroLayout.setHorizontalGroup(
            panelDetallesRetiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesRetiroLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelDetallesRetiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(panelDetallesRetiroLayout.createSequentialGroup()
                        .addGroup(panelDetallesRetiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addGroup(panelDetallesRetiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDetallesRetiroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(optsOficinasRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDetallesRetiroLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(textHoraRetiro1)
                                .addGap(44, 44, 44))))
                    .addGroup(panelDetallesRetiroLayout.createSequentialGroup()
                        .addGroup(panelDetallesRetiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(panelDetallesRetiroLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(textDiaRetiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(textMesRetiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textAñoRetiro1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDetallesRetiroLayout.setVerticalGroup(
            panelDetallesRetiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesRetiroLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(20, 20, 20)
                .addGroup(panelDetallesRetiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optsOficinasRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(24, 24, 24)
                .addGroup(panelDetallesRetiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textHoraRetiro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel13)
                .addGap(27, 27, 27)
                .addGroup(panelDetallesRetiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textDiaRetiro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(textMesRetiro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(textAñoRetiro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jLabel17.setText("Extras:");

        optExtraGPS.setText("GPS");

        optExtraBooster.setText("Booster");

        optExtraSillaBebe.setText("Silla Bebe");

        javax.swing.GroupLayout panelExtrasLayout = new javax.swing.GroupLayout(panelExtras);
        panelExtras.setLayout(panelExtrasLayout);
        panelExtrasLayout.setHorizontalGroup(
            panelExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExtrasLayout.createSequentialGroup()
                .addGroup(panelExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelExtrasLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel17))
                    .addGroup(panelExtrasLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(panelExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optExtraBooster)
                            .addComponent(optExtraGPS)
                            .addComponent(optExtraSillaBebe))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        panelExtrasLayout.setVerticalGroup(
            panelExtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExtrasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(optExtraGPS)
                .addGap(18, 18, 18)
                .addComponent(optExtraBooster)
                .addGap(18, 18, 18)
                .addComponent(optExtraSillaBebe)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        optGuardarDetallesRenta.setText("Guardar Detalles Renta");
        optGuardarDetallesRenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optGuardarDetallesRentaActionPerformed(evt);
            }
        });

        btnRentarVehiculo.setText("Rentar");
        btnRentarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentarVehiculoActionPerformed(evt);
            }
        });

        jLabel18.setText("Nombre:");

        jLabel19.setText("Cedula:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(136, 136, 136))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textNombreCliente)
                                    .addComponent(textCedulaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(optGuardarDetallesRenta)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btnRentarVehiculo)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelDetallesRetiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelDetallesDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(optsPlacasVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerDetalles))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(optsPlacasVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerDetalles))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDetallesRetiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDetallesDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelExtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(textNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(optGuardarDetallesRenta)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(textCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRentarVehiculo)
                        .addGap(8, 8, 8)
                        .addComponent(jButton1)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menu_Usuarios ventanaRegresar = new Menu_Usuarios();
        ventanaRegresar.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetallesActionPerformed
        // TODO add your handling code here:
        
        conectando.crearConexionGeneral();
        
        String placaInfo=optsPlacasVehiculos.getSelectedItem().toString();
        
        try {

            s = connection.createStatement();
            //aqui estoy haciendo un JOIN
            rs = s.executeQuery("SELECT nombre_marca,nombre_modelo,nombre_estilo,transmision,año FROM vehiculo JOIN marca ON marca=marca.id_marca JOIN modelo ON modelo=modelo.id_modelo JOIN estilo ON estilo=estilo.id_estilo WHERE placa='"+placaInfo+"'");
            
            while (rs.next()) {
                String nombreMarca = rs.getString("nombre_marca");
                String nombreModelo=rs.getString("nombre_modelo");
                String nombreEstilo=rs.getString("nombre_estilo");
                String tipoTransmision=rs.getString("transmision");
                String añoVehiculo=rs.getString("año");
            
                String detalleTotal="Marca : "+nombreMarca+" , Modelo : "+nombreModelo+" , Estilo : "+nombreEstilo+" , Transmision : "+tipoTransmision+" , Año : "+añoVehiculo;
                JOptionPane.showMessageDialog(null,detalleTotal);
            }
        } catch (Exception e) {
            System.out.println("Error de conexión "+e);
        }
        
    }//GEN-LAST:event_btnVerDetallesActionPerformed

    private void optGuardarDetallesRentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optGuardarDetallesRentaActionPerformed
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(null,"Estoy probando el codigo en la parte el boton de rentar\nSi no sirve ubo esta el otro jjjjjijij");
        
//         if((Integer.parseInt(textHoraRetiro1.getText())>24)||(Integer.parseInt(textHoraDevolucion.getText())>24)){
//            
//                JOptionPane.showMessageDialog(null,"Horas Incorrectas , Introduzca Datos Correctos");
//                System.out.println("horas incorrectas");
//            
//            }else{
//            
//                horaRetiro=Integer.parseInt(textHoraRetiro1.getText());
//                horaDevolucion=Integer.parseInt(textHoraDevolucion.getText());
//            }
//        
//        if( ((Integer.parseInt(textDiaRetiro1.getText())>31) || (Integer.parseInt(textMesRetiro1.getText())>12) || (Integer.parseInt(textAñoRetiro1.getText())>2018) ) && ((Integer.parseInt(textDiaDevolucion.getText())>31) || (Integer.parseInt(textMesDevolucion.getText())>12) || (Integer.parseInt(textAñoDevolucion.getText())>2018) ) ){
//            
//            JOptionPane.showMessageDialog(null,"Fechas Incorrectas , Introduzca Datos Correctos");
//            
//        }else{
//         
//            fechaRetiro=textDiaRetiro1.getText()+"-"+textMesRetiro1.getText()+"-"+textAñoRetiro1.getText();
//            fechaDevolucion=textDiaDevolucion.getText()+"-"+textMesDevolucion.getText()+"-"+textAñoDevolucion.getText();
//            int cantidadDiasAlquiler=0;
//            
//            try {
//                cantidadDiasAlquiler = diasAlquiler(fechaRetiro, fechaDevolucion);
//            } catch (ParseException ex) {
//                
//                //Logger.getLogger(rentar_Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("Problemas "+ex);
//            }
//            
//            informacionAlquiler.setPlaca(optsPlacasVehiculos.getSelectedItem().toString());
//            precioAlquiler=(obtenerPrecioAlquiler(placa)*cantidadDiasAlquiler);
//            
//            informacionAlquiler.setOficinaRetiro(obtenerIDOficina(optsOficinasRetiro.getSelectedItem().toString()));
//            informacionAlquiler.setOficinaDevolucion(obtenerIDOficina(optsOficinasDevolucion.getSelectedItem().toString()));
//            
//            informacionAlquiler.setHoraRetiro(horaRetiro);
//            informacionAlquiler.setHoraDevolucion(horaDevolucion);
//            
//            informacionAlquiler.setFechaRetiro(fechaRetiro);
//            informacionAlquiler.setFechaDevolucion(fechaDevolucion);
//            System.out.println("-------------------------------------");
//            System.out.println("fechas aceptadas");
//            System.out.println("detalles de la informacion del alquiler sin la cedula , nombre cliente y sin las extras");
//            System.out.println(informacionAlquiler.toString());
//            System.out.println("----------------------------------------------");
//        
//        }
        
    }//GEN-LAST:event_optGuardarDetallesRentaActionPerformed

    private void btnRentarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentarVehiculoActionPerformed
        // TODO add your handling code here:
        
        if((Integer.parseInt(textHoraRetiro1.getText())>24)||(Integer.parseInt(textHoraDevolucion.getText())>24)){
            
                JOptionPane.showMessageDialog(null,"Horas Incorrectas , Introduzca Datos Correctos");
                System.out.println("horas incorrectas");
            
            }else{
            
                horaRetiro=Integer.parseInt(textHoraRetiro1.getText());
                horaDevolucion=Integer.parseInt(textHoraDevolucion.getText());
            }
        
        if( ((Integer.parseInt(textDiaRetiro1.getText())>31) || (Integer.parseInt(textMesRetiro1.getText())>12) || (Integer.parseInt(textAñoRetiro1.getText())>2018) ) && ((Integer.parseInt(textDiaDevolucion.getText())>31) || (Integer.parseInt(textMesDevolucion.getText())>12) || (Integer.parseInt(textAñoDevolucion.getText())>2018) ) ){
            
            JOptionPane.showMessageDialog(null,"Fechas Incorrectas , Introduzca Datos Correctos");
            
        }else{
         
            fechaRetiro=textDiaRetiro1.getText()+"-"+textMesRetiro1.getText()+"-"+textAñoRetiro1.getText();
            fechaDevolucion=textDiaDevolucion.getText()+"-"+textMesDevolucion.getText()+"-"+textAñoDevolucion.getText();
            int cantidadDiasAlquiler=0;
            
            try {
                cantidadDiasAlquiler = diasAlquiler(fechaRetiro, fechaDevolucion);
            } catch (ParseException ex) {
                
                //Logger.getLogger(rentar_Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Problemas "+ex);
            }
            
            informacionAlquiler.setPlaca(optsPlacasVehiculos.getSelectedItem().toString());
            
            
            informacionAlquiler.setOficinaRetiro(obtenerIDOficina(optsOficinasRetiro.getSelectedItem().toString()));
            informacionAlquiler.setOficinaDevolucion(obtenerIDOficina(optsOficinasDevolucion.getSelectedItem().toString()));
            
            informacionAlquiler.setHoraRetiro(horaRetiro);
            informacionAlquiler.setHoraDevolucion(horaDevolucion);
            
            informacionAlquiler.setFechaRetiro(fechaRetiro);
            informacionAlquiler.setFechaDevolucion(fechaDevolucion);
//            System.out.println("-------------------------------------");
//            System.out.println("fechas aceptadas");
//            System.out.println("detalles de la informacion del alquiler sin la cedula , nombre cliente y sin las extras");
//            System.out.println(informacionAlquiler.toString());
//            System.out.println("----------------------------------------------");
//        

        while(!(textNombreCliente.getText().length()==0||textCedulaCliente.getText().length()==0)){
     
            informacionAlquiler.setIdUsuario(textCedulaCliente.getText());
                informacionAlquiler.setNombreUsuario(textNombreCliente.getText());
            
            if(optExtraGPS.isSelected()){
                
                precioAlquiler+=(cantidadDiasAlquiler*9);
                
            }
            else if(optExtraBooster.isSelected()){
            
                 precioAlquiler+=(cantidadDiasAlquiler*11);
                
            }else if(optExtraSillaBebe.isSelected()){
            
                 precioAlquiler+=(cantidadDiasAlquiler*3);
            }
            
            precioAlquiler+=(obtenerPrecioAlquiler(placa)*cantidadDiasAlquiler);
            
            informacionAlquiler.setPrecioAlquiler(precioAlquiler);
        }
        }
        
        
            System.out.println("-------------------------------------");
            System.out.println("Detalle Total");
            //System.out.println("detalles de la informacion del alquiler sin la cedula , nombre cliente y sin las extras");
            System.out.println(informacionAlquiler.toString());
            System.out.println("----------------------------------------------");
//  
    }//GEN-LAST:event_btnRentarVehiculoActionPerformed

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
            java.util.logging.Logger.getLogger(rentar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rentar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rentar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rentar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rentar_Vehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRentarVehiculo;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton optExtraBooster;
    private javax.swing.JRadioButton optExtraGPS;
    private javax.swing.JRadioButton optExtraSillaBebe;
    private javax.swing.JButton optGuardarDetallesRenta;
    private javax.swing.JComboBox<String> optsOficinasDevolucion;
    private javax.swing.JComboBox<String> optsOficinasRetiro;
    private javax.swing.JComboBox<String> optsPlacasVehiculos;
    private javax.swing.JPanel panelDetallesDevolucion;
    private javax.swing.JPanel panelDetallesRetiro;
    private javax.swing.JPanel panelExtras;
    private javax.swing.JTextField textAñoDevolucion;
    private javax.swing.JTextField textAñoRetiro1;
    private javax.swing.JTextField textCedulaCliente;
    private javax.swing.JTextField textDiaDevolucion;
    private javax.swing.JTextField textDiaRetiro1;
    private javax.swing.JTextField textHoraDevolucion;
    private javax.swing.JTextField textHoraRetiro1;
    private javax.swing.JTextField textMesDevolucion;
    private javax.swing.JTextField textMesRetiro1;
    private javax.swing.JTextField textNombreCliente;
    // End of variables declaration//GEN-END:variables
}
