package com.kali.kali;

import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
/**
 * @author mahan.k.palavelli
 *
 */
class Week extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5;
	TextField t1,t2,t3;
	Choice ch1,ch2;
	JButton b1,b2,b3;
	String a[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
	  Calendar calendar = Calendar.getInstance();
	int arr[]={0,400,800,1200,1600,2000,2400,2800,3200,3600,4000,4400,4800,5200,5600,6000,6400,6800,7200,7600,8000,8400,8800,9200,9600,10000,10400,10800,11200,11600,12000,12400,12800,13200,13600,14000,14400};
	Week()
	{
		setSize(200,210);
		setTitle("Kali");
		setLayout(new FlowLayout());
		setResizable(false);
		l1=new JLabel("Enter Year");
		t1=new TextField(5);
		//t1.setFocusable(true);
		l2=new JLabel("Select Month");
		ch1=new Choice();
		l3=new JLabel("Select Date");
		ch2=new Choice();
		b1=new JButton("Submit");
		b2=new JButton("Clear");
		b3=new JButton("Exit");
		l4=new JLabel("Week of the Year");
		t2=new TextField(5);
		//t2.setBackground(Color.orange);
		t2.setForeground(Color.red);
		l5=new JLabel("Name of the Day");
		t3=new TextField(5);
		t3.setForeground(Color.red);
		for(int i=0;i<12;i++)
			ch1.add(a[i]);
		for(int i=1;i<=31;i++)
			ch2.add(Integer.toString(i));
		add(l1);add(t1);
		add(l2);add(ch1);
		add(l3);add(ch2);
		add(b1);add(b2);//addAtEnd(b3);
		add(l4);add(t2);
		add(l5);add(t3);
		t1.setText(Integer.toString(calendar.get(Calendar.YEAR)));
		ch1.select(calendar.get(Calendar.MONTH));
		ch2.select(calendar.get(Calendar.DATE)-1);
	//	System.out.println(calendar.get(Calendar.DATE));
		Mymouse m=new Mymouse();
		b1.addActionListener(m);
		b2.addActionListener(m);
		b3.addActionListener(m);
		b1.addMouseListener(m);
		b2.addMouseListener(m);
		b3.addMouseListener(m);
		ch1.addItemListener(m);
		try{
		t1.addTextListener(m);
		}catch(Exception e)
		{
			System.out.println("Expeception at 90");
		}
		addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent we){System.exit(0);}});
