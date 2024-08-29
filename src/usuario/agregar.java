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
 * Clase que permite agregar un nuevo usuario al sistema.
 * Realiza una inserción en la base de datos con los detalles del usuario.
 *
 * @author jjer1
 */
public class agregar {
    
    /**
     * Método principal que ejecuta el proceso de agregar un nuevo usuario.
     * Establece una conexión con la base de datos, inserta los datos del usuario
     * y muestra todos los usuarios existentes en la base de datos.
     * 
     * @param args Argumentos de la línea de comandos.
     */
  public static void main (String[] args){
    // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir los valores para el nuevo usuario
    String Nombre = "Jessica";
    String Correo_Electronico = "jjjaaaaaauusssuua@hotmail.com";
    String Contraseña = "28";
    String Rol = "Usuario";
    String sql = "INSERT INTO usuario (Nombre, Correo_Electronico, Contraseña, Rol) values ('"+Nombre+"','"+Correo_Electronico+"','"+Contraseña+"','"+Rol+"')";
    
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
    
    // Ejecutar la inserción del nuevo usuario
    st.executeUpdate(sql);
    
    rs=st.executeQuery("SELECT * FROM usuario ");
    // Obtener y mostrar todos los usuarios actuales en la base de datos
    rs.next();
    
    do{
        // Imprimir detalles de cada usuario
    System.out.println("-"+rs.getString("idUsuario")+"-"+rs.getString("Nombre")+"-"+rs.getString("Correo_Electronico")+"-"+rs.getString("Contraseña")+"-"+rs.getString("Rol"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}

