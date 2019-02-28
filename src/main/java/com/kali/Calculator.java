package com.kali;

public class Calculator {
	int a = 10;
	static int b = 20;
    interface IntegerMath {
        int operation(int a, int b);

        /*default IntegerMath swap() {
          return (a, b) -> operation(b, a);
        }*/
//        int sub(int a, int b, int c);
    }

    private static int apply(int a, int b, IntegerMath op) {
    	a=a*2;
    	b = b*a+2;
        return op.operation(a, b);
    }

    static{
//    	Calculator.apply(10, 20, null);
    }
    
    public static void main(String... args) {
        IntegerMath addition = (a,b) -> a*b + b ;
        System.out.println("40 + 2 = " + apply(40, 2, addition));
        addition  = (a, b) -> (b*4);
        System.out.println("40 - 2 = " + apply(40, 12, addition));
//        System.out.println("20 - 10 = " + apply(20, 10, subtraction));
//        System.out.println("10 - 20 = " + apply(20, 10, subtraction.swap())); 
    }
    public void m1(){
    	apply(10, 20, null);
    	a=a*2;
    	b = b*a+2;
    }
}
