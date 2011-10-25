package euler;

import static euler.EulerUtils.findPrimeSieve;

/**
 * see for not brute force:
 *
 * http://mathworld.wolfram.com/Prime-GeneratingPolynomial.html
 */
public class P027PrimeFormula {
    static final boolean[] primeSieve = findPrimeSieve(1000000);

    public static void main(String[] args) {
        System.out.println(productOfCoefficientsForMaxPrimesSeries());
    }

    private static int productOfCoefficientsForMaxPrimesSeries() {

        int maxPrimes = 0;
        int product = 0;
        for (int b = 2; b < 1000; b++) {

            for (int a = b > 998 ? -999 : -b - 1; a < 1000; a++) {
                int primes = 0;

                for (int n = 0; isPrime(n * (n + a) + b); n++) {
                    primes++;

                }
                if (primes > maxPrimes) {
                    maxPrimes = primes;
                    product = a * b;
                }
            }
        }
        return product;
    }

    private static boolean isPrime(int n) {
        return n > 1 && !primeSieve[n];
    }
}
