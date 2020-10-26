/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.TiposUsuario;
import com.unab.edu.conexionmysql.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClsTipoUsuario {
    
    Conexion cn = new Conexion();
    Connection conexion = cn.retornarConexion();
    
    public ArrayList<TiposUsuario> MostrarTipoUsuario() {
        ArrayList<TiposUsuario> tipos = new ArrayList<>();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_TiposUsuario()");
            ResultSet rs = Statement.executeQuery();
            while (rs.next()) {
                TiposUsuario tipo = new TiposUsuario();
                tipo.setId(rs.getInt("Id"));
                tipo.setTipoUser(rs.getString("TipoUser"));
                tipos.add(tipo);
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return tipos;
    }
    
}
