/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Admie21
 */
public class Vehiculo {

    private int placa;
    private int idMarca;
    private int idModelo;
    private int idEstilo;
    private int año;
    private double precio;
    private File foto;
    private String estado;

    public Vehiculo() {
    }

    public Vehiculo(int placa, int idMarca, int idModelo, int idEstilo, int año, double precio, File foto, String estado) {
        this.placa = placa;
        this.idMarca = idMarca;
        this.idModelo = idModelo;
        this.idEstilo = idEstilo;
        this.año = año;
        this.precio = precio;
        this.foto = foto;
        this.estado = estado;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
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

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", idMarca=" + idMarca + ", idModelo=" + idModelo + ", idEstilo=" + idEstilo + ", a\u00f1o=" + año + ", precio=" + precio + ", foto=" + foto + ", estado=" + estado + '}';
    }
}
