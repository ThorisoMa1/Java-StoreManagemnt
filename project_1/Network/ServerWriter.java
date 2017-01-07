/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class ServerWriter implements Runnable {

    private Socket clientSocket;

    public ServerWriter(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            PrintWriter wr = new PrintWriter(clientSocket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true) {
                String input = sc.nextLine();
                wr.write(input + "\n");
                wr.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
