package TreesAndGraphsChapter;

public class RandomNode {

    int treeTraversalIndex = 0;

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private BinaryTreeNode<Integer> getRandomNode(BinaryTreeNode<Integer> aux, int randNumb) {
        if (aux == null) return null;
        if (treeTraversalIndex == randNumb) {
            System.out.println(randNumb);
            return aux;
        }
        treeTraversalIndex = treeTraversalIndex + 1;
        System.out.println(treeTraversalIndex);
        BinaryTreeNode<Integer> left = getRandomNode(aux.leftNode, randNumb);
        BinaryTreeNode<Integer> right = getRandomNode(aux.rightNode, randNumb);
        if (left != null) return left;
        return right;
    }

    private BinaryTreeNode<Integer> getRandomNode(Tree<Integer> aux) {
        treeTraversalIndex = 0;
        int randNum = getRandomNumber(0, aux.TREE_SIZE);
        BinaryTreeNode<Integer> res = aux.search(aux.FLAT_TREE.get(randNum));
        System.out.println(res.value);
        return getRandomNode(aux.ROOT, randNum);
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(45, 32, 35, 33, 89, 87, 43, 99, 1029);
        RandomNode newRandomNode = new RandomNode();
        System.out.println(newRandomNode.getRandomNode(tree).value);

    }

}
