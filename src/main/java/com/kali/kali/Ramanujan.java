package com.kali.kali;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author mahan.k.palavelli
 *
 */
public class Ramanujan {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Map<Integer,String> map = new TreeMap<Integer,String>();
		System.out.println("Enter Bound limit");
		int N = scan.nextInt();
		// for each a, b, c, d, check whether a^3 + b^3 = c^3 + d^3
		for (int a = 1; a <= N; a++) {
			int a3 = a * a * a;
			if (a3 > N)
				break;

			// start at a to avoid print out duplicate
			for (int b = a; b <= N; b++) {
				int b3 = b * b * b;
				if (a3 + b3 > N)
					break;

				// start at a + 1 to avoid printing out duplicates
				for (int c = a + 1; c <= N; c++) {
					int c3 = c * c * c;
					if (c3 > a3 + b3)
						break;

					// start at c to avoid printing out duplicates
					for (int d = c; d <= N; d++) {
						int d3 = d * d * d;
						if (c3 + d3 > a3 + b3)
							break;

						if (c3 + d3 == a3 + b3) {
							map.put(a3 + b3, a + "^3 + " + b + "^3 = " + c + "^3 + " + d + "^3");
							 System.out.print((a3+b3) + " = ");
							 System.out.print(a + "^3 + " + b + "^3 = ");
							 System.out.print(c + "^3 + " + d + "^3");
							 System.out.println();
						}
					}
				}
			}
		}

		Iterator<Integer> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			Object key = itr.next();
			StringBuffer strBuffer = checkForPrimesMulti((Integer)key);
			/*if(strBuffer != null && strBuffer.length()>0){
				System.out.println(key + " = " + map.get(key)+" = "+strBuffer);
			}
			else
				System.out.println(key + " = " + map.get(key));*/
		}
		
//		checkForPrimesMulti(1729);
//		ramanujan_BigInteger();
//		calFormal_1();
	}

	public static void calFormal_1() {
		System.out.print(
				Math.pow(Math.E, Math.log(Math.pow(3, 4) + Math.pow(2, 4) + 1 / (2 + Math.pow(2.0 / 3.0, 2))) / 4));
		System.out.print(" ~ " + Math.PI);
		//  (double)(calculate(4*i)*(1103+(26390*i)))/((Math.pow(calculate(i), 4))*Math.pow(396, (4*i)));
		// System.out.println(Math.pow(Math.E,Math.PI*Math.sqrt(58.0)));
	}

	public static StringBuffer checkForPrimesMulti(int ramanujanNumber) {
		List<Integer> listOfPrimes = new ArrayList<Integer>();
		StringBuffer strBuffer = new StringBuffer();
		boolean flag = true;
		for (int j = 2; j < Math.sqrt(ramanujanNumber); j++) {
			for (int i = 2; i <= Math.sqrt(j); i++) {
				if (j % i == 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				listOfPrimes.add(j);
			flag = true;
		}
		
		for (int i = 0; i < listOfPrimes.size(); i++) {
			if ((i + 2) < listOfPrimes.size()) {
				for(int j= i+1;j<listOfPrimes.size();j++){
					if((j+1) < listOfPrimes.size()){
						for(int k= j+1;k<listOfPrimes.size();k++){
							if((listOfPrimes.get(i)*listOfPrimes.get(j)*listOfPrimes.get(k)) == ramanujanNumber){
								strBuffer.append(listOfPrimes.get(i)+"*"+listOfPrimes.get(j)+"*"+listOfPrimes.get(k));
//								strBuffer.append("\n");
							}
						}
					}
				}
			}
		}
//		System.out.println(strBuffer);
		return strBuffer;
	}
	
	public static void ramanujan_BigInteger(){
		System.out.println("Enter Bound limits");
		BigInteger boundInterger = scan.nextBigInteger();
		for(BigInteger a= new BigInteger("0");a.compareTo(boundInterger)==-1;a.add(new BigInteger("1"))){
			a = a.multiply(a).multiply(a);
			if(a.compareTo(boundInterger)==1){
				break;
			}
			for(BigInteger b= a;b.compareTo(boundInterger)==-1;b.add(new BigInteger("1"))){
				b = b.multiply(b).multiply(b);
				if((a.add(b)).compareTo(boundInterger)==1){
					break;
				}
				for(BigInteger c= a.add(new BigInteger("1"));c.compareTo(boundInterger)==-1;c.add(new BigInteger("1"))){
					c = c.multiply(c).multiply(c);
					if(c.compareTo(a.add(b))==1){
						break;
					}
					for(BigInteger d = c;d.compareTo(boundInterger)==-1;d.add(new BigInteger("1"))){
						d = d.multiply(d).multiply(d);
						if((c.add(d)).compareTo((a.add(b)))==1){
							break;
						}
						if((a.add(b)).compareTo((c.add(d)))==0){
							System.out.println((a.add(b)).toString()+" = ");
						}
					}
				}
			}
		}
	}
}