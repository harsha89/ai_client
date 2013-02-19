/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JPanel;
import GraphicOb.Brick;
import GraphicOb.Bullet;
import GraphicOb.CoinPile;
import GraphicOb.LifePack;
import GraphicOb.Player;
import GraphicOb.Stone;
import GraphicOb.Water;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;

/**
 *
 * @author Harsha
 */
public class GUI extends JPanel  implements ActionListener{
    private ArrayList<CoinPile> coins;
    private ArrayList<LifePack> packs;
    private int x,y;
    private Player[] players;
    private int direction;
    private Timer timer;
    private Brick[] brcks;
    private Water[] wter;
    private Stone[] stne;
    private int dir;
    private ArrayList<Bullet> bullet;
    private boolean status=false;
    private AffineTransform transform;
    private ImageIcon imag=new ImageIcon("game.jpg");
    public GUI() {
    transform=new AffineTransform();
    setBackground(Color.BLACK);
    setDoubleBuffered(true);

    
    }
  
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(imag.getImage(), 0, 0, this);
        drawMap(g);
        drawPlayers(g);
        drawCoinPiles(g);
        drawLifePacks(g);
        drawBullets(g);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    public void initialize(Brick[] brcks,Water[] wter,Stone[] stne,Player[] plyr,ArrayList<CoinPile> coins,ArrayList<LifePack> packs,ArrayList<Bullet> bullet)
    {
    this.brcks=brcks;
    this.stne=stne;
    this.players=plyr;
    this.wter=wter;
    this.coins=coins;
    this.packs=packs;
    this.bullet=bullet;
    status=true;
        System.out.println("done");
        timer=new Timer(25, this);
    timer.start();
    }
    public void drawMap(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        for(int i=0;i<brcks.length;i++)
        {
        x=brcks[i].getX();
        y=brcks[i].getY();
        g2d.drawImage(brcks[i].getBrick().getImage(), x, y, this);
        }
        for(int i=0;i<stne.length;i++)
        {
        x=stne[i].getX();
        y=stne[i].getY();
        g2d.drawImage(stne[i].getStone().getImage(), x, y, this);
        }
         for(int i=0;i<wter.length;i++)
        {
        x=wter[i].getX();
        y=wter[i].getY();
        g2d.drawImage(wter[i].getWater().getImage(), x, y, this);
        }
         
    }
    public void drawPlayers(Graphics g)
    {
        int rotation;
        Graphics2D g2d = (Graphics2D)g;
             for(int i=0;i<players.length;i++)
             {
                 x=players[i].getNextX();
                 y=players[i].getNextY();
                 direction=players[i].getDirection();

                 dir=players[i].getPresentD();
                 rotation=players[i].getRotation();
                 transform.setToTranslation(x, y);
                 transform.rotate(Math.toRadians(rotation),12.5,12.5);
                 g2d.drawImage(players[i].getNorth().getImage(),transform, this);
              //   System.out.println("Look"+ rotation);
//                 if(direction==0)
//                 {
//
//                      g2d.drawImage(players[i].getNorth().getImage(),x,y, this);
//                 }
//                 else if(direction==1)
//                 {
//
//                      transform.setToTranslation(x, y);
//                      transform.rotate(Math.toRadians(90),25,25);
//                      g2d.drawImage(players[i].getNorth().getImage(),transform, this);
//                 }
//                 else if(direction==2)
//                 {
//                       transform.setToTranslation(x, y);
//                       transform.rotate(Math.toRadians(180),25,25);
//                       g2d.drawImage(players[i].getNorth().getImage(),transform, this);
//                 }
//                 else if(direction==3)
//                 {
//                       transform.setToTranslation(x, y);
//                       transform.rotate(Math.toRadians(270),25,25);
//                       g2d.drawImage(players[i].getNorth().getImage(),transform, this);
//                 }
             

         }
    }
    public void drawCoinPiles(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;

            for(int i=0;i<coins.size();i++)
            {
                 x=coins.get(i).getX();
                 y=coins.get(i).getY();
                 g2d.drawImage(coins.get(i).getCoin().getImage(), x, y, this);
            }
    }
    public void drawLifePacks(Graphics g)
    {

            Graphics2D g2d = (Graphics2D)g;
                for(int i=0;i<packs.size();i++)
                {
                    x=packs.get(i).getX();
                    y=packs.get(i).getY();
                    g2d.drawImage(packs.get(i).getLife().getImage(), x, y, this);
                }
    }

