package euler;

/**
 */
public class P007_1001prime {

    public static void main(String[] args) {

        long[] primes = findPrimes(10001);
        System.out.println(primes.length + ": " + primes[primes.length - 1]);
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


}
