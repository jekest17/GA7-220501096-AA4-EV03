/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que gestiona la conexión a la base de datos MySQL.
 * Proporciona métodos para establecer y obtener la conexión a la base de datos
 * utilizada por la aplicación CyberShield AI.
 *
 * @author jjer1
 */
public class conexion {
    
    // Objeto Connection para manejar la conexión a la base de datos
    Connection con;

    /**
     * Constructor de la clase que inicializa la conexión a la base de datos.
     * Intenta cargar el driver de MySQL y establecer una conexión utilizando
     * los parámetros de la base de datos.
     */
    public conexion() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establecer la conexión con la base de datos
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cybershield_ai", "root", "ingresarcontraseña");
        }catch (ClassNotFoundException | SQLException e) {
            // Manejar excepciones si falla la conexión
            System.out.println("No Conectado");
        }
    }
    
    /**
     * Método que devuelve la conexión a la base de datos.
     * 
     * @return Objeto Connection que representa la conexión a la base de datos.
     */
    public Connection getConection(){
    return con;
    }
    

}