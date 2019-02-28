package com.kali.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mpalavelli on 01-08-2018.
 */
public class MatchingWordWithStreams {
    public static void main(String[] args) {
        System.out.println("Enter source String....!");
        Scanner scan =new Scanner(System.in);
        String sourceString = scan.nextLine();

        List<String> list =  Stream.of(sourceString.split("")).collect(Collectors.toList());

        Map<String,Integer> map = process(sourceString);
    }
    public static Map<String,Integer> process(String sourceStr){
        List<String> listChars = Stream.of(sourceStr.split("")).collect(Collectors.toList());
        Map<String,Integer> mapChars = listChars.stream().distinct().collect(Collectors.toMap(s->s,s -> Collections.frequency(listChars,s)));
        System.out.println(mapChars);
        return null;
    }

}
