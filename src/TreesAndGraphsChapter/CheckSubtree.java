package TreesAndGraphsChapter;

import java.util.Objects;

public class CheckSubtree {

    public static boolean checkSubtreeAux(BinaryTreeNode<Integer> subTree1, BinaryTreeNode<Integer> subTree2) {
        if (subTree1 == null && subTree2 == null) return true;
        if (subTree1 == null || subTree2 == null) return false;
        if (!Objects.equals(subTree1.value, subTree2.value)) return false;

        boolean left = checkSubtreeAux(subTree1.leftNode, subTree2.leftNode);
        boolean right = checkSubtreeAux(subTree1.rightNode, subTree2.rightNode);
        return left && right;
    }

    public static boolean checkSubtree(BinaryTreeNode<Integer> subTree1, BinaryTreeNode<Integer> subTree2) {

        if (subTree1 == null) return false;

        // Check current

        boolean auxBool = checkSubtreeAux(subTree1, subTree2);

        if (auxBool) return true;

        boolean subTreeLeftRes = checkSubtree(subTree1.leftNode, subTree2);
        boolean subTreeRightRes = checkSubtree(subTree1.rightNode, subTree2);

        return subTreeLeftRes || subTreeRightRes;
    }

    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<>(84, 5, 4, 2, 6, 1, 3, 120, 90, 140);
        Tree<Integer> subtTree = new Tree<>(2, 3, 1);

        tree.printTree(tree.ROOT);

        boolean res = checkSubtree(tree.ROOT, subtTree.ROOT);

        System.out.println(res);

    }
}
