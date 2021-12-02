/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.integrador.escola.modelos.auxiliares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class Operations {
    public static boolean isLogin(String username, String password, JFrame frame) throws SQLException {
        Connection myConn = (Connection) MySQL_Connection.createConnection();
        String mySqlQuery = 
                "SELECT idLogin FROM login WHERE usuario = '" +
                username +
                "' AND senha = '" +
                password +
                "' AND tipoLogin = 'ESTUDANTE'";
        Statement loginQuery = myConn.createStatement();
        ResultSet rs = loginQuery.executeQuery(mySqlQuery);
        
        while(rs.next()) {
            LoginSessionAlunos.idLogin = rs.getInt("idLogin");
            
            return true;
            
        }
        
        return false;
    }

    public static boolean isLoginADM(String username, String password, JFrame frame) throws SQLException {
        Connection myConn = (Connection) MySQL_Connection.createConnection();
        String mySqlQuery = 
                "SELECT idLogin FROM login WHERE usuario = '" +
                username +
                "' AND senha = '" +
                password +
                "' AND tipoLogin = 'ADMINISTRADOR'";
        Statement loginQuery = myConn.createStatement();
        ResultSet rs = loginQuery.executeQuery(mySqlQuery);
        
        while(rs.next()) {
            return true;
            
        }
        
        return false;
    }    
    
    public static boolean isLoginProfessores(String username, String password, JFrame frame) throws SQLException {
        Connection myConn = (Connection) MySQL_Connection.createConnection();
        String mySqlQuery = 
                "SELECT idLogin FROM login WHERE usuario = '" +
                username +
                "' AND senha = '" +
                password +
                "' AND tipoLogin = 'PROFESSOR'";
        Statement loginQuery = myConn.createStatement();
        ResultSet rs = loginQuery.executeQuery(mySqlQuery);
        
        while(rs.next()) {
            LoginSessionProfessores.idLogin = rs.getInt("idLogin");
            
            return true;
            
        }
        
        return false;
    }    
    
    public static boolean getData() throws SQLException {
        Connection myConn = (Connection) MySQL_Connection.createConnection();
        String mySqlQuery = 
                "SELECT idEstudante, idPessoa, idEndereco FROM estudante WHERE idLogin = " +
                LoginSessionAlunos.idLogin;
        Statement loginQuery = myConn.createStatement();
        ResultSet rs = loginQuery.executeQuery(mySqlQuery);
        
        if (rs.next()) {
            LoginSessionAlunos.idEstudante = rs.getInt("idEstudante");
            LoginSessionAlunos.idPessoa = rs.getInt("idPessoa");
            LoginSessionAlunos.idEndereco = rs.getInt("idEndereco");
            return true;
        }
        
        return false;
    }
    
    public static boolean getDataProfessores() throws SQLException {
        Connection myConn = (Connection) MySQL_Connection.createConnection();
        
        Statement loginQuery = myConn.createStatement();
        String mySqlQuery = "SELECT * FROM professor WHERE idLogin = " + LoginSessionProfessores.idLogin;
        ResultSet rs = loginQuery.executeQuery(mySqlQuery);
        
        if (rs.next()) {
            LoginSessionProfessores.idProfessor = rs.getInt("idProfessor");
            LoginSessionProfessores.idPessoa = rs.getInt("idPessoa");
            LoginSessionProfessores.disciplina = rs.getString("disciplina");
            return true;
        }
        
        Statement enderecoQuery = myConn.createStatement();
        String mySqlQuery2 = "SELECT idEndereco FROM pessoa WHERE idPessoa = " +LoginSessionProfessores.idPessoa;
        ResultSet rs2 = enderecoQuery.executeQuery(mySqlQuery2);
        
        if (rs2.next()) {
            LoginSessionProfessores.idEndereco = rs2.getInt("idEndereco");
            return true;
        }
        
        return false;
    }
}
