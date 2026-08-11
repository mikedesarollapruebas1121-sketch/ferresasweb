package controller;

import connection.Conexion;
import model.Productos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductosController
{
    private Conexion conexion = new Conexion();

    //metodo agregar
    public void agregar(Productos productos)
    {
        Connection con = conexion.getConexion();

        String query = "INSERT INTO productos (nombre, descripcion, precio, stock, id_categorias) VALUES (?,?,?,?,?)";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, productos.getNombre());
            pst.setString(2, productos.getDescripcion());
            pst.setDouble(3, productos.getPrecio());
            pst.setInt(4, productos.getStock());
            pst.setInt(5, productos.getId_categorias());

            int resultado = pst.executeUpdate();

            if(resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al agregar producto");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void eliminar(int id)
    {
        Connection con = conexion.getConexion();

        String query = "DELETE FROM productos WHERE id_producto = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            int resultado = pst.executeUpdate();

            if(resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void editar(Productos productos)
    {
        Connection con = conexion.getConexion();

        String query = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, stock = ?, id_categorias = ? WHERE id_producto = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, productos.getNombre());
            pst.setString(2, productos.getDescripcion());
            pst.setDouble(3, productos.getPrecio());
            pst.setInt(4, productos.getStock());
            pst.setInt(5, productos.getId_categorias());
            pst.setInt(6, productos.getId_producto());

            int resultado = pst.executeUpdate();

            if(resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al actualizar producto");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Productos> mostrar()
    {
        ArrayList<Productos> listaProductos = new ArrayList<>();

        Connection con = conexion.getConexion();

        String query = "SELECT * FROM productos";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                Productos productos = new Productos(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getInt("id_categorias")
                );

                listaProductos.add(productos);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return listaProductos;
    }
}