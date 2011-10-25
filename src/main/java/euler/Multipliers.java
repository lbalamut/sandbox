package euler;

/**
 */
public class Multipliers {

    private static final long TARGET = 1000000000;

    public static void main(String[] args) {
//        System.out.println(bruteForce(TARGET));

        System.out.println(sumDividableBy(3, TARGET) + sumDividableBy(5, TARGET) - sumDividableBy(15, TARGET));
    }

    private static long bruteForce(final long target) {
        long sum = 0;
        for (long i = 0; i < target; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static long sumDividableBy(int n, long target) {
        long p = target / n;
        return n * (p * (p + 1)) / 2;
    }
}
