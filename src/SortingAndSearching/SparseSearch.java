package SortingAndSearching;

public class SparseSearch {

    public static int searchTheMostCloseIndexToMid(String[] wordsArray, int midIndex, int leftLimit, int rightLimit) {

        int leftIndex = midIndex;
        int rightIndex = midIndex;

        while (leftIndex > leftLimit && rightIndex < rightLimit) {
            if (!wordsArray[leftIndex].isEmpty()) return leftIndex;
            if (!wordsArray[rightIndex].isEmpty()) return rightIndex;
            leftIndex--;
            rightIndex++;
        }

        while (leftIndex >= leftLimit) {
            if (!wordsArray[leftIndex].isEmpty()) return leftIndex;
            leftIndex--;
        }

        while (rightIndex <= rightLimit) {
            if (!wordsArray[rightIndex].isEmpty()) return rightIndex;
            rightIndex++;
        }

        return -1;
    }


    public static int searchWordIndex(String[] wordsArray, int left, int right, String searchWord) {
        if (left > right) return -1;

        int mid = (left + right) / 2;

        if (wordsArray[mid].isEmpty()) {
            mid = searchTheMostCloseIndexToMid(wordsArray, mid, left, right);
        }

        String currentWord = wordsArray[mid];

        if (currentWord.equals(searchWord)) {
            return mid;
        } else if (currentWord.compareTo(searchWord) < 0) {
            return searchWordIndex(wordsArray, mid + 1, right, searchWord);
        } else {
            return searchWordIndex(wordsArray, left, mid - 1, searchWord);
        }
    }

    public static int searchWordIndex(String[] wordsArray, String searchWord) {
        return searchWordIndex(wordsArray, 0, wordsArray.length - 1, searchWord);
    }

    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(searchWordIndex(stringList, "banana"));
    }


}
