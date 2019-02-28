package com.kali.innovate;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UServer {
    public static void startServer(){
        try {
            String pattern = UtilOnly.getPattern();
            ServerSocket ss = new ServerSocket(2222);
            System.out.println("Server is running mode .........");
            Socket s = ss.accept();
            System.out.println("Server accept client .........");
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(pattern);
            //JOptionPane.showMessageDialog(null, new JTextArea(pattern), "Application", 1);
            JOptionPane.showOptionDialog(null,
                    "Secure Key: "+pattern,
                    "Application",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]{"Copy"}, // this is the array
                    "default");
            StringSelection strS = new StringSelection(pattern);
            new Frame().getToolkit().getSystemClipboard().setContents(strS,strS);
        } catch (IOException e) {
            System.out.println("Unable to start or Client disconnected..!");
        }
    }
}
