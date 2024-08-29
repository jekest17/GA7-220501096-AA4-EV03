/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recomendacion;
import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite agregar una nueva recomendación al sistema.
 * Realiza una inserción en la base de datos con los detalles de la recomendación.
 * 
 * @author jjer1
 */
public class agregar {
    
    /**
     * Método principal que ejecuta el proceso de agregar una nueva recomendación.
     * Establece una conexión con la base de datos, inserta los datos de la recomendación
     * y muestra todas las recomendaciones existentes.
     * 
     * @param args Argumentos de la línea de comandos.
     */
  public static void main (String[] args){
      // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir los valores para la nueva recomendación
    String Descripcion = "Implementar autenticación de dos factores";
    String NivelUrgencia = "Alto";
    String Amenaza_idAmenaza = "2";
    String sql = "INSERT INTO recomendacion (Descripcion, NivelUrgencia, Amenaza_idAmenaza) values ('"+Descripcion+"','"+NivelUrgencia+"','"+Amenaza_idAmenaza+"')";
    
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
    
    // Ejecutar la inserción de la nueva recomendación
    st.executeUpdate(sql);
    
     // Obtener y mostrar todas las recomendaciones actuales en la base de datos
    rs=st.executeQuery("SELECT * FROM recomendacion ");
    rs.next();
    
    do{
        // Imprimir detalles de cada recomendación
    System.out.println("-"+rs.getString("idRecomendacion")+"-"+rs.getString("Descripcion")+"-"+rs.getString("NivelUrgencia")+"-"+rs.getString("Amenaza_idAmenaza"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}

