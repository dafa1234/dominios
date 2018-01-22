/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruaba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author diegfraa
 */
public class Conexion {

    Properties Control_Autorizacion_property = new Control_Autorizacion_property().getProperties();

    String HOST = (String) Control_Autorizacion_property.getProperty("HOST");
    String USERNAME = (String) Control_Autorizacion_property.getProperty("USERNAME");
    String PASSWORD = (String) Control_Autorizacion_property.getProperty("PASSWORD");
    String DATABASE = (String) Control_Autorizacion_property.getProperty("DATABASE");
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + "/" + DATABASE + "?\""; 
    public Connection con;

    public Conexion() {

        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR" + e);
            System.out.println("No se genera conexion");

        } catch (SQLException e) {
            System.out.println("ERROR" + e);

        }
    }

    public Connection getConexion() {
        return con;
    }
}
