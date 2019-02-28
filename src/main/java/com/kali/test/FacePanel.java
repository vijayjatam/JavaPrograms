package com.kali.test;

import java.awt.* ;
import javax.swing.* ;
 
class FacePanel extends JPanel
{
  public void paintComponent(Graphics g)
  {
          //smiley face
        final int MID=150;
        final int TOP=50;
 
          g.setColor (Color.red);
        g.drawOval(100,25,175,175);
        g.setColor(Color.black);
        g.drawOval(135,75,25,25);
        g.setColor(Color.black);
        g.drawOval(200,75,25,25);
        g.drawArc(MID+10,TOP+100,60,20,190,175);
  }
}