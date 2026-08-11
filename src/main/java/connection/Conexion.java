package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion
{
    public Connection getConexion()
    {
        Connection con = null;

        try
        {
            //ustedes deben tenerlo asi
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda","root","");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }
}