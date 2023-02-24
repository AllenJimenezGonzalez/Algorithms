package TreesAndGraphsChapter;

public class PathsWithSum {

    public static int countPathsWithSum(BinaryTreeNode<Integer> aux, int counter, int sum) {
        if (aux == null) return 0;

        int left = countPathsWithSum(aux.leftNode, counter + aux.value, sum);
        int right = countPathsWithSum(aux.rightNode, counter + aux.value, sum);

        if (aux.value + counter == sum) return left + right + 1;
        else return left + right;
    }

    public static int countPathsWithSum(BinaryTreeNode<Integer> aux, int sum) {
        return countPathsWithSum(aux, 0, sum);
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(8, 4, 29, 2, 6, 14, 32);

        BinaryTreeNode<Integer> replace = tree.search(tree.ROOT, 6).rightNode = new BinaryTreeNode<>(-4);
        int res = countPathsWithSum(tree.ROOT, 14);
        System.out.println(res);
    }

}
