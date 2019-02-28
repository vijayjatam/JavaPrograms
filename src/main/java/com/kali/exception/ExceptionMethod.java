package com.kali.exception;

import java.io.FileNotFoundException;

public class ExceptionMethod {
	public void method1(int integer) throws ReflectiveOperationException  {
		if(integer==2){
			throw new ClassNotFoundException();
		}
	}
	public static void main(String[] args) {
		try {
			//new ExceptionMethod().m1();
			new TestOnException().m1();
		}  catch (RuntimeException illegalArguments) {
            illegalArguments.printStackTrace();
        } catch (Exception illegalArguments) {
            illegalArguments.printStackTrace();
        }

		/*try {
			return;
			//new ExceptionMethod().method1(2);
		} 
		finally{
			System.out.println("from final");
		}*/
//		System.out.println("out of all");
	}
	public void m1()throws Exception{
		m2();
//		throw new ArrayIndexOutOfBoundsException("inka chalu");
		
	}
	public void m2() throws Exception{
		throw m3();
	}
	public Exception m3() {
		 //m1();
		return new Exception("From m3");
	}
}
