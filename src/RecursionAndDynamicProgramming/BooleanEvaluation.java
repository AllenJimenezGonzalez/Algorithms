package RecursionAndDynamicProgramming;

public class BooleanEvaluation {
    public static boolean getBooleanFromString(String c) {
        return c.equals("1");
    }

    public static int evaluateExpression(String expression, boolean desiredValue) {
        if (expression.isEmpty()) return 0;
        if (expression.length() == 1) return getBooleanFromString(expression) == desiredValue ? 1 : 0;

        int ways = 0;
        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);

            String leftSide = expression.substring(0, i);
            String rightSide = expression.substring(i + 1);

            int leftTrue = evaluateExpression(leftSide, true);
            int leftFalse = evaluateExpression(leftSide, false);
            int rightTrue = evaluateExpression(rightSide, true);
            int rightFalse = evaluateExpression(rightSide, false);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
            int totalTrue = 0;
            if (c == '^') {
                totalTrue = (leftTrue * rightFalse) + (leftFalse * rightTrue);
            } else if (c == '&') {
                totalTrue += rightTrue * leftTrue;
            } else if (c == '|') {
                totalTrue += (rightTrue * leftTrue) + (rightTrue * leftFalse) + (leftTrue * rightFalse);
            }

            int subWays = desiredValue ? totalTrue : total - totalTrue;
            ways += subWays;
        }

        return ways;
    }

    public static void main(String[] args) {
    }
}

