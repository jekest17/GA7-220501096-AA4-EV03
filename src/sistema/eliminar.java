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
 * Clase que permite eliminar un sistema existente en el inventario de sistemas.
 * Realiza una eliminación en la base de datos según el ID del sistema especificado.
 *
 * @author jjer1
 */
public class eliminar {
    
    /**
     * Método principal que ejecuta el proceso de eliminación de un sistema.
     * Establece una conexión con la base de datos, elimina un sistema específico
     * y muestra todos los sistemas restantes.
     * 
     * @param args Argumentos de la línea de comandos.
     */
     public static void main (String[] args){
       // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir el ID del sistema a eliminar
     int idSistema_eliminar=2;
     
    // Definir la instrucción SQL para eliminar el sistema
    String sql= "DELETE fROM sistema where idSistema="+idSistema_eliminar;
     
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
    
    // Ejecutar la eliminación del sistema
    st.executeUpdate(sql);
    // Obtener y mostrar todos los sistemas restantes en la base de datos
    rs=st.executeQuery("SELECT * FROM sistema ");
    rs.next();
    
    do{
        // Imprimir detalles de cada sistema
    System.out.println("-"+rs.getString("idSistema")+"-"+rs.getString("Nombre")+"-"+rs.getString("Descripcion"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
