package com.kali.kali;

import com.kali.HanoiTime;
import com.kali.PrimeThread;

import java.math.BigInteger;

//*import java.util.Scanner;
public class MultiThreadedPrimeFinder {
	static final int nThreads = 2;

	public static void main(String[] args) throws InterruptedException {
		int t;
		int total = 0;
		com.kali.PrimeThread[] pthreads = new com.kali.PrimeThread[nThreads];
		// *Scanner kb = new Scanner(System.in);
		// *System.out.println("Enter a Positive Integer: ");
		// *long num = kb.nextLong();
		long starttime, endtime, runtime, a = 0;
		starttime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++)
			a += i;
		for (t = 0; t < nThreads; t++) {
			pthreads[t] = new com.kali.PrimeThread();
			pthreads[t].start();
		}

		for (t = 0; t < nThreads; t++) {
			pthreads[t].join();
			System.out.println("Thread " + t + "  Prime count: "
					+ pthreads[t].count);
		}
		total = com.kali.PrimeThread.count;
		System.out.println("Total prime count: " + total);
		for (int i = 0; i < 1000; i++)
			System.out.println("" + i + ": " + PrimeThread.primes[i]);
		endtime = System.currentTimeMillis();
		runtime = endtime - starttime;
		System.out.println("The run time is " + runtime + " milliseconds");
		HanoiTime.findHanoiTime(0, BigInteger.valueOf(runtime));
	}

}
