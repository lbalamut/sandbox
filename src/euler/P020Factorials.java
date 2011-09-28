package euler;

import java.math.BigInteger;
import static java.math.BigInteger.*;

import static euler.P015RoutesThroughGrid.factorial;

/**
 */
public class P020Factorials {


    public static void main(String[] args) {

        System.out.println(sumOfDigits(factorial(100)));
    }

    public static int sumOfDigits(BigInteger number) {
        int sum = 0;
        for (; ; ) {
            BigInteger[] dAr = number.divideAndRemainder(TEN);
            number = dAr[0];
            sum += dAr[1].intValue();
            if (number.equals(ZERO)) break;
        }
        return sum;
    }
}
