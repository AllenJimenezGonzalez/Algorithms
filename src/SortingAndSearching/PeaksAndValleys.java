package SortingAndSearching;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PeaksAndValleys {

    public int[] getSubArrayCopy(int[] baseArray, int nElements, int baseIndexPosition) {
        int[] response = new int[nElements];
        for (int i = 0; i < nElements; i++) {
            response[i] = baseArray[baseIndexPosition + i];
        }
        return response;
    }

    private void merge(int[] array, int left, int middle, int right) {

        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;

        int[] leftArray = getSubArrayCopy(array, leftArraySize, left);
        int[] rightArray = getSubArrayCopy(array, rightArraySize, middle + 1);

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;

        int baseArrayIndex = left;

        while (leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize) {
            if (leftArray[leftArrayIndex] > rightArray[rightArrayIndex]) {
                array[baseArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            } else {
                array[baseArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            }
            baseArrayIndex++;
        }

        while (leftArrayIndex < leftArraySize) {
            array[baseArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            baseArrayIndex++;
        }

        while (rightArrayIndex < rightArraySize) {
            array[baseArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            baseArrayIndex++;
        }
    }

    private void sort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(array, left, middle);
            sort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private int[] generatePeaksAndValleys(int[] array) {
        int[] sortedArray = sort(array);
        int[] response = new int[array.length];

        System.out.printf("Sorted array: %s \n", Arrays.toString(sortedArray));
        int i = 0;
        int j = array.length - 1;
        int k = 0;

        boolean isOdd = array.length % 2 != 0;

        while (k < array.length) {
            response[k] = sortedArray[j];
            if (k + 1 < array.length - 1) response[k + 1] = sortedArray[i];
            if (isOdd && k + 2 > array.length - 1) {
                k++;
            } else {
                k += 2;
            }
            i++;
            j--;
        }


        return response;
    }

    // 1 2 3 4 5 6 7 8
    // 8 1 7 2 6 3 5 4


    //8, 14, 27, 30, 45, 53, 68, 72, 86, 91
    //91, 8, 86, 14, 72, 27, 68, 30, 53, 45
    public static void main(String[] args) {
        PeaksAndValleys peaksAndValleys = new PeaksAndValleys();
        int[] testList = {743, 215, 891, 477, 632, 84, 315, 929, 556, 180};
        int[] bookTestList = {5, 3, 1, 2, 3};
        // System.out.println(Arrays.toString(peaksAndValleys.sort(testList)));

        //System.out.println(Arrays.toString(peaksAndValleys.generatePeaksAndValleys(testList)));
        System.out.println(Arrays.toString(peaksAndValleys.generatePeaksAndValleys(bookTestList)));

    }
}
