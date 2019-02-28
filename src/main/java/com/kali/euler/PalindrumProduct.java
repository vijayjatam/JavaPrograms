package com.kali.euler;

public class PalindrumProduct {

    public static void main(String[] args) {
        palindrumProd();
    }

    public static void palindrumProd() {
        int j;
        for (j = 999; j >= 100; j--) {
            int i;
            for (i = j; i >= 100; i--) {
                if (isPalindrum(j * i)) {
                    System.out.println(String.format("%d * %d = " + j * i + " is palindrum ", j, i));
                    break;
                } else {
                    System.out.println(String.format("%d * %d = " + j * i + " is not palindrum ", j, i));
                }

            }
            if(isPalindrum(j * i)){
                break;
            }
        }
    }

    public static boolean isPalindrum(int value) {
        String strValue = String.valueOf(value);
        boolean flage = false;
        int length = strValue.length() - 1;
        for (int i = 0; i < length / 2; i++) {
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
