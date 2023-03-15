package RecursionAndDynamicProgramming;

import java.util.Arrays;

public class TripleStep {

    public static int tripleStepBruteForce(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return tripleStepBruteForce(n - 1) + tripleStepBruteForce(n - 2) + tripleStepBruteForce(n - 3);
        }
    }


    public static int tripleStepMemo(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] != -1) {
            return memo[n];
        } else {
            memo[n] = tripleStepMemo(n - 1, memo) + tripleStepMemo(n - 2, memo) + tripleStepMemo(n - 3, memo);
            return memo[n];
        }
    }

    public static int tripleStepMemo(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return tripleStepMemo(n, memo);
    }


    public static void main(String[] args) {
        int res = tripleStepBruteForce(3);
        System.out.println(res);
        int resMemo = tripleStepMemo(3);
        System.out.println(resMemo);
    }
}
