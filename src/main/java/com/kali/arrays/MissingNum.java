package com.kali.arrays;

import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.Collectors;

/**
 * Created by mpalavelli on 24-09-2018.
 */
public class MissingNum {
    private static void missingNumber1(int[] numbers, int count){
        int missingcount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
       // Arrays.asList(numbers).stream().map(number->numbers).collect(Collectors.toSet());
        for(int number : numbers){
            bitSet.set(number);
        }
        int missing = 0;
        System.out.println("Missing numbers are below ");
        for (int i =count;i>0;i--) {
            if(missing==bitSet.nextClearBit(i-2))
                break;
            missing = bitSet.nextClearBit(i-2);
            System.out.print(missing+",");

        }
    }
    private  static void missingNumber2(int[] numbers, int count){
        int expectedSum = count * (++count) / 2;
        int actualSum = 0;
        for(int i : numbers){
            actualSum+=i;
        }
        System.out.println(expectedSum - actualSum);
    }

    public static void main(String[] args) {
        int[] arrays = {2,3,6,7};
        missingNumber1(arrays, 7);
        //missingNumber2(arrays, 6);
    }
}
