/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import modelo.Cliente;
import modelo.Producto;
import modelo.Venta;
import modelo.detVenta;

/**
 *
 * @author JoTa
 */

public class Registro {
    
 /**
 *
 * Metodos Producto
 */

    public boolean agregarProducto(Producto p) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
            
            String query = "INSERT INTO producto(nombre, perecible, precio, disponible) VALUES (?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, p.getNombre());
            stmt.setBoolean(2, p.isPerecible());
            stmt.setInt(3, p.getPrecio());
            stmt.setBoolean(4, p.isDisponible());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Producto" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Producto" + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProdcto(int idproducto) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM producto WHERE idproducto=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idproducto);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar Producto" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar Producto" + e.getMessage());
            return false;
        }
    }
    
    
    
    public Producto buscarPorNombreProducto(String nombre) {
             Producto p = new Producto();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idproducto, nombre, perecible, precio, disponible FROM producto WHERE nombre=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombre);
            
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setPerecible(rs.getBoolean("perecible"));
                p.setPrecio(rs.getInt("precio"));
                p.setDisponible(rs.getBoolean("disponible"));
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Producto por id" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Producto por id" + e.getMessage());
        }
        return p;
    } 
    
    public Producto buscarPorIdProducto(int idproducto) {
        Producto p = new Producto();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idproducto, nombre, perecible, precio, disponible FROM producto WHERE idproducto=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idproducto);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setPerecible(rs.getBoolean("perecible"));
                p.setPrecio(rs.getInt("precio"));
                p.setDisponible(rs.getBoolean("disponible"));

            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Producto por id" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Producto por id" + e.getMessage());
        }
        return p;
    }

    public List<Producto> buscarTodosProductos() {
        List<Producto> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT nombre, perecible, precio, disponible FROM producto order by nombre";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Producto Producto = new Producto();
                Producto.setNombre(rs.getString("nombre"));
                Producto.setPerecible(rs.getBoolean("perecible"));
                Producto.setPrecio(rs.getInt("precio"));
                Producto.setDisponible(rs.getBoolean("disponible"));

                lista.add(Producto);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Productos" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Productos" + e.getMessage());
        }
        return lista;
    }

