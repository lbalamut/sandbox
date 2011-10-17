package euler;

/**
 */
public class P002Fibonacci {

    private static final int MAX = 4000000;

    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        int k = i + j;

        long sum = 0;

        while (k < MAX) {
            sum += k;
            i = j + k;
            j = k + i;
            k = i + j;
        }
        System.out.println(sum);
    }
}
