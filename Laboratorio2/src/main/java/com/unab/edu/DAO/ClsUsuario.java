/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.TiposUsuario;
import com.unab.edu.Entidades.Usuario;
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
public class ClsUsuario {
    
    Conexion cn = new Conexion();
    Connection conexion = cn.retornarConexion();

    public boolean LoguinUsuario(String usuario, String Pass, int tipoUser) {
        ArrayList<Usuario> ListaUsuarios = new ArrayList<>();
        ArrayList<Usuario> ListarContra = new ArrayList<>();
        try {
            CallableStatement st = conexion.prepareCall("call SP_S_LOGUINUSUARIO(?,?)");
            st.setString("pusuario", usuario);
            st.setString("ppass", Pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario Us = new Usuario();
                Us.setUsuario(rs.getNString("Usuario"));
                Us.setPassword(rs.getNString("PassWord"));
                Us.setId(rs.getInt("tipoUsuario"));
                ListaUsuarios.add(Us);
            }
            String usuariodebasedatos = null;
            String passdebasededatos = null;
            int tipouserbasededatos = 0;
            for (var iterador : ListaUsuarios) {
                usuariodebasedatos = iterador.getUsuario();
                passdebasededatos = iterador.getPassword();
                tipouserbasededatos = iterador.getId();

            }

            CallableStatement st2 = conexion.prepareCall("call SP_S_CRIPMD5(?)");
            st2.setString("PcripPass", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Usuario escrip = new Usuario();

                escrip.setPassword(rs2.getNString("crip"));
                ListarContra.add(escrip);
            }

            String passcrip = null;
            for (var iterador : ListarContra) {

                passcrip = iterador.getPassword();

                Pass = passcrip;

            }
           
            
            if(usuariodebasedatos!=null &&passdebasededatos!=null ){
            if (usuariodebasedatos.equals(usuario) && passdebasededatos.equals(Pass) &&  tipouserbasededatos==tipoUser){
                return true;
            }
            }
            conexion.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
   
    
}
