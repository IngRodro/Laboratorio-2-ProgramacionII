/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.conexionmysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 */
public class Conexion {
    
    private Connection conexion;

    public Conexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/appbanco","root","root");
            System.out.println("Conectado a la BD");
        } catch (Exception e) {
            System.out.println("Error de Conexion: " + e);
        }
    }

    public Connection retornarConexion() {
        return conexion;
    }

    public CallableStatement prepareCall(String SP_I_CuentasUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
