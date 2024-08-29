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
 * Clase que permite editar una recomendación existente en el sistema.
 * Realiza una actualización en la base de datos con los nuevos detalles de la recomendación.
 *
 * @author jjer1
 */
public class editar {
    
    /**
     * Método principal que ejecuta el proceso de edición de una recomendación.
     * Establece una conexión con la base de datos, actualiza los datos de una recomendación
     * específica y muestra todas las recomendaciones actuales.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    
     public static void main (String[] args){
         // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir el ID de la recomendación a editar y los nuevos valores
    int idRecomendacion_editar=1;
    String new_Descripcion = "Configurar firewall";
    String new_NivelUrgencia = "Alto";
    String new_Amenaza_idAmenaza = "4";
    
    // Definir la instrucción SQL para actualizar la recomendación
    String sql = "UPDATE recomendacion set Descripcion='"+new_Descripcion+"',NivelUrgencia='"+new_NivelUrgencia+"',Amenaza_idAmenaza='"+new_Amenaza_idAmenaza+"' where idRecomendacion="+idRecomendacion_editar;
   
    try{
        // Cargar el driver de MySQL
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
         // Manejar la excepción si el driver no es encontrado
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
        // Obtener la conexión a la base de datos
    cn=con.getConection();
    st=cn.createStatement();
    
    // Ejecutar la actualización de la recomendación
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
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
