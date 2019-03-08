package com.kali.kali;

import java.io.*;

/**
 * Created by mpalavelli on 01-12-2017.
 */
public class PrepareLineAsString {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\mpalavelli\\Desktop\\InputFile.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String inputLine;
            String finalStr = "\"";
            while ((inputLine = br.readLine()) != null) {
                finalStr=finalStr+inputLine+"\",\"";
            }
            finalStr=finalStr+"\"";
            System.out.println(finalStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
