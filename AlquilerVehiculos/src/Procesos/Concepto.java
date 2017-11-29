/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

/**
 *
 * @author Roger Oporta
 */
public class Concepto {
    
    private int identificador;
    private String nombre;

    public Concepto() {
    }

    public Concepto(int identiicador, String nombre) {
        this.identificador = identiicador;
        this.nombre = nombre;
    }

    public int getIdentiicador() {
        return identificador;
    }

    public void setIdentiicador(int identiicador) {
        this.identificador = identiicador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Concepto{" + "identiicador=" + identificador + ", nombre=" + nombre + '}';
    }
}
