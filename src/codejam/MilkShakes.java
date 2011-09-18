package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

/**
 */
public class MilkShakes {


    public static void main(String[] args) throws IOException {
        String pathname = args.length > 0 ? args[0] : "/tmp/milkshakes.in";
        BufferedReader reader = new BufferedReader(new FileReader(new File(pathname)));

        int casesCount = parseInt(reader.readLine());

        for (int caseNo = 1; caseNo <= casesCount; caseNo++) {
            out.println("Case #" + caseNo + ": " + theCase(reader));
        }
    }

    private static String theCase(BufferedReader reader) throws IOException {
        int flavorsCount = parseInt(reader.readLine());
        int customersCount = parseInt(reader.readLine());

        boolean[] toPrepareMalted = new boolean[flavorsCount];

        int[][] customerLikes = new int[customersCount][flavorsCount];
        for (int i = 0; i < customersCount; i++) {
            String line = reader.readLine();
            String[] strings = line.split("\\s+");
            int likesSize = parseInt(strings[0]);
            int[] customerLike = new int[flavorsCount];
            for (int j = 1; j <= likesSize; j++) {
                int flavourIndex = parseInt(strings[2 * j - 1]) - 1;
                boolean malted = "1".equals(strings[2 * j]);
                customerLike[flavourIndex] = malted ? 1 : -1;
            }

            customerLikes[i] = customerLike;
        }

        int updated = update(toPrepareMalted, customerLikes);
        while (updated > 0) {
            updated = update(toPrepareMalted, customerLikes);
        }

        if (updated < 0) {
            return "IMPOSSIBLE";
        }
        StringBuilder caseOutput = new StringBuilder();
        for (boolean malted : toPrepareMalted) {
            caseOutput.append(malted ? 1 : 0).append(" ");
        }

        return caseOutput.substring(0, caseOutput.length() - 1);
    }

    private static int update(boolean[] toPrepareMalted, int[][] customerLikes) {

        for (int[] like : customerLikes) {
            boolean satisfied = false;
            for (int i = 0; i < like.length; i++) {
                if ((toPrepareMalted[i] && like[i] > 0)
                        || !toPrepareMalted[i] && like[i] < 0) {

                    satisfied = true;
                    break;
                }
            }
            if (!satisfied) {
                boolean possible = true;
                for (int i = 0; i < like.length; i++) {
                    if (like[i] < 0 && toPrepareMalted[i]) {
                        return -1;
                    }
                }
                for (int i = 0; i < like.length; i++) {
                    if (like[i] > 0 && !toPrepareMalted[i]) {
                        toPrepareMalted[i] = true;
                        break;
                    }
                }

                return 1;
            }
        }

        return 0;
    }
}
