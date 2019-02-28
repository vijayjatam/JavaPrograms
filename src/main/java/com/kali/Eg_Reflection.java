package com.kali;

import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Remote;
import java.util.concurrent.Callable;

//import org.apache.poi.hssf.record.WindowOneRecord;


public class Eg_Reflection implements Serializable, Remote{
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		test();
		/*InetAddress inet = null;
		try {
			inet = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		Method[] methodArray = inet.getClass().getMethods();
		Class obj = new Frame().getClass();
		Class[] interfaces = obj.getInterfaces();
		while(obj!=null){
			System.out.println(obj.getName());
			obj = obj.getSuperclass();
		}
		System.out.println("-----------");
		for(Class newClass : interfaces){
			System.out.println(newClass.getName());
		}
		for(Method method : methodArray) {
			String getsOnly = method.getName();
			System.out.println(method);
			if(getsOnly.charAt(0) == 'g') {
				System.out.println(method.invoke(inet, null));
			}
		}*/
	}
	public static void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		STSBean STSB = new STSBean();
		Constructor[] contruct =  STSB.getClass().getConstructors();
		Method[] methos = STSB.getClass().getMethods();
		for(Method meth : methos){
			System.out.println(meth.getName());
			//if(meth.getName().startsWith("get"))
			//	System.out.println(meth.getName());
				//System.out.println(meth.invoke(STSB));
		}
	}
}
