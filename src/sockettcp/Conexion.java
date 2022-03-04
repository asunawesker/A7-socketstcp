/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asunawesker
 */
public class Conexion {
    private static Conexion conexionInstancia = null;
    private Connection connection = null;
    private final String URL = "jdbc:postgresql://localhost:5432/registros";
    private final String USUARIO = "postgres";
    private final String CONTRASENIA = "postgres";

    private Conexion() {
        try{
            connection = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
            System.out.println("Conexion establecida");
        } catch(SQLException e){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
        
    public static Conexion getSingletonInstancia(){
        if(conexionInstancia == null)
            conexionInstancia = new Conexion();
        
        return conexionInstancia;
    }   
    
    public Connection getConnection(){
        return connection;
    }
}
