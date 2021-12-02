/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.integrador.escola.modelos.auxiliares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jonathan
 */
public class MySQL_Connection {
        public static Connection createConnection() throws SQLException {      
        String username = "root";
        String password = "inserida";
        
        String url = "jdbc:mysql://localhost/appescola";
        Connection myConn = (Connection)DriverManager.getConnection(url, username, password);
        return myConn;
    }
}
