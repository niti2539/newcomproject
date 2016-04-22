/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgame;

import javax.swing.JFrame;

/**
 *
 * @author 58336374
 */
public class NewGame {
 final static int width=800;
 final static  int height=600;
  
    public static void main(String[] args) {
      JFrame q =new JFrame("Project Com");
     q.setSize(800, 600);
     q.add(new Game());
     q.setLocationRelativeTo(null);
     q.setResizable(false);
     q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     q.setVisible(true);
     
    }
    
}
