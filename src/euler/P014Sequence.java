package euler;

/**
 */
public class P014Sequence {

    private static final int MAX = 1000000 - 1;
    private static int[] cache = new int[MAX];

    public static void main(String[] args) {

        int max = 0;
        int output = 0;

        for (int i = MAX; i > 13; i--) {
            int l = getSeqLengthFor(i);
            if (l > max) {
                max = l;
                output = i;
            }
        }
        System.out.println(output);
    }

    public static int getSeqLengthFor(long n) {
        if (n == 4) {
            return 3;
        }
        if (n < MAX) {
            int cached = cache[(int) n];
            if (cached != 0) {
                return cached;
            }
        }

        int count = 1;

        if (n % 2 == 0) {
            count += getSeqLengthFor(n / 2);
        } else {
            count += getSeqLengthFor((3 * n) + 1);
        }

        if (n < MAX) {
            cache[((int) n)] = count;
        }
        return count;
    }

}


