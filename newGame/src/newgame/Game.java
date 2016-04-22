/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgame;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import static newgame.ControlBomb.Nbomb;

/**
 *
 * @author 58336374
 */
public class Game extends JPanel implements ActionListener{
    int nc=0;
    Player player;
    Enemy enemy;
    ControlBomb bombs;
    boolean Start=true;
    public static Timer loop;
    Line line;
     private BufferedImage afterBomb;
     int nPanel;
     int score;
    public static int level=1;
     private BufferedImage menu;
     int choose=0;
     Timer menuu;
    Retry re;
     choosen c;
    
    
    
    
    
    public Game()  {
        try {
            
            nPanel=3;
            bombs=new ControlBomb(this);
            c=new choosen(this);
            player=new Player(this);
            line =new Line();
            re=new Retry(this);
            afterBomb=ImageIO.read(getClass().getResource("afterbombnew.gif"));
            menu=ImageIO.read(getClass().getResource("menu.jpg"));
            loop =new Timer(10,this);
             if(nc==0){
            addKeyListener(c);
         this.setFocusable(true);
         nc=3;
             }
              
              
         
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        }
       
        
    
    public void paint(Graphics g){
        if(nPanel==1){
           loop.start();
           bombs.tBomb.start();
           if(nc!=1){
           removeAll();
               removeKeyListener(c);
           
         
            addKeyListener(player);}
            
            
            
            g.setColor(Color.darkGray.darker().darker());
            g.fillRect(0, 0, NewGame.width, NewGame.height);
       bombs.paint(g);
        player.paint(g);
        
        line.paint(g);
        for(int i=0;i<ControlBomb.getEnemys().size();i++){
            if(ControlBomb.getEnemys().get(i).getBounds().intersects(line.getBounds())){
                
                   //    g.drawImage(afterBomb, ControlBomb.getEnemys().get(i).x,ControlBomb.getEnemys().get(i).y-50,50,50, null);
                        AfterBomb ab = new AfterBomb(ControlBomb.getEnemys().get(i).x,ControlBomb.getEnemys().get(i).y-50,g);
                        ab.start();
                    score+=(4*level);
                    if(score/level/level/200>1)
                        level+=1;
                    ControlBomb.Nbomb.remove(i);    
        }}
        g.setColor(Color.white);
        g.setFont(new Font("Tahoma",Font.BOLD,25));
        g.drawString("Score: "+(int)score, 20 ,75);
        g.drawString("EvadeBomB!!!", 20, 45);
        g.drawString("Level:"+level,NewGame.width-110,45);
        nc=1;
        }
        if(nPanel==2){
            
           loop.stop();
           // removeKeyListener(c);
           // removeKeyListener(player);
           if(nc !=2){
               
                removeKeyListener(player);
                addKeyListener(re);
           }
            
            bombs.tBomb.stop();
              for(int i=0;i<Nbomb.size();i++){
            Nbomb.remove(i);}
            
            g.setColor(Color.WHITE);
            g.fillRect(0, 0,NewGame.width, NewGame.height);
            g.setColor(Color.red);
            g.setFont(new Font("Tahoma", Font.BOLD, 50));
            g.drawString("Game Over!!!", 250, 250);
            g.setFont(new Font("Tahoma", Font.BOLD, 30));
            g.drawString("Your Score: "+score,275, 300);
            nc=2;
           
            
        }
        if(nPanel==3){
            if(nc!=3){
                removeKeyListener(re);
        
            addKeyListener(c);
            
            }
         
           score=0;
           level=1;
            g.drawImage(menu,0,0, NewGame.width, NewGame.height, this);
            g.setColor(Color.MAGENTA.brighter().brighter());
            g.setFont(new Font("Tahoma",Font.ITALIC|Font.BOLD,40));
            g.drawString("Welcome to Evade bomb!!!",120 , 400);
            
            if(choose==0){

                g.setColor(new Color(255,128,0));
                g.setFont(new Font("Tahoma",Font.CENTER_BASELINE,40));
                g.drawString("<Start>", 300, 450);


                      }

            if(choose!=0){
                g.setColor(new Color(255,128,0));
                g.setFont(new Font("Tahoma",Font.CENTER_BASELINE,40));
                g.drawString("<Exit>", 300, 450);



                    }
       
       
           
        
        
        nc=3;
   }
       repaint();}
       
   

    
    public void actionPerformed(ActionEvent e) {
       if(nPanel==1){
      player.update();
       bombs.update();
       }
       repaint();
                
    }
    public void stop(){
        loop.stop();
    }
    public void setnPanel(int a){
        nPanel=a;
    }
    public void checklisten(int nPanel){
      if(this.nPanel!=nPanel){
          //removeAll();
          this.nPanel=nPanel;
          
      }
    }
    public void checkBomb(){
       
    }

   
   
}
