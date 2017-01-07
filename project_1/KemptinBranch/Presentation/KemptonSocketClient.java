/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.KemptinBranch.Presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class KemptonSocketClient {

    private static Socket clientSocket;
    public static String Clientename="test";
    
    public static void Read() {
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (true) {
                String data = rd.readLine();
                System.out.println("Server: " + data);
            }
        } catch (IOException ex) {
            Logger.getLogger(KemptonSocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Write() {
        try {
            PrintWriter wr = new PrintWriter(clientSocket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            
           
            String name = Clientename;
            wr.write(name + "\n");
            wr.flush();
            while (true) {
                System.out.println("Please nter message");
                String input = sc.nextLine();
                wr.write(input + "\n");
                wr.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(KemptonSocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  void main() {
        try {
            //constructor automatically makes connectin to server
            clientSocket = new Socket("localhost", 4080);
            System.out.println("Client connected to server...");

            Thread t1 = new Thread(new Runnable() {

                @Override
                public void run() {
                    Read();
                }
            });
            t1.start();

            Write();

        } catch (UnknownHostException ex) {
            Logger.getLogger(KemptonSocketClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KemptonSocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
