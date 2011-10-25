/**
 */
public class StreetsOfManhatan {


    static boolean[][] grid = new boolean[][]{{true,}, {}};


    int path(int x1, int y1, int x2, int y2) {
        if (!grid[x1][y1]) return 0;

        if ((x2 - x1) == 1 && (y2 == y1)) return 1;
        if ((y2 - y1) == 1 && (x2 == x1)) return 1;

        int sum = 0;
        if (grid.length < x1 + 1)
            sum += path(x1 + 1, y1, x2, y2);
        if (grid[x1].length < y1 + 1)
            sum += path(x1, y1 + 1, x2, y2);

        return sum;
    }

    public static void main(String[] args) {

    }
}
