package connection;

import java.sql.Connection;

public class TestConexion {

    public static void main(String[] args) {

        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();

        if (con != null) {
            System.out.println("MYSQL CONECTADO CORRECTAMENTE");
        } else {
            System.out.println("NO SE PUDO CONECTAR A MYSQL");
        }
    }
}