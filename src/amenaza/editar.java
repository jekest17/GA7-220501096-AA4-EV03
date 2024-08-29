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
 * Clase que permite editar una amenaza existente en el sistema.
 * Realiza una actualización en la base de datos con los nuevos detalles de la amenaza.
 *
 * @author jjer1
 */
public class editar {
    
     /**
     * Método principal que ejecuta el proceso de edición de una amenaza.
     * Establece una conexión con la base de datos, actualiza los datos de una amenaza
     * y muestra todas las amenazas actuales.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main (String[] args){
        // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir los valores para la edición de la amenaza
    int idAmenaza_editar=2;
    String new_Descripcion = "Phishing en correos electrónicos";
    String new_NivelRiesgo = "Alto";
    String new_Analisis_idAnalisis = "1";
    String sql = "UPDATE amenaza set Descripcion='"+new_Descripcion+"',NivelRiesgo='"+new_NivelRiesgo+"',Analisis_idAnalisis='"+new_Analisis_idAnalisis+"' where idAmenaza="+idAmenaza_editar;
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
    
    // Ejecutar la actualización de la amenaza
    st.executeUpdate(sql);
    
    // Obtener y mostrar todas las amenazas actuales
    rs=st.executeQuery("SELECT * FROM amenaza ");
    rs.next();
    
    do{
        // Imprimir detalles de cada amenaza
    System.out.println("-"+rs.getString("idAmenaza")+"-"+rs.getString("Descripcion")+"-"+rs.getString("NivelRiesgo")+"-"+rs.getString("Analisis_idAnalisis"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
