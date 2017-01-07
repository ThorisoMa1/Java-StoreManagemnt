/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.DataAccess_Layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import project_1.Business_Layer.Book;
import project_1.Business_Layer.ItemClass;
import project_1.Business_Layer.Uniforms;

/**
 *
 * @author TeezyT
 */
public class DataAccess {

    final String userName;
    final String passworwd;
    final String JDBC_DRIVER;
    final String db_URL;

    static ResultSet rs;
    static Connection con;
    static Statement stmnt = null;
    static String Query = null;
    static PreparedStatement pst;
    static CallableStatement cStmt;

    private static final DataAccess instance = new DataAccess("root", null);

    public DataAccess(String userName, String passworwd) {

        this.userName = userName;
        this.passworwd = passworwd;

        this.JDBC_DRIVER = "com.mysql.jdbc.Driver";
        this.db_URL = "jdbc:mysql://localhost:3306/store_management_db";

        try {

            Class.forName(this.JDBC_DRIVER);

            System.out.println("Connecting to the db");
            con = DriverManager.getConnection(this.db_URL, this.userName, this.passworwd);
            System.out.println("Connection Successful");

        } catch (ClassNotFoundException ex) {
            System.out.println("Failed to connect");
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //con.close();
        }

    }

    /**
     *
     * @return
     */
    public static DataAccess getInstance() {
        return instance;
    }

    public static boolean DELETE(int ID, String type) {

        try {

            switch (type.toLowerCase()) {

                case "uniform":
                    cStmt = con.prepareCall("{CALL sp_DeleteUniform(?)}");

                    break;
                case "book":
                    cStmt = con.prepareCall("{CALL sp_DeleteBook(?)}");
                    break;
            }

            cStmt.setInt(1, ID);
            cStmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("failed to delete");
            return false;
        }
        return true;
    }

