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
 * Clase que permite consultar todos los usuarios existentes en el sistema.
 * Realiza una consulta en la base de datos y muestra los detalles de todos los usuarios.
 *
 * @author jjer1
 */
public class consultar {
    
    /**
     * Método principal que ejecuta el proceso de consulta de usuarios.
     * Establece una conexión con la base de datos y muestra todos los usuarios actuales.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main (String[] args){
       // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    try{
        // Cargar el driver de MySQL
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        // Manejar la excepción si el driver no es encontrado
        Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
        // Obtener la conexión a la base de datos
    cn=con.getConection();
    st=cn.createStatement();
      // Ejecutar la consulta de todos los usuarios
      rs=st.executeQuery("SELECT * FROM usuario ");
    rs.next();
    
    do{
        // Imprimir detalles de cada usuario
    System.out.println("-"+rs.getString("idUsuario")+"-"+rs.getString("Nombre")+"-"+rs.getString("Correo_Electronico")+"-"+rs.getString("Contraseña")+"-"+rs.getString("Rol"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Imprimir detalles de cada usuario
        Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
