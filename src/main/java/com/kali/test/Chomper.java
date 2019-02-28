package com.kali.test;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class Chomper {

    public static void main(String[] args) throws Exception {
    	String imagePath = "file:///C:/Users/mahan.k.palavelli/Desktop/runimages";
    	final Image[] frame = new Image[6];
    	for(int i=1;i<=frame.length; i++) {
    		frame[i-1] = ImageIO.read(new URL(imagePath+"/"+i+".jpg"));
    	}
        final Image[] frames = {
            ImageIO.read(new URL("http://i.stack.imgur.com/XUmOD.png")),
            ImageIO.read(new URL("http://i.stack.imgur.com/zKyiD.png")),
            ImageIO.read(new URL("http://i.stack.imgur.com/4maMm.png")),
            ImageIO.read(new URL("http://i.stack.imgur.com/wn9V5.png"))
        };
       runningImage(frame);
    }
    
    public static void runningImage (final Image[] frame) {
    	final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    	 Runnable r = new Runnable() {

             @Override
             public void run() {
                 JPanel gui = new JPanel(new BorderLayout());

                 final JLabel animation = new JLabel(new ImageIcon(frame[0]));
                 animation.setOpaque(true);
                 animation.setBackground(Color.white);
                 animation.setForeground(Color.white);
                 gui.add(animation, BorderLayout.CENTER);

                 ActionListener animate = new ActionListener() {

                     private int index = 0;

                     @Override
                     public void actionPerformed(ActionEvent e) {
                         if (index<frame.length-1) {
                             index++;
                         } else {
                             index = 0;
                         }
                         animation.setIcon(new ImageIcon(frame[index]));
                     }
                 };
                 final Timer timer = new Timer(200,animate);

                 final JToggleButton b = new JToggleButton("Start/Stop");
                 ActionListener startStop = new ActionListener() {

                     @Override
                     public void actionPerformed(ActionEvent e) {
                         if (b.isSelected()) {
                             timer.start();
                         } else {
                             timer.stop();
                         }
                     }
                 };
                 b.addActionListener(startStop);
                 gui.add(b, BorderLayout.PAGE_END);
                 splitPane.setBottomComponent(gui);
                 JOptionPane.showMessageDialog(null, splitPane);
             }
         };
         SwingUtilities.invokeLater(r);
    }
}
