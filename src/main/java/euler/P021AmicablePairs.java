package euler;

import static euler.EulerUtils.sumOfProperDivisors;

/**
 */
public class P021AmicablePairs {


    public static void main(String[] args) {
        System.out.println(sumOfAmicablePairs());
    }

    private static int sumOfAmicablePairs() {
        int sumOfPairs = 0;
        for (int i = 2; i < 10000; i++) {
            int j = sumOfProperDivisors(i);
            if (j > i && sumOfProperDivisors(j) == i) {
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



}



