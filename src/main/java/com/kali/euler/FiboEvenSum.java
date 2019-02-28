package com.kali.euler;

public class FiboEvenSum {
    private static long v1 = 0;
    private static long v2 = -1;
    private static long sum = 0;

    public static void main(String[] args) {
        fiboSum(4000000);
        System.out.println("\n"+sum);
    }
    public static long fiboSum(long range){
        if(v2<range) {
            if(v2 % 2 == 0)
                sum = sum + v2;
            if(v1 == 0 ){
                v1 = 1;
                System.out.print(v1+" ");
            } else if(v2 == -1){
                v2 = 2;
                System.out.print(v2+" ");
            } else{
                v2 = v1 + v2;
                v1 = v2 - v1;
                System.out.print(v2+" ");
            }
        } else {
            return v2;
        }
       return fiboSum(range-1);
    }
}
