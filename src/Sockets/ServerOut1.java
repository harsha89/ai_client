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
public class ServerOut1{
    private  DataOutputStream outToServer ;
    private   Socket clientSocket;
public void outToServer(String s) throws UnknownHostException, IOException, InterruptedException
    {
    Thread.sleep(1050);
    createSocket();
    outToServer =new DataOutputStream(clientSocket.getOutputStream());
    outToServer.writeBytes(s);
    closeConnection();
    
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
            Logger.getLogger(ServerOut1.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
