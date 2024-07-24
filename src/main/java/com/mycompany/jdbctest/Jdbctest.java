package com.mycompany.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Jdbctest {

    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/jdbctest";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("Select * FROM usuarios");
            while(rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            // Insercion de datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'David');");
            System.out.println("");
            System.out.println("");
            rs = statement.executeQuery("Select * FROM usuarios");
            while(rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //Actualizacion de datos
            statement.execute("UPDATE `usuarios` SET `nombre` = 'Svaleria' WHERE `usuarios`.`nombre` = 'David';");
            System.out.println("");
            System.out.println("");
            rs = statement.executeQuery("Select * FROM usuarios");
            while(rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //Eliminar o borrar
            statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 8");
            System.out.println("");
            System.out.println("");
            rs = statement.executeQuery("Select * FROM usuarios");
            while(rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Jdbctest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
