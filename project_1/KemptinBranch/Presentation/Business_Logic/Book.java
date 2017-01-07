/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.KemptinBranch.Presentation.Business_Logic;


import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author TeezyT
 */
public class Book extends ItemClass implements  IDataFunctions,Comparable<Object>,Serializable {

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

  

   



    public Book(String book_name, String description, String author, Date publishedDate, String genre, double price, int quantity, Date itemDate) {
        super(price, quantity, itemDate);
        this.book_name = book_name;
        this.description = description;
        this.author = author;
        this.publishedDate = publishedDate;
        this.genre = genre;
    }

   
    

    @Override
    public double TotalPrice() {

        return (this.getQuantity() * this.getPrice());

    }

   
 

    @Override
    public boolean GetAllItems() {

       //will need to get the rmi items;
        return  false;
    }

 

    @Override
    public String GetType() {
        return this.getClass().getSimpleName();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public void AddItemToList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean SeacrchItem(String text, String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
