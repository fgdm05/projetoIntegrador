/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.integrador.escola.modelos.auxiliares;

import javax.swing.JFrame;

/**
 *
 * @author Jonathan
 */
public class Logout {
    
    public static void Logout(JFrame context, JFrame loginScreen) {
        LoginSessionAlunos.isLoggedIn = false;
        context.setVisible(false);
        loginScreen.setVisible(true);
    }
}
