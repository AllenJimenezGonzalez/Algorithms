package TreesAndGraphsChapter;

import java.util.LinkedList;
import java.util.Stack;

public class ListOfDepths {

    private void listOfDepths(BinaryTreeNode<Integer> node,LinkedList<LinkedList<BinaryTreeNode<Integer>>> list,int level){
        if(node == null) return;
        if(level >= list.size() ) list.add(new LinkedList<>());
        list.get(level).add(node);
        listOfDepths(node.leftNode,list,++level);
        listOfDepths(node.rightNode,list,level);
    }

    public LinkedList<LinkedList<BinaryTreeNode<Integer>>> listOfDepths(BinaryTreeNode<Integer> root){
        LinkedList<LinkedList<BinaryTreeNode<Integer>>> res = new LinkedList<>();
        listOfDepths(root,res,0);
        return res;
    }

    public void printLists (LinkedList<LinkedList<BinaryTreeNode<Integer>>> value){
        for (int i = 0; i < value.size(); i++) {
            LinkedList<BinaryTreeNode<Integer>> levelList = value.get(i);
            System.out.printf("--------------Level: %d -----------------\n",i);
            for (BinaryTreeNode<Integer> integerBinaryTreeNode : levelList) {
                System.out.println(integerBinaryTreeNode.value);
            }
        }
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(5,2,6,1,7,4,900);
        ListOfDepths lod = new ListOfDepths();
        lod.printLists(lod.listOfDepths(tree.ROOT));
    }

}



