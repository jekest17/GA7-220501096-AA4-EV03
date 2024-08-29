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
 * Clase que permite editar un análisis existente en el sistema.
 * Realiza una actualización en la base de datos con los nuevos detalles del análisis.
 *
 * @author jjer1
 */
public class editar {
    
    /**
     * Método principal que ejecuta el proceso de edición de un análisis.
     * Establece una conexión con la base de datos, actualiza los datos de un análisis 
     * específico y muestra todos los análisis actuales.
     * 
     * @param args Argumentos de la línea de comandos.
     */
     public static void main (String[] args){
         // Inicializar la conexión a la base de datos
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    // Definir el ID del análisis a editar y los nuevos valores
    int idAnalisis_editar=1;
    String new_Fecha = "2022-01-26";
    String new_Resultado = "Se detectó un intento de intrusión";
    String new_Usuario_idUsuario = "6";
    String new_Sistema_idSistema = "1";
    // Definir la instrucción SQL para actualizar el análisis
    String sql = "UPDATE analisis set Fecha='"+new_Fecha+"',Resultado='"+new_Resultado+"',Usuario_idUsuario='"+new_Usuario_idUsuario+"',Sistema_idSistema='"+new_Sistema_idSistema+"' where idAnalisis="+idAnalisis_editar;
    
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
    
    // Ejecutar la actualización del análisis
    st.executeUpdate(sql);
    // Obtener y mostrar todos los análisis actuales en la base de datos
    rs=st.executeQuery("SELECT * FROM analisis ");
    rs.next();
    
    do{
        // Imprimir detalles de cada análisis
    System.out.println("-"+rs.getString("idAnalisis")+"-"+rs.getString("Fecha")+"-"+rs.getString("Resultado")+"-"+rs.getString("Usuario_idUsuario")+"-"+rs.getString("Sistema_idSistema"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        // Manejar la excepción si ocurre un error SQL
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
