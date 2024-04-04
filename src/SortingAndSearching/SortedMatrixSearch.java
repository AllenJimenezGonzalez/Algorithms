package SortingAndSearching;

public class SortedMatrixSearch {
    public static int binarySearch(int[] array, int start, int end, int elementToFind) {
        if (start > end) return Integer.MIN_VALUE;

        int middle = (start + end) / 2;
        int currentElement = array[middle];
        if (currentElement == elementToFind) return elementToFind;

        if (elementToFind > currentElement) return binarySearch(array, middle + 1, end, elementToFind);
        else return binarySearch(array, start, middle - 1, elementToFind);
    }

    public static int binarySearch(int[] array, int elementToFind) {
        return binarySearch(array, 0, array.length - 1, elementToFind);
    }

    public static int findMatrixElementBinarySearch(int[][] elementsMatrix, int elementToFind) {
        for (int[] matrix : elementsMatrix) {
            int response = binarySearch(matrix, elementToFind);
            if (response != Integer.MIN_VALUE) return response;
        }
        return Integer.MIN_VALUE;
    }

    public static int findMatrixElementDiagonalSearch(int[][] elementsMatrix, int elementToFind) {
        int maxY = elementsMatrix.length - 1;
        int maxX = elementsMatrix[0].length - 1;

        int x = 0;
        int y = 0;

        while (true) {
            if (x + 1 > maxX) break;
            if (y + 1 > maxY) break;
            if (elementToFind >= elementsMatrix[y][x] && elementToFind < elementsMatrix[y + 1][x + 1]) {
                break;
            }
            x++;
            y++;
        }

        for (; y < maxY; y++) {
            int[] elementList = elementsMatrix[y];
            int res = binarySearch(elementList, x, elementList.length - 1, elementToFind);
            if (res != Integer.MIN_VALUE) return res;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] testMatrix = {new int[]{15, 20, 70, 85}, new int[]{20, 35, 80, 95}, new int[]{30, 55, 95, 105}, new int[]{40, 80, 100, 120}};
        int response = findMatrixElementBinarySearch(testMatrix, 35);
        int response2 = findMatrixElementDiagonalSearch(testMatrix, 30);
        System.out.println(response);
        System.out.println(response2);

        int[] testBinarySearchList = new int[]{1, 5, 90, 1002, 3005, 9008, 10000};
        int res = binarySearch(testBinarySearchList, 1);
        System.out.println(res);
    }
}
