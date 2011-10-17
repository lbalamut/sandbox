package euler;

import org.junit.Test;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import static java.lang.Math.*;
import static org.junit.Assert.assertEquals;

/**
 */
public class P353RiskyMoon {


    private static final double MAX_RISK = 10000;
    private static int cacheHits = 0;

    public static void main(String[] args) {

        System.out.println(minRiskFor(7));

        double sum = 0.0;
        for (int n = 1; n <= 15; n++) {
            final double nSum = minRiskFor((int) pow(2, n) - 1);
            sum += nSum;
            System.out.println("n= " + n + ", sum " + nSum + ", hits: " + cacheHits);
        }
        System.out.println(sum);
        //a.bcdefghijk
        //1.7765898195285847
        //1.7765898195285847
    }

    @Test
    public void minRiskFor7() throws Exception {
//        minRiskFor(1);
//        minRiskFor(2);
//        minRiskFor(3);
//        minRiskFor(4);
//        minRiskFor(5);
//        minRiskFor(6);
//        System.out.println(new Vec(3, 6, 2, 7).risk(new Vec(0, 7, 0, 7)));
//        System.out.println(new Vec(3, 6, 2, 7).risk(new Vec(3, 6, -2, 7)));
        assertEquals(0.1784943998, minRiskFor(7), 0.0000000001);
        System.out.println("hits: " + cacheHits);
    }

    private static class Vec {
        final int x;
        final int y;
        final int z;
        final int r;
        final int r2;
        public double risk2End = MAX_RISK;

        Vec(int x, int y, int z, int r, int r2) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.r = r;
            this.r2 = r2;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + "," + z + ")";
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + z;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vec vec = (Vec) o;

            if (x != vec.x) return false;
            if (y != vec.y) return false;
            if (z != vec.z) return false;

            return true;
        }

        int product(Vec o) {
            return x * o.x + y * o.y + z * o.z;
        }

        double risk(Vec o) {
            final double v = acos((double) product(o) / r2) / PI;
            return v * v;
        }

        public Vec planeZTailStart() {
            return new Vec(r, r, z, r, r2);
        }
    }

    private static double minRiskFor(final int r) {
        System.out.print("r= " + r);


        final Comparator<Vec> comparator = new Comparator<Vec>() {
            @Override
            public int compare(Vec o1, Vec o2) {
                if (o1.z != o2.z) return o2.z - o1.z;
                if (o1.y != o2.y) return o2.y - o1.y;
                return o2.x - o1.x;
            }
        };

        TreeSet<Vec> stations = new TreeSet(comparator);

        final int r2 = r * r;
        final Vec start = new Vec(0, 0, r, r, r2);
        final Vec end = new Vec(0, 0, -r, r, r2);

        stations.add(end);

        for (int z = 1; z <= r; z++) {
            final int z2 = z * z;
            for (int y = 0; y <= r; y++) {
                final int y2 = y * y;
                int x2 = r2 - z2 - y2;
                if (x2 > 0) {
                    final double x = sqrt(x2);
                    int ix = (int) x;
                    if (x == ix) {
                        stations.add(new Vec(ix, y, z, r, r2));
                        stations.add(new Vec(ix, y, -z, r, r2));
                    }
                }

            }
        }
        System.out.println("...");
        return risk(start, end, stations);
    }


    private static double risk(Vec start, Vec end, NavigableSet<Vec> stations) {
        if (start.equals(end)) {
            return 0.0;
        }

        double minRisk = start.risk2End;
        if (minRisk == MAX_RISK) {
            minRisk = MAX_RISK;
            final NavigableSet<Vec> tail = stations.tailSet(start.planeZTailStart(), true);
            for (Vec vec : tail) {
                double risk = start.risk(vec) + risk(vec, end, tail);
                if (risk < minRisk) {
                    minRisk = risk;
                }
            }
            start.risk2End = minRisk;
        } else {
            cacheHits++;
        }
        return minRisk;
    }
}