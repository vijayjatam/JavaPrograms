package com.kali.kali;

import com.kali.STSBean;

import java.math.BigInteger;

public class A extends STSBean {
	  void m1(){
		System.out.println("from child");
	}
	  public static void main(String[] args) {
          byte b =  127; //1 byte = 8 bit,  7 combinations = 2^3-1 , so last value 2^7 - 1 = 127.....!
          short s =   32767; // 2 byte = 16 bit,  15 combinations = 2^4-1 , so last value 2^15 - 1 = 32767.....!
          int n = 2147483647; //4 byte = 32 bit,  31 combinations = 2^5-1 , so last value 2^31 - 1 = 2147483647 .....!
          long l =  9223372036854775807L;// 8 byte = 64 bit,  63 combinations = 2^6-1 , so last value 2^63 - 1 = 9223372036854775807L.....!


          BigInteger bi = new BigInteger("500000500000");
          System.out.println(s);
          System.out.println(m2());
	}
	  public static int m2(){
		  try{
			  throw new Exception();
			  //System.out.println("try");
			 // return 1;
		  }
		  catch(ArrayIndexOutOfBoundsException e){
			  System.out.println("ex");
			  return 2;
		  } catch (Exception exp){
			  System.out.println("exp");
		  }
		  finally{
			  System.out.println("final");
			  return 3;
		  }
	  }
}
