/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Business_Layer;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author TeezyT
 */
public class KemptonOrderProcess extends UnicastRemoteObject implements IkemptonOrders {

    public KemptonOrderProcess() throws RemoteException {
       
    }

    @Override
    public ArrayList<ItemClass> GetItems() throws RemoteException {

        ArrayList<ItemClass> ac = new ArrayList<>();
        Lists.items = new ArrayList<>();

        ac.add(new Uniforms());
        ac.add(new Book());

        ac.stream().forEach((item) -> {
            item.GetAllItems();
        });
        return Lists.items;

    }

    @Override
    public boolean GenerateOrder(Object o) throws RemoteException {

        Lists.orders = (Basket) o;
        Lists.orders.CheckCartOut();
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
