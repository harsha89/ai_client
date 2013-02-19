/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harsha
 */
public class ServerOut implements Runnable{
    private  DataOutputStream outToServer ;
    private   Socket clientSocket;
public void outToServer() throws UnknownHostException, IOException, InterruptedException
    {
    createSocket();
    outToServer =new DataOutputStream(clientSocket.getOutputStream());
    outToServer.writeBytes("JOIN#");
    closeConnection();
//   Thread.sleep(15000);
//    createSocket();
//    outToServer =new DataOutputStream(clientSocket.getOutputStream());
//    outToServer.writeBytes("RIGHT#");
//        System.out.println("yei");
//    closeConnection();
//    Thread.sleep(1050);
//    System.out.println("Shoot");
}    public void run() {
        try {
            try {
                outToServer();
            } catch (InterruptedException ex) {
                Logger.getLogger(ServerOut.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void createSocket() throws UnknownHostException, IOException
    {
    clientSocket = new Socket("localhost", 6000);
}
public void closeConnection()
    {
        try {
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerOut.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
