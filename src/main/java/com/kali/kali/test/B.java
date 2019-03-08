package com.kali.kali.test;

/**
 * Created by mpalavelli on 01-08-2017.
 */
public class B extends Thread {
    public static void main(String[] args) {
        int a =2;


        B b = new B();
        b.start();
    }
    public void run(int a){
        for (int i=0;i<10;i++){
            System.out.println("Value is: "+i);
        }
    }
}
