package euler;

/**
 */
public class P048LastTenDigits {

    public static void main(String[] args) {

        long limit = 10000000000l;
        long result = 0;

        for (int i = 1; i <= 1000; i++) {
            long pow = i;
            for (int j = 1; j < i; j++) {
                 pow = (pow * i) % limit;
            }
            result = (result + pow) % limit;
        }
        System.out.println(result);
    }
}
