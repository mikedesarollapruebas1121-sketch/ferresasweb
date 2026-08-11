package controller;

import connection.Conexion;
import model.Clientes;

import javax.swing.*;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientesController
{
    private Conexion conexion = new Conexion();

    //metodo agregar
    public void agregar(Clientes clientes)
    {
        Connection con = conexion.getConexion();

        String query = "INSERT INTO clientes (nombre, documento, telefono, direccion, correo) VALUES (?,?,?,?,?)";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, clientes.getNombre());
            pst.setString(2, clientes.getDocumento());
            pst.setString(3, clientes.getTelefono());
            pst.setString(4, clientes.getDireccion());
            pst.setString(5, clientes.getCorreo());

            int resultado = pst.executeUpdate();

            if(resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al agregar cliente");
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

        String query = "DELETE FROM clientes WHERE id_cliente = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);

            int resultado = pst.executeUpdate();

            if(resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar cliente");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void editar(Clientes clientes)
    {
        Connection con = conexion.getConexion();

        String query = "UPDATE clientes SET  nombre = ?, documento = ?, telefono = ?, direccion = ?, correo = ? WHERE id_cliente = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, clientes.getNombre());
            pst.setString(2, clientes.getDocumento());
            pst.setString(3, clientes.getTelefono());
            pst.setString(4, clientes.getDireccion());
            pst.setString(5, clientes.getCorreo());

            pst.setInt(6,clientes.getId_cliente());

            int resultado = pst.executeUpdate();

            if(resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al actualizar cliente");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Clientes> mostrar()
    {
        ArrayList<Clientes> listaClientes = new ArrayList<>();

        Connection con = conexion.getConexion();

        String query = "SELECT * FROM clientes";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();


            while(rs.next())
            {
                Clientes clientes = new Clientes(
                        rs.getString("correo"),
                        rs.getString("direccion"),
                        rs.getString("documento"),
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("telefono")
                );

                listaClientes.add(clientes);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return listaClientes;
    }
}