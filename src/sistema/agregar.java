/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;
import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite agregar un nuevo sistema al inventario de sistemas.
 * Realiza una inserción en la base de datos con los detalles del sistema.
 *
 * @author jjer1
 */
public class agregar {
    
   /**
     * Método principal que ejecuta el proceso de agregar un nuevo sistema.
     * Establece una conexión con la base de datos, inserta los datos del sistema
     * y muestra todos los sistemas existentes en la base de datos.
     * 
     * @param args Argumentos de la línea de comandos.
     */ 
    
  public static void main (String[] args){
      // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir los valores para el nuevo sistema
    String Nombre = "CyberProtect";
    String Descripcion = "Herramienta de analisis de vulnerabilidades";
    String sql = "INSERT INTO sistema (Nombre, Descripcion) values ('"+Nombre+"','"+Descripcion+"')";
    
    try{
        // Cargar el driver de MySQL
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        // Manejar la excepción si el driver no es encontrado
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
        // Obtener la conexión a la base de datos
    cn=con.getConection();
    st=cn.createStatement();
    
    // Ejecutar la inserción del nuevo sistema
    st.executeUpdate(sql);
    
     // Obtener y mostrar todos los sistemas actuales en la base de datos
    rs=st.executeQuery("SELECT * FROM sistema ");
    rs.next();
    
    do{
        // Imprimir detalles de cada sistema
    System.out.println("-"+rs.getString("idSistema")+"-"+rs.getString("Nombre")+"-"+rs.getString("Descripcion"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
         // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}


