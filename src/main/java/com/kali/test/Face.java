package com.kali.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;

public class Face extends JFrame implements ActionListener {

	FacePanel mmp = new FacePanel();
	private JButton smile = new JButton("Smile");
	private JButton sad = new JButton("Sad");
	boolean SMILE;

	public Face() {
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		add(mmp);
		JButton smile = new JButton("Smile");
		add(smile);
		smile.addActionListener(this);

		// The applet has a "Sad" button
		JButton sad = new JButton("Sad");
		add(sad);
		sad.addActionListener(this);

		setTitle("Smiley Face");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		Graphics g = null;
		if (cmd.equals("Smile")) { // "Smile" was pressed
			SMILE = true;
			setBackground(Color.yellow);
			repaint();
		} else if (cmd.equals("Sad")) { // "Sad"
			SMILE = false;
			setBackground(Color.lightGray);
			repaint();
		}
		if (SMILE) {
			g.drawArc(70, 95, 60, 60, 225, 90);
		} else {
			g.drawArc(70, 145, 60, 60, 45, 90);
		}
	}
}
