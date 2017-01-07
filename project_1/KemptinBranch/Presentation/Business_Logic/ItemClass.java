/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.KemptinBranch.Presentation.Business_Logic;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author TeezyT
 */
public abstract class ItemClass implements  Serializable{

    //private String name;
    private double price;
    private int quantity;
    // private String type;//will get from sub
    //private String description;
    private int itemID;
    private Date itemDate;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }

    public ItemClass(double price, int quantity, Date itemDate) {
        
        
        this.price = price;
        this.quantity = quantity;

     
        this.itemDate = itemDate;
    }

    public ItemClass() {

    }

    public ItemClass(double price, int quantity, int itemID, Date itemDate) {
        this.price = price;
        this.quantity = quantity;
        this.itemID = itemID;
        this.itemDate = itemDate;
    }

    public ItemClass(ResultSet rs) {
        try {
            this.itemID = rs.getInt("ID");
            this.itemDate = rs.getDate("DateAdd");
            this.quantity = rs.getInt("Quantity");
            this.price = rs.getDouble("Price");
               // this.type= GetType(rs.getInt("Item_Type"));

            // System.out.println("ID: "+st_id+" Name: "+st_name+" Course: "+st_course);
        } catch (SQLException ex) {
            Logger.getLogger(ItemClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to build object");
        }
    }

   
    /**
     *
     */
    public abstract void AddItemToList();

    public abstract double TotalPrice();

    public abstract boolean SeacrchItem(String text, String type);

    /**
     *
     * @param ID
     * @return
     */
    public boolean AddItem(ItemClass ic) {

        return false; // DataAccess.addItem(ic);
    }

    /**
     *
     * @return
     */
    public abstract boolean GetAllItems();

   

  

   
   

    public abstract String GetType();
    @Override
    public abstract  String toString();
   

}
