package SelfStudy;

import java.util.Arrays;

public class MergeSort {

    public int[] getHalveArray(int[] array, int startIndex, int numElements) {
        int[] halveArrayResponse = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            halveArrayResponse[i] = array[startIndex + i];
        }
        return halveArrayResponse;
    }

    private void merge(int[] array, int leftIndex, int midIndex, int rightIndex) {
        int leftHalveArraySize = midIndex - leftIndex + 1;
        int rightHalveArraySize = rightIndex - midIndex;

        int[] leftHalveArray = getHalveArray(array, leftIndex, leftHalveArraySize);
        int[] rightHalveArray = getHalveArray(array, midIndex + 1, rightHalveArraySize);

        int currentLeftIndex = 0;
        int currentRightIndex = 0;
        int currentBaseArrayIndex = leftIndex;

        while (currentLeftIndex < leftHalveArraySize && currentRightIndex < rightHalveArraySize) {
            if (leftHalveArray[currentLeftIndex] < rightHalveArray[currentRightIndex]) {
                array[currentBaseArrayIndex] = leftHalveArray[currentLeftIndex];
                currentLeftIndex++;
            } else {
                array[currentBaseArrayIndex] = rightHalveArray[currentRightIndex];
                currentRightIndex++;
            }
            currentBaseArrayIndex++;
        }

        while (currentLeftIndex < leftHalveArraySize) {
            array[currentBaseArrayIndex] = leftHalveArray[currentLeftIndex];
            currentLeftIndex++;
            currentBaseArrayIndex++;
        }
        while (currentRightIndex < rightHalveArraySize) {
            array[currentBaseArrayIndex] = rightHalveArray[currentRightIndex];
            currentRightIndex++;
            currentBaseArrayIndex++;
        }
    }

    private void sort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (right + left) / 2;
            sort(array, left, middle);
            sort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    public int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();

        int[] nonOrderedList = {5, 17, 3, 42, 8, 91, 24, 11, 33, 6};

        int[] sortedList = mergeSort.sort(nonOrderedList);

        System.out.println(Arrays.toString(sortedList));

    }
}
