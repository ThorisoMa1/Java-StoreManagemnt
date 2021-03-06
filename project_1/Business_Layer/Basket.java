/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Business_Layer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeezyT
 */
public class Basket implements ICourt, ISerilization, Serializable {

    //String Pid;
    // int Quantity;
    final HashMap<String, Object> m;
    final CreateReportPdf cR;

    /**
     *
     * @throws RemoteException
     */
    public Basket() throws RemoteException {

        //this.Pid = null;
        //this.Quantity = 0;
        this.m = new HashMap<>();
        cR = new CreateReportPdf();
        //Lists.items.clear();
    }

    public String GenerateKey(String type, String ID) {

        String key = null;

        switch (type) {

            case "book":
                key = "b" + ID;
                break;

            case "uniform":
                key = "u" + ID;
                break;
        }

        //return null;
        return key;
    }

    @Override
    public boolean AddToCart(Object item) {

        String ID = null;
        String Key;
        Book b;
        Uniforms u;

        switch (item.getClass().getSimpleName().toLowerCase()) {
            case "book":

                b = (Book) item;
                ID = b.getItemID() + "";
                Key = GenerateKey("book", ID);
                //u1.setPrice(u1.getPrice() + u.getPrice());
                //u1.setQuantity(u1.getQuantity() + u.getQuantity());

                if (this.m.containsKey(Key)) {

                    b = (Book) m.get(Key);
                    b.setQuantity(b.getQuantity() + 1);
                    m.remove(Key);

                    m.put(Key, b);//places the object into the list

                }

                break;

            case "uniforms":

                u = (Uniforms) item;
                ID = u.getItemID() + "";
                Key = GenerateKey("uniform", ID);

                if (this.m.containsKey(Key)) {

                    u = (Uniforms) m.get(Key);
                    u.setQuantity(u.getQuantity() + 1);

                    m.remove(Key);
                    m.put(Key, u);
                    //places the

                    break;

                } else {
                    m.put(Key, u);
                    System.out.println("Added u to cart");

                }
                getCartDetails();//will hen update 
                return true;
        }
        return false;
    }

    @Override
    public boolean RemoveFromCourt(Object item) {
        double Total;

        String ID = null;
        String Key;
        Book b;
        Uniforms u;
        switch (item.getClass().getSimpleName().toLowerCase()) {
            case "book":

                b = (Book) item;
                ID = b.getItemID() + "";
                Key = GenerateKey("book", ID);
                b = (Book) m.get(Key);
                //u1.setPrice(u1.getPrice() + u.getPrice());
                //u1.setQuantity(u1.getQuantity() + u.getQuantity());

                if (b.getQuantity() == 1) {

                    m.remove(Key);

                } else {
                    b.setQuantity(b.getQuantity() - 1);
                    m.remove(Key);

                    m.put(Key, b);//places the object into the list
                }

                break;

            case "uniforms":

                u = (Uniforms) item;
                ID = u.getItemID() + "";
                Key = GenerateKey("uniform", ID);
                u = (Uniforms) m.get(Key);

                if (u.getQuantity() == 1) {

                    m.remove(Key);

                    //places the
                    break;

                } else {

                    u.setQuantity(u.getQuantity() - 1);

                    m.remove(Key);
                    m.put(Key, u);

                }

                return true;
        }
        getCartDetails();//will hen update 
        return false;

    }//need to work on 

    @Override
    public boolean CheckCartOut() {
        try {
            getCartDetails();
            cR.Createreport(Lists.items);//creates report when checking out
            return true;
        } catch (Exception e) {
        }

        return false;

    }//databse method

    @Override
    public boolean getCartDetails() {

        Lists.items = new ArrayList<>();
        Lists.items.clear();
        //return  m;
        m.entrySet().stream().map((entrySet) -> {
            String key = entrySet.getKey();
            return entrySet;
        }).map((entrySet) -> entrySet.getValue()).forEach((value) -> {
            if ("book".equals(value.getClass().getSimpleName())) {

                Lists.items.add((Book) value);
            } else {
                Lists.items.add((Uniforms) value);
            }
        });
        return true;

    }

    @Override
    public Object getProductFromCart(String uID) {

        if (m.containsKey(uID)) {
            return m.get(uID);
        }
        return null;
    }

    @Override
    public void Serilizefile() {
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream("Report.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            Object data = null;
            getCartDetails();
            data = Lists.items;
            oos.writeObject(data);
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Basket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Basket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                fs.close();
            } catch (IOException ex) {
                Logger.getLogger(Basket.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public ArrayList<ItemClass> DserilizeSerilizefile(String Path) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (ArrayList<ItemClass>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Basket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Basket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Basket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Basket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }

}
