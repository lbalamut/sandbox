package euler;

import static euler.EulerUtils.isAbundant;
import static java.lang.System.out;

/**
 */
public class P023SumOfTwoAbundant {

    private static final int MAX = 28123;

    boolean[] abundantSieve = new boolean[MAX];
    {
        for (int i = 1; i < MAX; i++)
            if (isAbundant(i)) {
                abundantSieve[i] = true;
            }
    }

    public static void main(String[] args) {
        EulerUtils.Timer timer = new EulerUtils.Timer();

        P023SumOfTwoAbundant p23SumOfTwoAbundant = new P023SumOfTwoAbundant();
        timer.print();

        int sum = p23SumOfTwoAbundant.sumOfNumbersCannotBeExpressedByTwoAbdundants();
        timer.print();

        out.println(sum + " correct (4179871)");
    }

    private int sumOfNumbersCannotBeExpressedByTwoAbdundants() {
        int sum = 0;

        //Every _even_ integer n > 46 can be expressed as the sum of abundant numbers
        for (int i = 1; i <= 46; i++) {
            if (!canExpressAsSumOfAbundant(i)) {
                sum += i;
            }
        }

        for (int i = 47; i < MAX; i += 2) {
            if (!canExpressAsSumOfAbundant(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private boolean canExpressAsSumOfAbundant(int i) {
        for (int j = 1; j < (i / 2 + 1); j++) {
            if (abundantSieve[j] && abundantSieve[i - j]) {
                return true;
            }
        }
        return false;
    }
}
