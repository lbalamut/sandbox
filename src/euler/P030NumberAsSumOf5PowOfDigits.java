package euler;

import static euler.EulerUtils.powInt;

/**
 */
public class P030NumberAsSumOf5PowOfDigits {
    public static void main(String[] args) {

        int sum = 0;

        for (int num = 5; num < 1000000; num++) {
            if (num == sumOfPowers(num)) {
                System.out.println(num);
                sum +=num;
            }
        }
        System.out.println(sum);
    }

    public static int sumOfPowers(int num) {
        int ret = 0;

        while (num > 0) {
            ret += powInt(num % 10, 5);
            num /= 10;
        }
        return ret;
    }
}
