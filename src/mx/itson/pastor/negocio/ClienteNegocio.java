/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.pastor.negocio;

import mx.itson.pastor.persistencia.ClienteDAO;

/**
 *
 * @author taisa
 */
public class ClienteNegocio {
    
    public static boolean guardar(String nombre, String direccion, String telefono, String email){
        boolean resultado = false;
        try {
            resultado = ClienteDAO.guardar(nombre, direccion, email, email);
        } catch (Exception e) {
            System.err.print(e.getMessage());
     
        }
        return resultado;
    }
    
}
