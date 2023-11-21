package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PermutationWithDups {
    public static ArrayList<String> buildPermutation(String word) {
        char[] char_word = word.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        //Base case
        res.add(word);
        buildPermutation(char_word, 0, res);
        return res;
    }

    public static void buildPermutation(char[] word, int position, ArrayList<String> res) {
        if (position == word.length - 1) return;
        buildPermutation(word, position + 1, res);
        for (int i = position; i < word.length; i++) {
            if (i != position) {
                System.out.println("-- " + position + " -- " + i + " --");
                if (word[position] != word[i]) {
                    char[] resWord = swap(word, position, i);
                    res.add(new String(resWord));
                    buildPermutation(resWord, position + 1, res);
                }
            }
        }
    }

    public static char[] swap(char[] word, int pos1, int pos2) {
        char[] res = word.clone();
        char savedChar = res[pos2];
        res[pos2] = res[pos1];
        res[pos1] = savedChar;
        return res;
    }

    public static void main(String[] args) {
        // System.out.println(buildPermutation("abcd").size());
        ArrayList<String> res = buildPermutation("abcd");
        System.out.println(res);
        System.out.println(res.size());
    }
}
