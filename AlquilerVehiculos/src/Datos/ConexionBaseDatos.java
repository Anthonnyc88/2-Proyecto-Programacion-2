/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Procesos.Estilo;
import Procesos.Marca;
import Procesos.Modelo;
import Procesos.Oficina;
import Procesos.Usuario;
import Procesos.Vehiculo;
import Proyecto.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admie21
 */
public class ConexionBaseDatos {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;
    ConexionBaseDatos con = Principal.conectando;
    private Connection conexion = null;

    /**
     * Método utilizado para recuperar el valor del atributo conexion
     *
     * @return conexion contiene el estado de la conexión
     *
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Método utilizado para establecer la conexión con la base de datos
     *
     */
    public void crearConexionRoger() {
     if (connection != null) {
            return;
        }

        String nombreBaseDatos="renta_vehiculos";//aqui va el nombre de la base de datos 
        String url = "jdbc:postgresql://localhost:5432/"+nombreBaseDatos;//este es el nombre de la base de datos
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
     * Método utilizado para establecer la conexión con la base de datos
     *
     */
    public void crearConexionAnthonny() {

         if (connection != null) {
            return;
        }

        String nombreBaseDatos="proyecto";//aqui va el nombre de la base de datos 
        String url = "jdbc:postgresql://localhost:5432/"+nombreBaseDatos;//este es el nombre de la base de datos
        String password = "1414250816ma";//esta es la contraseña del postgrade deñ usuario
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

    public boolean crearConexionRegistrosVehiculos() {

        try {
            Class.forName("org.postgresql.Driver");

            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5433/renta_vehiculos", "postgres", "Saborio17");
            if (conexion != null) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("error en conexion: " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return false;
    }
//
//    public void crearConexion() {
//        if (connection != null) {
//            return;
//        }
//
//        String url = "jdbc:postgresql://localhost:5432/proyecto";
//        String password = "1414250816ma";
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection(url, "postgres", password);
//            if (connection != null) {
//                System.out.println("Connecting to database...");
//            }
//        } catch (Exception e) {
//            System.out.println("Problem when connecting to the database...");
//        }
//    }

//    public void conexionParaLoginRoger() {
//        if (connection != null) {
//            return;
//        }
//
//        String nombreBaseDatos = "renta_vehiculos";//aqui va el nombre de la base de datos 
//        String url = "jdbc:postgresql://localhost:5432/" + nombreBaseDatos;//este es el nombre de la base de datos
//        String password = "Saborio17";//esta es la contraseña del postgrade deñ usuario
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection(url, "postgres", password);//este es el nombre sel server
//            if (connection != null) {
//                System.out.println("Connecting to database... Base Datos Conectada " + nombreBaseDatos);
//            }
//        } catch (Exception e) {
//            System.out.println("Problem when connecting to the database... No se Puede conectar la Base Datos " + nombreBaseDatos);
//        }
//    }

    /**
     * Metodo que inserta un usuario
     *
     * @param usuario
     */
    public void insertarUsuario(Usuario usuario) {

    }

    public void insertarVehiculo(Vehiculo vehiculo) {

    }

    public void insertarEstilo(Estilo estilo) {

        crearConexionRoger();
        System.out.println("Estamos es registrar en Registrar Estilo");
        
        try {
            Statement s = connection.createStatement();

            int z = s.executeUpdate("INSERT INTO estilo(id_estilo,nombre_estilo) VALUES('" + estilo.getIdentiicador() + "', '" +estilo.getNombre() + "')");
            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa un Nuevo estilo " + estilo.getIdentiicador());
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa un Nuevo estilo ");
               

            } else {
                System.out.println("Error al insertar el registro");
            }
            

        } catch (Exception e) {
        }
        
    }

    public void insertarMarca(Marca marca) {

    }

    public void insertarModelo(Modelo modelo) {

    }

    public void insertarOficina(Oficina oficina) {

    }

    public void insertarInfoAlquilerVehiculo() {

    }

    public void modificarVehiculo(Vehiculo vehiculo) {

    }

    public void modificarEstilo(Estilo estilo) {

        System.out.println("estamos en modificar estilo");
        crearConexionRoger();
        try {

            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE estilo SET nombre_estilo = '" + estilo.getNombre() + "'  WHERE id_estilo = ' " + estilo.getIdentiicador() + " ' ");

            if (z == 1) {

                System.out.println("Se módificó el registro del estilo numero : " + estilo.getIdentiicador());
                JOptionPane.showMessageDialog(null, "Se módificó el registro de manera exitosa el estilo");

            } else {
                System.out.println("Error al modificar el registro");
                JOptionPane.showMessageDialog(null, "Error al modificar el registro");
            }
        } catch (Exception e) {
        }
    }
    
    public String buscarEstilo(String idEstilo){
    
        String nombreEstilo="";
        crearConexionRoger();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM estilo WHERE id_estilo='" +idEstilo+ "'");
            
            while (rs.next()) {
                
          nombreEstilo=rs.getString("nombre_estilo");
   
            }

        } catch (Exception e) {
            System.out.println("Problemas " + e);

        }
                                        
        
    return nombreEstilo;
    }

    public void modificarMarca(Marca marca) {

    }

    public void modificarModelo(Modelo modelo) {

    }

    public void modificarOficina(Oficina oficina) {

    }

    public void buscarVehiculo() {

    }
}
