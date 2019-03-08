package com.kali.kali.singleTon;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EagerSingleTon {
	public static EagerSingleTon eagerSingleTon = new EagerSingleTon();
	private EagerSingleTon(){
	}
	public static EagerSingleTon getInstance(){
		return eagerSingleTon;
	}
}

 class LazySingleTon {
	public static LazySingleTon lazySingleTon;
	private LazySingleTon(){
	}
	public static LazySingleTon getInstance(){
		if(lazySingleTon==null){
			lazySingleTon = new LazySingleTon();
		}
		return lazySingleTon;
	}
}
 
 class StaticSingleTon {
	public static StaticSingleTon staticSingleTon;
	private StaticSingleTon(){
	}
	static{
		try{
			staticSingleTon = new StaticSingleTon();
		}catch(Exception e){
			try {
				throw new Exception("unable to create");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public static StaticSingleTon getInstance(){
		return staticSingleTon;
	}
}

 
 class ThreadSafeSingleTon {
	public static ThreadSafeSingleTon threadSafeSingleTon;
	private ThreadSafeSingleTon(){
	}
	public static synchronized ThreadSafeSingleTon getInstance(){
		if(threadSafeSingleTon ==null){
			threadSafeSingleTon = new ThreadSafeSingleTon();
		}
		return threadSafeSingleTon;
	}
	public static ThreadSafeSingleTon getInstanceForDCL(){
		if(threadSafeSingleTon==null){
			synchronized (ThreadSafeSingleTon.class) {
				threadSafeSingleTon = new ThreadSafeSingleTon();
			}
		}
		return threadSafeSingleTon;
	}
}
 

 
 
 