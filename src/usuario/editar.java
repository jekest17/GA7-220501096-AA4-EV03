/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;
import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase que permite editar un usuario existente en el sistema.
 * Realiza una actualización en la base de datos con los nuevos detalles del usuario.
 *
 * @author jjer1
 */
public class editar {
    
    /**
     * Método principal que ejecuta el proceso de edición de un usuario.
     * Establece una conexión con la base de datos, actualiza los datos de un usuario
     * específico y muestra todos los usuarios actuales.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    
     public static void main (String[] args){
     // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir el ID del usuario a editar y los nuevos valores
    int idUsuario_editar=11;
    String new_Nombre = "Th2";
    String new_Correo_Electronico = "thing21254@gmail.com";
    String new_Contraseña = "123446";
    String new_Rol = "Usuario";
    
    // Definir la instrucción SQL para actualizar el usuario
    String sql = "UPDATE usuario set Nombre='"+new_Nombre+"',Correo_Electronico='"+new_Correo_Electronico+"',Contraseña='"+new_Contraseña+"',Rol='"+new_Rol+"' where idUsuario="+idUsuario_editar;
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
    
    // Ejecutar la actualización del usuario
    st.executeUpdate(sql);
    
    // Obtener y mostrar todos los usuarios actuales en la base de datos
    rs=st.executeQuery("SELECT * FROM usuario ");
    rs.next();
    
    do{
        // Imprimir detalles de cada usuario
    System.out.println("-"+rs.getString("idUsuario")+"-"+rs.getString("Nombre")+"-"+rs.getString("Correo_Electronico")+"-"+rs.getString("Contraseña")+"-"+rs.getString("Rol"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
