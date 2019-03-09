package com.kali.algebrafunctions;

import com.kali.Factorial;

import java.math.BigInteger;

public class A_Plus_B {
    static BigInteger finalValue = BigInteger.ZERO;
    static long k = 0;

    public static void main(String[] args) {
        System.out.println(new A_Plus_B().a_b_power(2, 3, 6));
        //System.out.println(ncr(10, 2));
    }

    public BigInteger a_b_power(long a, long b, long n) {
        for (long k =0;k<=n;k++){
            BigInteger ncr = ncr(n,k);
            BigInteger aPower = power(a,n-k);
            BigInteger bPower = power(b,k);
            finalValue = finalValue.add(ncr.multiply(aPower).multiply(bPower));
        }
        return finalValue;
    }

    public static BigInteger power(long base, long power) {
        BigInteger bigInteger = BigInteger.valueOf((long) Math.pow(base, power));
        return bigInteger;
    }

    public static BigInteger ncr(long n, long r) {
        //double finalNCR = 0.d;
        BigInteger bigInteger = BigInteger.ZERO;
        if (r == 0 || n == r) {
            return BigInteger.ONE;
        } else if (r > n) {
            n = n + r;
            r = n - r;
            n = n - r;
        }
        Factorial fact = new Factorial();
        if (n - r == 1 || n - 1 == r) {
            return BigInteger.valueOf(n);
        } else if (n - r >= n / 2) {
            BigInteger b1 = fact.findBigFact(BigInteger.valueOf(n), n - r);
            fact.finalValue = BigInteger.ONE;
            BigInteger b2 = fact.findBigFact(BigInteger.valueOf(r), 0);
            bigInteger = b1.divideAndRemainder(b2)[0];
            /*long l1 = fact.findIntFact(n, n-r);
            fact.finalVal = 1;
            long l2 = fact.findIntFact(r,0);
            finalNCR =  l1 / l2;*/
        } else {
            BigInteger b1 = fact.findBigFact(BigInteger.valueOf(n), r);
            fact.finalValue = BigInteger.ONE;
            BigInteger b2 = fact.findBigFact(BigInteger.valueOf(n - r), 0);
            bigInteger = b1.divideAndRemainder(b2)[0];
            /*long l1 = fact.findIntFact(n,r);
            fact.finalVal = 1;
            long l2 = fact.findIntFact(n-r,0);
            finalNCR =  l1 / l2;*/
        }
        return bigInteger;
    }
}
