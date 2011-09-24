package euler;

/**
 */
public class P004Palindromes {

    public static void main(String[] args) {

        int ret = 0;
        for (int i = 999; i > 100; i--) {
            for (int j = i; j > 100; j--) {
                int p = i * j;

                if (p <= ret)
                    break;

                if (p > ret && checkPalindrome(p)) {
                    ret = p;
                }
            }
        }
        System.out.println(ret);
    }

    static boolean checkPalindrome(int number) {
        String str = String.valueOf(number);
        if (str.length() != 6) {
            return false;
        }

        return str.charAt(0) == str.charAt(5)
                && str.charAt(1) == str.charAt(4)
                && str.charAt(2) == str.charAt(3);
    }
}
