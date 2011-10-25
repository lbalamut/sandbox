package euler;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.pow;

/**
 */
public class P029DistinctPowers {
    public static void main(String[] args) {
        Set<Double> numbers = new HashSet<Double>();

        for (int a = 2; a <= 100; a++)
        for (int b = 2; b <= 100; b++) {

            numbers.add(pow(a, b));

        }
        System.out.println(numbers.size());
    }

}
