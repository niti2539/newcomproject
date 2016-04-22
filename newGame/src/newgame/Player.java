/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Player  implements KeyListener{
    private int x=0;
    public int movex=0;
    ArrayList<Enemy> cbomb=ControlBomb.Nbomb;
    public Game game;
  
    public Player(Game game){
        x=250;
        this.game=game;
        
        
        
    }
    public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(x, 430,25,25 );
        
        
    }
    public void update(){
        x+=movex;
         if(x<=0){
           movex=0;
             x=0;}
       if(x+25>=800){
           movex=0;
            x=800-25;}
       collision();
    }
  
    public Rectangle getBounds(){
        return new Rectangle(x,430,25,25).getBounds();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ;
    }

    @Override
    public void keyPressed(KeyEvent e) {
       int key=e.getKeyCode();
      
            if(key==KeyEvent.VK_RIGHT)
           movex=3;
            
       if(key==KeyEvent.VK_LEFT)
           movex=-3;
       return ;
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
         int key=e.getKeyCode();
       if(key==KeyEvent.VK_RIGHT)
           movex=0;
       
       if(key==KeyEvent.VK_LEFT)
           movex=0;
       return ;
        
        
    }
    public void collision(){
        for(int i=0;i<cbomb.size();i++){
            if(this.getBounds().intersects(cbomb.get(i).getBounds())){
                //game.stop();
                game.setnPanel(2);
            }
        }
    }
    
}
