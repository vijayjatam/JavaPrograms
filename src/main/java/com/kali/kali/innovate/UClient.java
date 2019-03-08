package com.kali.kali.innovate;

import com.kali.innovate.DTOClass;
import com.kali.innovate.UServer;
import com.kali.innovate.UtilOnly;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UClient {
    public static void createConnection(DTOClass dtoObj, String ipAddress){
        String morseCode = "";
        //UServer.startServer();
        try {
            /*Socket s=new Socket(ipAddress,2222);
            DataInputStream din=new DataInputStream(s.getInputStream());
            String pattern=din.readUTF();*/
            //JOptionPane.showMessageDialog(null, "Code: "+dtoObj.getPattern(), "STOP", 1);
            //UServer.startServer(dtoObj);
            //System.out.println("OTP: "+pattern);

            Executors.newCachedThreadPool().invokeAll(Arrays.asList(
                    new Callable<String>() {
                        @Override public String call() {
                            UServer.startServer();
                            return  null;
                        }
                    },
                    new Callable<String>() {
                        @Override public String call() {
                            Socket s= null;
                            try {
                                s = new Socket(ipAddress,2222);
                                DataInputStream din=new DataInputStream(s.getInputStream());
                                String pattern=din.readUTF();
                                dtoObj.setPattern(pattern);
                                dtoObj.setMorseCode(UtilOnly.covertToMorse(pattern));
                                System.out.println("Please check your code...!");

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return  null;
                        }
                    }));

            //final ExecutorService executorService = Executors.newFixedThreadPool(2);
        } catch (Exception e) {
            System.out.println("Server not an active mode...!");
        }
    }
}
