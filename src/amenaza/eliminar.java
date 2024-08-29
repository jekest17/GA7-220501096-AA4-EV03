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
 * Clase que permite eliminar una amenaza existente en el sistema.
 * Realiza una eliminación en la base de datos según el ID de la amenaza especificada.
 * 
 * @author jjer1
 */
public class eliminar {
    
    /**
     * Método principal que ejecuta el proceso de eliminación de una amenaza.
     * Establece una conexión con la base de datos, elimina una amenaza específica 
     * y muestra todas las amenazas restantes.
     * 
     * @param args Argumentos de la línea de comandos.
     */
     public static void main (String[] args){
         // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    // Definir el ID de la amenaza a eliminar 
     int idAmenaza_eliminar=3;
     
     // Definir la instrucción SQL para eliminar la amenaza  
     String sql= "DELETE fROM amenaza where idAmenaza="+idAmenaza_eliminar;
     
     try{
         // Cargar el driver de MySQL
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        // Manejar la excepción si el driver no es encontrado
        Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
        // Obtener la conexión a la base de datos
    cn=con.getConection();
    st=cn.createStatement();
    
    // Ejecutar la eliminación de la amenaza
    st.executeUpdate(sql);
    
    // Obtener y mostrar todas las amenazas restantes en la base de datos
    rs=st.executeQuery("SELECT * FROM amenaza ");
    rs.next();
    
    do{
        // Imprimir detalles de cada amenaza
   System.out.println("-"+rs.getString("idAmenaza")+"-"+rs.getString("Descripcion")+"-"+rs.getString("NivelRiesgo")+"-"+rs.getString("Analisis_idAnalisis"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
