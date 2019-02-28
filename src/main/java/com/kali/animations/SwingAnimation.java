package com.kali.animations;

import javax.swing.*;
import java.awt.*;

public class SwingAnimation extends JFrame implements Runnable {
    public SwingAnimation() {
        setTitle("Image on Frame");
        setSize(350, 350);
        setVisible(true);
    }
    public void paint(Graphics g)
    {
        Toolkit tkit = Toolkit.getDefaultToolkit( );
        Image img = tkit.getImage("D:/Mahankaleswararao-301710/firstJava/src/main/java/com/kali/animations/Images/Floppy" + 0 + ".jpg");
        g.drawImage(img, 60, 80, this);


    }
    public static void main( String args[])
    {
        new SwingAnimation();   // anonymous object to access the constructor
    }
    @Override
    public void run(){

    }

}
