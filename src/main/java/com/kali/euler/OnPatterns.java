package com.kali.euler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnPatterns {
    public static void main( String args[] ) {
        // String to be scanned to find the pattern.
        String line = "12121";
        String pattern = "[0-9][2,4,6,8][0-9][2,4,6,8][0]";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: "+m.group());
        }else {
            System.out.println("NO MATCH");
        }
    }
}
