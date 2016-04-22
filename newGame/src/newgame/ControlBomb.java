/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgame;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author 58336374
 */
public class ControlBomb implements ActionListener{
    public static ArrayList<Enemy>Nbomb=new ArrayList();
    Enemy bomb;
    Game game;
    Timer tBomb;
    int e;
    private BufferedImage bomber;
    private Line line;
   
    public ControlBomb(Game a) {
        
        line=new Line();
        game=a;
            tBomb =new Timer(200-(int)(game.level*100),this);
        try {
            bomber=ImageIO.read(getClass().getResource("bombnew.gif"));
        } catch (IOException ex) {
           ;
        }
            add(new Enemy( ));
            
       
            
          
        
    }
    public void paint(Graphics g){
        for(int i=0;i<Nbomb.size();i++){
            bomb=Nbomb.get(i);
           bomb.paint(g);
          
        }
       
    }
    public void draw(Graphics g){
      
           for(int i=0;i<Nbomb.size();i++){
            bomb=Nbomb.get(i);
           if(line.getBounds().intersects(bomb.getBounds()))
           bomb.draw(g);
        }
         
        
    }
    public void update(){
        for(int i=0;i<Nbomb.size();i++){
            bomb=Nbomb.get(i);
            bomb.update();
            tBomb.start();
            tBomb.setRepeats(false);
            
        }
        
        
    }
    public void add(Enemy x){
        Nbomb.add(x);
    }
    public void remove(Enemy x){
        Nbomb.remove(x);
    }
    public static ArrayList<Enemy> getEnemys(){
        return Nbomb;
    }

    
   
    public void actionPerformed(ActionEvent e) {
           add(new Enemy());
           // if(Game.level>5)add(new Enemy());
          //  if(Game.level>4)add(new Enemy());
            if(Game.level>3)add(new Enemy());
            if(Game.level>2)add(new Enemy());
         //   if(Game.level>1)add(new Enemy());

                    
          
    
           
           
            
    }
    
    
}
