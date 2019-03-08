package com.kali.kali;

import java.math.BigInteger;

/**
 * Created by mpalavelli on 11-09-2017.
 */
public class Operators {
    public static void main(String[] args) {


        long a = 122; // 0111 1010 ... 0011 1101
        a = 922337203; // 0000 0111 1101 ~ 1110 1000 ~ 0011 1110 1000 === 0011 0110 1111 1001 1011 1111 1011 0011
        a = 96; // 3 = 0000 0101 32767, 12= 1100
        long b = 4;//0000 0100
        b=2; // 0011
        int i  =20^6; //2^((4*8)-1); XOR => T-T -> F or F-F -> F :)
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i)+"\n"+"-------------------------");
        //bigIntCalc();
        //System.out.println(a&b);
        //System.out.println(a>>>b); // 7 = 0000 0111, 61=0011 1101
        System.out.println(a<<b); // add 'b' many zeros to a's left side.
        System.out.println(Long.toBinaryString(a>>b)); // 24 = 0001 1000  add 'b' many zeros to a's right side.



        int n = 12 - 1;
        System.out.println(" n values: "+n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(" n values: "+n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(" n values: "+n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(" n values: "+n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(" n values: "+n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;

        System.out.println(" n values: "+n);
        System.out.println(Integer.toBinaryString(n));


      //  BigInteger bigInteger = new BigInteger("5644564645");
       // System.out.println(bigInteger.intValue()>>2);




    }
public static void bigIntCalc(){
    BigInteger big = new BigInteger("2");
    System.out.println(BigInteger.valueOf(125).multiply(big.pow(125)));
}



}
