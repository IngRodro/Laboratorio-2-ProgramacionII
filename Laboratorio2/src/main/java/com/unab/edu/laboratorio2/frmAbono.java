/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.laboratorio2;

import com.unab.edu.DAO.CLsCuentaUsuario;
import com.unab.edu.DAO.ClsUsuario;
import com.unab.edu.Entidades.Cuentausuario;
import com.unab.edu.Entidades.Usuario;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class frmAbono extends javax.swing.JFrame {

    /**
     * Creates new form frmAbono
     */
    public frmAbono() {
        initComponents();
        DisplayMember();
    }
    String valueMember[];
    int contador = 1;

    void DisplayMember() {
        DefaultComboBoxModel cbdefaDefault = new DefaultComboBoxModel();
        ClsUsuario claseUsuario = new ClsUsuario();
        ArrayList<Usuario> Usuarios = claseUsuario.MostrarUsuarios();
        valueMember = new String[Usuarios.size() + 1];
        String filas[] = new String[3];
        cbdefaDefault.addElement("");
        for (var IterarDatosUsuarios : Usuarios) {
            filas[0] = String.valueOf(IterarDatosUsuarios.getIdUsuario());
            filas[1] = IterarDatosUsuarios.getUsuario();
            valueMember[contador] = filas[0];
            cbdefaDefault.addElement(filas[1]);
            contador++;
        }
        cbUsuario.setModel(cbdefaDefault);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCantidadAbono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbUsuario = new javax.swing.JComboBox<>();
        bttnRealizarAbono = new javax.swing.JButton();
        txtFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cantidad a Abonar");

        jLabel2.setText("Elija a que Usuario Abonar");

        cbUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bttnRealizarAbono.setText("Realizar Abono");
        bttnRealizarAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnRealizarAbonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantidadAbono)
                        .addComponent(jLabel2)
                        .addComponent(cbUsuario, 0, 244, Short.MAX_VALUE))
                    .addComponent(bttnRealizarAbono))
                .addContainerGap(308, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtCantidadAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(bttnRealizarAbono)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttnRealizarAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnRealizarAbonoActionPerformed
        try {
            CLsCuentaUsuario cuentaUsuario = new CLsCuentaUsuario();
            Cuentausuario cuentausuario = new Cuentausuario();
            cuentausuario.setSaldo(Double.parseDouble(txtCantidadAbono.getText()));
            cuentausuario.setIdUsuario(Integer.parseInt(valueMember[cbUsuario.getSelectedIndex()]));
            cuentausuario.setFecha(txtFecha.getDate());
            cuentausuario.setTransaccion(1);
            cuentaUsuario.RealizarTransaccion(cuentausuario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique que toda la informacion es correcta");
        }
    }//GEN-LAST:event_bttnRealizarAbonoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAbono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAbono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAbono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAbono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAbono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnRealizarAbono;
    private javax.swing.JComboBox<String> cbUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtCantidadAbono;
    private com.toedter.calendar.JDateChooser txtFecha;
    // End of variables declaration//GEN-END:variables
}
