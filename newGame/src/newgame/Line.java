/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author 58336374
 */
public class Line {
    ArrayList<Enemy> bomb=ControlBomb.Nbomb;

    public Line(){
        
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(0, 455,800, 10);
    }

    public Rectangle getBounds(){
        return new Rectangle(0,455,800,10).getBounds();
    }
     
        
   
    
}
