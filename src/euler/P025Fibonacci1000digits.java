package euler;


import java.math.BigInteger;

import static java.lang.Math.*;
import static java.math.BigInteger.valueOf;

/**
 */
public class P025Fibonacci1000digits {

    public static void main(String[] args) {

        EulerUtils.Timer timer = new EulerUtils.Timer();

        System.out.println(firstToContain1000DigitsBrute());
        /*
        Fn = phi^n / sqrt(5)

        phi^n / sqrt(5) > 10^999

        phi = (1 + sqrt(5)) / 2;

        n * log(phi) - log(5)/2 > 999 * log(10)
        n * log(phi) - log(5)/2 > 999
        n * log(phi) > 999 + log(5)/2
        n > (999 + log(5) / 2) / log(phi)

        */
        System.out.println((int) ceil((999 + log10(5) / 2) / log10((1 + sqrt(5)) / 2)));

        timer.print();
    }

    private static int firstToContain1000DigitsBrute() {
        final BigInteger max = valueOf(10).pow(999);

        BigInteger i = valueOf(1);
        BigInteger j = valueOf(1);
        BigInteger k = i.add(j);

        int n = 3;

        while (max.compareTo(k) >= 0) {
            i = k.add(j);
            j = i.add(k);
            k = i.add(j);
            n += 3;
        }

        if (max.compareTo(i) < 0) {
            System.out.println("i");
            System.out.println(i);
            return n - 2;
        }

        if (max.compareTo(j) < 0) {
            System.out.println("j");
            System.out.println(j);
            return n - 1;
        }

        System.out.println("k");
        System.out.println(k);
        return n;
    }
}
