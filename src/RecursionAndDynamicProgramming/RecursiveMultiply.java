package RecursionAndDynamicProgramming;

public class RecursiveMultiply {
    public static int multiply(int factor1, int factor2) {
        if (factor2 == 1) return factor1;
        return multiply(factor1, factor2 - 1) + factor1;
    }

    public static int multiplyImprovedHelper(int min, int max) {
        if (min == 0 || max == 0) return 0;
        if (min == 1) return max;

        int s = min / 2;
        int halfProd = multiplyImprovedHelper(s, max);

        if (min % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + max;
        }

    }

    public static int multiplyImproved(int factor1, int factor2) {
        int min = factor1 > factor2 ? factor2 : factor1;
        int max = factor1 > factor2 ? factor1 : factor2;

        return multiplyImprovedHelper(min, max);
    }


    public static void main(String[] args) {
        System.out.println(multiply(5, 3));
        System.out.println(multiplyImproved(9, 5));
    }
}
