package com.kali.innovate;

import java.io.*;
import java.net.*;
import java.util.*;
public class server
{
    public static void main(String k[])throws Exception {
       try {
          ServerSocket ss = new ServerSocket(2222);
          System.out.println("Server is waiting for client .........");
          Socket s = ss.accept();
          System.out.println("Yes, connect to client");
          Scanner s1 = new Scanner(System.in);
          DataInputStream din = new DataInputStream(s.getInputStream());
          String str1 = din.readUTF();
          System.out.println("Client::" + str1);
          DataOutputStream dout = new DataOutputStream(s.getOutputStream());
          System.out.print("Server::");
          String str = s1.nextLine();
          dout.writeUTF(str);
          str1 = din.readUTF();
          System.out.println("Client::" + str1);
          while (true) {
             if (str1.equalsIgnoreCase("bye")) {
                dout.writeUTF("bye");
                break;
             } else {
                System.out.print("Server::");
                str = s1.nextLine();
                dout.writeUTF(str);
                str1 = din.readUTF();
                System.out.println("Client::" + str1);
             }
          }
       } catch (Exception e){
          System.out.println("Client(s) disconnected...!");
       }
    }
    public void a(){
        try {
            ServerSocket ss = new ServerSocket(2222);
            System.out.println("Server is waiting for client .........");
            Socket s = ss.accept();
            System.out.println("Yes, connect to client");
            Scanner s1 = new Scanner(System.in);
            DataInputStream din = new DataInputStream(s.getInputStream());
            String str1 = din.readUTF();
            System.out.println("Client::" + str1);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            System.out.print("Server::");
            String str = s1.nextLine();
            dout.writeUTF(str);
            str1 = din.readUTF();
            System.out.println("Client::" + str1);
            while (true) {
                if (str1.equalsIgnoreCase("bye")) {
                    dout.writeUTF("bye");
                    break;
                } else {
                    System.out.print("Server::");
                    str = s1.nextLine();
                    dout.writeUTF(str);
                    str1 = din.readUTF();
                    System.out.println("Client::" + str1);
                }
            }
        } catch (Exception e){
            System.out.println("Client(s) disconnected...!");
        }
    }
}
