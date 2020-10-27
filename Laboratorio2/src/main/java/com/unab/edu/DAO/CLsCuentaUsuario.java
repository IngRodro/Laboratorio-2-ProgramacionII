/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Cuentausuario;
import com.unab.edu.conexionmysql.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class CLsCuentaUsuario {
    Conexion cn = new Conexion();
    Connection conexion = cn.retornarConexion();
    
    public void RealizarAbono(Cuentausuario CuUser){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_CuentasUsuario(?,?,?,?)");
            Statement.setDouble("Psaldo", CuUser.getSaldo());
            Statement.setInt("PidUsuario", CuUser.getIdUsuario());
            Statement.setInt("Ptransaccion", CuUser.getTransaccion());
            Statement.setDate("Pfecha", new java.sql.Date(CuUser.getFecha().getTime()));
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Realizado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
