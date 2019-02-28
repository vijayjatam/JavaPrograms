package com.kali.innovate;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //StringBuffer finalMorseCode = new StringBuffer("");
        String userName,password;
        System.out.println("Enter User Name: ");
        userName = scan.nextLine();
        System.out.println("Enter Password: ");
        password=scan.nextLine();
        int flag = new Service().verify(userName,password);
        if(flag==0) {
            System.out.println("Hello World...!");
            UtilOnly.shutDown();
        } else if(flag==1) {
            System.out.println("User Name / Password not matched");
            UtilOnly.shutDown();
        } else {
            System.out.println("Unauthorized");
            UtilOnly.shutDown();
        }
    }
}
