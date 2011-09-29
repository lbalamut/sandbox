package euler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 */
public class P017NumOfLettersIn1to1000 {
    private static int[] lettersOfLessThan20 = new int[]{
    //      0  1  2  3  4  5  6  7  8  9
            0, 3, 3, 5, 4, 4, 3, 5, 5, 4,
    //      0  1  2  3  4  5  6  7  8  9
            3, 6, 6, 8, 8, 7, 7, 9, 8, 8
    };
    private static int[] lettersOfTenths = new int[]{
    //      0  1  2  3  4  5  6  7  8  9
            0, 0, 6, 6, 5, 5, 5, 7, 6, 6
    };

    static int countLetters(int n) {
        int count = 0;

        int thousands = n / 1000;
        if (thousands >= 1) {
            count += lettersOfLessThan20[thousands] + 8;
            n %= 1000;
        }
        int hundreds = n / 100;
        if (hundreds >= 1) {
            count += lettersOfLessThan20[hundreds] + 7;
            n %= 100;
        }

        if ((thousands > 0 || hundreds > 0) && n > 0) count += 3; //"and"

        if (n >= 20) {
            int tens = n / 10;
            count += lettersOfTenths[tens];
            count += lettersOfLessThan20[n % 10];
        } else {
            count += lettersOfLessThan20[n];
        }

        return count;   //20854
    }

    public static void main(String[] args) {

        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += countLetters(i);

        }
        System.out.println(sum);
    }

    @Test
    public void test() throws Exception {
        assertLengthEquals("three hundred and forty-two", 342);
        assertLengthEquals("one hundred and fifteen", 115);
        assertLengthEquals("one thousand", 1000);
        assertLengthEquals("one hundred and one", 101);
        assertLengthEquals("one hundred and ten", 110);
        assertLengthEquals("one hundred and eleven", 111);
        assertLengthEquals("two hundred and twenty-two", 222);
        assertLengthEquals("three hundred and thirty-three", 333);
        assertLengthEquals("four hundred and forty-four", 444);
        assertLengthEquals("five hundred and fifty-five", 555);
        assertLengthEquals("six hundred and sixty-six", 666);
        assertLengthEquals("seven hundred and seventy-seven", 777);
        assertLengthEquals("eight hundred and eighty-eight", 888);
        assertLengthEquals("nine hundred and ninety-nine", 999);

        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += countLetters(i);

        }
        assertEquals(19, sum);
    }


    private void assertLengthEquals(String s, int n) {
        assertEquals(s.replaceAll("[-\\s]", "").length(), countLetters(n));
    }
}
