package euler;

import static euler.EulerUtils.findPrimeSieve;

/**
 */
public class P010SumOfPrimesBellow2M {

    public static void main(String[] args) {
        int max = 2000000;
        boolean[] notPrime = findPrimeSieve(max);

        long sum = 0;
        for (int i = 2; i < max; i++) {
            if (!notPrime[i]) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
