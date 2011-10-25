package euler;

import org.junit.Test;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import static euler.EulerUtils.powInt;
import static java.lang.Math.PI;
import static java.lang.StrictMath.acos;
import static java.lang.StrictMath.sqrt;
import static org.junit.Assert.assertEquals;

/**
 */
public class P353RiskyMoon {

    private static final double MAX_RISK = 1000000;
    private static final double PI2 = PI * PI;

    public static void main(String[] args) {

        double sum = 0.0;
        for (int n = 1; n <= 15; n++) {
            final int r = (int) (powInt(2, n) - 1);
            final RiskyMoon moon = new RiskyMoon(r);
            System.out.print("n=" + n + ", r=" + r);

            final double nSum = moon.minRiskToEnd();
            System.out.println(", sum=" + nSum / PI2);
            sum += nSum;
        }
        System.out.println(sum / PI2);
        //a.bcdefghijk
        //1.2765274756245548
        //1.7765898195285847
        //1.776589819528585
    }

    @Test
    public void minRiskFor() throws Exception {
//        minRiskToEnd(1);
//        minRiskToEnd(2);
//        minRiskToEnd(3);
//        minRiskToEnd(4);
//        minRiskToEnd(5);
//        minRiskToEnd(6);
//        System.out.println(new Vec(3, 6, 2, 7).riskTimesPi2(new Vec(0, 7, 0, 7)));
//        System.out.println(new Vec(3, 6, 2, 7).riskTimesPi2(new Vec(3, 6, -2, 7)));
        //a.bcdefghijk
        assertEquals(0.5, new RiskyMoon(1).minRiskToEnd() / PI2, 0.0000000001);
        assertEquals(0.1784943998, new RiskyMoon(7).minRiskToEnd() / PI2, 0.0000000001);
    }

    static class RiskyMoon {

        final int r;
        final int r2;
        final Comparator<Vec> comparator = new Comparator<Vec>() {
            @Override
            public int compare(Vec o1, Vec o2) {
                if (o1.z != o2.z) return o2.z - o1.z;
                if (o1.y != o2.y) return o2.y - o1.y;
                return o2.x - o1.x;
            }
        };

        final TreeSet<Vec> stations = new TreeSet(comparator);

        final Vec start;
        final Vec end;

        public RiskyMoon(int r) {
            this.r = r;
            this.r2 = r * r;
            start = new Vec(0, 0, r);
            end = new Vec(0, 0, -r);
            end.minRisk2End = 0.0;

            stations.add(end);

            for (int z = 0; z <= r; z++) {
                final int z2 = z * z;
                for (int y = 0; y <= r; y++) {
                    final int y2 = y * y;
                    int x2 = r2 - z2 - y2;
                    if (x2 > 0) {
                        final double x = sqrt(x2);
                        int ix = (int) x;
                        if (x == ix) {
                            stations.add(new Vec(ix, y, z));
                            stations.add(new Vec(ix, y, -z));
                        }
                    }
                }
            }
        }

        private class Vec {
            final int x;
            final int y;
            final int z;
            public double minRisk2End = MAX_RISK;

            Vec(int x, int y, int z) {
                this.x = x;
                this.y = y;
                this.z = z;
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

            double riskTimesPi2(Vec o) {
                final double v = acos((double) (x * o.x + y * o.y + z * o.z) / r2);
                return v * v;
            }
        }

        private double minRiskToEnd() {
            return minRiskToEnd(start, stations);
        }


        private double minRiskToEnd(Vec start, NavigableSet<Vec> stations) {

            if (start.minRisk2End != MAX_RISK) {
                return start.minRisk2End;
            }

            double minRisk = MAX_RISK;
            for (Vec vec : this.stations) {
                if (vec.z < start.z) {
                    double risk = start.riskTimesPi2(vec) + minRiskToEnd(vec, stations.tailSet(vec, false));
                    if (risk < minRisk) {
                        minRisk = risk;
                    }
                }
            }
            start.minRisk2End = minRisk;

            return minRisk;
        }
    }
}