package com.kali;

import java.util.Scanner;

public class QuadraticForm {
    public static void main(String[] args) {
        Quadratic();
    }

    public static void Quadratic() {
        String existedForm = "1112,1113,1114,1115,1116,1117,1122,1123,1124,1125,1126,1127,1128,1129,11210,11211,11212,11213,11214,1133,1134,1135,1136,1222,1223,1224,1225,12261227,1233,1234,1235,1236,1237,1238,1239,12310,1244,1245,1246,1247,1248,1249,12410,12411,12412,12413,12414,1256,1257,1258,159,12510";
//		calulate("11210");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number");
        int number = scan.nextInt();
        String[] eachForm = existedForm.split(",");
        for (int i = 0; i < eachForm.length; i++) {
            if (number == calulate(eachForm[i])) {
                System.out.println(number + " is equal to sum of squares of " + eachForm[i]);
            }
        }
    }

    public static int calulate(String eachForm) {
        int finalSquerValue = 0;
        if (eachForm.length() != 5) {
            for (int i = 0; i < eachForm.length(); i++) {
                finalSquerValue = finalSquerValue + (int) (Math.pow(Double.parseDouble(new Character(eachForm.charAt(i)).toString()), 2));
            }
        } else {
            for (int i = 0; i < eachForm.length() - 2; i++) {
                finalSquerValue = finalSquerValue + (int) (Math.pow(Double.parseDouble(new Character(eachForm.charAt(i)).toString()), 2));
            }
            finalSquerValue = finalSquerValue + (int) (Math.pow(Double.parseDouble(eachForm.substring(3)), 2));
        }
        return finalSquerValue;
    }
}
