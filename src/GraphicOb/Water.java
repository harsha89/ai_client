/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GraphicOb;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Harsha
 */
public class Water {
    private int x;
    private int y;
    private String location="water.jpg";
    private ImageIcon water;
    private int imageX;
    private int imageY;
    private Rectangle rec;

    public Water(int x, int y) {
        this.x = x;
        this.y = y;
        water=new ImageIcon(location);
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the brick
     */
    public ImageIcon getWater() {
        return water;
    }

    /**
     * @param brick the brick to set
     */
    public void setBrick(ImageIcon water) {
        this.water = water;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
        public Rectangle getRec()
        {
        imageX=this.getWater().getImage().getWidth(null);
        imageY=this.getWater().getImage().getHeight(null);
        rec=new Rectangle(x,y,imageX,imageY);
        return rec;
        }
}
