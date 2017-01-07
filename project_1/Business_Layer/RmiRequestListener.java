/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Business_Layer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeezyT
 */
public class RmiRequestListener extends Thread {

    public RmiRequestListener() {
     
    }

    @Override
    public void run() {
                KemptonOrderProcess ko;
       // IkemptonOrders kop;
        try {
            ko=new KemptonOrderProcess();
            System.out.println("About to host rmi");
            Registry registry = LocateRegistry.createRegistry(1099);
            
           // kop = new KemptonOrderProcess();
            registry.rebind("Kempton",ko);
            System.out.println("Rmi service running");
        } catch (RemoteException ex) {
            Logger.getLogger(RmiRequestListener.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error with rmi requets");
        }

    }//starts the rmi 

}
