package com.kali.animations;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.net.URL;

public class Animation extends Applet implements Runnable
{
	Thread animator;
	Image floppy;
	int imageFrame;
	boolean stopped = false;

	public void init()
	{
		//setBackground(Color.red);
		//setForeground(Color.yellow);

		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				toggleAnimation();
			}
		});
	}

    public void start()
    {
		animator = new Thread(this);
		animator.start();
    }

	public void run()
	{
		while (Thread.currentThread() == animator)
		{
			repaint();

			//showStatus("Click on applet to stop.");
			
			try
			{
				Thread.sleep(1000);
				
				synchronized(this)
				{
					while (stopped)
					{
						//showStatus("Click on applet to restart.");
						wait();
					}
				}
			}

			catch (InterruptedException e)
			{
				break;
			}
//D:\kaliprograms\FirstProject\src\com\kali\animations\Images
			imageFrame = (++imageFrame) % 8;

			String filePath = "D:/Mahankaleswararao-301710/firstJava/src/main/java/com/kali/animations/Images/Floppy"+imageFrame+".jpg";
			floppy = getImage(getCodeBase(), filePath);
		}
	}

    public void stop()
    {
		animator = null;
		floppy = null;
	}

    public void update(Graphics g)
    {
    	try
    	{
			//g.drawString("Walking Floppy", 115, 20);
			g.drawImage(floppy,50,25,this);
			//g.drawImage(floppy, 50, 25, this);
			//g.drawString("Yes", 140, 240);
		}
		
		catch (Exception ex)
		{
		}
    }

	public void paint(Graphics g)
	{
		update(g);
	}

	private synchronized void toggleAnimation()
	{
		if (animator != null && animator.isAlive())
		{
			stopped = !stopped;
			
			if (!stopped)
			{
				notify();
			}
		}
		
		else
		{
			stopped = false;
			start();
		}
	}
}

