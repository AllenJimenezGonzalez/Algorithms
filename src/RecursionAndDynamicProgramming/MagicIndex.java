package RecursionAndDynamicProgramming;

public class MagicIndex {
    public static int findMagicIndex(int[] array, int start, int end) {

        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return findMagicIndex(array, start, mid - 1);
        } else {
            return findMagicIndex(array, mid + 1, end);
        }
    }

    public static int findMagicIndex(int[] array) {
        return findMagicIndex(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println(findMagicIndex(array));
    }

}
