package euler;

import java.io.*;

import static euler.P018MaxThroughtTriangle.calculateMaxPath;

/**
 */
public class P067MaxThroughtTriangle100 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("./src/euler/P067triangle.txt")));


        int result = calculateMaxPath(reader);
        System.out.println(result);


    }
}
