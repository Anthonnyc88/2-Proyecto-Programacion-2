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
 * @author Admie21 o roger
 * @author Anthonny
 */
public class Principal {

    public static ConexionBaseDatos conectando = new ConexionBaseDatos();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Conectado: " + conectando.crearConexion());
        if (conectando.crearConexion()) {
            LoginPrincipal ventanaPrincipal = new LoginPrincipal();
            ventanaPrincipal.setVisible(true);
            System.out.println("ejecutando el programa");

        }

    }
    
}
