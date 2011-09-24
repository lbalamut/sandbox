package euler;

import static java.lang.StrictMath.sqrt;

/**
 */
public class P010SumOfPrimesBellow2M {

    public static void main(String[] args) {
        int max = 2000000;
        boolean [] isNotPrime = new boolean[max];

        long sum = 0;

        isNotPrime[2] = false;

        for (int i = 2; i < max; i++) {
            if (!isNotPrime[i]) {
                sum += i;
                for (int j = 2 * i ; j < max; j+= i) {
                    isNotPrime[j] = true;
                }
            }
        }
        System.out.println(sum);
    }
}
