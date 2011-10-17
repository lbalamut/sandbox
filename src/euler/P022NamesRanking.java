package euler;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

import static java.util.Arrays.sort;
import static org.junit.Assert.assertEquals;

/**
 */
public class P022NamesRanking {

    public static void main(String[] args) throws IOException {
        String fileName = "./src/euler/P022names.txt";
        BufferedReader reader = reader(fileName);

        String[] names = reader.readLine().replaceAll("\"", "").split(",");

        sort(names);

        int sum = 0;
        for (int i = 0; i < names.length; i++) {
            sum += rank(names[i]) * (i + 1);
        }
        System.out.println(sum);
    }

    private static BufferedReader reader(String fileName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(new File(fileName)));
    }

    @Test
    public void rank() throws Exception {
        assertEquals(53, rank("COLIN"));
    }

    private static int rank(String name) {
        int rank = 0;
        byte[] bytes = name.getBytes(Charset.forName("UTF-8"));
        for (byte b : bytes) {
            rank += b - 64; //position of A = 65
        }
        return rank;
    }
}
