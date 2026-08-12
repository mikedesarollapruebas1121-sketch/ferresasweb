package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public Connection getConexion() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tienda",
                    "root",
                    ""
            );

            System.out.println("Conexión a MySQL exitosa");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return con;
    }
}