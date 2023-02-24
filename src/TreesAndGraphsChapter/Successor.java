package TreesAndGraphsChapter;

public class Successor {

    public static BinaryTreeNode<Integer> leftmostChild(BinaryTreeNode<Integer> node){
        if (node == null) return null;
        while (node.leftNode != null) node = node.leftNode;
        return node;
    }

    public static BinaryTreeNode<Integer> findSuccessor(BinaryTreeNode<Integer> node){
        if(node == null) return null;

        if(node.rightNode != null){
            return leftmostChild(node);
        }

        BinaryTreeNode<Integer> parentNode = node.parent;

        while(parentNode != null && parentNode.leftNode != node ){
            node = parentNode;
            parentNode = parentNode.parent;
        }
        return parentNode;
    }

    public static void main(String[] args) {
        Tree<Integer> baseNode = new Tree<>(5,3,2,6,8,7,9,4);
        baseNode.printTree(baseNode.ROOT);
        BinaryTreeNode<Integer> aux = baseNode.search(7);
        System.out.println(aux.value);
        System.out.println(findSuccessor(aux).value);
    }

}