    public void actionPerformed(ActionEvent e) {
    checkForTimeExpired();
    checkForGrab();
    moveBullets();
    movePlayers();
    //ditectCollisions();
    repaint();
    }
    public void checkForTimeExpired()
    {
             long timeNow=System.currentTimeMillis();
             long dif;
             long pileTime;
             long coinTime;
             if(packs!=null){
             for(int i=0;i<packs.size();i++)
              {
               dif=timeNow-packs.get(i).getInitiateTime();
               pileTime=packs.get(i).getLifeTime();
               if(pileTime<=dif)
               {
                  System.out.println("called");
                  packs.remove(i);
                  i=i-1;
               }

             }
        }
             if(coins!=null)
             {
            for(int i=0;i<coins.size();i++)
           {
           dif=timeNow-coins.get(i).getInitiateTime();
           coinTime=coins.get(i).getLifeTime();
           if(coinTime<=dif)
           {
              coins.remove(i);
              i=i-1;
           }
         }
        }
    }
    public void checkForGrab()
    {
        int xx;
        int yy;
        int px;
        int py;
        if(coins!=null){
          for(int i=0;i<coins.size();i++)
          {
              xx=coins.get(i).getX();
               yy=coins.get(i).getY();
              for(int j=0;j<players.length;j++)
              {
                  px=players[j].getX();
                  py=players[j].getY();
                  if(px==xx && py==yy)
                  {
                      coins.remove(i);
                      if(coins.size()>0)
                      i=i-1;
                  }
              }
          }
        }
          for(int i=0;i<packs.size();i++)
          {
               xx=packs.get(i).getX();
               yy=packs.get(i).getX();

              for(int j=0;j<players.length;j++)
              {
                  px=players[j].getX();
                  py=players[j].getY();
                  if(px==xx && py==yy)
                  {
                      packs.remove(i);
                      if(packs.size()>0)
                      i=i-1;
                  }
              }
          }
    }
    public void ditectCollisions()
    {
        Rectangle one,two;
        for(int i=0;i<bullet.size();i++)
        {
        one=bullet.get(i).getRec();
        for(int j=0;j<stne.length;j++)
        {
           two=stne[j].getRec();
        //    System.out.println(two.width+"and"+two.OUT_BOTTOM+"and"+two.OUT_LEFT+"and"+two.OUT_RIGHT);
           if(one.intersects(two))
           {
          
           if(bullet.size()>0)
           {
               bullet.remove(i);
               i=i-1;
               System.out.println("Bullet Removed1");
               }
           }
        }
        for(int j=0;j<players.length;j++)
        {
           two=players[j].getRec();
           if(one.intersects(two) && bullet.get(i).getShootBy()!=j)
           {
           
           if(bullet.size()>0)
           {
               bullet.remove(i);
               i=i-1;
           System.out.println("Bullet Removed2");
           }
           }
        }
        for(int j=0;j<brcks.length;j++)
        {
           two=brcks[j].getRec();
           if(one.intersects(two))
           {
          
           if(bullet.size()>0)
           {
               bullet.remove(i);
               i=i-1;
           System.out.println("Bullet Removed3");
           }
           }
          }
        if(bullet.size()>0)
        {
        if(!bullet.get(i).isVisible())
        {
          
            if(bullet.size()>0)
            {
                  bullet.remove(i);
            i=i-1;
            System.out.println("Bullet Removed4");
            }
        }
       }
        }

    }
    public void drawBullets(Graphics g)
    {
        int bDirection;
        Graphics2D g2d = (Graphics2D)g;
      //  System.out.println("Bullet Size"+bullet.size());
        for(int i=0;i<bullet.size();i++)
        {
            bDirection=bullet.get(i).getDirection();
            x=bullet.get(i).getX();
            y=bullet.get(i).getY();
            if(bDirection==0 && bullet.get(i).isVisible())
                 {

                      g2d.drawImage(bullet.get(i).getBullet().getImage(),x,y, this);
                 }
                 else if(bDirection==1  && bullet.get(i).isVisible())
                 {

                      transform.setToTranslation(x, y);
                      transform.rotate(Math.toRadians(90),12.5,12.5);
                      g2d.drawImage(bullet.get(i).getBullet().getImage(),transform, this);
                 }
                 else if(bDirection==2 && bullet.get(i).isVisible())
                 {
                       transform.setToTranslation(x, y);
                       transform.rotate(Math.toRadians(180),12.5,12.5);
                        g2d.drawImage(bullet.get(i).getBullet().getImage(),transform, this);
                 }
                 else if(bDirection==3 && bullet.get(i).isVisible())
                 {
                       transform.setToTranslation(x, y);
                       transform.rotate(Math.toRadians(270),12.5,12.5);
                        g2d.drawImage(bullet.get(i).getBullet().getImage(),transform, this);
                 }
            System.out.println("Bullet Moving");
        }
    }
    public void moveBullets()
    {
        for(int i=0;i<bullet.size();i++)
        {
            bullet.get(i).move();
        }
    }
    public void movePlayers()
    {
        for(int i=0;i<players.length;i++)
        {
            players[i].move();
            players[i].rotateImage();
        }
    }

}
