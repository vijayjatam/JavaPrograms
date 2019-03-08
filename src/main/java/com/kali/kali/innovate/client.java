package com.kali.kali.innovate;

import java.util.*;
import java.io.*;
import java.net.*;
public class client
{
   public static void main(String k[])throws Exception
   {
	try{
     Socket s=new Socket("192.168.0.68",2222);

     System.out.println("Client is waiting ............");
     System.out.println("Yes, client connected to the server");
     DataOutputStream dout=new DataOutputStream(s.getOutputStream());
     Scanner s1=new Scanner(System.in);
     System.out.print("Client::");
     String str=s1.nextLine();
     dout.writeUTF(str);
     int n=0;
     DataInputStream din=new DataInputStream(s.getInputStream());
     String str1=din.readUTF();
     System.out.println("Server::"+str1);
     while(true)
     {
         if(str1.equalsIgnoreCase("bye"))
         {
            dout.writeUTF("bye");
            break;
         }
         else
         {
           System.out.print("Client::");
           str=s1.nextLine();
           dout.writeUTF(str);
           str1=din.readUTF();
           System.out.println("Server::"+str1);
         }
     }
	}catch(Exception e) {
	   System.out.println("Sorry server is not running mode.......");
	}
   }
   public void b(){
       try{
           Socket s=new Socket("192.168.0.68",2222);

           System.out.println("Client is waiting ............");
           System.out.println("Yes, client connected to the server");
           DataOutputStream dout=new DataOutputStream(s.getOutputStream());
           Scanner s1=new Scanner(System.in);
           System.out.print("Client::");
           String str=s1.nextLine();
           dout.writeUTF(str);
           int n=0;
           DataInputStream din=new DataInputStream(s.getInputStream());
           String str1=din.readUTF();
           System.out.println("Server::"+str1);
           while(true)
           {
               if(str1.equalsIgnoreCase("bye"))
               {
                   dout.writeUTF("bye");
                   break;
               }
               else
               {
                   System.out.print("Client::");
                   str=s1.nextLine();
                   dout.writeUTF(str);
                   str1=din.readUTF();
                   System.out.println("Server::"+str1);
               }
           }
       }catch(Exception e) {
           System.out.println("Sorry server is not running mode.......");
       }
   }

}
