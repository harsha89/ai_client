/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sockets;

import AI.AI;
import GUI.GameUI;
import GraphicOb.Brick;
import GraphicOb.Bullet;
import GraphicOb.CoinPile;
import GraphicOb.LifePack;
import GraphicOb.Player;
import GraphicOb.Stone;
import GraphicOb.Water;

import java.util.ArrayList;

/**
 *
 * @author Harsha
 */
public class DataHandler {
    private Brick[] brcks;
    private Water[] wter;
    private Stone[] stne;
    private Player[] plyr;
    private ArrayList coins=new ArrayList<CoinPile>();
    private ArrayList life=new ArrayList<LifePack>();
    private ArrayList<Bullet> bullet=new ArrayList<Bullet>();
    private GameUI game;
    private Bullet bullt;
    private AI ai;
    public static int player;
    public void addDetails(String s)
    {
       String[] temp;
       String[] temp2;
       int x;
       int y;
       int lifeTime;
       long timeInit;
       int value;
       int direction;
       String name;
       boolean shoot;
       int coin;
       int health;
       if(s.split(":")[0].equalsIgnoreCase("I"))
       {
         player=Integer.parseInt(s.split(":")[1].substring(1));
         temp=s.split("[:#]")[2].split(";");
         brcks=new Brick[temp.length];
         for(int i=0;i<brcks.length;i++)
         {

              brcks[i]=new Brick(Integer.parseInt(temp[i].split(",")[0])*25,Integer.parseInt(temp[i].split(",")[1])*25,0);
         }
         temp=s.split("[:#]")[3].split(";");
         stne=new Stone[temp.length];
         for(int i=0;i<getStne().length;i++)
         {
              stne[i]=new Stone(Integer.parseInt(temp[i].split(",")[0])*25,Integer.parseInt(temp[i].split(",")[1])*25);
         }
         temp=s.split("[:#]")[4].split(";");
         wter=new Water[temp.length];
         for(int i=0;i<getWter().length;i++)
         {
             wter[i]=new Water(Integer.parseInt(temp[i].split(",")[0])*25,Integer.parseInt(temp[i].split(",")[1])*25);
         }
       }
         if(s.split(":")[0].equalsIgnoreCase("S"))
           {
            temp=s.split(":");
            int xx=temp.length-1;
            plyr=new Player[xx];
            for(int i=0;i<xx;i++)
            {
                name=temp[i+1].split(";")[0];
                x=Integer.parseInt(temp[i+1].split(";")[1].split(",")[0])*25;
                y=Integer.parseInt(temp[i+1].split(";")[1].split(",")[1])*25;
                direction=Integer.parseInt(temp[i+1].split("[;#]")[2]);
                plyr[i]=new Player(name,x,y,0,false,direction);
            }
                System.out.println("hhhhhhhhhhhhhhhhh" +plyr.length);
               game=new GameUI();
               game.getGuiInstance().initialize(brcks, wter, stne, plyr, coins, life,bullet);
               ai=new AI(coins, life, plyr, brcks, wter, stne,bullet);
               ai.generateSqures();
               ai.createAdjecencies();
               Thread t=new Thread(ai);
               t.start();
               System.out.println("Calllllesd");
            }
        if(s.split(":")[0].equalsIgnoreCase("G"))
       {
            temp=s.split(":");
                for(int i=0;i<plyr.length;i++)
                {
                    x=Integer.parseInt(temp[i+1].split(";")[1].split(",")[0])*25;
                    y=Integer.parseInt(temp[i+1].split(";")[1].split(",")[1])*25;
                    direction=Integer.parseInt(temp[i+1].split(";")[2]);
                    if(Integer.parseInt(temp[i+1].split(";")[3])==0)
                    {
                        shoot=false;
                    }
                    else
                    {
                        shoot=true;

                        bullt=new Bullet(x,y,true,direction);
                        bullt.setShootBy(i);
                        bullet.add(bullt);
                        System.out.println("bULLET aDDED");

                    }
                    health=Integer.parseInt(temp[i+1].split(";")[4]);
                    coin=Integer.parseInt(temp[i+1].split(";")[5]);
                    value=Integer.parseInt(temp[i+1].split(";")[6]);
                    plyr[i].setX(x);
                    plyr[i].setY(y);
                    plyr[i].setDirection(direction);
                    plyr[i].setShoot(shoot);
                    plyr[i].setDamage(health);
                    plyr[i].setCoins(coin);
                    plyr[i].setScore(coin);
                }
                temp2=temp[plyr.length+1].split("[;#]");
                for(int i=0;i<brcks.length;i++)
                {
                    health=Integer.parseInt(temp2[i].split(",")[2]);
                    brcks[i].setDamage(health);
                }
       }
        if(s.split(":")[0].equalsIgnoreCase("C"))
       {
                x=Integer.parseInt(s.split(":")[1].split(",")[0])*25;
                y=Integer.parseInt(s.split(":")[1].split(",")[1])*25;
                value=Integer.parseInt(s.split("[:#]")[3]);
                timeInit=System.currentTimeMillis();
                lifeTime=Integer.parseInt(s.split("[:#]")[2]);
                coins.add(new CoinPile(x,y,value,lifeTime,timeInit));
       }
         if(s.split(":")[0].equalsIgnoreCase("L"))
       {
                x=Integer.parseInt(s.split(":")[1].split(",")[0])*25;
                y=Integer.parseInt(s.split(":")[1].split(",")[1])*25;
                lifeTime=Integer.parseInt(s.split("[:#]")[2]);
                timeInit=System.currentTimeMillis();
                life.add(new LifePack(x,y,lifeTime,timeInit));
       }
    }

    /**
     * @return the brcks
     */
    public Brick[] getBrcks() {
        return brcks;
    }

    /**
     * @param brcks the brcks to set
     */
    public void setBrcks(Brick[] brcks) {
        this.brcks = brcks;
    }

    /**
     * @return the wter
     */
    public Water[] getWter() {
        return wter;
    }

    /**
     * @param wter the wter to set
     */
    public void setWter(Water[] wter) {
        this.wter = wter;
    }

    /**
     * @return the stne
     */
    public Stone[] getStne() {
        return stne;
    }

    /**
     * @param stne the stne to set
     */
    public void setStne(Stone[] stne) {
        this.stne = stne;
    }

    /**
     * @return the plyr
     */
    public Player[] getPlyr() {
        return plyr;
    }

    /**
     * @param plyr the plyr to set
     */
    public void setPlyr(Player[] plyr) {
        this.plyr = plyr;
    }

    /**
     * @return the coins
     */
    public ArrayList getCoins() {
        return coins;
    }

    /**
     * @param coins the coins to set
     */
    public void setCoins(ArrayList coins) {
        this.coins = coins;
    }

    /**
     * @return the life
     */
    public ArrayList getLife() {
        return life;
    }

    /**
     * @param life the life to set
     */
    public void setLife(ArrayList life) {
        this.life = life;
    }
}
