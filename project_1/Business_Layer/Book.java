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
public class Book extends ItemClass implements IDataFunctions, Comparable<Object>,Serializable {

    private String book_name;
    private String description;
    private String author;
    private Date publishedDate;
    private String genre;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getGenre() {
        return genre;
    }

    public Book(String book_name, String description, String author, Date publishedDate, String genre, double price, int quantity, int itemID, Date itemDate) {
        super(price, quantity, itemID, itemDate);
        this.book_name = book_name;
        this.description = description;
        this.author = author;
        this.publishedDate = publishedDate;
        this.genre = genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Book() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    @Override
    public void AddItemToList() {

        System.out.println("Entering experiment book");
        ResultSet rs = DataAccess.GetAllBooks();
        try {

            while (rs.next()) {
                ((IDataFunctions) this).CreateItem(rs);///practice

            }

            //Lists.items.add(this);//will add this item into the lists
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Done with book experiement");
    }//will create the item and add it to the list

    @Override
    public boolean GetItem() {

        return false;
    }

//    @Override
//    public void GetAllitems() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public String GenerateID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Book(String book_name, String description, String author, Date publishedDate, String genre, double price, int quantity, Date itemDate) {
        super(price, quantity, itemDate);
        this.book_name = book_name;
        this.description = description;
        this.author = author;
        this.publishedDate = publishedDate;
        this.genre = genre;
    }

    public Book(ResultSet rs) throws SQLException {
        super(rs);

        this.description = rs.getString("book_Description");
        this.book_name = rs.getString("book_name");

        this.author = DataAccess.GetAuthorName(rs.getInt("book_Author_id"));
        this.publishedDate = rs.getDate("book_publishedDate");
        this.genre = DataAccess.GetGenre(rs.getInt("book_genre_id"));
    }

    @Override
    public double TotalPrice() {

        return (this.getQuantity() * this.getPrice());

    }

    /**
     *
     * @param text
     * @param type
     * @return
     * @throws MyException
     */
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
        System.out.println("Done with book search");
        return true;
    }

    @Override
    public boolean GetAllItems() {

        ResultSet rs = DataAccess.GetInfo("book");

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

    }

    @Override
    public boolean CreateItem(ResultSet rs) {

        try {

            Lists.items.add(new Book(rs));

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }//adds the item to the List

    @Override
    public String GetType() {
        return this.getClass().getSimpleName();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update() {

        return DataAccess.UpdateBook(this);//will update this class
    }

    @Override
    public boolean Delete() {

        return DataAccess.DELETE(this.getItemID(), "book");
    }

    @Override
    public boolean InsertItem() {

        return DataAccess.addItem(this, "book");

    }

    @Override
    public int compareTo(Object o) {
        Book b1;
        Book b2;

        b1 = (Book) o;
        b2 = this;

        if (b2.getItemID() == b1.getItemID()) {
            this.setQuantity(this.getQuantity()-1);//setes the new qunaitty
            return 1;
            
            

        }
        return 0;

    }

    @Override
    public String toString() {
         return String.format( "ID:"+getItemID()+"\nName: "+getBook_name()+"\nDescription:"+getDescription()+"\nGenre"+getGenre()+"\nAuthor:"+getAuthor()+"\nPrice per:R"+getPrice());
    }
    
    

}
