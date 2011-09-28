package euler;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 */
public class P015RoutesThroughGrid {

    static BigInteger routesCalc(final int n) {
        BigInteger fac = factorial(n);
        return factorial(2 * n).divide(fac.multiply(fac));
    }

    public static BigInteger factorial(int n) {
        if (n == 1) {
            return BigInteger.ONE;
        }
        BigInteger fac = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac;
    }

    public static void main(String[] args) {
        System.out.println(routesCalc(20));
    }
}
