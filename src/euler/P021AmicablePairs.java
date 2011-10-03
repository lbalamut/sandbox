package euler;

/**
 */
public class P021AmicablePairs {


    public static void main(String[] args) {
        System.out.println(sumOfAmicablePairs());
    }

    private static int sumOfAmicablePairs() {
        int sumOfPairs = 0;
        for (int i = 2; i < 10000; i++) {
            int j = sumOfPerfectDivisors(i);
            if (j > i && sumOfPerfectDivisors(j) == i) {
                System.out.println(i + " = " + j);
                sumOfPairs += i + j;
            }
        }
        return sumOfPairs;
    }

    private static int sumOfDivisorsBrute(int n) {
        int sum = 1;

        int d = 2;
        while (d * d <= n) {
            if (n % d == 0) {
                sum += d + (n / d);
            }
            d++;
        }

        return sum;
    }

    private static int sumOfPerfectDivisors(final int n) {

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
}



