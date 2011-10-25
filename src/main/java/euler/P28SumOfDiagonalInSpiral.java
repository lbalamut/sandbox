package euler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * http://www.mathblog.dk/2011/project-euler-28-sum-diagonals-spiral/
 */
public class P28SumOfDiagonalInSpiral {

    public static void main(String[] args) {
        System.out.println(sumOfDiagonalsOfSpiralBrute(1001));
    }

    static int sumOfDiagonalsOfSpiralBrute(int maxDim) {

        int n = 1;
        int sum = 1;
        for (int dim = 3; dim <= maxDim; dim += 2) {
            n += dim - 1;
            sum += n;
            n += dim - 1;
            sum += n;
            n += dim - 1;
            sum += n;
            n += dim - 1;
            sum += n;
        }
        return sum;
    }

    @Test
    public void sum() throws Exception {
        assertEquals(101, sumOfDiagonalsOfSpiralBrute(5));
    }
}
