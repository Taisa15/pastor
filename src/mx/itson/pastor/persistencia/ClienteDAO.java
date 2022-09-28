/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 data access object */
package mx.itson.pastor.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.entidades.Cliente;

/**
 *
 * @author taisa
 */
public class ClienteDAO {
 
    public static List<Cliente> obtenerTodos(){
        
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, nombre, direccion, telefono, email FROM cliente");
            while (resultSet.next()){
                Cliente c = new Cliente();
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setDireccion(resultSet.getString(3));
                c.setEmail(resultSet.getString(4));
                c.setTelefono(resultSet.getString(5));
                clientes.add(c);

            } 
        } catch (Exception ex) {
        System.err.print("Ocurrio un error"+ex.getMessage());
        }
        return clientes;
    }
    
    public static boolean guardar(String nombre, String direccion, String telefono, String email ){
        boolean resultado = false;
        try {
            Connection connection = Conexion.obtener();
            String consulta = "INSERT INTO cliente (nombre, direccion, telefono, email) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, direccion);
            statement.setString(3, telefono);
            statement.setString(4, email);
            
            resultado = statement.getUpdateCount() == 1;
            
        } catch (Exception e) {
            System.err.print("Ocurrio un error"+e.getMessage());
        }
        return resultado;
    }
    
    public static buscarPorEmail(String email){
        
        boolean resultado = false;
        
       
    }
    
}
