package com.latino.utilitarie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Judith
 */
public class DataManagerOracle {
    private static Connection cnx;
    private static final String url = "jdbc:oracle:thin:@ikeypro.ca:1521:xe";
    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    private static final String user = "judith";
    private static final String password = "judith2019";
    
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