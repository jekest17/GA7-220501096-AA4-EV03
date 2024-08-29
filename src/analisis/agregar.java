/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisis;
import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite agregar un nuevo análisis al sistema.
 * Realiza una inserción en la base de datos con los detalles del análisis.
 *
 * @author jjer1
 */
public class agregar {
    
    /**
     * Método principal que ejecuta el proceso de agregar un nuevo análisis.
     * Establece una conexión con la base de datos, inserta los datos de análisis
     * y muestra todos los análisis existentes.
     * 
     * @param args Argumentos de la línea de comandos.
     */
  public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir los valores para el nuevo análisis
    String Fecha = "2023-08-14";
    String Resultado = "Vulnerabilidad identificada en el servidor";
    String Usuario_idUsuario = "6";
    String Sistema_idSistema = "3";
    String sql = "INSERT INTO analisis (Fecha, Resultado, Usuario_idUsuario, Sistema_idSistema ) values ('"+Fecha+"','"+Resultado+"','"+Usuario_idUsuario+"','"+Sistema_idSistema+"')";
    
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
    
    // Ejecutar la inserción del nuevo análisis
    st.executeUpdate(sql);
    // Obtener y mostrar todos los análisis actuales en la base de datos
    rs=st.executeQuery("SELECT * FROM analisis ");
    rs.next();
    
    do{
        // Imprimir detalles de cada análisis
    System.out.println("-"+rs.getString("idAnalisis")+"-"+rs.getString("Fecha")+"-"+rs.getString("Resultado")+"-"+rs.getString("Usuario_idUsuario")+rs.getString("Sistema_idSistema"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}


