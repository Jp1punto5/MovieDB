
package MODELO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
  private final String url = "jdbc:mysql://localhost:3306/moviesdb?zeroDateTimeBehavior=CONVERT_TO_NULL";
  private final String driver = "com.mysql.cj.jdbc.Driver";
  private final String user = "root";
  private final String password = "";
  
  public Connection cadena;

    public Conexion() {
        this.cadena = null;
    }
    
     public Connection conectar()
    {
        try
        {
            Class.forName(driver);
            this.cadena = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage()+" Este error es por que no se puede conectar");
            System.exit(0);
        }
        return cadena;
    }// fin metodo conectar
     
      public void desconectar()
    {
        try
        {
            this.cadena.close();
        } catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }// fin metodo desconectar
}
