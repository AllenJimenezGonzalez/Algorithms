package SortingAndSearching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class RankFromStream {


    private void merge(int[] array, int leftIndex, int midIndex, int rightIndex) {
        int leftHalveSize = midIndex - leftIndex + 1;
        int rightHalveSize = rightIndex - midIndex;
        int[] leftHalveArray = new int[leftHalveSize];
        int[] rightHalveArray = new int[rightHalveSize];

        for (int i = 0; i < leftHalveSize; i++) {
            leftHalveArray[i] = array[leftIndex + 1];
        }

        for (int j = 0; j < rightHalveSize; j++) {
            rightHalveArray[j] = array[midIndex + j];
        }

        int i = 0;
        int j = 0;

        int k = leftIndex;


        while (i < leftHalveSize && j < rightHalveSize) {
            if (leftHalveArray[i] < rightHalveArray[j]) {
                array[k] = leftHalveArray[i];
                i++;
            } else {
                array[k] = rightHalveArray[j];
                j++;
            }
            k++;
        }

        while (i < leftHalveSize) {
            array[k] = leftHalveArray[i];
            i++;
            k++;
        }

        while (j < rightHalveSize) {
            array[k] = rightHalveArray[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middlePoint = leftIndex + (rightIndex - leftIndex) / 2;
            mergeSort(array, leftIndex, middlePoint);
            mergeSort(array, middlePoint + 1, rightIndex);
            merge(array, leftIndex, middlePoint, rightIndex);
        }
    }

    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int[] stream;
        if (!line.isEmpty()) {
            stream = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        } else {
            stream = new int[]{5, 1, 4, 4, 5, 9, 7, 13, 3};
        }

        System.out.println(Arrays.toString(stream));
        RankTree rankTree = new RankTree();

        for (int i : stream) {
            rankTree.track(i);
        }
        rankTree.printTree();
        System.out.println(rankTree.getRank(1));
        System.out.println(rankTree.getRank(3));
        System.out.println(rankTree.getRank(4));
    }
}

class RankTree {
    private Node root;

    private void updateBiggerBranchNodesCount(Node aux) {
        if (aux != null) {
            aux.minors += 1;
            updateBiggerBranchNodesCount(aux.left);
            updateBiggerBranchNodesCount(aux.right);
        }
    }

    private void addNode(int value, Node aux) {
        if (value == aux.value) {
            aux.equals += 1;
            updateBiggerBranchNodesCount(aux.right);
        } else if (value > aux.value) {
            if (aux.right == null) {
                aux.right = new Node(value);
                aux.right.minors = aux.minors + aux.equals + 1;
            } else {
                addNode(value, aux.right);
            }
        } else {
            aux.minors += 1;
            updateBiggerBranchNodesCount(aux.right);
            if (aux.left == null) {
                aux.left = new Node(value);
                aux.left.minors = aux.minors - 1;
            } else {
                addNode(value, aux.left);
            }
        }
    }

    public void track(int value) {
        Node aux = root;
        if (root == null) {
            root = new Node(value);
        } else {
            addNode(value, aux);
        }
    }

    private int getRank(int value, Node aux) {
        if (aux == null) return -1;

        if (value == aux.value) {
            return aux.equals + aux.minors;
        }

        int res;
        if (value > aux.value) {
            res = getRank(value, aux.right);
        } else {
            res = getRank(value, aux.left);
        }
        return res == -1 ? aux.getCount() : res;

    }

    public int getRank(int value) {
        Node aux = root;
        return getRank(value, aux);
    }

    private void printTree(Node aux, int level) {
        if (aux != null) {
            printTree(aux.right, level + 1);
            System.out.printf(" ".repeat(level * 2) + "%d (%d)%n", aux.value, (aux.minors + aux.equals));
            printTree(aux.left, level + 1);
        }
    }

    public void printTree() {
        Node aux = root;
        printTree(aux, 0);
    }

}

class Node {
    public int value;
    public int minors;
    public int equals;

    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
        this.minors = 0;
        this.equals = 0;
    }

    public int getCount() {
        return minors + equals;
    }
}
