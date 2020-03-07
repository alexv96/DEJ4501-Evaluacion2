/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alex
 */
public class Conexion {
    private static Connection conexion;
    
    private String usuario = "root";
    private String contrasena = "";
    
    private String url = "jdbc:mysql://localhost:3306/medicamento";

    public Conexion(){
        
        try {
            //Cargar driver.
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            if (conexion == null) {
                this.conexion = DriverManager.getConnection(url,usuario,contrasena);
            }
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }
}
