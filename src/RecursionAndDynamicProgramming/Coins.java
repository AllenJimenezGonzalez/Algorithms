package RecursionAndDynamicProgramming;

import java.util.HashMap;

public class Coins {
    public static int makeChange(int n, int[] denoms) {
        int[][] map = new int[n + 1][denoms.length];
        return makeChangeHelper(n, denoms, 0, map);
    }

    public static int makeChangeHelper(int total, int[] denoms, int index, int[][] map) {
        /* Check cache for prior result. */
        if (map[total][index] > 0) { // retrieve value
            return map[total][index];
        }

        int coin = denoms[index];
        if (index == denoms.length - 1) {
            int remaining = total % coin;
            return remaining == 0 ? 1 : 0;
        }
        int numberOfWays = 0;
        /* Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest). */
        for (int amount = 0; amount <= total; amount += coin) {
            numberOfWays += makeChangeHelper(total - amount, denoms, index + 1, map); // go to next denom
        }

        /* Update cache with current result. */
        map[total][index] = numberOfWays;

        return numberOfWays;
    }

    public static int coinPermutation(int totalAmount, int currentIndex, int[] coinDenominations, HashMap<String, Integer> precalculatedValues) {

        String key = "T" + totalAmount + "CI" + currentIndex;

        if (precalculatedValues.containsKey(key)) return precalculatedValues.get(key);

        int currentCoinDenomination = coinDenominations[currentIndex];

        if (currentIndex == coinDenominations.length - 1) {
            return totalAmount % currentCoinDenomination == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int actualAmount = 0; actualAmount <= totalAmount; actualAmount += currentCoinDenomination) {
            ways += coinPermutation(totalAmount - actualAmount, currentIndex + 1, coinDenominations, precalculatedValues);
        }

        precalculatedValues.put(key, ways);
        return ways;
    }


    public static int coinPermutation(int totalAmount) {
        int[] denominations = {25, 10, 5, 1};
        HashMap<String, Integer> precalculatedValues = new HashMap<>();

        return coinPermutation(totalAmount, 0, denominations, precalculatedValues);
    }

    public static int coinsPermutationSecondWay(int totalAmount, int currentCoinIndex, int[] denominations, HashMap<String, Integer> memoization) {
        // Created by myself, there is some recursion stack limit, works fine under 5000 coins
        String key = "TA" + totalAmount + "CI" + currentCoinIndex;

        if (memoization.containsKey(key)) return memoization.get(key);

        if (totalAmount == 0) return 1;

        if (currentCoinIndex >= denominations.length) {
            return 0;
        }

        if (denominations[currentCoinIndex] > totalAmount) {
            return coinsPermutationSecondWay(totalAmount, currentCoinIndex + 1, denominations, memoization);
        }

        // Explorar el monto antes de restar con el resto de monedas

        int tryWithNextDenomination = coinsPermutationSecondWay(totalAmount, currentCoinIndex + 1, denominations, memoization);

        // Explorar el nuevo monto con el resto de monedas

        int tryWithCurrentDenomination = coinsPermutationSecondWay(totalAmount - denominations[currentCoinIndex], currentCoinIndex, denominations, memoization);

        int ways = tryWithCurrentDenomination + tryWithNextDenomination;

        memoization.put(key, ways);

        return ways;
    }

    public static int coinsPermutationSecondWay(int totalAmount) {

        int[] denominations = {25, 10, 5, 1};

        HashMap<String, Integer> memoization = new HashMap<>();

        return coinsPermutationSecondWay(totalAmount, 0, denominations, memoization);
    }

    public static void main(String[] args) {
        //System.out.println(coinWays(1500));

        int[] denominations = {25, 10, 5, 1};
        int ways = makeChange(5000, denominations);
        System.out.println(ways);
        //System.out.println(coinPermutation(11500));
        System.out.println(coinsPermutationSecondWay(5000));
    }

}
