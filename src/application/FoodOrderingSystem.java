/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Isurika
 */
public class FoodOrderingSystem {
    
    Connection conn;
    PreparedStatement prestmnt;
    ResultSet Reltset;
    Statement stm;
    
    //constructer
    public FoodOrderingSystem() {
        //database connector object
        DbConnector connect = new DbConnector();
        conn = connect.dbConnect();
    }
    
    //-----------------------------------------------------user controlls----------------------------------------------------------------------
    
    //log out current user and log in new user
    public boolean checkUser(String username, String password){
        boolean result = false;
        Reltset = Login(username, password);//invoke Login method
        try {
            if (Reltset.next()){
                //log in to new user(update login status to 'true')
                String sql = "update CUSTOMER set LOGIN_STATUS = 'true' where username = '"+username+"'";
                prestmnt = conn.prepareStatement(sql);
                prestmnt.execute();//execute query command
                
                result = true;
            }
        } 
        catch (SQLException ex) {
             Logger.getLogger(FoodOrderingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    //show current user at top of the window
    public ResultSet ShowLogin(){
        try {
            String sql = "SELECT * FROM CUSTOMER WHERE lOGIN_STATUS = '"+true+"'";//search current user
            prestmnt = conn.prepareStatement(sql);
            Reltset = prestmnt.executeQuery();
        } 
        catch (SQLException ex) {
             Logger.getLogger(FoodOrderingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Reltset;
    }
    
    //cancel order when exit
    public void exitAndCancelOrder(){
        try {
            String order = "draft";
            
            String sql1 = "update CUSTOMER set LOGIN_STATUS = 'false' where LOGIN_STATUS = 'true'";//log out current user
            prestmnt = conn.prepareStatement(sql1);
            prestmnt.execute();
            
            String sql = "SELECT address FROM ordertable WHERE address = '"+order+"'";//search draft orders
            prestmnt = conn.prepareStatement(sql);
            Reltset = prestmnt.executeQuery();
            
            if(Reltset.next()){
                String sql2 = "DELETE FROM ORDERTABLE WHERE ADDRESS = '"+order+"'";//delete draft order
                prestmnt = conn.prepareStatement(sql2);
                prestmnt.execute();
            }
            System.exit(0);
            
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(FoodOrderingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //login check
    public ResultSet Login(String username, String password){
        //search validity of username and password that given by the user
        String sql = "SELECT USERNAME, PASSWORD FROM CUSTOMER WHERE username= '"+username+"' and password = '"+password+"'";
        try {
            prestmnt = conn.prepareStatement(sql);
            Reltset = prestmnt.executeQuery();//execute sql command
        } 
        catch (SQLException ex) {
            Logger.getLogger(FoodOrderingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Reltset;
    }
    
    
    //reset password
    public boolean ResetPwd( String username, String password){
        boolean result = false;
        try {
            String sql1 = "SELECT username FROM CUSTOMER WHERE username = '"+username+"'";//search user
            prestmnt = conn.prepareStatement(sql1);
            Reltset = prestmnt.executeQuery();
            
            if(Reltset.next()){
                String sql = "update CUSTOMER set password = '"+password+"' where username = '"+username+"'";//update current password of the user
                prestmnt = conn.prepareStatement(sql);
                prestmnt.execute();//execute query command
                JOptionPane.showMessageDialog(null, "Password updated successfully");
                result = true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong username");
            }
        } 
        catch (SQLException ex) {
             Logger.getLogger(FoodOrderingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
