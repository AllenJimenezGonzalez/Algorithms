package RecursionAndDynamicProgramming;

public class Parens {
    // Proud, do it by myself
    private static void printParensPermutation(int parensQuantity, int openedParens, int closedParens, String parensBuild) {

        if (openedParens > parensQuantity || closedParens > parensQuantity || closedParens > openedParens) return;

        if (parensBuild.length() == parensQuantity * 2) {
            System.out.println(parensBuild);
        }

        printParensPermutation(parensQuantity, openedParens + 1, closedParens, parensBuild + "(");
        printParensPermutation(parensQuantity, openedParens, closedParens + 1, parensBuild + ")");

    }

    public static void printParensPermutation(int quantity) {
        printParensPermutation(quantity, 0, 0, "");
    }

    public static void main(String[] args) {
        printParensPermutation(3);
    }

}
