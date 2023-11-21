package SortingAndSearching;

import java.util.Arrays;

public class SortedMerge {

    public static int[] mergeList(int[] sortedList1, int[] sortedList2) {

        int[] responseList = new int[sortedList1.length + sortedList2.length];
        int index1 = 0;
        int index2 = 0;
        int responseListIndex = 0;
        while (index1 < sortedList1.length && index2 < sortedList2.length) {
            if (sortedList1[index1] < sortedList2[index2]) {
                responseList[responseListIndex] = sortedList1[index1];
                index1++;
            } else {
                responseList[responseListIndex] = sortedList2[index2];
                index2++;
            }
            responseListIndex++;
        }

        if (index1 < sortedList1.length) {
            for (int i = index1; i < sortedList1.length; i++) {
                responseList[responseListIndex] = sortedList1[i];
                responseListIndex++;
            }
        }

        if (index2 < sortedList2.length) {
            for (int i = index2; i < sortedList2.length; i++) {
                responseList[responseListIndex] = sortedList2[i];
                responseListIndex++;
            }
        }
        sortedList1 = responseList;
        return responseList;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 7, 6, 7, 7};

        int[] res = mergeList(a, b);
        System.out.println(Arrays.toString(res));
    }

}
