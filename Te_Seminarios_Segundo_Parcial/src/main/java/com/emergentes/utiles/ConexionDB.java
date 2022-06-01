
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_seminarios";
    static String user = "root";
    static String password = "";
    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexión exitosa...");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error en la Conexión: " + ex.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar: " + ex.getMessage());
        }
    }
    
    
    
}
