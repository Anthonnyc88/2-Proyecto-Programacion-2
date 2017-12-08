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
public class InformacionAlquiler {
    
    private String placa;
    private String idUsuario;
    private String nombreUsuario;
    private int oficinaRetiro;
    private int oficinaDevolucion;
    private String fechaRetiro;
    private int horaRetiro;
    private String fechaDevolucion;
    private int horaDevolucion;
    private double precioAlquiler;

    public InformacionAlquiler(String placa, String idUsuario, String nombreUsuario, int oficinaRetiro, int oficinaDevolucion, String fechaRetiro, int horaRetiro, String fechaDevolucion, int horaDevolucion, double precioAlquiler) {
        this.placa = placa;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.oficinaRetiro = oficinaRetiro;
        this.oficinaDevolucion = oficinaDevolucion;
        this.fechaRetiro = fechaRetiro;
        this.horaRetiro = horaRetiro;
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.precioAlquiler = precioAlquiler;
    }
    
    public InformacionAlquiler(){
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getOficinaRetiro() {
        return oficinaRetiro;
    }

    public void setOficinaRetiro(int oficinaRetiro) {
        this.oficinaRetiro = oficinaRetiro;
    }

    public int getOficinaDevolucion() {
        return oficinaDevolucion;
    }

    public void setOficinaDevolucion(int oficinaDevolucion) {
        this.oficinaDevolucion = oficinaDevolucion;
    }

    public String getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public int getHoraRetiro() {
        return horaRetiro;
    }

    public void setHoraRetiro(int horaRetiro) {
        this.horaRetiro = horaRetiro;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(int horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public String toString() {
        return "InformacionAlquiler{" + "\nplaca=" + placa + ",\nidUsuario=" + idUsuario + ",\nnombreUsuario=" + nombreUsuario + ",\noficinaRetiro=" + oficinaRetiro + ",\noficinaDevolucion=" + oficinaDevolucion + ",\nfechaRetiro=" 
                + fechaRetiro + ",\nhoraRetiro=" + horaRetiro + ",\nfechaDevolucion=" + fechaDevolucion + ",\nhoraDevolucion=" + horaDevolucion + ",\nprecioAlquiler=" + precioAlquiler + '}';
    }
 
}
