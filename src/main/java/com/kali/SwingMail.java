package com.kali;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SwingMail extends Frame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t3,t4;
	JTextArea t5;
	JPasswordField t2;
	JButton b1,b2;
	String from,pass,to,sub,message,host="smtp.gmail.com",port="587";
	SwingMail()
	{
		setTitle("Send Mail");
		setLayout(new FlowLayout());
		setSize(200,275);
		setResizable(false);
		l1=new JLabel("Your Mail   ");
		l2=new JLabel("Password  ");
		l3=new JLabel("Others Mail");
		l4=new JLabel("Subject    ");
		l5=new JLabel("Message");
		t1=new JTextField(10);
		t2=new JPasswordField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);
		t5=new JTextArea(5,10);
		t5.setBackground(Color.yellow);
		b1=new JButton("Send");
		b2=new JButton("Clear");
		add(l1);add(t1);
		add(l2);add(t2);
		add(l3);add(t3);
		add(l4);add(t4);
		add(l5);add(t5);
		add(b1);add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent we){System.exit(0);}});
		setVisible(true);
	}
	@SuppressWarnings("deprecation")
	public  void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			from=t1.getText().trim();
			pass=t2.getText().trim();
			to=t3.getText().trim();
			sub=t4.getText().trim();
			message=t5.getText().trim();
			if(from.equals("")||pass.equals("")||to.equals(""))
			{
				JOptionPane.showMessageDialog(t1,"Mail Declarations Manditory","Error",2);
			}
			else{
			Properties props = new Properties();
			props.put("mail.smtp.user",from);
			props.put("mail.smtp.host",host);
			props.put("mail.smtp.port",port);
			props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.auth", "true");
			//props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.port",port);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			//SecurityManager security = System.getSecurityManager();
			try {
				Authenticator auth = new SMTPAuthenticator();
				Session session = Session.getInstance(props, auth);
				//session.setDebug(true);

				MimeMessage msg = new MimeMessage(session);
				msg.setText(message);
				msg.setSubject(sub);
				msg.setFrom(new InternetAddress(from));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				Transport.send(msg);
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				JOptionPane.showMessageDialog(t1,"Your Mail is Send Successfully","Success",1);
				} catch (Exception mex) {
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					JOptionPane.showMessageDialog(t1,"Your Mail not Sent","Sorry",2);
				}
			}
		}
		else
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
		}
	}
	private class SMTPAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(from,pass);
		}
		}
	public static void main(String args[])
	{
		SwingMail sm=new SwingMail();
	}
}
