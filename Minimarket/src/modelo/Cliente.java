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
public class Cliente {

   private int idrun,telefono;
   private String dvrun,nombre,appaterno,apmaterno;

    public Cliente() {
    }

    public Cliente(int idrun, int telefono, String dvrun, String nombre, String appaterno, String apmaterno) {
        this.idrun = idrun;
        this.telefono = telefono;
        this.dvrun = dvrun;
        this.nombre = nombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
    }

    public int getIdrun() {
        return idrun;
    }

    public void setIdrun(int idrun) {
        this.idrun = idrun;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDvrun() {
        return dvrun;
    }

    public void setDvrun(String dvrun) {
        this.dvrun = dvrun;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

     @Override
    public String toString() {
        return this.nombre;
    }

       public Vector<Cliente> mostrarProductos(){
        
        Vector<Cliente> datos = new Vector<Cliente>();
        Cliente cli = null;
        try {
        Conexion con = new Conexion();
        Connection cnx = con.obtenerConexion();
        String query = "SELECT idrun,nombre FROM cliente order by nombre";
        PreparedStatement stmt = cnx.prepareStatement(query);        
        
        cli = new Cliente();
        cli.setIdrun(0);
        cli.setNombre("Selecciona un Cliente");
        datos.add(cli);
        try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()){
                    
                    cli = new Cliente();
                    cli.setIdrun(rs.getInt("idrun"));
                    cli.setNombre(rs.getString("nombre"));
                    datos.add(cli);
                    
                }   }
         } catch (SQLException e) {
            System.out.println("Error SQL al listar Producto por id" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Producto por id" + e.getMessage());
        }
        return datos;
    }
   

}
