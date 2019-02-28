package com.kali.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mpalavelli on 05-08-2017.
 */
public class Java8Streams {
    public static void main(String[] args) {
        // Count the strings / Integers in list
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk","abc","abc");
        Set<String> set = new HashSet<String>(strList);
        System.out.println(strList.stream().count());
        //set.stream().forEach(s -> s.equalsIgnoreCase(strList.stream().));
        //strList.stream().filter(x -> x.equalsIgnoreCase(set.stream().forEach(s -> s))).count();
        //strList.stream().filter(x -> x.equalsIgnoreCase(str::strList.stream().distinct())).count();
        long count = strList.stream().filter(x -> x.equalsIgnoreCase("abc")).count();
        System.out.printf("List %s has %d '%s' strings %n", strList, count,"abc");
        List<Integer> intList = Arrays.asList(1,2,3,4,2,2,2,2,2,3,3,4,2,4,3,2);
        count = intList.stream().filter(x -> x==2).count();
        System.out.printf("List %s has %d '%s' strings %n", intList, count,2);

        // Remove doublecat values.
        intList = Arrays.asList(1,2,3,4,2,2,2,2,2,3,3,4,2,4,3,2);
        System.out.println(intList.stream().distinct().collect(Collectors.toList()));

        List<Integer> intList1 = Arrays.asList(1,2,3,4,2,2,2,2,2,3,3,4,2,4,3,2);
        Map map = intList.stream().distinct().collect(Collectors.toMap(x->x, y -> Collections.frequency(intList1,y)));
        System.out.println(map);

        String source = "java,Hello";

        List<String> list = Stream.of(source.split("")).collect(Collectors.toList());
        //list.stream().distinct().flatMap();
        Map<String, Integer> sourceMap = list.stream().distinct().collect(Collectors.toMap(s->s,s->Collections.frequency(list,s)));
        System.out.println(sourceMap);
        sourceMap.entrySet().removeIf(x -> (x.getValue()<=1));

        //sourceMap.entrySet().stream().map()
        System.out.println(sourceMap);

        Arrays.asList(source).stream().map(x->x.split(",")).collect(Collectors.toList())
                .stream().forEach(System.out::println);

    }
}
