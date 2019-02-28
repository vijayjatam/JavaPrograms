package com.kali.test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IP_From_Java {
	public static void main(String[] args) {
		
		try {
			InetAddress inet = InetAddress.getLocalHost();
			System.out.println("IP of my system is := "+inet.getHostAddress());
			
			Enumeration e = NetworkInterface.getNetworkInterfaces();
			while(e.hasMoreElements())
			{
			    NetworkInterface n = (NetworkInterface) e.nextElement();
			    Enumeration ee = n.getInetAddresses();
			    while (ee.hasMoreElements())
			    {
			        InetAddress i = (InetAddress) ee.nextElement();
			        System.out.println(i.getHostAddress());
			    }
			}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
