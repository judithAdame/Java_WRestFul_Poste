package com.latino.utilitarie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataManagerMySQL {
    private static Connection cnx;
    private static final String url = "jdbc:mysql://localhost:3306/postesdb?useSSL=false";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "root";
    
    public static Connection getConnexion() {
        try {
            if (cnx==null || cnx.isClosed()) {
                Class.forName(driver);
                cnx = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException ex) {
            System.out.println("ERREUR : "+ex);
            Logger.getLogger(DataManagerMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("ERREUR : "+ex);
            Logger.getLogger(DataManagerMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }
    
    public static void close() {
        try {
            if (cnx!=null) {
                cnx.close();
                cnx = null;
            }
        } catch (SQLException ex) {
            System.out.println("ERREUR : "+ex);
            Logger.getLogger(DataManagerMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
