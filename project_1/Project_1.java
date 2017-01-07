/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1;

import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import project_1.DataAccess_Layer.DataAccess;
import project_1.Presentation.Store_Management_Menu;
import project_1.Project_1;
import com.seaglasslookandfeel.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import project_1.Business_Layer.KemptonOrderProcess;
import project_1.Business_Layer.RmiRequestListener;
import project_1.Network.Server;
import project_1.Network.ServerWriter;

/**
 *
 * @author TeezyT
 */
public class Project_1 extends Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            DataAccess da = DataAccess.getInstance();//singltinMethod
            RmiRequestListener rrl = new RmiRequestListener();
            rrl.start();
            Thread th=new Thread(() -> {
                MessageServer();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            });
            th.start();
           
            Store_Management_Menu sm = new Store_Management_Menu();
            sm.setVisible(true);

            //UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
//            
        } catch (Exception e) {

        }

    }

    private static void MessageServer() {
        try {
            //constructor automatically binds to port
            ServerSocket serverSocket = new ServerSocket(4080);

            while (true) {

                System.out.println("Waiting for client");
                Socket clientSocket = serverSocket.accept();
                Thread t1 = new Thread(new Server(clientSocket));
                t1.start();
                Thread t2 = new Thread(new ServerWriter(clientSocket));
                t2.start();

            }

        } catch (IOException ex) {
            System.out.println("Server failed to connect on port 4444");
            System.out.println(ex.getMessage());
        }

    }

}
