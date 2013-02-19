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
public class Player {
    private String name;
    private int x;
    private int y;
    private int damage;
    private int direction;
    private int score;
    private int coins;
    private ImageIcon north;
    private boolean alive;
    private boolean shoot;
    private int rotation;
    private String location1="tank.png";
    private int imageX;
    private int imageY;
    private Rectangle rec;
    private int presentX;
    private int presentY;
    private int presentD;
    private int x1;
    private int x2;
    private int x3;
    private int x4;
    public Player(String name, int x, int y, int damage, boolean shoot,int direction) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.presentX=x;
        this.presentY=y;
        this.damage = damage;
        this.shoot = shoot;
        presentD=direction;
        north=new ImageIcon(location1);
        this.direction=direction;
    }
 public void setRDirection()
    {
     x1=90;
     x2=180;
     x3=270;
     x4=0;
 }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
        this.presentX=this.x;
       
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
        this.presentY=this.y;
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
     * @return the north
     */
    public ImageIcon getNorth() {
        return north;
    }

    /**
     * @param north the north to set
     */
    public void setNorth(ImageIcon north) {
        this.north = north;
    }

   
    /**
     * @return the shoot
     */
    public boolean isShoot() {
        return shoot;
    }

    /**
     * @param shoot the shoot to set
     */
    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    /**
     * @return the location1
     */
    public String getLocation1() {
        return location1;
    }

    /**
     * @param location1 the location1 to set
     */
    public void setLocation1(String location1) {
        this.location1 = location1;
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
         setRDirection();
        setPresentD(this.direction);
        this.direction = direction;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the coins
     */
    public int getCoins() {
        return coins;
    }

    /**
     * @param coins the coins to set
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }
        public Rectangle getRec()
        {
        imageX=this.getNorth().getImage().getWidth(null);
        imageY=this.getNorth().getImage().getHeight(null);
        rec=new Rectangle(x,y,imageX,imageY);
        return rec;
        }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @return the nextX
     */
    public int getNextX() {
        return presentX;
    }

    /**
     * @param nextX the nextX to set
     */
    public void setNextX(int nextX) {
        this.presentX = nextX;
    }

    /**
     * @return the nextY
     */
    public int getNextY() {
        return presentY;
    }

    /**
     * @param nextY the nextY to set
     */
    public void setNextY(int nextY) {
        this.presentY = nextY;
    }
    public void move()
    {
        if(x!=presentX || y!=presentY)
        {
            if(x>presentX && y==presentY)
                presentX=presentX+2;
            if(x<presentX && y==presentY)
                 presentX=presentX-2;
            if(x==presentX && y<presentY)
                 presentY=presentY-2;
            if(x==presentX && y>presentY)
                  presentY=presentY+2;
        }
    }
    public void rotateImage()
    {
    int dif=direction-presentD;
     if(direction==presentD && direction==0)
        rotation=0;
     if(direction==presentD && direction==1)
        rotation=90;
     if(direction==presentD && direction==2)
        rotation=180;
     if(direction==presentD && direction==3)
        rotation=270;
     if(dif==1 || dif==-1)
        diffOne(dif);
     if(dif==3 || dif==-3)
        diffThree(dif);
     if(dif==2 || dif==-2)
        diffTwo(dif);
    }
    /**
     * @return the presentD
     */
    public int getPresentD() {
        return presentD;
    }

    /**
     * @param presentD the presentD to set
     */
    public void setPresentD(int presentD) {
        this.presentD = presentD;
    }

    /**
     * @return the rotation
     */
    public int getRotation() {
        return rotation;
    }

    /**
     * @param rotation the rotation to set
     */
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
    public void diffOne(int dif)
    {
       if(dif==1 && presentD==0 && x4<=90)
     {
         rotation=x4;
         x4=x4+5;
     }
         if(dif==-1 && presentD==3 && x3>=180)
     {
         rotation=x3;
         x3=x3-5;
     }
          if(dif==-1 && presentD==1 && x1>=0)
     {
         rotation=x1;
         x1=x1-5;
     }
         if(dif==-1 && presentD==2 && x2>=90)
     {
         rotation=x2;
         x2=x2-5;
     }
             if(dif==1 && presentD==1 && x1<=180)
     {
         rotation=x1;
         x1=x1+5;
     }
             if(dif==1 && presentD==2 && x2<=270)
     {
         rotation=x2;
         x2=x2+5;
     }
    }
    public void diffThree(int dif)
    {
           if(dif==3 && x4<=90)
     {
         rotation=-x4;
         x4=x4+5;
     }
     if(dif==-3 && x1>=0)
     {
         rotation=-x1;
         x1=x1-5;
     }
    }
    public void diffTwo(int dif)
    {
         if(dif==2 && presentD==1 && x1<=270)
     {
        rotation=x1;
        x1=x1+5;
     }
      if(dif==2 && presentD==0 && x4<=180)
     {
         rotation=x4;
         x4=x4+5;
     }
      if(dif==-2 && presentD==3 && x3>=90)
     {
         rotation=x3;
         x3=x3-5;
     }
      if(dif==-2 && presentD==2 && x2>=0)
     {
         rotation=x2;
         x2=x2-5;
     }
    }
}
