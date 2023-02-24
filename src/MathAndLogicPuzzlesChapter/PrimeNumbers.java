package MathAndLogicPuzzlesChapter;

import java.util.Arrays;

public class PrimeNumbers {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    private static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

    public static boolean[] sieveOfEratostenes(int num) {
        boolean[] flags = new boolean[num + 1];
        Arrays.fill(flags, true);
        int prime = 2;
        while (prime <= Math.sqrt(num)) {
            crossOff(flags, prime);
            prime = getNextPrime(flags, prime);
        }
        return flags;
    }

    public static boolean isPrimeEratostenes(int number) {
        return sieveOfEratostenes(number)[number];
    }

    public static void main(String[] args) {
        System.out.println(isPrime(200));
        System.out.println(isPrimeEratostenes(200));
    }

}
