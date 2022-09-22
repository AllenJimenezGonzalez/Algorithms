package ArraysAndStringsChapter;


public class PalindromePermutation {
    public static boolean palindromePermutation(String palindrome){
        palindrome = palindrome.replace(" ","");
        if(palindrome.length() == 1) return true;
        if(palindrome.length() == 2) return false;
        char [] chars = palindrome.toCharArray();
        int [] letterCounter = new int[128];
        for (char aChar : chars) {
            letterCounter[aChar]++;
        }
        boolean flag = false;
        for (int i : letterCounter) {
            if(i%2 !=0 ) {
                if(flag) return false;
                flag = true;
            }
        }
        return true;
    }

    public static void main(String [] args) {
        System.out.println("Is palidrome permutation: "+palindromePermutation("tact coaz"));
    }
}
