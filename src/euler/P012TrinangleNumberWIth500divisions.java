package euler;


import static euler.P007_1001prime.findPrimes;

/**
 */
public class P012TrinangleNumberWIth500divisions {

    static long[] primes = findPrimes(500);

    public static void main(String[] args) {

        for (int i = 7; ; i++) {

            int divisors = 0;

            if (i % 2 == 0) {
                divisors = divisors(i / 2) * divisors(i + 1);
            } else {
                divisors = divisors(i) * divisors((i + 1) / 2);
            }

            if (divisors > 500) {
                System.out.println(i * (i + 1) / 2);
                break;
            }
        }
    }


    private static int divisors(long number) {
        int divisors = 1;
        long remainder = number;

        for (int i = 0; i < primes.length; i++) {
            long prime = primes[i];
            if (prime * prime > remainder) {
                divisors *= 2;
                break;
            }
            int power = 0;
            while (remainder % prime == 0) {
                remainder /= prime;
                power++;
            }
            divisors *= (power + 1);
            if (remainder == 1) break;
        }
        return divisors;
    }


}
