package com.kali.kali.game.two;

import com.kali.game.two.ThirdQ;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class  SecQ extends JFrame implements ActionListener
{
	JOptionPane p;
	JButton b1,b2;
	JLabel l1,l2;
	JTextField t1,t2;
	SecQ()
	{
		setSize(200,200);
		setLayout(new FlowLayout());
		b1=new JButton("Submit");
		b2=new JButton("Exit");
		l1=new JLabel("2. Ok is ok?");
		l2=new JLabel("Your present score is::");
		t1=new JTextField(10);
		t2=new JTextField(10);
		add(l1);
		add(t1);
		add(b1);add(b2);
		add(l2);add(t2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		t2.setText("                  1");
		t2.setEnabled(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String q=t1.getText().trim();
			if(q.equalsIgnoreCase("ok"))
			{
				new ThirdQ();
				setVisible(false);
			}//innner if
			else
			{
				p.showMessageDialog(t1,"Wrong Answer","Error",2);
				t1.setText("");
			}//else
		}//if
		else
			System.exit(0);
	}

	public static void main(String[] args) 
	{
		new SecQ();
		System.out.println("All the Best");
	}
}
