package euler;

import java.math.BigDecimal;
import java.math.BigInteger;

import static euler.EulerUtils.factorial;

/**
 */
public class P015RoutesThroughGrid {

    static BigInteger routesCalc(final int n) {
        BigInteger fac = factorial(n);
        return factorial(2 * n).divide(fac.multiply(fac));
    }


    public static void main(String[] args) {
        System.out.println(routesCalc(20));
    }
}
