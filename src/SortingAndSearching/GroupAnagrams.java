package SortingAndSearching;

import java.util.HashMap;
import java.util.LinkedList;

public class GroupAnagrams {

    public static String getAnagramCode(String word1) {
        int[] letterCounter = new int[28];

        for (int i = 0; i < word1.length(); i++) {
            letterCounter[word1.charAt(i) - 97]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < letterCounter.length; i++) {
            stringBuilder.append((char) (i + 97));
            stringBuilder.append(letterCounter[i]);
        }
        return stringBuilder.toString();
    }

    public static LinkedList<String> solve(String[] words) {
        HashMap<String, LinkedList<String>> wrappedWords = new HashMap<>();
        for (String word : words) {
            String key = getAnagramCode(word);
            if (wrappedWords.containsKey(key)) {
                wrappedWords.get(key).push(word);
            } else {
                LinkedList<String> s = new LinkedList<>();
                s.push(word);
                wrappedWords.put(key, s);
            }
        }
        LinkedList<String> res = new LinkedList<>();
        for (LinkedList<String> value : wrappedWords.values()) {
            res.addAll(value);
        }

        return res;
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        System.out.println(solve(array).toString());
    }
}
