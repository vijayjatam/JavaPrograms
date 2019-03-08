package com.kali.euler;

import com.kali.jug.JugSolve;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.kali.NumberPlateSum.sumOfIntegers;

public class SmallestMultiple {

    public boolean twoDivisible(int value) {
        boolean flage = false;
        if (value % 2 == 0)
            flage = true;
        return flage;
    }

    public boolean threeOrNineDivisible(int value) {
        boolean flage = false;
        value = sumOfIntegers(String.valueOf(value));
        if (value % 9 == 0)
            flage = true;
        return flage;
    }

    public boolean fourOrEightDivisible(int value) {
        boolean flage = false;
        String strValue = String.valueOf(value);
        value = Integer.parseInt(strValue.substring(strValue.length() - 3, strValue.length()));
        if (value % 8 == 0)
            flage = true;
        return flage;
    }

    public boolean fiveOrTenDivisible(int value) {
        boolean flage = false;
        value = Integer.parseInt(String.valueOf(value).substring(String.valueOf(value).length()));
        if (value == 0) {
            flage = true;
        } else if (value == 5) {
            flage = true;
        }
        return flage;
    }

    public boolean sevenDivisible(int value) {
        boolean flage = false;
        value = value + Integer.parseInt(String.valueOf(value).substring(String.valueOf(value).length())) * 2;
        if (value % 7 == 0)
            flage = true;
        return flage;

    }

    public static void printing() {
        for (int i = 1; i <= 10000; i++) { // 100000000 999999999
            String strI = String.valueOf(i);
            String pattern = "[1-9][0-9][0]"; // [1-9][0-9][0-9][0-9][0-9][0,2,4,6,8][0-9][0,2,4,6,8][0]

            // Create a Pattern object
            Pattern r = Pattern.compile(pattern);

            // Now create matcher object.
            Matcher m = r.matcher(strI);
            if (m.find()) {
                int value = Integer.parseInt(m.group());
                if (value % 7 == 0 && value % 4 == 0 && value % 3 == 0) {
                    System.out.println("Smallest: " + value);
                    break;
                }
               /* if(value % 19 == 0 && value % 18 == 0 && value % 17 == 0 && value % 16 == 0 && value % 14 == 0 && value % 13 == 0 && value % 11 == 0){
                    System.out.println("smallest: "+value);
                    break;
                }*/
            }
        }
    }
    static int count = 0;
    static BigInteger scm = BigInteger.ZERO;
    static Integer value = 0;
    public static void main(String[] args) {
        //printing();
        List list = new ArrayList();
        for(int i =1;i<=17;i++){
            list.add(i);
        }
        value = (Integer) list.get(count);
        list.remove(count);
        System.out.println(lcmOnInt(list));
        for(int i =1;i<=17;i++){
            BigInteger big = new BigInteger(String.valueOf(i));
            list.add(big);
        }
        scm = (BigInteger) list.get(0);
        list.remove(0);
        System.out.println(lcm(list));
        check();
    }
    public static int lcmOnInt(List<Integer> list){
        value = (value*list.get(count)) / JugSolve.GCD(value,list.get(count));
        list.remove(count);
        if(list.size() == count)
            return value;
        return lcmOnInt(list);
    }
    public static BigInteger lcm(List<BigInteger> list) {
        scm = (((BigInteger)list.get(count)).multiply(scm)).divide(gcd((BigInteger) list.get(count),scm));
        list.remove(count);
        if (list.size() == count)
            return scm;
        return lcm(list);
    }
    public static BigInteger gcd(BigInteger n1, BigInteger n2) {
        if (n2.compareTo(BigInteger.ZERO) == 0)
            return n1;
        return gcd(n2, n1.divideAndRemainder(n2)[1]);
    }

    public static void check(){
        BigInteger bigInteger = new BigInteger("7128865274665093053166384155714272920668358861885893040452001991154324087581111499476444151913871586911717817019575256512980264067621009251465871004305131072686268143200196609974862745937188343705015434452523739745298963145674982128236956232823794011068809262317708861979540791247754558049326475737829923352751796735248042463638051137034331214781746850878453485678021888075373249921995672056932029099390891687487672697950931603520000");
        for (long i =1;i<=1000;i++){
            if(bigInteger.divideAndRemainder(BigInteger.valueOf(i))[1].compareTo(BigInteger.ZERO) != 0){
                System.out.println(i+" False ");
                break;
            }
        }
    }
}
