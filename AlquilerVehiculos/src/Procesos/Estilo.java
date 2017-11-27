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
public class Estilo {
    
    private int idEstilo;
    private String nombre;

    public Estilo(int idEstilo, String nombre) {
        this.idEstilo = idEstilo;
        this.nombre = nombre;
    }
   
     public Estilo(){
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estilo{" + "idEstilo=" + idEstilo + ", nombre=" + nombre + '}';
    }

}
