package com.kali.kali;

public class PrimeThread extends Thread {
	static long nextNumber = 3;
	static final long max = 0;
	public static int count = 0;
	public long thread = 100;
	public static long[] primes = new long[1000];

	public void run() {
		long myNumber;
		while ((myNumber = getNextNumber()) > max) {
			primes[0] = 2;
			if (prime(myNumber)) {

				primes[count++] = myNumber;
			}
		}
	}

	public static synchronized long getNextNumber() {
		long n = nextNumber;
		nextNumber += 2;
		return n;
	}

	public boolean prime(long n) {
		int i;

		for (i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
}