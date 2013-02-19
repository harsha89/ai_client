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
public class Stone {
    private int x;
    private int y;
    private ImageIcon stone;
    private String location="stone.jpg";
    private int imageX;
    private int imageY;
    private Rectangle rec;
    public Stone(int x, int y) {
        this.x = x;
        this.y = y;
        stone=new ImageIcon(location);

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
    public ImageIcon getStone() {
        return stone;
    }

    /**
     * @param brick the brick to set
     */
    public void setBrick(ImageIcon stne) {
        this.stone = stne;
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
        imageX=this.getStone().getImage().getWidth(null);
        imageY=this.getStone().getImage().getHeight(null);
        rec=new Rectangle(x,y,imageX,imageY);
        return rec;
        }
}
