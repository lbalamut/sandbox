package euler;

import org.junit.Test;

import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;

/**
 */
public class P354HoneycombDistances {
    public static final double SQRT_3 = sqrt(3);

    public static void main(String[] args) {
//        new P354HoneycombDistances().printDistancesFor(1);
//        new P354HoneycombDistances().printDistancesFor(2);
//        new P354HoneycombDistances().printDistancesFor(3);
//        new P354HoneycombDistances().printDistancesFor(4);
//        new P354HoneycombDistances().printDistancesFor(5);
//        System.out.println(new P354HoneycombDistances().countByDistance(21));
        System.out.println(new P354HoneycombDistances().countByDistance(111111111l * 111111111l));
    }

    @Test
    public void countByDistance() throws Exception {
        //1st ring on side
        assertEquals(6, new P354HoneycombDistances().countByDistance(3));
        //2nd ring on side 2*sqrt(3)
        assertEquals(6, new P354HoneycombDistances().countByDistance(12));
        //2nd ring in the middle 3
        assertEquals(6, new P354HoneycombDistances().countByDistance(9));
        //4th ring in the middle
        assertEquals(6, new P354HoneycombDistances().countByDistance(36));
        //3rd ring two around middle
        assertEquals(12, new P354HoneycombDistances().countByDistance(21));
    }

    private int countByDistance(long distance2) {
        System.out.println(distance2);
        final double nMin2 = distance2 / 3;
        final double nMax2 = 4.0d / 9 * distance2;
        System.out.println("min " + sqrt(nMin2));
        System.out.println("max " + sqrt(nMax2));

        int count = 0;
        for (long n = (long) sqrt(nMin2); n <= sqrt(nMax2); n++) {
            long n2 = n * n;

            if (distance2 == 3 * n2) {
                System.out.println("n: " + n + " side");
                count++;
            }

            if (n % 2 == 0) {
//                for (int m = 1; m < (n / 2); m++) {
//                    final int m2 = m * m;
//                    if (distance2 == (2.25 * n2) + 3 * m2) {
//                        System.out.println("n (even): " + n + ", m: " + m);
//                        count += 2;
//                    }
//                }
//                distance2 == (2.25 * n2) + 3 * m2
//                  3 * m2 == distance2 - (2.25 * n2)
//                  m2 == (distance2 - (2.25 * n2)) / 3
                double m = sqrt((distance2 - (2.25 * n2)) / 3);
                if (m >= 1 && m < (n / 2) && m % 1 == 0) {
                    System.out.println("n (even): " + n + ", m: " + m);
                    count += 2;
                } else if (distance2 == (n2 * 9.0 / 4)) {
                    System.out.println("n (even): " + n + " middle");
                    count++;
                }
            } else {
//                distance2 == (2.25 * n2) + 3 * (0.5 + m) * (0.5 + m)
//                distance2 - (2.25 * n2) == 3 * (0.5 + m) * (0.5 + m)
//                (0.5 + m) * (0.5 + m) == (distance2 - (2.25 * n2)) / 3
                double m = sqrt((distance2 - (2.25 * n2)) / 3) - 0.5;
                if (m >= 0 && m < (n / 2) && m % 1 == 0) {
                    System.out.println("n (odd): " + n + ", m: " + m);
                    count += 2;
                }
            }
        }

        return count * 6;
    }

    private void printDistancesFor(int n) {
        System.out.println("6x:");
        final double dmax = SQRT_3 * n;
        final double dmin = 3.0d / 2 * n;
        final int n2 = n * n;

        System.out.println(dmax);

        if (n % 2 == 0) {
            for (int m = 1; m < (n / 2); m++) {
                final int m2 = m * m;
                final double dm = sqrt((2.25 * n2) + 3 * m2);
                System.out.println(dm);
                System.out.println(dm);
            }
            System.out.println(dmin);
        } else {
            for (int m = 0; m < (n / 2); m++) {
                final int m2 = m * m;
                final double dm = sqrt((2.25 * n2) + 3 * (0.5 + m) * (0.5 + m));
                System.out.println(dm);
                System.out.println(dm);
            }
        }

    }
}
