package euler;

/**
 */
public class LargestPrimeFactor {

    public static void main(String[] args) {
        long dividend = 600851475143l;
        long n = 2;

        while (n < dividend) {
            if (dividend % n == 0) {
                dividend /= n;
            }
            n++;
        }
        System.out.println(n);

    }
}
