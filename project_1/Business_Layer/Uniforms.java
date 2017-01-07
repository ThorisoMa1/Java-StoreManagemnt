/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Business_Layer;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_1.DataAccess_Layer.DataAccess;

/**
 *
 * @author TeezyT
 */
public class Uniforms extends ItemClass implements IDataFunctions ,Comparable<Object>,Serializable{

    private String Size;
    private String type;

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Uniforms() {
    }

    public Uniforms(String Size, String Type, double price, int quantity, Date itemDate) {
        super(price, quantity, itemDate);
        this.Size = Size;
        this.type = Type;
    }

    public Uniforms(ResultSet rs) {
        super(rs);
        try {

            this.Size = rs.getString("Size");//needs datbase method
            this.type = DataAccess.Gettype(rs.getInt("type_id"));

        } catch (SQLException ex) {
            Logger.getLogger(Uniforms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Uniforms(String Size, String type, double price, int quantity, int itemID, Date itemDate) {
        super(price, quantity, itemID, itemDate);
        this.Size = Size;
        this.type = type;
    }
    
    

    @Override
    public void AddItemToList() {

        ResultSet rs = DataAccess.GetAllUniforms();
        try {

            while (rs.next()) {
                ((IDataFunctions) this).CreateItem(rs);///practice

            }

            //Lists.items.add(this);//will add this item into the lists
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Done with uniform experiement");
    }

    @Override
    public boolean GetItem() {
        return false;

    }

    @Override
    public String GenerateID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }//will generate the ID

    @Override
    public boolean CreateItem(ResultSet rs) {

        Lists.items.add(new Uniforms(rs));//creates a list
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public double TotalPrice() {

        return (this.getQuantity() * this.getPrice());

    }

    @Override
    public boolean SeacrchItem(String text, String type) {

        ResultSet rs = DataAccess.SeasrchItem(text, type);
        try {

            while (rs.next()) {
                ((IDataFunctions) this).CreateItem(rs);///sets the object

            }

            //Lists.items.add(this);//will add this item into the lists
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        System.out.println("Done with uniform search");
        return true;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String GetType() {

        return this.getClass().getSimpleName();
    }

    @Override
    public boolean GetAllItems() {

        ResultSet rs = DataAccess.GetAllUniforms();

        try {

            while (rs.next()) {
                ((IDataFunctions) this).CreateItem(rs);///sets the object

            }

            //Lists.items.add(this);//will add this item into the lists
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        System.out.println("Done with book search");
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update() {
        
       return DataAccess.UpdateUniForm(this);
    }

    @Override
    public boolean Delete() {
         return DataAccess.DELETE(this.getItemID(),"uniform");
    }

    @Override
    public boolean InsertItem() {
        
         return DataAccess.addItem(this,"uniform");
        }

    @Override
    public int compareTo(Object o) {
        
         Uniforms u1;
        Uniforms u2;

        u1 = (Uniforms) o;
        u2 = this;

        if (u2.getItemID() == u1.getItemID()) {
            
            this.setQuantity(this.getQuantity()-1);//setes the new qunaitty
            return 1;
            
            

        }
        return 0;//means that it shouldnt add to cart
        
        }

    @Override
    public String toString() {
       return String.format( "ID:"+getItemID()+"\nType: "+getType()+"\nSize:"+getSize()+"\nQuantity"+getQuantity()+"\nPrice per:R"+getPrice());
    }

}
