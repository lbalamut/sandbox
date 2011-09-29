package euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static java.lang.Integer.parseInt;

/**
 */
public class P018MaxThroughtTriangle {

    static String input =
            "75\n" +
                    "95 64\n" +
                    "17 47 82\n" +
                    "18 35 87 10\n" +
                    "20 04 82 47 65\n" +
                    "19 01 23 75 03 34\n" +
                    "88 02 77 73 07 63 67\n" +
                    "99 65 04 28 06 16 70 92\n" +
                    "41 41 26 56 83 40 80 70 33\n" +
                    "41 48 72 33 47 32 37 16 94 29\n" +
                    "53 71 44 65 25 43 91 52 97 51 14\n" +
                    "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                    "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                    "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                    "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";


    public static int calculateMaxPath(BufferedReader lines) throws IOException {

        int[] prevMax = readCol(lines);
        int[] max = new int[0];

        for (int[] numbers = readCol(lines); numbers != null ; numbers = readCol(lines)) {

            max = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                if (j == 0) {
                    max[j] = prevMax[j] + numbers[j];
                } else if (j == numbers.length - 1) {
                    max[j] = prevMax[j - 1] + numbers[j];
                } else {
                    max[j] = (prevMax[j] > prevMax[j - 1] ? prevMax[j] : prevMax[j - 1]) + numbers[j];
                }
            }
            prevMax = max;
        }

        int result = 0;
        for (int i = 0; i < max.length; i++) {
            int n = max[i];
            if (n > result) result = n;
        }
        return result;
    }

    public static int[] readCol(BufferedReader lines) throws IOException {
        String row = lines.readLine();
        if (row == null) return null;

        String[] cols = row.split("\\s");
        int[] mums = new int[cols.length];
        for (int i = 0; i < cols.length; i++) {
            mums[i] = parseInt(cols[i]);
        }

        return mums;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader lines = new BufferedReader(new StringReader(input));

        int result = calculateMaxPath(lines);
        System.out.println(result);
    }
}
