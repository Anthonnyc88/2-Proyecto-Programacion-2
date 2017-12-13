/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

/**
 *
 * @author Admie21
 */
public class Marca extends Concepto{

    public Marca() {
    }

   

    public Marca(int identificador, String nombre) {
        super(identificador, nombre);
    }

    @Override
    public String toString() {
        return "Marca{" + '}';
    }
    
   
}
