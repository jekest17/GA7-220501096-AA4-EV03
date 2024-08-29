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
 * Clase que permite eliminar una recomendación existente en el sistema.
 * Realiza una eliminación en la base de datos según el ID de la recomendación especificada.
 *
 * @author jjer1
 */
public class eliminar {
    
    /**
     * Método principal que ejecuta el proceso de eliminación de una recomendación.
     * Establece una conexión con la base de datos, elimina una recomendación específica
     * y muestra todas las recomendaciones restantes.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    
     public static void main (String[] args){
         // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir el ID de la recomendación a eliminar
     int idRecomendacion_eliminar=3;
     
    // Definir la instrucción SQL para eliminar la recomendación
     
     String sql= "DELETE fROM recomendacion where idRecomendacion="+idRecomendacion_eliminar;
     
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
    
    // Ejecutar la eliminación de la recomendación
    st.executeUpdate(sql);
    
     // Obtener y mostrar todas las recomendaciones restantes en la base de datos
    rs=st.executeQuery("SELECT * FROM recomendacion ");
    rs.next();
    
    do{
        // Imprimir detalles de cada recomendación
    System.out.println("-"+rs.getString("idRecomendacion")+"-"+rs.getString("Descripcion")+"-"+rs.getString("NivelUrgencia")+"-"+rs.getString("Amenaza_idAmenaza"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}

