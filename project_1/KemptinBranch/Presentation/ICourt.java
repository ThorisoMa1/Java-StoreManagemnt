/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.KemptinBranch.Presentation;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author TeezyT
 */
public interface ICourt {
    
    public boolean AddToCart(Object i);
    public boolean RemoveFromCourt(Object item);
    public boolean CheckCartOut();
    public boolean getCartDetails();

    /**
     *
     * @param uID
     * @return
     */
    public Object getProductFromCart(String uID);
    
    
    
}
