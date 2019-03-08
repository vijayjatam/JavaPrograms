package com.kali.kali.sg;

/**
 * Created by mpalavelli on 20-09-2017.
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    // Java code below


    static boolean exists(int[] ints, int k) {

        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        return Arrays.binarySearch(ints,k)>-1?true:false;
    }

    public static void main(String[] args) {
        int[] ints = {-9, 14, 37, 102};
        System.out.println(Test.exists(ints, 37)); // true
        System.out.println(Test.exists(ints, 36)); // false
    }
}
