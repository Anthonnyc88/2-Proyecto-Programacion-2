/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admie21
 */
public class ConexionBaseDatos {
    
    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;
    
    /**
     *Este metodo es el que hace la magia de la conexion con la 
     * base de datos necesita la url del SGDB , el puerto del server
     *  de la DB por utilizar ademas de la contraseña del server
     */
    public void conexionParaLogin() {
        
         if (connection != null) {
            return;
        }

        String nombreBaseDatos="prueba";//aqui va el nombre de la base de datos 
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
    
}
