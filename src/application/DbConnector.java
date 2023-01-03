/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Isurika
 */
public class DbConnector {
    String url = "jdbc:derby://localhost:1527/";
    String dbName = "Test";
    String userName = "root"; 
    String password = "root";
    
    Connection conn = null;
    
    //database connection
    public Connection dbConnect(){
        try {
            conn = DriverManager.getConnection(url+dbName,userName,password);
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
       
    }
}
