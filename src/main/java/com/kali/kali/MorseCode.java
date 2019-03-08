package com.kali.kali;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCode {
    //--.-.....--.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter morse code. Space between letters and '/' between words");
        String morseCode = scan.nextLine();
        Map<String,String> morseCodeMap = new HashMap<>();
        morseCodeMap.put("E",".");
    }
}
/*
* E i s h
* T a u v
*   n r f
*   m d l
*     k b
*     g x
*     o c
*     w z
*       q
*       j
*       p
*       y
*
*/
