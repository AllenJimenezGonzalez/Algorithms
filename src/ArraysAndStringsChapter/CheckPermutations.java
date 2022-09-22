package ArraysAndStringsChapter;

import java.util.Arrays;

public class CheckPermutations {

    public static boolean isPermutation(String value1, String value2){
        if(value1.length() != value2.length()) return false;
        value1=value1.toLowerCase();
        value2=value2.toLowerCase();
        int [] lettersWord1 = new int[128];
        int [] lettersWord2 = new int[128];
        for (int i = 0; i < value1.toCharArray().length; i++) {
            lettersWord1[value1.charAt(i)]++;
            lettersWord2[value2.charAt(i)]++;
        }
        for (int i = 0; i < lettersWord1.length; i++) {
            if(lettersWord1[i] != lettersWord2[i]) return false;
        }
        return true;
    }

    public static boolean isPermutationBookOptimizedByMe(String value1, String value2){
        if(value1.length() != value2.length()) return false;
        value1=value1.toLowerCase();
        value2=value2.toLowerCase();
        int [] lettersWord = new int[128];
        for (int i = 0; i < value1.toCharArray().length; i++) {
            lettersWord[value1.charAt(i)]++;
            lettersWord[value2.charAt(i)]--;
        }
        for (int j : lettersWord) {
            if (j != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("ada","ada"));
        System.out.println(isPermutation("ads","sda9"));
        System.out.println(isPermutation("sapo","sopi"));
        System.out.println("-------------------------------------------------");
        System.out.println(isPermutationBookOptimizedByMe("ada","ada"));
        System.out.println(isPermutationBookOptimizedByMe("ads","sda9"));
        System.out.println(isPermutationBookOptimizedByMe("sapo","sopi"));
    }



}
