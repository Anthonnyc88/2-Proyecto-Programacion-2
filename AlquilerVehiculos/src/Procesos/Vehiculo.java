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
 * @author Anthonny
 */
public class Vehiculo {

    int Placa_vehiculo;
    int Codigo_marca;
    int Codigo_estilo;
    int Codigo_modelo;
    String Transmision_vehiculo;
    int Año;
    double Precio;
    String Estado;
    File Foto;

    public Vehiculo() {
    }

    public Vehiculo(int Placa_vehiculo, int Codigo_marca, int Codigo_estilo, int Codigo_modelo, String Transmision_vehiculo, int Año, double Precio, String Estado, File Foto) {
        this.Placa_vehiculo = Placa_vehiculo;
        this.Codigo_marca = Codigo_marca;
        this.Codigo_estilo = Codigo_estilo;
        this.Codigo_modelo = Codigo_modelo;
        this.Transmision_vehiculo = Transmision_vehiculo;
        this.Año = Año;
        this.Precio = Precio;
        this.Estado = Estado;
        this.Foto = Foto;
    }

    public int getPlaca_vehiculo() {
        return Placa_vehiculo;
    }

    public int getCodigo_marca() {
        return Codigo_marca;
    }

    public int getCodigo_estilo() {
        return Codigo_estilo;
    }

    public int getCodigo_modelo() {
        return Codigo_modelo;
    }

    public String getTransmision_vehiculo() {
        return Transmision_vehiculo;
    }

    public int getAño() {
        return Año;
    }

    public double getPrecio() {
        return Precio;
    }

    public File getFoto() {
        return Foto;
    }

    public String getEstado() {
        return Estado;
    }

}