/**
 *
 * Metodos Cliente
 */
    
    public boolean agregarCliente(Cliente c) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
            
            String query = "INSERT INTO cliente (idrun,dvrun,nombre,appaterno,apmaterno,telefono) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, c.getIdrun());
            stmt.setString(2, c.getDvrun());
            stmt.setString(3, c.getNombre());
            stmt.setString(4, c.getAppaterno());
            stmt.setString(5, c.getApmaterno());
            stmt.setInt(6, c.getTelefono());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Cliente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Cliente" + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCliente(int idrun) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM cliente WHERE idrun=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idrun);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar Cliente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar Cliente" + e.getMessage());
            return false;
        }
    }

    public Cliente buscarPorIdCliente(int idrun) {
        Cliente c = new Cliente();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idrun,dvrun,nombre,appaterno,apmaterno,telefono FROM cliente WHERE idrun=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idrun);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                c.setIdrun(rs.getInt("idrun"));
                c.setDvrun(rs.getString("dvrun"));
                c.setNombre(rs.getString("nombre"));
                c.setAppaterno(rs.getString("appaterno"));
                c.setApmaterno(rs.getString("apmaterno"));
                c.setTelefono(rs.getInt("telefono"));

            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Cliente por idrun" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Cliente por idrun" + e.getMessage());
        }
        return c;
    }

    public List<Cliente> buscarTodosClientes() {
        List<Cliente> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idrun,dvrun,nombre,appaterno,apmaterno,telefono FROM cliente order by nombre";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdrun(rs.getInt("idrun"));
                c.setDvrun(rs.getString("dvrun"));
                c.setNombre(rs.getString("nombre"));
                c.setAppaterno(rs.getString("appaterno"));
                c.setApmaterno(rs.getString("apmaterno"));
                c.setTelefono(rs.getInt("telefono"));

                lista.add(c);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Cliente" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Cliente" + e.getMessage());
        }
        return lista;
    } 
    
   /**
 *
 * Metodos Venta
 */
  
    public boolean agregarVenta(Venta v) {
         Date date;
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
            date = v.getFecha();
            
            String query = "INSERT INTO venta(fecha,idrun,preciototal,efectivo) VALUES (?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setDate(1, new java.sql.Date(date.getTime()));
            stmt.setInt(2, v.getIdrun());
            stmt.setInt(3, v.getPreciototal());
            stmt.setBoolean(4, v.isEfectivo());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Venta" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Venta" + e.getMessage());
            return false;
        }
    }

    public boolean eliminarVenta(int idventa) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM detventa WHERE idventa=?";
            String query2 = "DELETE FROM venta WHERE idventa=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            PreparedStatement stmt2 = cnx.prepareStatement(query2);
            stmt.setInt(1, idventa);
            stmt2.setInt(1, idventa);

            stmt.executeUpdate();
            stmt.close();
            stmt2.executeUpdate();
            stmt2.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar Venta" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar Venta" + e.getMessage());
            return false;
        }
    }

    public Venta buscarPorIdVenta(int idventa) {
        Venta v = new Venta();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idventa,fecha,ven.idrun, CONCAT(cli.nombre,\" \",cli.appaterno,\" \",cli.apmaterno) \"nombre\",preciototal,efectivo FROM venta ven JOIN cliente cli on (ven.idrun = cli.idrun)  where ven.idventa = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idventa);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                v.setIdventa(rs.getInt("idventa"));
                v.setFecha(rs.getDate("fecha"));
                v.setNombre(rs.getString("nombre"));
                v.setPreciototal(rs.getInt("preciototal"));
                v.setEfectivo(rs.getBoolean("efectivo"));
                v.setIdrun(rs.getInt("ven.idrun"));


            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Venta por idventa" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Venta por idventa" + e.getMessage());
        }
        return v;
    }
    
    public List<Venta> buscarTodasVentas() {
        List<Venta> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idventa,fecha, CONCAT(cli.nombre,\" \",cli.appaterno,\" \",cli.apmaterno) \"nombre\",preciototal,efectivo FROM venta ven JOIN cliente cli on (ven.idrun = cli.idrun) order by ven.idventa;";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Venta v = new Venta();
                v.setIdventa(rs.getInt("idventa"));
                v.setFecha(rs.getDate("fecha"));
                v.setNombre(rs.getString("nombre"));
                v.setPreciototal(rs.getInt("preciototal"));
                v.setEfectivo(rs.getBoolean("efectivo"));

                lista.add(v);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Ventas" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Ventas" + e.getMessage());
        }
        return lista;
    }     

    public List<Venta> ultimaboleta() {
        List<Venta> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT MAX(idventa)FROM venta;";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Venta v = new Venta();
                v.setIdventa(rs.getInt("MAX(idventa)"));
                lista.add(v);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Ventas" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Ventas" + e.getMessage());
        }
        return lista;
    }     

 /**
 *
 * Metodos detVenta
     * @param dV
     * @return 
 */
  
    public boolean agregardetVenta(detVenta dV) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
            
            String query = "INSERT INTO detventa(idventa, idproducto, cantidad, preciouni) VALUES (?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, dV.getIdventa());
            stmt.setInt(2, dV.getIdproducto());
            stmt.setInt(3, dV.getCantidad());
            stmt.setInt(4, dV.getPreciouni());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Detalle Venta" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Detalle Venta" + e.getMessage());
            return false;
        }
    }
    
    public List<detVenta> buscarPorIdVentaDetVenta(int idventa) {
        List<detVenta> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idventa, pro.nombre \"nombrePro\", cantidad, preciouni FROM detventa dv JOIN producto pro ON (dv.idproducto = pro.idproducto) where idventa = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idventa);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                detVenta dv = new detVenta();
                dv.setIdventa(rs.getInt("idventa"));
                dv.setNombrepro(rs.getString("nombrePro"));
                dv.setCantidad(rs.getInt("cantidad"));
                dv.setPreciouni(rs.getInt("preciouni"));

                lista.add(dv);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar Ventas" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Ventas" + e.getMessage());
        }
        return lista;        
    }
}

