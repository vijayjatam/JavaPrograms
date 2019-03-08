package com.kali.kali.innovate;



import com.kali.NumberPlateSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class UniqueKeys {
    private static int patternValue = 5;
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        StringBuffer finalMorseCode = new StringBuffer("");
        String userName,password;
        System.out.println("Enter User Name: ");
        userName = scan.nextLine();
        System.out.println("Enter Password: ");
        password=scan.nextLine();
        String pattern = getPattern();
        System.out.println(pattern);
        finalMorseCode.append(covertToMorse(String.valueOf(userName.charAt(Integer.parseInt(String.valueOf(pattern.charAt(0))) % userName.length()))));
        finalMorseCode.append(" ");
        finalMorseCode.append(covertToMorse(String.valueOf(userName.charAt(Integer.parseInt(String.valueOf(pattern.charAt(1))) % userName.length()))));
        finalMorseCode.append(" ");
        finalMorseCode.append(covertToMorse(String.valueOf(password.charAt(Integer.parseInt(String.valueOf(pattern.charAt(2))) % password.length()))));
        finalMorseCode.append(" ");
        finalMorseCode.append(covertToMorse(String.valueOf(password.charAt(Integer.parseInt(String.valueOf(pattern.charAt(3))) % password.length()))));
        /*UClient uc = new UClient();
        uc.setUserName(userName);
        uc.setPassword(password);
        uc.setPattern(pattern);*/
        System.out.println(finalMorseCode);
    }
    public static String covertToMorse(String letter){
        Map<String,String> letterVsMorse = mapping();
        String morseCode = letterVsMorse.get(letter.toUpperCase());
        if(morseCode == null)
            morseCode = letterVsMorse.get(NumberPlateSum.sumOfNumber(letter));
        return morseCode;
    }
    private static Map<String,String> mapping(){
        Map<String,String> letterVsMorse = new HashMap<>();
        letterVsMorse.put("A",".-");
        letterVsMorse.put("B","-...");
        letterVsMorse.put("C","-.-.");
        letterVsMorse.put("D","-..");
        letterVsMorse.put("E",".");
        letterVsMorse.put("F","..-.");
        letterVsMorse.put("G","--.");
        letterVsMorse.put("H","....");
        letterVsMorse.put("I","..");
        letterVsMorse.put("J",".---");
        letterVsMorse.put("K","-.-");
        letterVsMorse.put("L",".-..");
        letterVsMorse.put("M","--");
        letterVsMorse.put("N","-.");
        letterVsMorse.put("O","---");
        letterVsMorse.put("P",".--.");
        letterVsMorse.put("Q","--.-");
        letterVsMorse.put("R",".-.");
        letterVsMorse.put("S","...");
        letterVsMorse.put("T","-");
        letterVsMorse.put("U","..-");
        letterVsMorse.put("V","...-");
        letterVsMorse.put("W",".--");
        letterVsMorse.put("X","-..-");
        letterVsMorse.put("Y","-.--");
        letterVsMorse.put("Z","--..");

        letterVsMorse.put("0",".....");
        letterVsMorse.put("1","....-");
        letterVsMorse.put("2","...--");
        letterVsMorse.put("3","..---");
        letterVsMorse.put("4",".----");
        letterVsMorse.put("5","-----");
        letterVsMorse.put("6","----.");
        letterVsMorse.put("7","---..");
        letterVsMorse.put("8","--...");
        letterVsMorse.put("9","-....");
        return letterVsMorse;
    }
    private static String getPattern(){
        String text = "1415926535897932384626433832";
        Random rand = new Random();
        int randomNum = rand.nextInt(text.length() - patternValue + 1);
        String answer = text.substring(randomNum, randomNum + patternValue);
        return answer;
    }

}
