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
public class Bullet {

  
    private int x, y;
    private ImageIcon bullet;
    private  boolean visible;
    private  int direction;
    private int MISSILE_SPEED =5;
    private String bulletLocation="bullet.png";
    private int imageX;
    private int imageY;
    private Rectangle rec;
    private int shootBy;

      public Bullet(int x, int y, boolean visible,int direction) {
        this.x = x;
        this.y = y;
        this.visible = visible;
        bullet=new ImageIcon(bulletLocation);
        this.direction=direction;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.setVisible((boolean) visible);
    }

    public void move() {
        if(direction==0)
        {
        setY(getY() - getMISSILE_SPEED());
        }
        if(direction==1)
        {
        setX(getX() + getMISSILE_SPEED());
        }
        if(direction==2)
        {
        setY(getY() + getMISSILE_SPEED());
        }
        if(direction==3)
        {
         setX(getX() - getMISSILE_SPEED());
        }
        System.out.println(getX() +"anf"+getY());
        if(getX()<=0 || getX()>=500||getY()<=0||getY()>=500)
        {
            this.setVisible(false);
        }
    }
        public Rectangle getRec()
        {

        imageX=this.getBullet().getImage().getWidth(null);
        imageY=this.getBullet().getImage().getHeight(null);
        rec=new Rectangle(x,y,imageX,imageY);
        return rec;
        }
    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the bullet
     */
    public ImageIcon getBullet() {
        return bullet;
    }

    /**
     * @param bullet the bullet to set
     */
    public void setBullet(ImageIcon bullet) {
        this.bullet = bullet;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the MISSILE_SPEED
     */
    public int getMISSILE_SPEED() {
        return MISSILE_SPEED;
    }

    /**
     * @param MISSILE_SPEED the MISSILE_SPEED to set
     */
    public void setMISSILE_SPEED(int MISSILE_SPEED) {
        this.MISSILE_SPEED = MISSILE_SPEED;
    }

    /**
     * @return the brickLocation
     */
    public String getBrickLocation() {
        return bulletLocation;
    }

    /**
     * @param brickLocation the brickLocation to set
     */
    public void setBrickLocation(String brickLocation) {
        this.bulletLocation = brickLocation;
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @return the shootBy
     */
    public int getShootBy() {
        return shootBy;
    }

    /**
     * @param shootBy the shootBy to set
     */
    public void setShootBy(int shootBy) {
        this.shootBy = shootBy;
    }

}
