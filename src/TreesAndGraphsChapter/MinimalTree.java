package TreesAndGraphsChapter;

import java.util.LinkedList;

public class MinimalTree {

    BinaryTreeNode<Integer> buildMinimalTree(int [] values,int lowIndex, int highIndex){
        if(highIndex<lowIndex) return null;
        int middle = (highIndex+lowIndex)/2;
        BinaryTreeNode<Integer> tNode = new BinaryTreeNode<>(values[middle]);
        tNode.leftNode = buildMinimalTree(values,lowIndex,middle-1);
        tNode.rightNode = buildMinimalTree(values,middle+1,highIndex);
        return tNode;
    }

    public BinaryTreeNode<Integer> buildMinimalTree(int [] values){
        return buildMinimalTree(values,0,values.length-1);
    }


    public static void main(String[] args) {
        MinimalTree mt = new MinimalTree();
        Tree<Integer> tree = new Tree<>();
        BinaryTreeNode<Integer> btn = mt.buildMinimalTree(new int[]{1,2,3,4,5,6,7,8,9});
        tree.printTree(btn);

    }


}
