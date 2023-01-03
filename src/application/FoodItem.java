/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author Isurika
 */
public abstract class FoodItem {
    protected String foodName, FoodId;
    protected double price;

    public FoodItem() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodId() {
        return FoodId;
    }

    public void setFoodId(String FoodId) {
        this.FoodId = FoodId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public abstract double calcTotal();
    
}
