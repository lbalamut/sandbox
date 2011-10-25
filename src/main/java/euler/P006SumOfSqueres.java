package euler;

/**
 */
public class P006SumOfSqueres {
    public static void main(String[] args) {

        int limit = 100;

        long sumOfSquers = limit * (2 * limit +1) * (limit + 1) /6;
        long sum = limit * (limit + 1) / 2;


        System.out.println(sum * sum - sumOfSquers);

    }
}
