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
public class LifePack {
private int x,y;
private ImageIcon life;
private int lifeTime;
private long initiateTime;
private String location="life.jpg";
    private int imageX;
    private int imageY;
    private Rectangle rec;
    public LifePack(int x, int y, int lifeTime, long initiateTime) {
        this.x = x;
        this.y = y;
        this.lifeTime = lifeTime;
        this.initiateTime = initiateTime;
        life=new ImageIcon(location);
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
     * @return the life
     */
    public ImageIcon getLife() {
        return life;
    }

    /**
     * @param life the life to set
     */
    public void setLife(ImageIcon life) {
        this.life = life;
    }

    /**
     * @return the lifeTime
     */
    public int getLifeTime() {
        return lifeTime;
    }

    /**
     * @param lifeTime the lifeTime to set
     */
    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    /**
     * @return the initiateTime
     */
    public long getInitiateTime() {
        return initiateTime;
    }

    /**
     * @param initiateTime the initiateTime to set
     */
    public void setInitiateTime(long initiateTime) {
        this.initiateTime = initiateTime;
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
        imageX=this.getLife().getImage().getWidth(null);
        imageY=this.getLife().getImage().getHeight(null);
        rec=new Rectangle(x,y,imageX,imageY);
        return rec;
        }
    
}
