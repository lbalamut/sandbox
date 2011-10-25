package euler;

import java.math.BigInteger;

import static euler.EulerUtils.sumOfDigits;

/**
 */
public class P016SumOfDigits {

    public static void main(String[] args) {
//        byte[] val = new byte[127];
//          val[1] = 1;
//          BigInteger num = new BigInteger(1, val);


        BigInteger num = BigInteger.valueOf(2);

        System.out.println(sumOfDigits(num.pow(1000)));
    }
}
