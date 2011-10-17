package euler;

import org.junit.Test;

import java.math.BigInteger;

import static java.lang.System.nanoTime;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 */
public class EulerUtils {
    static long powInt(int a, int pow) {
        if (a == 0 || a == 1 ) return a;
        long ret = a;
        for (int i = 1; i < pow; i++) {
            ret *=a;
        }
        return ret;
    }

    public static class Timer {
        long start = nanoTime();

        public void print() {
            System.out.println("time: " + NANOSECONDS.toMillis(nanoTime() - start));
        }
    }

    public static BigInteger factorial(int n) {
        if (n == 1 || n == 0) {
            return BigInteger.ONE;
        }
        BigInteger fac = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac;
    }

    public static int sumOfDigits(BigInteger number) {
        int sum = 0;
        for (; ; ) {
            BigInteger[] dAr = number.divideAndRemainder(TEN);
            number = dAr[0];
            sum += dAr[1].intValue();
            if (number.equals(ZERO)) break;
        }
        return sum;
    }

    public static long[] findPrimes(final int number) {
        long[] primes = new long[number];

        primes[0] = 2;

        int primesCount = 1;

        for (int candidate = 3; primesCount < primes.length; candidate += 2) {

            boolean isPrime = true;
            for (int j = 0; j < primesCount; j++) {
                if (candidate % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[primesCount++] = candidate;
            }
        }
        return primes;
    }

    public static boolean[] findPrimeSieve(int max) {
        boolean[] notPrime = new boolean[max];

        notPrime[2] = false;

        for (int i = 2; i * i < max; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < max; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return notPrime;
    }

    public static int sumOfProperDivisors(final int n) {

        int sum = 1;
        int p = 2;
        int r = n;
        while (p * p <= r && r > 2) {
            int k = 1;
            while (r % p == 0) {
                r /= p;
                k *= p;
            }
            if (k > 1) {
                sum *= (k * p - 1) / (p - 1);
            }
            if (p == 2) p = 3;
            else p += 2;
        }
        if (r > 1) sum *= r + 1;

        return sum - n;
    }

    public static boolean isAbundant(final int n) {

        int sum = 1;
        int p = 2;
        int r = n;
        while (p * p <= r && r > 2) {
            int k = 1;
            while (r % p == 0) {
                r /= p;
                k *= p;
            }
            if (k > 1) {
                sum *= (k * p - 1) / (p - 1);
            }
            if (sum > 2 * n) return true;

            if (p == 2) p = 3;
            else p += 2;
        }
        if (r > 1) sum *= r + 1;

        return (sum > 2 * n);
    }

    @Test
    public void abundantCalculations() throws Exception {
        assertFalse(isAbundant(28));
        assertTrue(isAbundant(12));
    }
}
