package euler;

import static euler.EulerUtils.powInt;

/**
 * take a look for P290 for simillar
 */
public class P030NumberAsSumOf5PowOfDigits {
    public static void main(String[] args) {

        int sum = new P030NumberAsSumOf5PowOfDigits().bruteForce();
        System.out.println(sum);
    }

    private int bruteForce() {
        int sum = 0;
        for (int num = 5; num < 355000; num++) {
            if (num == sumOfPowers(num)) {
                System.out.println(num);
                sum += num;
            }
        }
        return sum;
    }

    int[] pow5 = new int[10];
    {
        for (int i = 0; i < pow5.length; i++) {
            pow5[i] = (int) powInt(i, 5);

        }
    }

    public int sumOfPowers(int num) {
        int ret = 0;

        while (num > 0) {
            ret += pow5[num % 10];
            num /= 10;
        }
        return ret;
    }
}
