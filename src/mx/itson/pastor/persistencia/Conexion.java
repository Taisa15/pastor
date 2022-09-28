/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.pastor.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author taisa
 */
public class Conexion {
 
    public static Connection obtener(){
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pastordb?user=root&password=root");
        } catch (Exception e) {
            System.err.print(e.getMessage());
            
        }
        return conexion;
    }          
    
}