//		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}//week()
	class Mymouse  extends MouseAdapter implements ActionListener,ItemListener,TextListener
	{
		Mymouse m;
		public void actionPerformed(ActionEvent ae)
		{
			int ye,year,r,r2,month=2,d=1;
			int com=Integer.parseInt(ch1.getSelectedItem());
			int r1=Integer.parseInt(ch2.getSelectedItem());
			if(ae.getSource()==b1)
			{
				try{
				if(t1.getText().equals("")||Integer.parseInt(t1.getText().trim())<0||Integer.parseInt(t1.getText().trim())>arr[arr.length-1])
				{
					JOptionPane.showMessageDialog(t1,"Invalid Year","Error",2);
					t1.setText(Integer.toString(calendar.get(Calendar.YEAR)));
					ch1.select(calendar.get(Calendar.MONTH));
					ch2.select(calendar.get(Calendar.DATE)-1);
				}
				else
				{
					year=Integer.parseInt(t1.getText().trim());
					month=Integer.parseInt(ch1.getSelectedItem());
					d=Integer.parseInt(ch2.getSelectedItem());
					switch(month)
					{
						case 1:d=d;break;
						case 2:d=d+3;break;
						case 3:d=d+3;break;
						case 4:d=d+6;break;
						case 5:d=d+1;break;
						case 6:d=d+4;break;
						case 7:d=d+6;break;
						case 8:d=d+2;break;
						case 9:d=d+5;break;
						case 10:d=d+7;break;
						case 11:d=d+3;break;
						case 12:d=d+5;break;
						default:System.out.println(month+" No day: 133");
					}//switch
					if(year%4==0&&month>2)
						d=d+1;
					int year1=year-1;//get the previous year of the given year
					int cal=0,co,co1,rem=0;
					if(year1>=1000|year1>=100)
					{
						cal=year1%100;
						co=cal/4;
						co1=(2*co)+(cal-co);
						co1=co1%7;
						rem=year1-cal;
						//System.out.println("year last part "+co1);
					}//split the previous  year into 2 parts(
					else
					{
						co=year1/4;
						co1=(2*co)+(year1-co);
						co1=co1%7;
					}//else
					for(int i=0;i<arr.length-2;i++)
					{
						if(arr[i+1]>rem && arr[i]<rem)
						{
                                                cal=rem-arr[i];
                                                if(cal==100)
                                                        co1=co1+5;
                                                else if(cal==200)
                                                        co1=co1+3;
                                                else
                                                        co1=co1+1;
						break;
						}
					}
					//System.out.println("total odd day from year "+co1);
				/*	if(3200>rem && 2800<rem)
					{
				 		cal=rem-2800;
                                                if(cal==100)
                                                        co1=co1+5;
                                                else if(cal==200)
                                                        co1=co1+3;
                                                else
                                                        co1=co1+1;
					}
					else if(2800>rem&&2400<rem)
					{
						cal=rem-2400;
                                                if(cal==100)
                                                        co1=co1+5;
                                                else if(cal==200)
                                                        co1=co1+3;
                                                else
                                                        co1=co1+1;

					}
					else if(2400>rem&&2000<rem)
					{
						cal=rem-2000;
						if(cal==100)
							co1=co1+5;
						else if(cal==200)
							co1=co1+3;
						else
							co1=co1+1;
					}//if
					else if(2000>rem&&1600<rem)
					{
						cal=rem-1600;
						if(cal==100)
							co1=co1+5;
						else if(cal==200)
							co1=co1+3;
						else
							co1=co1+1;
					}//
					else if(1600>rem&&1200<rem)
					{
						cal=rem-1200;
						if(cal==100)
							co1=co1+5;
						else if(cal==200)
							co1=co1+3;
						else
							co1=co1+1;
					}//
					else if(1200>rem&&800<rem)
					{
						cal=rem-800;
						if(cal==100)
							co1=co1+5;
						else if(cal==200)
							co1=co1+3;
						else
							co1=co1+1;
					}//
					else if(800>rem&&400<rem)
					{
						cal=rem-1600;
						if(cal==100)
							co1=co1+5;
						else if(cal==200)
							co1=co1+3;
						else
							co1=co1+1;
					}//
					else if(400>rem&&99<rem)
					{
						if(cal==100)
							co1=co1+5;
						else if(cal==200)
							co1=co1+3;
						else
							co1=co1+1;
					}*/
					d=d+co1;
					d=d%7;
					switch(d)
					{
						case 0:t3.setText("Sunday");break;
						case 1:t3.setText("Monday");break;
						case 2:t3.setText("Tuesday");break;
						case 3:t3.setText("Wednesday");break;
						case 4:t3.setText("Thursday");break;
						case 5:t3.setText("Friday");break;
						case 6:t3.setText("Saturday");break;
						default:System.out.println("sorry no day: 260");
					}//switch
					ye=Integer.parseInt(t1.getText().trim());
					r2=ye%4;
					switch(com)
					{
						case 1:r=0;//1st
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 2:r=4;//2nd
						r1=r1+3;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 3:r=8;//3rd
						if(r2==0)
							r1=r1+4;
						else
							r1=r1+3;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 4:r=12;//4th
						if(r2==0)
							r1=r1+7;
						else
							r1=r1+6;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 5:r=17;//5th
						if(r2==0)
							r1=r1+2;
						else
							r1=r1+1;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 6:r=21;//6th
						if(r2==0)
							r1=r1+5;
						else
							r1=r1+4;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 7:r=25;//7th
						if(r2==0)
							r1=r1+7;
						else
							r1=r1+6;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 8:r=30;//8th
						if(r2==0)
							r1=r1+3;
						else
							r1=r1+2;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 9:r=34;//9th
						if(r2==0)
							r1=r1+6;
						else
							r1=r1+5;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 10:r=39;//10th
						if(r2==0)
							r1=r1+1;
						else
							r1=r1+7;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 11:r=43;//11th
						if(r2==0)
							r1=r1+4;
						else
							r1=r1+3;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
						case 12:r=47;//12th
						if(r2==0)
							r1=r1+6;
						else
							r1=r1+5;
						while(r1>=7)
						{
							r=r+1;
							r1=r1-7;
						}//while
						if(r1!=0)
							r=r+1;
						t2.setText(Integer.toString(r));
						break;
					}//switch
				}//else
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(t1,"Invalid Year","Error",2);
					t1.setText(Integer.toString(calendar.get(Calendar.YEAR)));
		ch1.select(calendar.get(Calendar.MONTH));
		ch2.select(calendar.get(Calendar.DATE)-1);
				}//
			}//b1 if
			if(ae.getSource()==b2)
			{
				t1.setText(Integer.toString(calendar.get(Calendar.YEAR)));
		ch1.select(calendar.get(Calendar.MONTH));
		ch2.select(calendar.get(Calendar.DATE)-1);
				t2.setText("");
				t3.setText("");
			}//b2 if
			if(ae.getSource()==b3)
				System.exit(0);
		}//actionPerformed
		public void itemStateChanged(ItemEvent ie)
		{
			int ye = 0,r,flag=0;
			String plac=ch2.getSelectedItem();
			flag=Integer.parseInt(plac);
			if(t1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(t1,"Invalid Year","Error",2);
				t1.setText(Integer.toString(calendar.get(Calendar.YEAR)));
		ch1.select(calendar.get(Calendar.MONTH));
		ch2.select(calendar.get(Calendar.DATE)-1);
			}//if
			else
			{
				try {
					ye=Integer.parseInt(t1.getText().trim());
				}catch (Exception e) {
					JOptionPane.showMessageDialog(t1,"Invalid Year","Error",2);
					t1.setText(Integer.toString(calendar.get(Calendar.YEAR)));
					ch1.select(calendar.get(Calendar.MONTH));
					ch2.select(calendar.get(Calendar.DATE)-1);
				}
			  r=ye%4;
			  String com=ch1.getSelectedItem();
			if(com.equals("2"))
			{
				ch2.removeAll();
				if(r!=0)
				{
					for(int i=1;i<=28;i++)
					ch2.add(Integer.toString(i));
					if(flag>=29)
					ch2.select(Integer.toString(28));
					else
						ch2.select(plac);
				}
				else
				{
					for(int i=1;i<=29;i++)
					ch2.add(Integer.toString(i));
					if(flag>=30)
					ch2.select(Integer.toString(29));
					else
						ch2.select(plac);
				}
			}
			else if(com.equals("4")||com.equals("6")||com.equals("9")||com.equals("11"))
				{
				ch2.removeAll();
				for(int i=1;i<=30;i++)
				ch2.add(Integer.toString(i));
				if(flag>=31)
					ch2.select(Integer.toString(30));
				else
				ch2.select(plac);
				}
			else
				{
				ch2.removeAll();
				for(int i=1;i<=31;i++)
				ch2.add(Integer.toString(i));
				ch2.select(plac);
				}
			}//else
		}//itemStateChanged
		public void mouseEntered(MouseEvent me)
		{
			if(me.getSource()==b1)
				b1.setForeground(Color.green);
			else if(me.getSource()==b2)
				b2.setForeground(Color.yellow);
			else
				b3.setForeground(Color.red);
		}
		public void mouseExited(MouseEvent me)
		{
			if(me.getSource()==b1)
				b1.setForeground(Color.black);
			else if(me.getSource()==b2)
				b2.setForeground(Color.black);
			else
				b3.setForeground(Color.black);
		}
		public void textValueChanged(TextEvent te)
		{
			try{
			//if(clr.equals(""))
			//	 System.out.println("sorr");
			int ye=Integer.parseInt(t1.getText().trim());
			  int r=ye%4;
			  String plac=ch2.getSelectedItem();
			  int flag=Integer.parseInt(plac);
			  int flag1=Integer.parseInt(ch1.getSelectedItem());
			if(r!=0&&flag1==2&&flag<=29)
			{
				ch2.removeAll();
				for(int i=1;i<=28;i++)
				ch2.add(Integer.toString(i));
				if(flag==29)
			  ch2.select(Integer.toString(flag-1));
				else
					ch2.select(Integer.toString(flag));
			  //ch1.select(Integer.toString(2));
			 // if(r!=0)
			}
		    else if(r==0&&flag1==2)
			{
				ch2.removeAll();
				for(int i=1;i<=29;i++)
				ch2.add(Integer.toString(i));
				ch2.select(flag-1);
			}
			}catch(Exception e)
			{
				//System.out.println("Sorry");
			}
		}
	}//mouse class
	public static void main(String[] args) 
	{
		new Week();
	}
}
