package euler;

/**
 */
public class P010SumOfPrimesBellow2M {

    public static void main(String[] args) {
        int max = 2000000;
        boolean[] notPrime = findPrimeSieve(max);

        long sum = 0;
        for (int i = 2; i < max; i++) {
            if (!notPrime[i]) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

    public static boolean[] findPrimeSieve(int max) {
        boolean[] notPrime = new boolean[max];

        notPrime[2] = false;

        for (int i = 2; i * i < max; i ++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < max; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return notPrime;
    }
}
