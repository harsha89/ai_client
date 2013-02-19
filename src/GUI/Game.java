/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.JFrame;

/**
 *
 * @author Harsha
 */
public class Game extends JFrame {
private GUI gui;
    public Game()
    {
        gui=new GUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(510, 535);
        setLocationRelativeTo(null);
        setTitle("TankBusters");
        setResizable(false);
        setVisible(true);
        add(gui);
       
    }
    public GUI getGuiInstance()
    {
        return this.gui;
    }
}
