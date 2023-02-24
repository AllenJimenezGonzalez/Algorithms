package TreesAndGraphsChapter;

public class ValidateBst {
    class Node {
        int data;
        Node left;
        Node right;
    }
    // No comprueba todos los casos

    public static int validateBst(BinaryTreeNode<Integer> node) {
        if (node == null) return 0;

        int leftRes = validateBst(node.leftNode);
        if (leftRes == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightRes = validateBst(node.rightNode);
        if (rightRes == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (leftRes > node.value) return Integer.MIN_VALUE;
        return node.value;
    }

    public static boolean isBst(BinaryTreeNode<Integer> node) {
        return validateBst(node) != Integer.MIN_VALUE;
    }

    // ^^^^^ No comprueba todos los casos ^^^^


    int[] onFail() {
        int[] res = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        return res;
    }

    int[] getRes(int... values) {
        int[] res = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int x : values) {
            res[0] = Math.min(x, res[0]);
            res[1] = Math.max(x, res[1]);
        }
        return res;
    }

    int[] checkBSTAux(Node root) {
        if (root == null) return null;

        int[] left = checkBSTAux(root.left);
        int[] right = checkBSTAux(root.right);

        if (left == null && right == null) return new int[]{root.data, root.data};
        else if (left == null) return getRes(root.data, right[0], right[1]);
        else if (right == null) return getRes(root.data, left[0], left[1]);

        if (left[0] == Integer.MIN_VALUE || left[1] == Integer.MIN_VALUE) return onFail();
        if (right[0] == Integer.MIN_VALUE || right[1] == Integer.MIN_VALUE) return onFail();

        if (root.data >= right[0] || root.data >= right[1]) return onFail();

        if (root.data <= left[0] || root.data <= left[1]) return onFail();


        return getRes(left[0], left[1], right[0], right[1]);

    }

    boolean checkBST(Node root) {
        int[] res = checkBSTAux(root);
        return res[0] == Integer.MIN_VALUE || res[1] == Integer.MIN_VALUE ? false : true;
    }

    public static void main(String[] args) {
        Tree<Integer> baseNode = new Tree<>(5, 3, 2, 6, 8, 9, 4);
        System.out.println(isBst(baseNode.ROOT));
        BinaryTreeNode<Integer> baseNodeNoBst = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> left1 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> left3 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> right1 = new BinaryTreeNode<>(12);
        BinaryTreeNode<Integer> right2 = new BinaryTreeNode<>(14);

        left1.rightNode = left3;

        baseNodeNoBst.leftNode = left1;
        baseNodeNoBst.rightNode = right1;
        right1.leftNode = right2;
        System.out.println(isBst(baseNodeNoBst));


    }

}
