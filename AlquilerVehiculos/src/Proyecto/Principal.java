/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import Datos.ConexionBaseDatos;
import Interfaz.LoginPrincipal;

/**
 *
 * @author Anthonny
 */
public class Principal {

    public static ConexionBaseDatos conectando = new ConexionBaseDatos();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Conectado: " + conectando.crearConexionRegistrosAnthonny());
        //System.out.println("Conectado: " + conectando.crearConexionRegistrosRoger());
        if (conectando.crearConexionRegistrosAnthonny()) {
            LoginPrincipal ventanaPrincipal = new LoginPrincipal();
            ventanaPrincipal.setVisible(true);
            System.out.println("------------------------");
            System.out.println("Ejecutando el programa");
            System.out.println("------------------------");
    }
        
        
    }
    
}
        
//        LoginPrincipal ventanaPrincipal = new LoginPrincipal();
//            ventanaPrincipal.setVisible(true);
//            System.out.println("------------------------");
//            System.out.println("Ejecutando el programa");
//            System.out.println("------------------------");
//    } 
//    

