package euler;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * 89 * 76 = 6764
 * 123 * 45 = 5535
 * <p/>
 * must be in the form of
 * (100 * a + 10 * b + c) * (10 * d + e) == 1000 * f + 100 * g + 10 * h + i
 * 1000ad + 100(bd + ae) + 10(cd  + be) + ce == 1000f + 100g + 10h + i
 */
public class P032PandigitalProduct {

    private static final List<Integer> EMPTY_LIST = Collections.<Integer>emptyList();

    public static void main(String[] args) {
        EulerUtils.Timer timer = new EulerUtils.Timer();
        P032PandigitalProduct product = new P032PandigitalProduct();
        System.out.println(product.sumPandigitals());
        timer.print();
    }

    @Test
    public void regression() throws Exception {
        assertEquals(45228, new P032PandigitalProduct().sumPandigitals());
    }

    int sumPandigitals() {
        return sumPandigitals(EMPTY_LIST, asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    int sumPandigitals(List<Integer> prefix, List<Integer> rest) {
        if (prefix.size() == 4) {
            int f = prefix.get(0);
            int g = prefix.get(1);
            int h = prefix.get(2);
            int i = prefix.get(3);

            int product = 1000 * f + 100 * g + 10 * h + i;
            if (canFormPandigital(product, EMPTY_LIST, rest))
                return product;
            else
                return 0;
        }

        int result = 0;
        for (int i = 0; i < rest.size(); i++) {
            List<Integer> newRest = new ArrayList<Integer>(rest);
            newRest.remove(i);
            List<Integer> newPrefix = new ArrayList<Integer>(prefix);
            newPrefix.add(rest.get(i));

            result += sumPandigitals(newPrefix, newRest);
        }
        return result;
    }

    private boolean canFormPandigital(int product, List<Integer> prefix, List<Integer> rest) {
        if (!rest.isEmpty()) {
            for (int i = 0; i < rest.size(); i++) {
                List<Integer> newRest = new ArrayList<Integer>(rest);
                newRest.remove(i);
                List<Integer> newPrefix = new ArrayList<Integer>(prefix);
                newPrefix.add(rest.get(i));

                if (canFormPandigital(product, newPrefix, newRest))
                    return true;

            }
            return false;
        } else {
            int a = prefix.get(0);
            int b = prefix.get(1);
            int c = prefix.get(2);
            int d = prefix.get(3);
            int e = prefix.get(4);

            return ((100 * a + 10 * b + c) * (10 * d + e) == product
                    || ((1000 * a + 100 * b + 10 * c + d) * e == product));
        }
    }
}
