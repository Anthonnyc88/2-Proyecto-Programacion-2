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
import Procesos.InformacionAlquiler;
import java.util.ArrayList;

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
    
     //SOLO SIRVE PARA REGISTROS ESTE METODO
    public boolean crearConexionRegistrosAnthonny() {
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/renta_vehiculos", "postgres", "1414250816ma");
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
 
     //SOLO SIRVE PARA REGISTROS ESTE METODO
    public boolean crearConexionRegistrosRoger() {
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/renta_vehiculos", "postgres", "Saborio17");
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

        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        System.out.println("Estamos es registrar en Registrar Estilo");
        
        try {
            Statement s = connection.createStatement();

            int z = s.executeUpdate("INSERT INTO estilo(id_estilo,nombre_estilo) VALUES('" + estilo.getIdentificador() + "', '" +estilo.getNombre() + "')");
            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa un Nuevo estilo " + estilo.getIdentificador());
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa un Nuevo estilo ");
               

            } else {
                System.out.println("Error al insertar el registro");
            }
            

        } catch (Exception e) {
        }
        
    }

    /**
     * Metodo que inserta una 
     * marca en la DB
     * @param marca 
     */
    public void insertarMarca(Marca marca) {

        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        
        System.out.println("estamos en registrar marcas");

        try {
    
            
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO marca(id_marca,nombre_marca) VALUES('"+marca.getIdentificador() +"', '" +marca.getNombre() + "')");
            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa una Nueva marca "+marca.getIdentificador());
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa una Nueva marca ");
                

            } else {
                System.out.println("Error al insertar el registro");
            }
            
            
        } catch (Exception e) {
        }
    }
    
    /**
     * Metodo que busca una marca 
     * en base a una pk dada
     * 
     * @param idMarca
     * @return 
     */
    public String buscarMarca(String idMarca){
    
        String nombreMarca="";
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
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

    /**
     * Metodo que inserta un modelo
     * en la DB
     * @param modelo 
     */
    public void insertarModelo(Modelo modelo) {

        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        
        System.out.println("estamos en registrar modelo");
        try {
       s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO modelo(id_modelo,nombre_modelo) VALUES('"+modelo.getIdentificador() +"', '" +modelo.getNombre() + "')");
            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa un Nuevo modelo "+modelo.getIdentificador());
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa un Nuevo modelo ");
            } else {
                System.out.println("Error al insertar el registro");
            }
        } catch (Exception e) {
        }
    }

    /**
     * Metodo que inserta una oficina
     * en la DB
     * @param oficina 
     */
    public void insertarOficina(Oficina oficina) {

        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        
        System.out.println("estamos en registrar oficinas");
        try {
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO oficinas(id_oficina,nombre_oficina) VALUES('"+oficina.getIdentificador() +"', '" +oficina.getNombre()+"')");
            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa una Nueva oficina "+oficina.getIdentificador());
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa una Nueva oficina ");

            } else {
                System.out.println("Error al insertar el registro");
            }
 
        } catch (Exception e) {
        }
    }

    /**
     * Metodo que Inserta la Informacion
     * de un Vehiculo
     * 
     * @param infoAlquiler 
     */
    public void insertarInformacionRentaVehiculo(InformacionAlquiler infoAlquiler) {

        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        
        System.out.println("estamos en registrar rentas");
        try {
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO alquiler_vehiculos(placa_vehiculo,id_usuario,nombre_usuario,oficina_retiro,oficina_devolucion,fecha_retiro,hora_retiro,fecha_devolucion,hora_devolucion,precio_alquiler) VALUES('"+infoAlquiler.getPlaca()+"','"+infoAlquiler.getIdUsuario()+"','"+infoAlquiler.getNombreUsuario()+"','"+infoAlquiler.getOficinaRetiro()+"','"+infoAlquiler.getOficinaDevolucion()+"','"+infoAlquiler.getFechaRetiro()+"','"+infoAlquiler.getHoraRetiro()+"','"+infoAlquiler.getFechaDevolucion()+"','"+infoAlquiler.getHoraDevolucion()+"','"+infoAlquiler.getPrecioAlquiler()+"')");
            if (z == 1) {
                System.out.println("---------------------------------------------\n"
                        + "Esta es la info almacenada:\n"+infoAlquiler.toString()+
                                 "\n---------------------------------------------");
                JOptionPane.showMessageDialog(null,"Se agregó el registro de manera exitosa la renta del Vehiculo\nDisfrutelo y que Dios lo acompañe ");

            } else {
                System.out.println("Error al insertar la Informacion de la Renta");
            }
 
        } catch (Exception e) {
            System.out.println("Erores en la Insersion "+e);
        }
        
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
        //crearConexionGeneralAnthonny();
        try {

            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE estilo SET nombre_estilo = '" + estilo.getNombre() + "'  WHERE id_estilo = ' " + estilo.getIdentificador() + " ' ");

            if (z == 1) {

                System.out.println("Se módificó el registro del estilo numero : " + estilo.getIdentificador());
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
        //crearConexionGeneralAnthonny();
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

    /**
     * Metodo que modifica 
     * una marca
     * @param marca 
     */
    public void modificarMarca(Marca marca) {
        
        System.out.println("estamos en modificar marca");
        
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        
       try {       
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE marca SET nombre_marca = '"+marca.getNombre()+"'  WHERE id_marca = ' "+marca.getIdentificador()+" ' ");
            
            if (z == 1) {
            
                System.out.println("Se módificó el registro de la marca numero : "+marca.getIdentificador());
                JOptionPane.showMessageDialog(null,"Se módificó el registro de manera exitosa la marca");

            }else {
                System.out.println("Error al modificar el registro");
                JOptionPane.showMessageDialog(null,"Error al modificar el registro");
            }     
        } catch (Exception e) {
        }
    }
    
    /**
     * Metodo que busca la informacion
     * de un modelo
     * @param modelo
     * 
     * @return el nombre del Modelo
     */
    public String buscarModelo(Modelo modelo){
    
        
        String modeloNombre="";
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM modelo WHERE id_modelo='" +modelo.getIdentificador()+ "'");
            
            while (rs.next()) {
                
            modeloNombre=rs.getString("nombre_modelo");
            }
            
        } catch (Exception e) {
            System.out.println("Problemas " + e);

        }
    
        return modeloNombre;
    }

    /**
     * Metodo que modifica
     * un Modelo
     * @param modelo 
     */
    public void modificarModelo(Modelo modelo) {

        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        
        System.out.println("estamos en modificar modelo");
        
        try {
      
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE modelo SET nombre_modelo = '"+modelo.getNombre()+"'  WHERE id_modelo = ' "+modelo.getIdentificador()+" ' ");
            
            if (z == 1) {
            
                System.out.println("Se módificó el registro el modelo numero : "+modelo.getIdentificador());
                JOptionPane.showMessageDialog(null,"Se módificó el registro de manera exitosa del modelo");
         
                
            }else {
                System.out.println("Error al modificar el registro");
                JOptionPane.showMessageDialog(null,"Error al modificar el registro");
            }           
            
            
        } catch (Exception e) {
            System.out.println("Problemas "+e);
        }       
    }

    /**
     * Metodo que busca los datos de una oficina
     * @param oficina
     * @return  el nombre de la Oficina
     */
    public String buscarOficina(Oficina oficina){


           String nombreOficina="";
           crearConexionGeneral();
           //crearConexionGeneralAnthonny();

           try {

               s = connection.createStatement();
               rs = s.executeQuery("SELECT * FROM oficinas WHERE id_oficina='" +oficina.getIdentificador()+ "'");

               while (rs.next()) {

               nombreOficina=rs.getString("nombre_oficina");
               }

           } catch (Exception e) {
               System.out.println("Problemas " + e);

           }

           return nombreOficina;
       }   
    
    /**
     * Metodo que modifica los datos 
     * de una oficina
     * @param oficina 
     */
    public void modificarOficina(Oficina oficina) {
        
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
     
         System.out.println("estamos en modificar modelo");
        try {
  
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE oficinas SET nombre_oficina = '"+oficina.getNombre()+"'  WHERE id_oficina = ' "+oficina.getIdentificador()+" ' ");
            
            if (z == 1) {
            
                System.out.println("Se módificó el registro la oficina numero : "+oficina.getIdentificador());
                JOptionPane.showMessageDialog(null,"Se módificó el registro de manera exitosa de la oficina");;
                
            }else {
                System.out.println("Error al modificar el registro");
                JOptionPane.showMessageDialog(null,"Error al modificar el registro");
            }
     
        }catch (Exception e) {
            
            System.out.println("Problemas "+e);
        }

    }
    
    /**
     * Metodo que devuelve el tipo de 
     * Usuario en el momento de que se
     * Logea
     * 
     * @param usuario
     * @return el tipo de Usuario 
     */
    public String loginUsuarios(Usuario usuario){
    
        String tipoUsuario="";
        crearConexionGeneral();
        crearConexionGeneralAnthonny();
        
          try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM usuarios WHERE id_usuario = '" + usuario.getCedula() + "'");

            while (rs.next()) {
                String userDatabase = rs.getString("id_usuario");
                String datoTipoUsuario=rs.getString("tipo_usuario");
                String nombreUsuario=rs.getString("nombre");
        
                if (userDatabase.equals(userDatabase) && datoTipoUsuario.equals("Administrador")) {

                    tipoUsuario="Administrador";
                    System.out.println("Bienvenido Administrador "+nombreUsuario);
                }
                else if(userDatabase.equals(userDatabase) && datoTipoUsuario.equals("Cliente")){

                    tipoUsuario="Cliente";
                }else{
                      System.out.println("Usuario No Registrado");
                }
               
            }
        } catch (Exception e) {
            System.out.println("Problemas" + e);
        }
          
          return tipoUsuario;
    }
    
    /**
     * Metodo que realiza la consulta
     * de un vehiculo en base a una placa
     * @param placa
     * @return 
     */
    public String detalleVehiculo(String placa){
    
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        String detalleTotal="";

        try {

            s = connection.createStatement();
            //aqui estoy haciendo un JOIN
            rs = s.executeQuery("SELECT nombre_marca,nombre_modelo,nombre_estilo,transmision,año FROM vehiculo JOIN marca ON marca=marca.id_marca JOIN modelo ON modelo=modelo.id_modelo JOIN estilo ON estilo=estilo.id_estilo WHERE placa='"+placa+"'");
            
            while (rs.next()) {
                String nombreMarca = rs.getString("nombre_marca");
                String nombreModelo=rs.getString("nombre_modelo");
                String nombreEstilo=rs.getString("nombre_estilo");
                String tipoTransmision=rs.getString("transmision");
                String añoVehiculo=rs.getString("año");
            
                 detalleTotal="Marca : "+nombreMarca+" , Modelo : "+nombreModelo+" , Estilo : "+nombreEstilo+" , Transmision : "+tipoTransmision+" , Año : "+añoVehiculo;
                JOptionPane.showMessageDialog(null,detalleTotal);
               
            }
        } catch (Exception e) {
            System.out.println("Error de conexión "+e);
        }
        
        return  detalleTotal;
    }
    
    /**
     * Metodo que cambia el Etdo de un
     * Vehiculo a la hora de Rentarlo.
     * @param vehiculo 
     */
    public void cambiarEstadoVehiculo(Vehiculo vehiculo){
    
    
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        System.out.println("estamos en cambiar estado de Vehiculos");
        try {
  
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE vehiculo SET estado = '"+vehiculo.getEstado()+"'  WHERE placa = ' "+vehiculo.getPlaca()+" ' ");
            
            if (z == 1) {
            
                System.out.println("Se módificó el estado del vehiculo placa : "+vehiculo.getPlaca());
                JOptionPane.showMessageDialog(null,"Vehiculo Reservado");;
                
            }else {
                System.out.println("Error al modificar el registro");
                JOptionPane.showMessageDialog(null,"Error al modificar el registro");
            }
     
        }catch (Exception e) {
            
            System.out.println("Problemas "+e);
        }
     
    }
    
    /**
     * Metodo que realiza la consulta
     * por año de un vehiculo
     * 
     * @param añoBuscar
     * @return 
     */
    public String consultaAnno(String añoBuscar){
    
        String resultadoConsulta="";
    
        crearConexionGeneral();
           //crearConexionGeneralAnthonny();

           try {

               s = connection.createStatement();
               rs = s.executeQuery("SELECT nombre_marca,nombre_modelo,nombre_estilo,transmision,precio FROM vehiculo JOIN marca ON marca=marca.id_marca JOIN modelo ON modelo=modelo.id_modelo JOIN estilo ON estilo=estilo.id_estilo WHERE año = ' "+añoBuscar+" ' ");

               while (rs.next()) {
                   
                String nombreMarca = rs.getString("nombre_marca");
                String nombreModelo=rs.getString("nombre_modelo");
                String nombreEstilo=rs.getString("nombre_estilo");
                String precio=rs.getString("precio");
                String tipoTransmision=rs.getString("transmision");
            
                resultadoConsulta="Marca : "+nombreMarca+" , Modelo : "+nombreModelo+" , Estilo : "+nombreEstilo+" , Transmision : "+tipoTransmision+" , Precio : "+precio;
               }

           } catch (Exception e) {
               System.out.println("Problemas " + e);

           }
        
        return  resultadoConsulta;
    }
    
    
    public ArrayList<String> mostrarMarcas() {
        
        ArrayList<String> resultados = new ArrayList();
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre_marca FROM marca");

            while (rs.next()) {
                String nombre=rs.getString("nombre_marca");
                resultados.add(nombre);
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
    }
        return  resultados;
    }
    
    public int averiguarIDMarca(String nombreMarca) {
        
        int idMarca = 0;
      
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_marca FROM marca WHERE nombre_marca = '" + nombreMarca + "'");

            while (rs.next()) {
                idMarca = rs.getInt("id_marca");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
        return idMarca;

    }
    
    /**
     * Metodo que realiza la consulta
     * por Marca de un vehiculo
     * 
     * @param idMarca
     * @return 
     */
    public String consultaMarca(String idMarca){
    
        String resultadoConsulta="";
    
        crearConexionGeneral();
           //crearConexionGeneralAnthonny();

           try {

               s = connection.createStatement();
               rs = s.executeQuery("SELECT nombre_marca,nombre_modelo,nombre_estilo,transmision,año,precio FROM vehiculo JOIN marca ON marca=marca.id_marca JOIN modelo ON modelo=modelo.id_modelo JOIN estilo ON estilo=estilo.id_estilo WHERE marca = ' "+idMarca+" ' ");

               while (rs.next()) {
               
                String nombreModelo=rs.getString("nombre_modelo");
                String nombreEstilo=rs.getString("nombre_estilo");
                String tipoTransmision=rs.getString("transmision");
                String precio=rs.getString("precio");
                String marcaNombre=rs.getString("nombre_marca");
                String añoVehiculo=rs.getString("año");
            
                   System.out.println("SE ESTA LLENANDO LA INFORMACION");
                 resultadoConsulta="Marca : "+marcaNombre+" , Modelo : "+nombreModelo+" , Estilo : "+nombreEstilo+" , Transmision : "+tipoTransmision+" , Año : "+añoVehiculo+" , Precio : "+precio;
               }

           } catch (Exception e) {
               System.out.println("Problemas " + e);

           }
        
        return  resultadoConsulta;
    }
    
    public ArrayList<String> mostrarEstilos() {
        
        ArrayList<String> resultados = new ArrayList();
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre_estilo FROM estilo");

            while (rs.next()) {
                String nombreEstilos=rs.getString("nombre_estilo");
                resultados.add(nombreEstilos);
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
    }
        return  resultados;
    }
    
    public int averiguarIDEstilo(String nombreEstilo) {
        
        int idEstilo = 0;
      
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_estilo FROM estilo WHERE nombre_estilo = '" + nombreEstilo + "'");

            while (rs.next()) {
                idEstilo = rs.getInt("id_estilo");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
        return idEstilo;

    }
    
    /**
     * Metodo que realiza la consulta
     * por Marca de un vehiculo
     * 
     * @param idEstilo
     * @return 
     */
    public String consultaEstilo(String idEstilo){
    
        String resultadoConsulta="";
    
        crearConexionGeneral();
           //crearConexionGeneralAnthonny();

           try {

               s = connection.createStatement();
               rs = s.executeQuery("SELECT nombre_marca,nombre_modelo,nombre_estilo,transmision,año,precio FROM vehiculo JOIN marca ON marca=marca.id_marca JOIN modelo ON modelo=modelo.id_modelo JOIN estilo ON estilo=estilo.id_estilo WHERE estilo = ' "+idEstilo+" ' ");

               while (rs.next()) {
               
                String nombreModelo=rs.getString("nombre_modelo");
                String nombreEstilo=rs.getString("nombre_estilo");
                String tipoTransmision=rs.getString("transmision");
                String precio=rs.getString("precio");
                String marcaNombre=rs.getString("nombre_marca");
                String añoVehiculo=rs.getString("año");
            
                   //System.out.println("SE ESTA LLENANDO LA INFORMACION");
                 resultadoConsulta="Marca : "+marcaNombre+" , Modelo : "+nombreModelo+" , Transmision : "+tipoTransmision+" , Año : "+añoVehiculo+" , Precio : "+precio;
               }

           } catch (Exception e) {
               System.out.println("Problemas " + e);

           }
        
        return  resultadoConsulta;
    }
    
     /**
     * Metodo que realiza la consulta
     * por Tramision de un vehiculo
     * 
     * @param tipoTransmision
     * @return 
     */
    public String consultaTransmision(String tipoTransmision){
    
        String resultadoConsulta="";
    
        crearConexionGeneral();
           //crearConexionGeneralAnthonny();

           try {

               s = connection.createStatement();
               rs = s.executeQuery("SELECT placa,nombre_marca,nombre_modelo,nombre_estilo,año,precio FROM vehiculo JOIN marca ON marca=marca.id_marca JOIN modelo ON modelo=modelo.id_modelo JOIN estilo ON estilo=estilo.id_estilo WHERE transmision ='"+tipoTransmision+"'");

               while (rs.next()) {
               
                String nombreModelo=rs.getString("nombre_modelo");
                String nombreEstilo=rs.getString("nombre_estilo");
                String placa=rs.getString("placa");
                String precio=rs.getString("precio");
                String marcaNombre=rs.getString("nombre_marca");
                String añoVehiculo=rs.getString("año");
            
                 resultadoConsulta="Placa : "+placa+" , Marca : "+marcaNombre+" , Modelo : "+nombreModelo+" , Estilo : "+nombreEstilo+" , Año : "+añoVehiculo+" , Precio : "+precio;
               }

           } catch (Exception e) {
               System.out.println("Problemas " + e);

           }
        
        return  resultadoConsulta;
    }
    
    /**
     * Metodo que realiza la consulta
     * por Tramision de un vehiculo
     * 
     * @param precioV
     * @return 
     */
    public String consultaPrecio(String precioV){
    
        String resultadoConsulta="";
    
        crearConexionGeneral();
           //crearConexionGeneralAnthonny();

           try {

               s = connection.createStatement();
               rs = s.executeQuery("SELECT placa,nombre_marca,nombre_modelo,nombre_estilo,año,transmision FROM vehiculo JOIN marca ON marca=marca.id_marca JOIN modelo ON modelo=modelo.id_modelo JOIN estilo ON estilo=estilo.id_estilo WHERE precio='"+precioV+"'");

               while (rs.next()) {
               
                String nombreModelo=rs.getString("nombre_modelo");
                String nombreEstilo=rs.getString("nombre_estilo");
                String placa=rs.getString("placa");
                String transmision=rs.getString("transmision");
                String marcaNombre=rs.getString("nombre_marca");
                String añoVehiculo=rs.getString("año");
            
                 resultadoConsulta="Placa : "+placa+" , Marca : "+marcaNombre+" , Modelo : "+nombreModelo+" , Estilo : "+nombreEstilo+" , Año : "+añoVehiculo+" , Transmision : "+transmision;
               }

           } catch (Exception e) {
               System.out.println("Problemas " + e);

           }
        
        return  resultadoConsulta;
    }
    
    public ArrayList<String> mostrarModelos() {
        
        ArrayList<String> resultados = new ArrayList();
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre_modelo FROM modelo");

            while (rs.next()) {
                String nombreEstilos=rs.getString("nombre_modelo");
                resultados.add(nombreEstilos);
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
    }
        return  resultados;
    }
    
    public int averiguarIDModelo(String nombreModelo) {
        
        int idModelo = 0;
      
        crearConexionGeneral();
        //crearConexionGeneralAnthonny();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_modelo FROM modelo WHERE nombre_modelo = '" + nombreModelo + "'");

            while (rs.next()) {
                idModelo = rs.getInt("id_modelo");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
        return idModelo;

    }
    
    /**
     * Metodo que realiza la consulta
     * por Marca de un vehiculo
     * 
     * @param idModelo
     * @return 
     */
    public String consultaModelo(String idModelo){
    
        String resultadoConsulta="";
    
        crearConexionGeneral();
           //crearConexionGeneralAnthonny();

           try {

               s = connection.createStatement();
               rs = s.executeQuery("SELECT placa,nombre_marca,nombre_modelo,nombre_estilo,transmision,año,precio FROM vehiculo JOIN marca ON marca=marca.id_marca JOIN modelo ON modelo=modelo.id_modelo JOIN estilo ON estilo=estilo.id_estilo WHERE modelo = ' "+idModelo+" ' ");

               while (rs.next()) {
       
                String nombreEstilo=rs.getString("nombre_estilo");
                String placa = rs.getString("placa");
                String tipoTransmision=rs.getString("transmision");
                String precio=rs.getString("precio");
                String marcaNombre=rs.getString("nombre_marca");
                String añoVehiculo=rs.getString("año");
            
                   //System.out.println("SE ESTA LLENANDO LA INFORMACION");
                 resultadoConsulta="Placa : "+placa+" , Marca : "+marcaNombre+" , Transmision : "+tipoTransmision+" , Año : "+añoVehiculo+" , Precio : "+precio;
               }

           } catch (Exception e) {
               System.out.println("Problemas " + e);

           }
        
        return  resultadoConsulta;
    }
}
