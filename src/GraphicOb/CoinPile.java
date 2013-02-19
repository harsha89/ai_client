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
public class CoinPile {
private int x,y;
private ImageIcon coin;
private int value;
private int lifeTime;
private long initiateTime;
private String coinLocation="coins.png";
private int imageX;
private int imageY;
private Rectangle rec;

    public CoinPile(int x, int y,  int value, int lifeTime, long initiateTime) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.lifeTime = lifeTime;
        this.initiateTime = initiateTime;
        coin=new ImageIcon(coinLocation);
    }
   

    /**
     * @return the coin
     */
    public ImageIcon getCoin() {
        return coin;
    }

    /**
     * @param coin the coin to set
     */
    public void setCoin(ImageIcon coin) {
        this.coin = coin;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
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
     * @return the coinLocation
     */
    public String getCoinLocation() {
        return coinLocation;
    }

    /**
     * @param coinLocation the coinLocation to set
     */
    public void setCoinLocation(String coinLocation) {
        this.coinLocation = coinLocation;
    }
        public Rectangle getRec()
        {
        imageX=this.getCoin().getImage().getWidth(null);
        imageY=this.getCoin().getImage().getHeight(null);
        rec=new Rectangle(x,y,imageX,imageY);
        return rec;
        }
}
