package SortingAndSearching;

public class SortedSearchNoSize {

    public static int getListyAproxSize(Listy<Integer> listy, int searchNumber) {
        int index = 1;
        while (listy.elementAt(index) != null && listy.elementAt(index).value < searchNumber) {
            index *= 2;
        }
        return index;
    }

    public static int binarySearch(Listy<Integer> listy, int left, int right, int searchValue) {
        if (left > right) return -1;

        int middle = (left + right) / 2;

        if (listy.elementAt(middle) == null) return binarySearch(listy, left, middle - 1, searchValue);

        if (listy.elementAt(middle).value == searchValue) return middle;

        if (searchValue > listy.elementAt(middle).value) return binarySearch(listy, middle + 1, right, searchValue);
        else return binarySearch(listy, left, middle - 1, searchValue);
    }

    public static void main(String[] args) {
        Listy<Integer> listy = new Listy<>(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(binarySearch(listy, 0, getListyAproxSize(listy, 5), 5));
    }


}

class Listy<CustomArrayType> {
    ListyNode<CustomArrayType> root;
    ListyNode<CustomArrayType> lastElement;
    int lastIndex = 0;

    ListyNode<CustomArrayType>[] indexManager = new ListyNode[32];

    public Listy() {
        for (int i = 0; i < indexManager.length; i++) {
            indexManager[i] = null;
        }
    }

    public Listy(CustomArrayType value) {
        root = new ListyNode<>(value);
    }

    public Listy(CustomArrayType... value) {
        for (CustomArrayType customArrayType : value) {
            push(customArrayType);
        }
    }

    public ListyNode<CustomArrayType> push(CustomArrayType value) {
        if (root == null) {
            root = new ListyNode<>(value);
            lastElement = root;
        } else {
            ListyNode<CustomArrayType> newNode = new ListyNode<>(value);
            lastElement.nextNode = newNode;
            lastElement = newNode;
        }
        indexManager[lastIndex] = lastElement;
        lastIndex++;
        return lastElement;
    }

    public ListyNode<CustomArrayType> elementAt(int index) {
        if (index > lastIndex || index < 0) return null;
        else return indexManager[index];
    }


}

class ListyNode<NodeType> {

    NodeType value;
    public ListyNode<NodeType> nextNode;

    public ListyNode() {
    }

    public ListyNode(NodeType value) {
        this.value = value;
    }

    public NodeType getValue() {
        return value;
    }

    public void setValue(NodeType value) {
        this.value = value;
    }
}
