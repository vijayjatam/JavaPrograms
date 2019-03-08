package com.kali.euler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PalindrumProduct {

    public static void main(String[] args) {
        palindrumProd(100,999);
    }

    public static void palindrumProd(int starging, int ending) {
        Map<String, Integer> palindrumMap = new HashMap<>();
        int j;
        for (j = ending; j >= starging; j--) {
            int i;
            for (i = j; i >= starging; i--) {
                if (isPalindrum(j * i)) {
                    System.out.println(String.format("%d * %d = " + j * i + " is palindrum ", j, i));
                    palindrumMap.put(String.format("%d * %d",j,i),(j*i));
                    //break;
                } else {
                    //System.out.println(String.format("%d * %d = " + j * i + " is not palindrum ", j, i));
                }

            }
            if(isPalindrum(j * i)){
                break;
            }
        }
        System.out.println(Collections.max(palindrumMap.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList())));
    }

    public static boolean isPalindrum(int value) {
        String strValue = String.valueOf(value);
        boolean flage = false;
        int length = strValue.length() - 1;
        for (int i = 0; i <= length / 2; i++) {
            if (strValue.charAt(i) == strValue.charAt(length - i)) {
                flage = true;
            } else {
                flage = false;
                break;
            }
        }
        return flage;
    }
}
