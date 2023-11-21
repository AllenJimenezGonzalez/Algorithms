package RecursionAndDynamicProgramming;

import java.util.Stack;

public class TowersOfHanoi {

    public static int solveHanoi(int n, Stack<Integer> origin, Stack<Integer> auxiliary, Stack<Integer> destiny) {
        if (n <= 0) {
            return 1;
        }
        int val1 = solveHanoi(n - 1, origin, destiny, auxiliary);
        destiny.push(origin.pop());
        int val2 = solveHanoi(n - 1, auxiliary, origin, destiny);

        return val1 + val2;
    }

    public static void main(String[] args) {
        Stack<Integer> origin = new Stack<>();
        Stack<Integer> auxiliary = new Stack<>();
        Stack<Integer> destiny = new Stack<>();
        for (int i = 1; i < 5; i++) {
            origin.push(i);
        }

        int steps = solveHanoi(origin.peek(), origin, auxiliary, destiny);
        System.out.println(steps - 1);
        System.out.println(destiny);
    }
}
