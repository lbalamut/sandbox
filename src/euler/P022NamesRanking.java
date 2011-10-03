package euler;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import static java.util.Arrays.sort;
import static org.junit.Assert.assertEquals;

/**
 */
public class P022NamesRanking {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("./src/euler/P022names.txt")));

        String[] names = reader.readLine().replaceAll("\"", "").split(",");

        sort(names);

        int sum = 0;
        for (int i = 0; i < names.length; i++) {
            sum += rank(names[i]) * (i + 1);
        }
        System.out.println(sum);
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
