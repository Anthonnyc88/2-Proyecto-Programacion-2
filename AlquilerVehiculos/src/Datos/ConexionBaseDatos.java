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
    public void crearConexionGeneral() {
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
    public void crearConexionGeneralAnthonny() {

         if (connection != null) {
            return;
        }

        String nombreBaseDatos="renta_vehiculos";//aqui va el nombre de la base de datos 
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

    /**
     * Metodo que registra un nuevo estilo
     * @param estilo 
     */
    public void insertarEstilo(Estilo estilo) {

        //crearConexionGeneral();
        crearConexionGeneralAnthonny();
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

        //crearConexionGeneral();
        crearConexionGeneralAnthonny();
        
        System.out.println("estamos en registrar marcas");

        try {
    
            
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO marca(id_marca,nombre_marca) VALUES('"+marca.getIdentiicador() +"', '" +marca.getNombre() + "')");
            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa una Nueva marca "+marca.getIdentiicador());
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa una Nueva marca ");
                

            } else {
                System.out.println("Error al insertar el registro");
            }
            
            
        } catch (Exception e) {
        }
    }
    
    /**
     * Metodo que busca un estilo 
     * en base a una pk dada
     * 
     * @param idMarca
     * @return 
     */
    public String buscarMarca(String idMarca){
    
        String nombreMarca="";
        crearConexionGeneral();
        try {
           s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM marca WHERE id_marca='" +idMarca+ "'");
            
            while (rs.next()) {
                
          nombreMarca=rs.getString("nombre_marca");
            }
        } catch (Exception e) {
            System.out.println("Problemas " + e);
        }                        
        
    return nombreMarca;
    }

    public void insertarModelo(Modelo modelo) {

        //crearConexionGeneral();
        crearConexionGeneralAnthonny();
        
        System.out.println("estamos en registrar modelos");

        try {
    
            
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO modelo(id_modelo,nombre_modelo) VALUES('"+modelo.getIdentiicador() +"', '" +modelo.getNombre() + "')");
            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa una Nuevo modelo "+modelo.getIdentiicador());
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa una Nueva marca ");
                

            } else {
                System.out.println("Error al insertar el registro");
            }
            
            
        } catch (Exception e) {
        }
    }

    public void insertarOficina(Oficina oficina) {

        crearConexionGeneral();
    }

    public void insertarInfoAlquilerVehiculo() {

        crearConexionGeneral();
    }

    public void modificarVehiculo(Vehiculo vehiculo) {

        crearConexionGeneral();
    }

    /**
     * Metodo que modifica un estilo en base 
     * a pk
     * @param estilo 
     */
    public void modificarEstilo(Estilo estilo) {

        System.out.println("estamos en modificar estilo");
        crearConexionGeneral();
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
    
    /**
     * Metodo que busca un estilo 
     * en base a una pk dada
     * 
     * @param idEstilo
     * @return 
     */
    public String buscarEstilo(String idEstilo){
    
        String nombreEstilo="";
        crearConexionGeneral();
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
        
        System.out.println("estamos en modificar marca");
        
        crearConexionGeneral();
        
       try {       
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE marca SET nombre_marca = '"+marca.getNombre()+"'  WHERE id_marca = ' "+marca.getIdentiicador()+" ' ");
            
            if (z == 1) {
            
                System.out.println("Se módificó el registro de la marca numero : "+marca.getIdentiicador());
                JOptionPane.showMessageDialog(null,"Se módificó el registro de manera exitosa la marca");

            }else {
                System.out.println("Error al modificar el registro");
                JOptionPane.showMessageDialog(null,"Error al modificar el registro");
            }     
        } catch (Exception e) {
        }
    }

    public void modificarModelo(Modelo modelo) {

        crearConexionGeneral();
    }

    public void modificarOficina(Oficina oficina) {

        crearConexionGeneral();
    }

    public void buscarVehiculo() {

        crearConexionGeneral();
    }
}
