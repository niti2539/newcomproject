/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import static newgame.Game.loop;

/**
 *
 * @author 58336374
 */
public class choosen implements KeyListener{
    Game game;
    
    public choosen(Game g){
        game=g;
      
       
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
       return;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        
         int key=event.getKeyCode();
            if(key==KeyEvent.VK_LEFT){
                game.choose+=1;
                if(game.choose>1)
                    game.choose=0;
            }
            if(key==KeyEvent.VK_RIGHT){
                game.choose-=1;
           
            if(game.choose<-1)
                game.choose=0;
            
        }
            if(key==KeyEvent.VK_ENTER){checkPanel();}
    return ;}
    

    @Override
    public void keyReleased(KeyEvent e) {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT){
                
           
            if(game.choose<-1)
                game.choose=0;
            
        }
        if(key==KeyEvent.VK_LEFT){
            if(game.choose>1)
                game.choose=0;
        }return ;
    }

   
   
    public void checkPanel(){
        if(game.choose==0){
            game.nPanel=1;
        }
        else 
    System.exit(0);
    }
    
    

  /*  public void paint(Graphics g){
      
            
if(game.choose==0){
    g.setColor(Color.PINK);
    g.setFont(new Font("Tahoma",Font.CENTER_BASELINE,40));
   g.drawString("<Start>", 300, 400);
     
          }

if(game.choose!=0){
     g.setColor(Color.PINK);
    g.setFont(new Font("Tahoma",Font.CENTER_BASELINE,40));
            g.drawString("<Exit>", 300, 400);
           
            
        
        }
        
    }*/
    
}
