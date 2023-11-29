
package CONTROLAR;

import MODELO.Conexion;
import MODELO.Movie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos 
{
    //VARIABLES LOCALES
    Movie m;
    Conexion conn = new Conexion();
    Connection con;
    Statement st;
    //FIN VARIABLES LOCALES
    
    
    public Movie validarCampos(String t, String dd, String a, String du, String g)
    {
        String campoVacio = "";
        String campoNumerico = "";
        if (t.trim().equals("")||t.equals(null)) 
        {
            campoVacio = campoVacio + "\n-TITULO-";
        }
        if (dd.trim().equals("")||dd.equals(null)) 
        {
            campoVacio = campoVacio + "\n-DIRECTOR-";
        }
        if (a.trim().equals("")||a.equals(null)) 
        {
            campoVacio = campoVacio + "\n-AÑO-";
        }
        if (du.trim().equals("")||du.equals(null)) 
        {
            campoVacio = campoVacio + "\n-DURACIÓN-";
        }
        if (g.trim().equals("GENERO")) 
        {
            campoVacio = campoVacio + "\n-SELECCIONE UNA OPCIÓN EN GENERO-";
        }
        //FIN DE VALIDAR CAMPOS VACIOS
        if (campoVacio.equals("")) 
        {
            //verificando que el campo año y duracion sea numerico
            try
            {
                int aa = Integer.parseInt(a);
            }catch(Exception ee)
            {
                campoNumerico = campoNumerico + "\n-AÑO-";
            }          
            try
            {
                int dur = Integer.parseInt(du);
            }catch(Exception ee)
            {
                campoNumerico = campoNumerico + "\n-DURACIÓN-";
            }
            //Fin verificacion numerica
            if (campoNumerico.equals("")) 
            {
                //VALIDAMOS QUE NO SE INGRESEN NUMEROS DECIMALES
                int validarDecimal = 0;
                for (int i = 0; i < a.length(); i++) 
                {
                    if (a.substring(i).equals(".")||a.substring(i).equals(",")) 
                    {
                        validarDecimal = validarDecimal +1;
                    }
                }// fin for de la variable año
                
                for (int i = 0; i < du.length(); i++) 
                {
                    if (du.substring(i).equals(".")||du.substring(i).equals(",")) 
                    {
                        validarDecimal = validarDecimal +2;
                    }
                }// fin for de la variable duracion
                
                if (validarDecimal > 0) 
                {
                    if (validarDecimal == 1) {
                        JOptionPane.showMessageDialog(null, "\nNo se Pueden ingresar Numeros Decimales en el Campo AÑO");
                    }
                    if (validarDecimal == 2) {
                        JOptionPane.showMessageDialog(null, "\nNo se pueden ingresar numeros decimales en campo DURACIÓN.");
                    }
                    if (validarDecimal == 3) {
                        JOptionPane.showMessageDialog(null, "\nNo se pueden ingresar numeros decimales...");
                    }
                    return null;
                //FIN VALIDAR DECIMALES
                }else
                {
                    //AQUI SE PARSEAN LOS CAMPOS NUMERICOS
                    int aa = Integer.parseInt(a);
                    int dur = Integer.parseInt(du);
                    //VAMOS A VALIDAR QUE LOS DATOS INGRESADOS SEAN REALES
                    LocalDate hoy = LocalDate.now();
                    String datosFalsos = "";
                    if (aa<1895 || aa>hoy.getYear()) 
                    {
                        datosFalsos = datosFalsos + "\n-AÑO-";
                    }
                    if (dur<30 || dur>280) 
                    {
                        datosFalsos = datosFalsos + "\n-DURACIÓN-";
                    }
                    //FIN VALIDAR DATOS FALSOS
                    if (datosFalsos.equals("")) 
                    {
                        m = new Movie(t, dd, g, aa, dur);
                        return m;
                    }
                    else
                    {
                        String mensaje = "Ingrese datos reales en el/los campos siguientes: "+datosFalsos;
                        JOptionPane.showMessageDialog(null, mensaje);
                        return null;
                    }
                }
            }else
            {
                String mensaje = "Limitese a ingresar solo números en el/los campos: "+campoNumerico;
                JOptionPane.showMessageDialog(null, mensaje);
                return null;
            }
            
        }else
        {
            String mensaje = "No se Aceptan Campos vacios, Complete los siguientes campos: "+campoVacio;
            JOptionPane.showMessageDialog(null, mensaje);
            return null;
        }
        
    }// metodo validar campos
    
    public int ingresarPelicula(Movie mm)
    {
        String t = mm.getTitulo().toUpperCase();
        String dd = mm.getDirector().toUpperCase();
        String g = mm.getGenero().toUpperCase();
        int du = mm.getDuracion();
        int a = mm.getAnio();
        int ingresar = 0;
        String query = "insert into movie values(null,'"+t+"','"+dd+"',"+a+","+du+",'"+g+"')";
        try
        {
            con = conn.conectar();
            st = con.createStatement();
            ingresar = st.executeUpdate(query);
            conn.desconectar();
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ingresar;
    }//metodo ingresar pelicula
    
    public DefaultTableModel MostrarTodos()
    {
        String query = "select id,titulo,director,genero,anio,duracion from movie order by genero asc";
        DefaultTableModel modelo = new DefaultTableModel();
        try
        {
            con = conn.conectar();
            //El siguiente contenido entre parentesis del ST, nos permite volver atras y/o adelantar filas
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = st.executeQuery(query);
            
            //creamos las columnas
            modelo.addColumn("ID");
            modelo.addColumn("TITULO");
            modelo.addColumn("DIRECTOR");
            modelo.addColumn("GENERO");
            modelo.addColumn("AÑO");
            modelo.addColumn("DURACIÓN");
            if (!res.next()) //aqui validamos que la tabla tenga datos
            {
                JOptionPane.showMessageDialog(null, "No hay datos en la tabla movie");  
                return modelo;
            }
                //el siguiente codigo, nos permite comenzar de nuevo la consulta res, ya que fue utilizada en el if
                res.beforeFirst();
                while(res.next())
                {
                    //aqui creamos un array para crear las filas
                    Object fila[] = new Object[6];// aqui le indicamos el largo de la fila
                    fila[0] = res.getString("id");
                    fila[1] = res.getString("titulo");
                    fila[2] = res.getString("director");
                    fila[3] = res.getString("genero");
                    fila[4] = res.getInt("anio");
                    fila[5] = res.getInt("duracion")+" Minutos";
                    modelo.addRow(fila);//aqui agregamos la fila a la tabla que ya tiene sus columnas
                }
            
            conn.desconectar();
            return modelo;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       return modelo;
       
    }// metodo mostrar todos
    
    public DefaultTableModel filtrarGenero(String g)
    {
        String query = "select titulo,director,genero,anio,duracion from movie where genero = '"+g+"'";
        DefaultTableModel modelo = new DefaultTableModel();
        try
        {
            con = conn.conectar();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //Lo que esta adentro del "()" sirve para contener un error que se produce con el codigo mas abajo
            ResultSet res = st.executeQuery(query);
            
            //creamos las columnas
            modelo.addColumn("TITULO");
            modelo.addColumn("DIRECTOR");
            modelo.addColumn("GENERO");
            modelo.addColumn("AÑO");
            modelo.addColumn("DURACIÓN");
            if (!res.next()) //aqui validamos que la tabla tenga datos
            {
                JOptionPane.showMessageDialog(null, "No existen Peliculas del Genero: " +g);
                return modelo;
            }
                res.beforeFirst();
                while(res.next())   
                {
                    //aqui creamos un array para crear las filas
                    Object fila[] = new Object[5];// aqui le indicamos el largo de la fila
                    fila[0] = res.getString("titulo");
                    fila[1] = res.getString("director");
                    fila[2] = res.getString("genero");
                    fila[3] = res.getInt("anio");
                    fila[4] = res.getInt("duracion")+" Minutos";
                    modelo.addRow(fila);//aqui agregamos la fila a la tabla que ya tiene sus columnas
                }
            
            conn.desconectar();
            return modelo;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       return modelo;
    }//Fin del filtrar por genero
    
    public int validarCamposFiltrar(String a1, String a2)
    {
        
        String campoVacio = "";
        String campoNumerico = "";
        if (a1.trim().equals("")||a1.equals(null))
        {
            campoVacio = campoVacio+"\n-AÑO DESDE-";
        }
        
        if (a2.trim().equals("")||a2.equals(null)) 
        {
            campoVacio = campoVacio + "\n-AÑO HASTA-";
        }
        
        if (campoVacio.trim().equals("")) 
        {
            try
            {
                int aa1 = Integer.parseInt(a1);
            }catch(Exception ee)
            {
                campoNumerico = campoNumerico + "\n-AÑO DESDE-";
            }          
            try
            {
                int aa2 = Integer.parseInt(a2);
            }catch(Exception ee)
            {
                campoNumerico = campoNumerico + "\n-AÑO HASTA-";
            }
            
            if (campoNumerico.trim().equals(""))
            {
                int aa1 = Integer.parseInt(a1);
                int aa2 = Integer.parseInt(a2);
                int validarAnioReal = 0;
                String real = "";
                LocalDate fecha = LocalDate.now();
                if (aa1<1895 ||aa1>fecha.getYear()) 
                {
                    validarAnioReal = validarAnioReal +1;
                    real = real + "\n-AÑO DESDE-";
                }
                if (aa2<1895 || aa2>fecha.getYear()) 
                {
                    validarAnioReal = validarAnioReal +2;
                    real = real + "\n-AÑO HASTA-";
                }
                
                if (validarAnioReal>0) 
                {
                    String mensaje = "Ingrese un año real en el/los campos: " +real;
                    JOptionPane.showMessageDialog(null, mensaje);
                }else
                {
                    String error = "";
                    if (aa1>aa2) 
                    {
                        error = error+"\n-AÑO DESDE DEBE SER MAYOR QUE AÑO HASTA-";
                    }
                    if (aa2<aa1) 
                    {
                        error = error + "\n-Año HASTA debe ser mayor que año DESDE-";
                    }
                    if (aa1==aa2) 
                    {
                        error = "\n-RANGO ENTRE FECHAS DEBE SER MINIMO DE 1 DE DIFERENCIA-";
                    }
                    
                    if (error.trim().equals("")) 
                    {
                        return 1;
                    }else
                    {
                        String mensaje = "Favor respetar las siguientes reglas: " + error;
                        JOptionPane.showMessageDialog(null, mensaje);
                    }
                }
            }else
            {
                String mensaje = "Ingrese solo Numeros en el/los campos: " + campoNumerico;
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }else
        {
            String mensaje = "Complete el/los campos vacios: " +campoVacio;
            JOptionPane.showMessageDialog(null, mensaje);
        }
        
        return 0;
    }//fin validar campos filtrar
    
    public DefaultTableModel filtrarPorFecha(int a1 , int a2)
    {
        String query = "select titulo,director,genero,anio,duracion from movie where anio between "+a1+" and "+a2+"";
        DefaultTableModel modelo = new DefaultTableModel();
        try
        {
            con = conn.conectar();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //Lo que esta adentro del "()" sirve para contener un error que se produce con el codigo mas abajo
            ResultSet res = st.executeQuery(query);
            
            //creamos las columnas
            modelo.addColumn("TITULO");
            modelo.addColumn("DIRECTOR");
            modelo.addColumn("GENERO");
            modelo.addColumn("AÑO");
            modelo.addColumn("DURACIÓN");
            if (!res.next()) //aqui validamos que la tabla tenga datos
            {
                JOptionPane.showMessageDialog(null, "No existen Peliculas entre los años :  "+a1+" y "+a2);
                return modelo;
            }
                res.beforeFirst();
                while(res.next())   
                {
                    //aqui creamos un array para crear las filas
                    Object fila[] = new Object[5];// aqui le indicamos el largo de la fila
                    fila[0] = res.getString("titulo");
                    fila[1] = res.getString("director");
                    fila[2] = res.getString("genero");
                    fila[3] = res.getInt("anio");
                    fila[4] = res.getInt("duracion")+" Minutos";
                    modelo.addRow(fila);//aqui agregamos la fila a la tabla que ya tiene sus columnas
                }
            
            conn.desconectar();
            return modelo;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       return modelo;
    }//fin filtrar por fecha
    
    public int ActualizarPelicula(Movie mm, int id)
    {
         String t = mm.getTitulo();
        String dd = mm.getDirector();
        String g = mm.getGenero();
        int du = mm.getDuracion();
        int a = mm.getAnio();
        int ingresar = 0;
        String query = "update movie set"
                + " titulo = '"+t+"' ,"
                + " director = '"+dd+"',"
                + " genero = '"+g+"', "
                + "anio ="+a+" "
                + ",duracion ="+du+" "
                + "where id = "+id+"";
        try
        {
            con = conn.conectar();
            st = con.createStatement();
            ingresar = st.executeUpdate(query);
            conn.desconectar();
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ingresar;
    }// FIN METODO ACTUALIZAR
    
    public int EliminarPelicula(int id)
    {
         
        int eliminar = 0;
        String query = "delete from movie where id = "+id+";";
        try
        {
            con = conn.conectar();
            st = con.createStatement();
            eliminar = st.executeUpdate(query);
            conn.desconectar();
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return eliminar;
    }
    
    
    
}//Metodos
