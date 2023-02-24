package TreesAndGraphsChapter;

public class CheckBalanced {

    public static int checkBalanced(BinaryTreeNode<Integer> aux){
        if(aux == null) return -1;
        int left = checkBalanced(aux.leftNode);
        if(left == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int right = checkBalanced(aux.rightNode);
        if(right == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(Math.abs(left-right)>1) return Integer.MIN_VALUE;
        return Math.max(left,right)+1;
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> aux){
        return checkBalanced(aux) != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(5,2,7,6,1,8,1000);
        tree.printTree(tree.ROOT);
        System.out.println(isBalanced(tree.ROOT));
    }

}
