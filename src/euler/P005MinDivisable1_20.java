package euler;

import static java.lang.Math.pow;
import static java.lang.System.out;

/**
 */
public class P005MinDivisable1_20 {

    static int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
    static int[] powers = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
    static int[] maxPowers = new int[]{4, 2, 1, 1, 1, 1, 1, 1};

    public static long calculate() {
        long ret = 1;
        for (int i = 0; i < primes.length; i++) {
            ret *= pow(primes[i], powers[i]);
        }
        return ret;
    }

    private static void increasePower() {
        for (int j = 0; j < powers.length; j++) {
            if (powers[j] < maxPowers[j]) {
                powers[j]++;
                return;
            }
        }
        throw new IllegalStateException("cannot increase primes pow5 anymore");
    }

    public static void main(String[] args) {

        for (int i = 2; i <= 20; i++) {
            while (calculate() % i != 0) {
                increasePower();
            }
        }

        long ret = calculate();

        out.println("ret: " + ret);

        for (int i = 2; i <= 20; i++) {
            out.print(i + ":" + ret % i + ", ");
        }
    }
}
