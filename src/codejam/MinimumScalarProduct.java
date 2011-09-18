package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.out;
import static java.util.Arrays.sort;

/**
 */
public class MinimumScalarProduct {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));

        int casesCount = parseInt(reader.readLine());

        for (int caseNo = 1; caseNo <= casesCount; caseNo++) {
            int vectorSize = parseInt(reader.readLine());
            long[] v1 = readVector(reader, vectorSize);
            long[] v2 = readVector(reader, vectorSize);

            sort(v1);
            sort(v2);

            long minSum = 0;
            for (int i = 0; i < vectorSize; i++) {
                minSum += v1[i] * v2[vectorSize - i - 1];
            }
            out.println("Case #" + caseNo + ": " + minSum);
        }
    }

    private static long[] readVector(BufferedReader reader, int vectorSize) throws IOException {
        String[] vectorStrings = reader.readLine().split("\\s+");
        long[] vector = new long[vectorSize];
        for (int i = 0; i < vectorSize; i++) {
            vector[i] = parseLong(vectorStrings[i]);
        }
        return vector;
    }
}
