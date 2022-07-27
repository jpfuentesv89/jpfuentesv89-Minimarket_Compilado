/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author JoTa
 */
public class Venta {
    
    String nombre;
    private Date fecha;
    private int idventa,idrun,preciototal;
    private boolean efectivo;

    public Venta() {
    }

    public Venta(Date fecha, int idventa, int idrun, int preciototal, boolean efectivo) {
        this.fecha = fecha;
        this.idventa = idventa;
        this.idrun = idrun;
        this.preciototal = preciototal;
        this.efectivo = efectivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdrun() {
        return idrun;
    }

    public void setIdrun(int idrun) {
        this.idrun = idrun;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }

    public boolean isEfectivo() {
        return efectivo;
    }

    public void setEfectivo(boolean efectivo) {
        this.efectivo = efectivo;
    }

    

   

   
}
