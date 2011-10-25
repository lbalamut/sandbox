package euler;

import static euler.EulerUtils.findPrimes;

/**
 */
public class P007_1001prime {

    public static void main(String[] args) {

        long[] primes = findPrimes(10001);
        System.out.println(primes.length + ": " + primes[primes.length - 1]);
    }



}