    public static boolean UpdateBook(Book b) {

        try {

            cStmt = con.prepareCall("{CALL Sp_UpdateBook(?,?,?,?,?,?,?,?)}");

            cStmt.setInt(1, b.getItemID());
            cStmt.setString(2, b.getBook_name());
            cStmt.setString(3, b.getAuthor());
            cStmt.setString(4, b.getDescription());
            cStmt.setDate(5, convertUtilToSql(b.getPublishedDate()));
            cStmt.setString(6, b.getGenre());

//converts date to sql
            cStmt.setInt(7, b.getQuantity());
            cStmt.setDouble(8, b.getPrice());

            //cStmt.executeQuery();
            return cStmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean UpdateUniForm(Uniforms u) {

        try {

            // int id=u.getItemID();
            cStmt = con.prepareCall("{CALL sp_UpdateUniform(?,?,?,?)}");
            // cStmt.setInt(1, Number);
            cStmt.setInt(1, u.getItemID());
            cStmt.setString(2, u.getSize());
            cStmt.setInt(3, u.getQuantity());
            cStmt.setDouble(4, u.getPrice());

            //cStmt.executeQuery();
            return cStmt.execute();

            //boolean as=cStmt.execute();
            //rs =null;
            //return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean PurchaseBook(Book u) {

        try {

            // int id=u.getItemID();
            cStmt = con.prepareCall("{CALL sp_PurchaseBook(?,?)}");
            // cStmt.setInt(1, Number);
            cStmt.setInt(1, u.getQuantity());
            cStmt.setInt(2, u.getItemID());

            //cStmt.executeQuery();
            return cStmt.execute();

            //boolean as=cStmt.execute();
            //rs =null;
            //return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean PurchaseUniform(Uniforms u) {

        try {

            // int id=u.getItemID();
            cStmt = con.prepareCall("{CALL sp_UpdateUniform(?,?)}");
            // cStmt.setInt(1, Number);
            cStmt.setInt(1, u.getQuantity());
            cStmt.setInt(2, u.getItemID());

            //cStmt.executeQuery();
            return cStmt.execute();

            //boolean as=cStmt.execute();
            //rs =null;
            //return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static ArrayList<String> getTypes() {

        ArrayList<String> types = new ArrayList<>();

        try {

            cStmt = con.prepareCall("{CALL sp_GetTypes()}");
            // cStmt.setInt(1, Number);

            rs = cStmt.executeQuery();

            while (rs.next()) {
                types.add(rs.getString("TypeName"));
            }

            //boolean as=cStmt.execute();
            //rs =null;
            //return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return types;

    }

    public static ArrayList<String> getAuthors() {
        ArrayList<String> authors = new ArrayList<>();

        try {

            cStmt = con.prepareCall("{CALL sp_getAllAuthors()}");
            // cStmt.setInt(1, Number);

            rs = cStmt.executeQuery();

            while (rs.next()) {
                authors.add(rs.getString("author_Name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return authors;

    }

    public static ArrayList<String> getGenres() {
        ArrayList<String> genre = new ArrayList<>();

        try {

            cStmt = con.prepareCall("{CALL sp_GetGenres()}");
            // cStmt.setInt(1, Number);

            rs = cStmt.executeQuery();

            while (rs.next()) {
                genre.add(rs.getString("genre_Name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return genre;

    }

    public static ArrayList<String> getSizes() {
        ArrayList<String> sizes = new ArrayList<>();

        try {

            cStmt = con.prepareCall("{CALL sp_GetSizes()}");
            // cStmt.setInt(1, Number);

            rs = cStmt.executeQuery();

            while (rs.next()) {
                sizes.add(rs.getString("Size"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sizes;

    }

    /**
     *
     * @param o
     * @param type
     * @param ItemType
     * @param date
     * @param ID
     * @return
     */
    public static boolean addItem(Object o, String type) {

        Book b;
        Uniforms u;
        try {
            switch (type) {

                case "book":

                    cStmt = con.prepareCall("{CALL sp_InsertBook(?,?,?,?,?,?,?)}");
                    b = (Book) o;

                    cStmt.setString(1, b.getBook_name());
                    cStmt.setString(2, b.getAuthor());
                    cStmt.setString(3, b.getDescription());
                    cStmt.setDate(4, convertUtilToSql(b.getPublishedDate()));
                    cStmt.setString(5, b.getGenre());
                    cStmt.setInt(6, b.getQuantity());
                    cStmt.setDouble(7, b.getPrice());

                    break;
                case "uniform":
                    cStmt = con.prepareCall("{CALL sp_InsertUniform(?,?,?,?)}");
                    u = (Uniforms) o;

                    cStmt.setString(1, u.getSize());
                    cStmt.setInt(2, u.getQuantity());
                    cStmt.setDouble(3, u.getPrice());
                    cStmt.setString(4, u.getType());

                    break;
            }

            System.out.println("Trying to run  insert query");

            return cStmt.execute();
            //boolean as=cStmt.execute();
            //rs =null;

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed");
        }

        return false;

    }

    public static ResultSet GetInfo(String ItemType) {

        try {
            switch (ItemType.toLowerCase()) {

                case "book":

                    cStmt = con.prepareCall("{CALL sp_GetAllBooks()}");

                    break;
                case "uniform":
                    cStmt = con.prepareCall("{CALL sp_GetAllUniforms()}");
                    break;
            }
            // cStmt.setString(1, "");

            //stmnt = con.createStatement();
            System.out.println("Trying to run query");

            rs = cStmt.executeQuery();
            //boolean as=cStmt.execute();
            //rs =null;

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed");
        }

        return rs;
    }

    public static ResultSet GetAllBooks() {

        try {

            cStmt = con.prepareCall("{CALL sp_GetAllBooks()}");

            rs = cStmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to get all books");
        }

        return rs;
    }

    public static ResultSet GetAllUniforms() {

        try {

            cStmt = con.prepareCall("{CALL sp_GetAllUniforms()}");

            rs = cStmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to get all uniforms");
        }

        return rs;
    }

    public static String Gettype(Integer Number) {

        String type = null;

        try {

            cStmt = con.prepareCall("{CALL sp_GetType(?)}");
            cStmt.setInt(1, Number);
            rs = cStmt.executeQuery();
            while (rs.next()) {
                type = rs.getString("TypeName");
            }

            //boolean as=cStmt.execute();
            //rs =null;
            //return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;
    }

    public static String GetGenre(Integer Number) {

        String genre = null;

        try {

            cStmt = con.prepareCall("{CALL sp_GetGenreName(?)}");
            cStmt.setInt(1, Number);
            rs = cStmt.executeQuery();
            while (rs.next()) {
                genre = rs.getString("genre_Name");
            }

            //boolean as=cStmt.execute();
            //rs =null;
            //return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return genre;
    }

    public static String GetAuthorName(Integer Number) {

        String author = null;

        try {

            cStmt = con.prepareCall("{CALL sp_GetAuthorName(?)}");
            cStmt.setInt(1, Number);
            rs = cStmt.executeQuery();
            while (rs.next()) {
                author = rs.getString("author_Name");
            }

            //boolean as=cStmt.execute();
            //rs =null;
            //return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return author;
    }

    public static ResultSet SeasrchItem(String test, String typeSearch) {

        String author = null;

        try {

            switch (typeSearch.toLowerCase()) {

                case "book":

                    cStmt = con.prepareCall("{CALL sp_SearchBook(?)}");

                    break;
                case "uniform":

                    cStmt = con.prepareCall("{CALL sp_SearchUniform(?}");
                    break;

            }

            cStmt.setString(1, test + '%');

            rs = cStmt.executeQuery();

            //boolean as=cStmt.execute();
            //rs =null;
            //return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
//        Query = "SELECT * FROM tbl_items  WHERE  Item_Name LIKE ? OR Item_Quantity LIKE ? OR Item_Description LIKE ? OR Item_Price LIKE ?";
//
//        try {
//
//            pst = con.prepareStatement(Query);
//
//            pst.setString(1, test + '%');
//            pst.setString(2, test + "%");
//            pst.setString(3, test + "%");
//            pst.setString(4, test + "%");
//
//            System.out.println("Search to run query");
//
//            rs = pst.executeQuery();
//
//        } catch (SQLException ex) {
//
//            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Failed to search");
//
//        }
//
//        return rs;

    }

    /**
     *
     * @param typeID
     * @return
     */
    public static String GetTypeName(int typeID) {
        String query;
        String type = null;

        query = "SELECT * FROM tbl_item_type WHERE Type_ID=?";

        //return "Book";
        try {

            pst = con.prepareStatement(query);
            pst.setInt(1, typeID);

            System.out.println("Trying to run query");
            rs = pst.executeQuery();

            while (rs.next()) {
                type = rs.getString("TypeName");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed");
        }

        return type;
    }

//    public static int GetTypeId(String type) {
//
//        int id = 0;
//
//        String query = "SELECT * FROM tbl_item_type WHERE TypeName=?";
//
//        try {
//
//            pst = con.prepareStatement(query);
//            pst.setString(1, type);
//
//            System.out.println("Trying to run query");
//
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//                id = rs.getInt("Type_ID");
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Failed");
//            System.out.println(id);
//        }
//
//        return id;
//    }
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {

        java.sql.Date sDate = new java.sql.Date(uDate.getTime());

        return sDate;

    }//converts to the sql date

}
