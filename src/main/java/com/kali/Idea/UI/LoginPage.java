package com.kali.Idea.UI;

import com.kali.shopping.test.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginPage extends JFrame {
    JLabel userName,password;
    JTextField userNameTF,passwordTF;
    JButton submit,cancel;
    JPanel jPanel1;

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.pack();
        loginPage.setSize(400, 300);
        loginPage.setLocationRelativeTo(null);
        loginPage.setResizable(false);
        loginPage.setVisible(true);
    }
    public LoginPage(){

        initComponents();
    }
    private void initComponents() {
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        // what happens when user closes the JFrame.
        WindowAdapter windowListener = new WindowAdapter() {
            // anonymous WindowAdapter class
            public void windowClosing(WindowEvent w) {
                // Whatever code you want to actually close the JFrame, e.g.
                LoginPage.this.setVisible(false);
                LoginPage.this.dispose();
            } // end windowClosing

        };// end anonymous class
        this.addWindowListener(windowListener);
        userName = new JLabel();
        userName.setText("UserName");
        password = new JLabel();
        password.setText("Password");
        userNameTF = new JTextField();
        passwordTF = new JTextField();
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        jPanel1 = new JPanel();
        setTitle("Application");
        setBackground(Color.gray);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Login Page"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
                jPanel1);
        getContentPane().add(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout
                .setHorizontalGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                                jPanel1Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(
                                                jPanel1Layout
                                                        .createSequentialGroup()
                                                        .addGap(50,50,50)
                                                        .addGroup(
                                                                jPanel1Layout
                                                                        .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(
                                                                                userName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                108,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(password,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                108,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                10,
                                                                Short.MAX_VALUE)
                                                        .addGroup(
                                                                jPanel1Layout
                                                                        .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(
                                                                                jPanel1Layout
                                                                                        .createSequentialGroup()
                                                                                        .addGap(10,10,10)
                                                                                        .addComponent(userNameTF,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                108,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(passwordTF,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                108,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))));
        jPanel1Layout
                .setVerticalGroup(jPanel1Layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel1Layout
                                        .createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(
                                                jPanel1Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(userName)
                                                        .addComponent(userNameTF,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10,10,10)
                                        .addComponent(password)
                                        .addComponent(passwordTF,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

    }
}
