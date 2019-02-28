package com.kali;

import java.util.Scanner;

/**
 * Created by mpalavelli on 11-09-2017.
 */
public class Ex_From_Ramya {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ranges & starting value");
        int range1 = scan.nextInt();
        int start = scan.nextInt();
        for(int i=1;i<=range1;i++){
            for(int j=0;j<i;j++){
                System.out.print(start+j);
                //System.out.print(start<<j);  //j<<(start)
                System.out.print(" ");
            }
            System.out.println();
            start = start<<1;
        }
    }
}
/*
* << we need to move to left side.( right side always zero will place)...
*
* Ex:-  5 = 0000 0101, 5<<2 -> move 2 bits to left, then binary value & decimal values would be 0001 0100 & 20
*
*
*
*
*
*
* */
