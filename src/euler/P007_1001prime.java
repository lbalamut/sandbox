package euler;

/**
 */
public class P007_1001prime {
    public static void main(String[] args) {

        long[] primes = new long[10001];

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
        System.out.println(primesCount + ": " + primes[primesCount - 1]);
    }
}
