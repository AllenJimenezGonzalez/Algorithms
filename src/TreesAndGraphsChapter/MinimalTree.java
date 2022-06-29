package TreesAndGraphsChapter;

public class MinimalTree {
    public static void main(String [] args){
        BinaryTree binaryTree = new BinaryTree();
        int [] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        binaryTree.minimalTree(arr,arr.length/2);
        //binaryTree.printTree();
        binaryTree.fixTree(arr);
        binaryTree.printTree(binaryTree.ROOT,0);
    }
}
