package euler;


import java.util.ArrayList;
import java.util.List;

import static euler.EulerUtils.factorial;
import static java.util.Arrays.asList;

/**
 */
public class P024MilionthLexonographicPermutation {


    public static void main(String[] args) {
        EulerUtils.Timer timer = new EulerUtils.Timer();

        List<Integer> numbers = asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(nThPermutation(numbers, 1000000));
        System.out.println(nThPermutationModulo(numbers, 1000000));

        timer.print();
    }

    private static StringBuilder nThPermutation(List<Integer> input, int dest) {
        List<Integer> numbers = new ArrayList<Integer>(input);

        StringBuilder ret = new StringBuilder();
        int max = numbers.size();
        int digit = 0;
        int increment = factorial(max).intValue();

        while (numbers.size() > 1) {
            if (dest <= increment) {
                if (digit > 0) {
                    ret.append(numbers.remove(digit));
                    digit = 0;
                }
                increment = factorial(--max).intValue();
            } else if (dest > increment) {
                digit++;
                dest -= increment;
            }
        }


        return ret.append(numbers.remove(0));
    }

    private static StringBuilder nThPermutationModulo(final List<Integer> input, final int dest) {
        List<Integer> numbers = new ArrayList<Integer>(input);

        StringBuilder ret = new StringBuilder();

        int num = dest - 1;
        for (int i = numbers.size() - 1; i >= 0; i--) {

            int fac = factorial(i).intValue();

            ret.append(numbers.remove(num / fac));
            num %= fac;
        }

        return ret;
    }
}

