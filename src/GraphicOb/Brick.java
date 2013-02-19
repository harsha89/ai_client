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
public class Brick {

    private int x;
    private int y;
    private int damage;
    private String brickLocation="bricks.jpg";
    private ImageIcon brick;
    private Rectangle rec;
    private int imageX;
    private int imageY;
    private boolean visible;
    public Brick(int x, int y, int damage) {
        this.x = x;
        this.y = y;
        this.damage = damage;
        brick=new ImageIcon(brickLocation);
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
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @return the brick
     */
    public ImageIcon getBrick() {
        return brick;
    }

    /**
     * @param brick the brick to set
     */
    public void setBrick(ImageIcon brick) {
        this.brick = brick;
    }

    /**
     * @return the brickLocation
     */
    public String getBrickLocation() {
        return brickLocation;
    }

    /**
     * @param brickLocation the brickLocation to set
     */
    public void setBrickLocation(String brickLocation) {
        this.brickLocation = brickLocation;
    }

    /**
     * @return the rec
     */
    public Rectangle getRec() {
        imageX=this.getBrick().getImage().getWidth(null);
        imageY=this.getBrick().getImage().getHeight(null);
        rec=new Rectangle(x,y,imageX,imageY);
        return rec;
    }

    /**
     * @param rec the rec to set
     */
    public void setRec(Rectangle rec) {
        this.rec = rec;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
