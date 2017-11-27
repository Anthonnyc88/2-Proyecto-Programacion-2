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
public class Oficina {
    
    private int idOficina;
    private String ubicacion;

    public Oficina(int idOficina, String ubicacion) {
        this.idOficina = idOficina;
        this.ubicacion = ubicacion;
    }
   
    public Oficina() {

    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Oficina{" + "idOficina=" + idOficina + ", ubicacion=" + ubicacion + '}';
    }

}
