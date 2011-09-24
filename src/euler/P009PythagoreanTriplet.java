package euler;

/**
 */
public class P009PythagoreanTriplet {
    public static void main(String[] args) {

        for (int a = 3; a < 1000 - 3 / 3; a++) {
            for (int b = a + 1; b < 1000 -a / 2; b++) {
                int c = 1000 - (a + b);
                if (c * c == a * a + b * b) {
                    System.out.println("a: " + a + ", b: " + b + ", c:" + c);
                    long product = a * b * c;
                    System.out.println(product);

                }
            }
        }
    }
}
