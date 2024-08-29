/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amenaza;
import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite agregar una nueva amenaza al sistema.
 * Realiza una inserción en la base de datos con los detalles de la amenaza.
 * 
 * @author jjer1
 */
public class agregar {
    
    /**
     * Método principal que ejecuta el proceso de agregar una nueva amenaza.
     * Establece una conexión con la base de datos, realiza la inserción de datos
     * y muestra las amenazas existentes.
     * 
     * @param args Argumentos de la línea de comandos.
     */
  public static void main (String[] args){
      // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    // Definir los valores para la nueva amenaza
    String Descripcion = "Malware en el sistema";
    String NivelRiesgo = "Alto";
    String Analisis_idAnalisis = "3";
    String sql = "INSERT INTO amenaza (Descripcion, NivelRiesgo, Analisis_idAnalisis) values ('"+Descripcion+"','"+NivelRiesgo+"','"+Analisis_idAnalisis+"')";
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
    // Ejecutar la inserción de la nueva amenaza
    st.executeUpdate(sql);
    
    // Obtener y mostrar las amenazas actuales en la base de datos
    rs=st.executeQuery("SELECT * FROM amenaza ");
    rs.next();
    
    do{
        // Imprimir detalles de cada amenaza
    System.out.println("-"+rs.getString("idAmenaza")+"-"+rs.getString("Descripcion")+"-"+rs.getString("NivelRiesgo")+"-"+rs.getString("Analisis_idAnalisis"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}

