/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author JoTa
 */
public class detVenta {
    
    private int iddetventa,idventa,idproducto,cantidad,preciouni;
    String nombrepro;

    public detVenta() {
    }

    public detVenta(int iddetventa, int idventa, int idproducto, int cantidad, int preciouni) {
        this.iddetventa = iddetventa;
        this.idventa = idventa;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.preciouni = preciouni;
    }

    public int getIddetventa() {
        return iddetventa;
    }

    public void setIddetventa(int iddetventa) {
        this.iddetventa = iddetventa;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPreciouni() {
        return preciouni;
    }

    public void setPreciouni(int preciouni) {
        this.preciouni = preciouni;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    
    

   
    
}
