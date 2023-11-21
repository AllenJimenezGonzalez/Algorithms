package SortingAndSearching;

public class SearchInRotatedArray {

    public static int search(int[] array, int number) {
        int firstElement = array[0];
        int lastElement = array[array.length - 1];

        if (Math.abs(firstElement - number) > Math.abs(lastElement - number)) {
            for (int i = array.length - 1; 0 <= i; i--) {
                if (array[i] == number) return i;
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == number) return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, 0, array.length - 1, target);
    }

    private static int binarySearch(int[] array, int left, int right, int target) {
        if (right < left) return -1;

        int pivot = (right + left) / 2;

        if (array[pivot] == target) return pivot;

        if (array[left] < array[pivot]) {
            if (array[pivot] > target && array[left] <= target) return binarySearch(array, left, pivot - 1, target);
            else return binarySearch(array, pivot + 1, right, target);
        } else if (array[right] > array[pivot]) {
            if (array[pivot] < target && array[right] >= target) return binarySearch(array, pivot + 1, right, target);
            else return binarySearch(array, left, pivot - 1, target);
        } else {
            int location = -1;
            if (array[left] == array[right]) {
                location = binarySearch(array, pivot + 1, right, target);
            }

            if (location == -1 && array[left] == array[right]) {
                location = binarySearch(array, left, pivot - 1, target);
            }

            return location;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(search(array, 5));
        System.out.println(binarySearch(array, 5));
    }

}
