package com.kali.kali.animations;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingMutliAni extends JFrame implements Runnable {
    Thread animator;
    Image floppy;
    int imageFrame;
    boolean stopped = false;
    JButton button;
    Toolkit tkit = Toolkit.getDefaultToolkit();

    public static void main(String[] args) {
        new SwingMutliAni().start();
    }

    public SwingMutliAni() {
        button = new JButton();
        button.setSize(100, 100);
        setTitle("Image on Frame");
        setSize(500, 500);
        setVisible(true);
    }

    public void init() {
        //setBackground(Color.red);
        //setForeground(Color.yellow);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                toggleAnimation();
            }
        });
    }

    public void start() {
        animator = new Thread(this);
        animator.start();
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                toggleAnimation();
            }
        });

    }

    public void run() {
        while (Thread.currentThread() == animator) {
            repaint();
            button.setText("Click on to stop.");
            //showStatus("Click on applet to stop.");

            try {
                Thread.sleep(1000);

                synchronized (this) {
                    while (stopped) {
                        //showStatus("Click on applet to restart.");
                        button.setText("Click on to restart.");
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                break;
            }
//D:\kaliprograms\FirstProject\src\com\kali\animations\Images
            imageFrame = (++imageFrame) % 8;

            String filePath = "D:/Mahankaleswararao-301710/firstJava/src/main/java/com/kali/animations/Images/Floppy" + imageFrame + ".jpg";
            floppy = tkit.getImage(filePath);
            //floppy = g.getImage(getCodeBase(), filePath);
        }
    }

    public void stop() {
        animator = null;
        floppy = null;
    }

    public void update(Graphics g) {
        try {
            //g.drawString("Walking Floppy", 115, 20);
            g.drawImage(floppy, 80, 50, this);
            g.drawString("Hello", 115, 20);
            //add(button);
            //g.drawImage(floppy, 50, 25, this);
            //g.drawString("Yes", 140, 240);
        } catch (Exception ex) {
        }
    }

    public void paint(Graphics g) {
        update(g);
    }

    private synchronized void toggleAnimation() {
        if (animator != null && animator.isAlive()) {
            stopped = !stopped;

            if (!stopped) {
                notify();
            }
        } else {
            stopped = false;
            start();
        }
    }
}

