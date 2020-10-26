/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class Cuentausuario extends Usuario{
    int idcuentausuario;
    double saldo;
    int transaccion;
    Date fecha;
    
}
