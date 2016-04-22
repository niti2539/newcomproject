/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author culi
 */
public class Retry implements KeyListener{
    Game g;
    public Retry(Game g){
        this.g=g;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
       return ;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
      int key =ke.getKeyCode();
      if(key==KeyEvent.VK_ENTER){
          g.nPanel=3;
      }
          return ;
          
    }

    @Override
    public void keyReleased(KeyEvent ke) {
      return ;
    }
    
}
