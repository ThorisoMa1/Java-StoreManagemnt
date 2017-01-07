/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeezyT
 */
public class Server  implements  Runnable{
    
 private Socket clientSocket;

    public Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
 
 
    @Override
    public void run() {
        
          try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String name = rd.readLine();
            System.out.println("Connected to " + name);   
            while (true) {
                String data = rd.readLine();
                System.out.println(name + ": " + data);
            }        
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
