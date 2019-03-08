package com.kali.euler;

public class ThreeAndFiveSum {
    public static void main(String[] args) {
        sum(1000);
    }
    public static void sum(int range){
        int sum = 0;
        for (int i = 3;i<range;i++){
            //System.out.println(i);
            if(i % 3 == 0){
                sum = sum+i;
            } else if(i % 5 == 0){
                sum = sum+i;
            }
        }
        System.out.println(sum);
    }
}
