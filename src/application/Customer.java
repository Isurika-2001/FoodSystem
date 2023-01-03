/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author Isurika
 */
public class Customer {
    private String name, phoneNumber, username, password;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void viewItems(){
        
    }
    public boolean login(){
        return false;
    }
    public boolean logOut(){
        return false;
    }
    public boolean register(){
        return false;
    }
    public void resetPassword(){
        
    }
    public void addToOrder(){
        
    }
    public void placeOrder(){
        
    }
    public void editOrder(){
        
    }
    public boolean exit(){
        return false;
    }
}
