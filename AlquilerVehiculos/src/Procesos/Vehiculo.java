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
public class Vehiculo {

    private String placa;
    private int idMarca;
    private int idModelo;
    private int idEstilo;
    private int año;
    private double precio;
    private ImageIcon foto;
    private boolean estado;

    public Vehiculo(String placa, int idMarca, int idModelo, int idEstilo, int año, double precio, ImageIcon foto, boolean estado) {
        this.placa = placa;
        this.idMarca = idMarca;
        this.idModelo = idModelo;
        this.idEstilo = idEstilo;
        this.año = año;
        this.precio = precio;
        this.foto = foto;
        this.estado = estado;
    }
  
    public Vehiculo(){
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", idMarca=" + idMarca + ", idModelo=" + idModelo + ", idEstilo=" + idEstilo + ", a\u00f1o=" + año + ", precio=" + precio + ", foto=" + foto + ", estado=" + estado + '}';
    }
}
