/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sockets;

import GUI.GameUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harsha
 */
public class ServerIn implements Runnable{
    private DataHandler communicate;

    public ServerIn() {
      communicate=new DataHandler();
    }

public void inFromServer() throws IOException
    {
    int i=0;
ServerSocket welcomeSocket = new ServerSocket(7000);
while(true) {
Socket connectionSocket = welcomeSocket.accept();
BufferedReader inFromClient =new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
String s=inFromClient.readLine();
communicate.addDetails(s);

System.out.println(s);
    }
    }

    public void run() {
        try {
            inFromServer();
        } catch (IOException ex) {
            Logger.getLogger(ServerIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
