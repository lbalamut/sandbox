package euler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 */
public class P31EnglishCoinsCombinations {

    public static void main(String[] args) {
        //73682
        final EulerUtils.Timer timer = new EulerUtils.Timer();
        System.out.println(new P31EnglishCoinsCombinations().getNumberOfPossibleCombinations());
        timer.print();
    }

    @Test
    public void regression() throws Exception {
        assertEquals(73682, new P31EnglishCoinsCombinations().getNumberOfPossibleCombinations());
    }

    @Test
    public void possibleCombinations() throws Exception {
        assertEquals(1, new P31EnglishCoinsCombinations(new int[]{200}).getNumberOfPossibleCombinations());
        assertEquals(1, new P31EnglishCoinsCombinations(new int[]{100}).getNumberOfPossibleCombinations());
        assertEquals(2, new P31EnglishCoinsCombinations(new int[]{200, 100}).getNumberOfPossibleCombinations());
        assertEquals(4, new P31EnglishCoinsCombinations(new int[]{200, 100, 50}).getNumberOfPossibleCombinations());
        assertEquals(7, new P31EnglishCoinsCombinations(new int[]{200, 100, 50, 20}).getNumberOfPossibleCombinations());
    }

    public final int[] coins;

    int[][] combinationsCache;

    public P31EnglishCoinsCombinations() {
        this(new int[]{200, 100, 50, 20, 10, 5, 2, 1});
    }

    P31EnglishCoinsCombinations(int[] coins) {
        this.coins = coins;
        combinationsCache = new int[coins.length][200 + 1];
    }

    public int getNumberOfPossibleCombinations() {
        return getNumberOfPossibleCombinations(200, 0);
    }

    private int getNumberOfPossibleCombinations(final int pennies, final int startCoin) {

        if (startCoin >= coins.length) return 0;
        int cached = combinationsCache[startCoin][pennies];
        if (cached != 0) {
            return cached;
        }

        int combinations = 0;
        for (int i = startCoin; i < coins.length; i++) {
            int coin = coins[i];

            for (int rest = pennies - coin; rest >= 0; rest = rest - coin) {
                if (rest == 0) {
                    combinations++;
                    break;
                } else if (rest > 0) {
                    combinations += getNumberOfPossibleCombinations(rest, i + 1);
                }
            }
        }
        combinationsCache[startCoin][pennies] = combinations;
        return combinations;
    }

    private int getNumberOfPossibleCombinationsDynamic(final int pennies, final int startCoin) {

        if (startCoin >= coins.length) return 0;

        for (int i = startCoin; i < coins.length; i++) {
            int coin = coins[i];


            for (int rest = pennies - coin; rest >= 0; rest = rest - coin) {
                if (rest == 0) {
                    combinationsCache[i][pennies] = 1;
                    break;
                } else if (rest > 0) {
//                    combinationsCache[i+1][rest] = combinationsCache[i];
//                    combinationsCache += getNumberOfPossibleCombinations(rest, i + 1);
                }
            }
        }
//        return combinationsCache[];
        return pennies;
    }
}
