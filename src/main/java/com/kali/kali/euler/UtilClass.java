package com.kali.kali.euler;

public class UtilClass {
    public static int sumOfIntegers(String stringNumber) {
        int finalSum = 0;
        for (int i = 0; i < stringNumber.length(); i++) {
            finalSum = finalSum + (new Integer(stringNumber.substring(i, i + 1)));
        }
        return finalSum;
    }
   /* public static int subInteger(int value){
        String strInt = String.valueOf(value);
        return
    }*/

}
