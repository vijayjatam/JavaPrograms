package com.kali;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class SortInSingleLoop {
	public static void main(String[] args) {
		find_2nd_Big();
		//sortInSingleLoop();
	}
	public static void find_2nd_Big(){
		int array[] = {3,-1,11,2,0,10,6}; // output -1,0,1,2,3,6,10
		int bigValue = array[0];
		int nextBig = array[1];
		if(nextBig>bigValue){
			nextBig = nextBig+bigValue;
			bigValue = nextBig-bigValue;
			nextBig = nextBig-bigValue;
		}
		for(int i=2;i<array.length;i++){
			if(array[i]>nextBig){
				nextBig =  array[i];
			}
			if(nextBig>bigValue){
				nextBig = nextBig+bigValue;
				bigValue = nextBig-bigValue;
				nextBig = nextBig-bigValue;
			}
		}
		System.out.println(nextBig);
	}
	
	public static void sortInSingleLoop(){
		Random r = new Random();
		int Low = 10;
		int High = 1000;
		int R = r.nextInt(High - Low) + Low;
		List<Integer> valueButtons = new ArrayList<>();

		for (int i = 1; i <= 100000; i++) {
			R = r.nextInt(High - Low) + Low;
			valueButtons.add(R);
		}
		Character.isDigit('j');

		Integer arrayObj[] = (Integer[]) valueButtons.toArray();
		int array[] = new int[arrayObj.length];
		for(int i =0;i<arrayObj.length;i++){
			array[i] = (int) arrayObj[i];
		}
        //array = {3,-1,1,2,0,10,6}; output -1,0,1,2,3,6,10
		int bigValueIndex = 0;
		int bigValue = array[bigValueIndex];
		long time = System.currentTimeMillis();
		System.out.println(time);
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]);
			if(i+1 < array.length)
				System.out.print(",");
		}
		System.out.println();
		for(int i=array.length-1;i>bigValueIndex;i--){
			if(array[i]<bigValue){
				array[bigValueIndex] = array[i];
				array[i] =  bigValue;
				bigValue = array[bigValueIndex];
			}
			if(i-1 == bigValueIndex){
				bigValueIndex++;
				bigValue = array[bigValueIndex];
				i = array.length;
			}
		}
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]);
			if(i+1 < array.length)
				System.out.print(",");
		}
		System.out.println();
		long endtime = System.currentTimeMillis();
		System.out.println(endtime);
		System.out.println(endtime-time);
		if(endtime-time >= 1000)
			HanoiTime.findHanoiTime(0, new BigInteger(String.valueOf((endtime-time))));
		else if(endtime-time > 0)
			HanoiTime.findHanoiTime(0, new BigInteger(String.valueOf(endtime-time)));
	}
}
