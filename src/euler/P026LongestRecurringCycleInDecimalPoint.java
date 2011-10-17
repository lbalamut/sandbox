package euler;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static euler.EulerUtils.findPrimeSieve;
import static org.junit.Assert.assertEquals;

/**
 * http://mathworld.wolfram.com/DecimalExpansion.html
 */
public class P026LongestRecurringCycleInDecimalPoint {

    public static void main(String[] args) {
        EulerUtils.Timer timer = new EulerUtils.Timer();

        System.out.println(maxCycleLength());

        timer.print();
    }

    private static int maxCycleLength() {
        int max = 0;
        int num = 0;

        final int limit = 1000;
        final boolean[] primeSieve = findPrimeSieve(limit + 1);

        for (int denominator = 7; denominator <= limit; denominator += 2) {

            if (primeSieve[denominator]) continue;

            int cycleLength = 1;
            int numerator = 10 % denominator;
            while (numerator != 1) {
                numerator = (numerator * 10) % denominator;
                cycleLength++;
            }
            final int l = cycleLength;
            if (l > max) {
                max = l;
                num = denominator;
            }
        }
        return num;
    }

    @Test
    public void cycleLengthBruteForce() throws Exception {
        assertEquals(1, cycleLengthBruteForce(3));
        assertEquals(1, cycleLengthBruteForce(6));
        assertEquals(1, cycleLengthBruteForce(9));
        assertEquals(6, cycleLengthBruteForce(7));
        assertEquals(22, cycleLengthBruteForce(23));
        assertEquals(96, cycleLengthBruteForce(97));
    }

    private static int cycleLengthBruteForce(final int denominator) {
        int numerator = 1;

        List<Integer> number = new ArrayList<Integer>();
        List<Integer> remainders = new ArrayList<Integer>();

        while (numerator != 0) {
            numerator *= 10;
            final int digit = numerator / denominator;
            numerator = numerator % denominator;

            for (int i = 0; i < remainders.size(); i++) {
                if (remainders.get(i) == numerator && number.get(i) == digit) {
                    return number.size() - i;
                }
            }
            number.add(digit);
            remainders.add(numerator);
        }
        return 0;
    }

}

