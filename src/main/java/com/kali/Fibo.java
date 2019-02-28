package com.kali;

import java.math.BigInteger;

public class Fibo {
	static String prefix="";
	public static void main(String[] args) {
		int range = 100;
		//System.out.println(fibona(range, 0, 1));
        System.out.println(bigFibona(range, new BigInteger("0"), new BigInteger("1")));
		/*while(range>=1){
			System.out.println(b+",");//1,1,2,3
			b = a+b;//0+1, 1+1=2,2+1=3
			a = b-a;//1-0=1, 2-1=1, 3-1=2
			range--;//4,3,2
		}*/
	}
	private static String fibona(int range,int a, int b){
		if(range>=1){
			//if(prefix.length()!=0)
				prefix = prefix+"\n"+b;
			/*else
				prefix = prefix+b;*/
			fibona(--range, (a+b)-a, a+b);
			return prefix;
		}
		else{
			return "";
		}
		
	}

    private static String bigFibona(int range, BigInteger a, BigInteger b){
        if(range>=1){
            //if(prefix.length()!=0)
                prefix = prefix+"\n"+b.toString();
            /*else
                prefix = prefix+b.toString();*/
            bigFibona(--range,(a.add(b)).subtract(a),a.add(b));
            return prefix;
        }
        else
            return "";
    }
}
