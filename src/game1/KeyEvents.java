/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class KeyEvents implements Runnable,KeyListener{
  public void keyPressed()  {
        try {
            toServer("DOWN#");
            // Called when the user has pressed a key, which can be
            // a special key such as an arrow key.  If the key pressed
            // was one of the arrow keys, move the square (but make sure
            // that it doesn't move off the edge, allowing for a
            // 3-pixel border all around the applet).
            //      int key = evt.getKeyCode();  // keyboard code for the key that was pressed
            //    try {
            //      if (key == KeyEvent.VK_LEFT) {
            //
            //                toServer("LEFT#");
            //
            //      }
            //      else if (key == KeyEvent.VK_RIGHT) {
            //          toServer("RIGHT#");
            //      }
            //      else if (key == KeyEvent.VK_UP) {
            //          toServer("UP#");
            //      }
            //      else if (key == KeyEvent.VK_DOWN) {
            //           toServer("DOWN#");
            //      }
            //      } catch (UnknownHostException ex) {
            //                Logger.getLogger(KeyEvents.class.getName()).log(Level.SEVERE, null, ex);
            //            } catch (IOException ex) {
            //                Logger.getLogger(KeyEvents.class.getName()).log(Level.SEVERE, null, ex);
            //            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(KeyEvents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KeyEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
   }  // end keyPressed()
 public void toServer(String s) throws UnknownHostException, IOException
    {
Socket clientSocket = new Socket("localhost", 6000);
DataOutputStream outToServer =new DataOutputStream(clientSocket.getOutputStream());
//BufferedReader inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//sentence = inFromUser.readLine();
outToServer.writeBytes(s);
clientSocket.close();
    }

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void run() {

    }

    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
