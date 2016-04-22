/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgame;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static newgame.ControlBomb.Nbomb;


public class Enemy  {
    public int x=0;
    public int y=0;
    private int speedy=2;
    private BufferedImage bomb;
    private Line line;
    boolean isCollision = false;
    private BufferedImage afterBomb;
    Game c;
    private String typeMissile;
    
    public Enemy(){
        y=0;
        line=new Line();
        x=new Random().nextInt(800);
        typeMissile="missile"+new Random().nextInt(6);
        speedy+=new Random().nextInt(2)*Game.level;
         try {
          afterBomb=ImageIO.read(getClass().getResource("afterbombnew.gif"));
          bomb = ImageIO.read(getClass().getResource(typeMissile+".png"));
        } catch (IOException ex) {
             printStackTrace();
        
    }
      
}
public void update(){
   
                     y=y+speedy+(int)Game.level/2;
                    
                    
}
public void paint(Graphics g){
     if(!isCollision){
        g.drawImage(bomb,x, y, 30,30,null);
     }
     else
         g.drawImage(afterBomb,x, y, 25,25,null);
   }
public Rectangle getBounds(){
    return new Rectangle(x,y,25,25).getBounds();
}
public void draw(Graphics g){
  g.drawImage(afterBomb,x,y,40,40, null);
}
public void collision(){
    
        for(int i=0;i<Nbomb.size();i++){
            if(new Line().getBounds().intersects(Nbomb.get(i).getBounds())){
                isCollision = true;
                Nbomb.remove(i);
                
                
           
                
        }
        }}
public int getX(){
    return x;
}
public int getY(){
    return y;
}



 

        


}
