/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import javax.swing.ImageIcon;

/**
 *
 * @author Admie21
 */
public class Usuario {
    
    public int cedula;
    public String nombre;
    public int telefono;
    public String direccion;
    public String  contaseña;
    public ImageIcon foto;

    public Usuario(int cedula, String nombre, int telefono, String direccion, String contaseña, ImageIcon foto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contaseña = contaseña;
        this.foto = foto;
    }
    
     public Usuario(){
     }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContaseña() {
        return contaseña;
    }

    public void setContaseña(String contaseña) {
        this.contaseña = contaseña;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", contase\u00f1a=" + contaseña + ", foto=" + foto + '}';
    }
}
