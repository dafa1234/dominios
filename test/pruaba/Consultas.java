/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruaba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diegfraa
 */
public class Consultas extends Conexion{
    
        public static ResultSet Resultados(String query) {
        try {

            Conexion conex = new Conexion();
            Connection cnon = (Connection) conex.getConexion();
            Statement ps = cnon.createStatement();
            ResultSet res = ps.executeQuery(query);
            return res;
        } catch (SQLException e) {
            System.out.println("Ex|" + e.getMessage() + "|" + e.getLocalizedMessage() + "|" + e.getSQLState());
            return null;
        }
    }
}
