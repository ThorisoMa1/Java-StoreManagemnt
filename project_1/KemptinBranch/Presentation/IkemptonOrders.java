/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.KemptinBranch.Presentation;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import project_1.KemptinBranch.Presentation.Business_Logic.ItemClass;

/**
 *
 * @author TeezyT
 */
public interface IkemptonOrders extends Remote{
    
    
    public ArrayList<ItemClass> GetItems()throws RemoteException;//gets all the items 
    public boolean GenerateOrder(Object o)throws RemoteException;//generates the order ffor the items 
   
}
