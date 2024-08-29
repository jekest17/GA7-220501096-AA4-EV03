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
 * Clase que permite editar un sistema existente en el inventario de sistemas.
 * Realiza una actualización en la base de datos con los nuevos detalles del sistema.

 *
 * @author jjer1
 */
public class editar {
    
    /**
     * Método principal que ejecuta el proceso de edición de un sistema.
     * Establece una conexión con la base de datos, actualiza los datos de un sistema
     * específico y muestra todos los sistemas actuales.
     * 
     * @param args Argumentos de la línea de comandos.
     */
     public static void main (String[] args){
        // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir el ID del sistema a editar y los nuevos valores
    int idSistema_editar=1;
    String new_Nombre = "ShieldGuard";
    String new_Descripcion = "Sistema de monitoreo de intrusiones";
    
    // Definir la instrucción SQL para actualizar el sistema
    String sql = "UPDATE sistema set Nombre='"+new_Nombre+"',Descripcion='"+new_Descripcion+"' where idSistema="+idSistema_editar;
    
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
    
    // Ejecutar la actualización del sistema
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
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
