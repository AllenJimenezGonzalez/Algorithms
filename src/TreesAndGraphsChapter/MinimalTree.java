package TreesAndGraphsChapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinimalTree {
    public static void main(String [] args){
        BinaryTree binaryTree = new BinaryTree();
        int [] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,277,278,987,1099};
        //binaryTree.minimalTree(arr,0,arr.length-1);
        //binaryTree.printTree();
        //binaryTree.fixTree(arr);
        binaryTree.ROOT = binaryTree.minimalTreeBook(arr);
        BinaryTreeNode testRoot = new BinaryTreeNode(5,5);
        testRoot.left = new BinaryTreeNode(-1,-1);
        BinaryTreeNode testRight1 = new BinaryTreeNode(4,4);
        BinaryTreeNode testRight2 = new BinaryTreeNode(8,8);
        testRight1.right = testRight2;
        testRoot.right = testRight1;

        //binaryTree.ROOT = binaryTree.minimalTreeConscious(arr);
        binaryTree.printTree(binaryTree.ROOT,0);
        List<LinkedList<BinaryTreeNode>> res = binaryTree.listOfDepths();
        for (int i = 0; i < res.size(); i++) {
            System.out.println("Level: "+i);
            for (BinaryTreeNode binaryTreeNode : res.get(i)) {
                System.out.println(binaryTreeNode.value);
            }
            System.out.println("-----------------------------------------");
        }

        System.out.println("Is balanced tree: "+binaryTree.isBalancedTree(binaryTree.ROOT));

        System.out.println("Is binary search tree?: "+binaryTree.isBinarySearchTree(testRoot));

        System.out.println("The next succesor node is: " + binaryTree.findNextSuccessor(testRight1).value);
    }
}
