/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author culi
 */
public class AfterBomb extends JLabel implements Runnable{
    Thread runner;
    private int x;
    private BufferedImage boom;
    private int y;
    private Graphics g;
    AfterBomb(int x ,int y,Graphics g) {
        try {
            this.x=x;
            this.y=y;
            this.g = g;
            
            boom=ImageIO.read(getClass().getResource("afterbombnew.gif"));
        } catch (IOException ex) {
           ;
        }
        
    }
    
    @Override
  public void paint(Graphics g){
  }

    @Override
    public void run() {
     if(runner!=null)
     {
    
      repaint();
         try {
             Thread.sleep(100)
                     ;
         } catch (InterruptedException ex) {
             Logger.getLogger(AfterBomb.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    }
    
    public void start()
    {
        g.drawImage(boom, x, y,40,40,null);
        super.paint(g);
        if(runner == null)
        {
            runner = new Thread(this,"afterbomb");
            runner.start();
        }
    }
}
