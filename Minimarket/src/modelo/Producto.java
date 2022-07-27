/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author JoTa
 */
public class Producto {
    
    private int idproducto,precio;
    private boolean perecible,disponible;
    private String nombre;

    public Producto() {
    }

    public Producto(int idproducto, int precio, boolean perecible, boolean disponible, String nombre) {
        this.idproducto = idproducto;
        this.precio = precio;
        this.perecible = perecible;
        this.disponible = disponible;
        this.nombre = nombre;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isPerecible() {
        return perecible;
    }

    public void setPerecible(boolean perecible) {
        this.perecible = perecible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

       public Vector<Producto> mostrarProductos(){
        
        Vector<Producto> datos = new Vector<Producto>();
        Producto pro = null;
        try {
        Conexion con = new Conexion();
        Connection cnx = con.obtenerConexion();
        String query = "SELECT idProducto,nombre FROM producto order by nombre";
        PreparedStatement stmt = cnx.prepareStatement(query);        
        
        pro = new Producto();
        pro.setIdproducto(0);
        pro.setNombre("Selecciona un Producto");
        datos.add(pro);
        try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()){
                    
                    pro = new Producto();
                    pro.setIdproducto(rs.getInt("idProducto"));
                    pro.setNombre(rs.getString("nombre"));
                    datos.add(pro);
                    
                }   }
         } catch (SQLException e) {
            System.out.println("Error SQL al listar Producto por id" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Producto por id" + e.getMessage());
        }
        return datos;
    }
   
    
}
