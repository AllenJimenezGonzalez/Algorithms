package TreesAndGraphsChapter;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree{
    BinaryTreeNode ROOT;
    int treeLevel = 0;
    public void insert(int id,int value,BinaryTreeNode root,int level){
        if(ROOT == null) {
            ROOT = new BinaryTreeNode(id,value);
            return;
        }
        if(level>treeLevel) treeLevel = level;
        if(id > root.id){
            if(root.right == null) root.right = new BinaryTreeNode(id,value);
            else insert(id,value, root.right,level+1);
        }else{
            if(root.left == null) root.left = new BinaryTreeNode(id,value);
            else insert(id,value, root.left,level+1);
        }
    }

    public HashMap<Integer,Boolean> visited = new HashMap<>();

    public void minimalTree(int [] array,int index){
        if(index>=array.length || index<0) return;
        insert(index,array[index],ROOT,0);
        visited.put(index,true);
        if(!visited.containsKey(index / 2)) minimalTree(array,index/2);
        if(!visited.containsKey(index + (index / 2))) minimalTree(array,index+(index/2));
    }

    public void fixTree(int [] array){
        for (int i=0; i<array.length;i++) {
            if(!visited.containsKey(i)){
                insert(i,array[i],ROOT,0);
            }
        }
    }

    public void printTree(){
        Queue<BinaryTreeNode> q = new ArrayDeque<>();
        q.add(ROOT);
        int actualLevel = 0;

        int maxSpaces = (int) Math.pow(2,treeLevel);
        int lvlNodesCounter = 0;
        while (actualLevel!=treeLevel){

            BinaryTreeNode btn = q.poll();

            int nodes = (int) Math.pow(2,actualLevel);
            int spacesBetween = maxSpaces/nodes;
            assert btn != null;
            System.out.print(" ".repeat(spacesBetween) +btn.id);

            if(btn.left==null) q.add(new BinaryTreeNode(0,0));
            else q.add(btn.left);
            if(btn.right==null) q.add(new BinaryTreeNode(0,0));
            else q.add(btn.right);
            lvlNodesCounter++;
            if(lvlNodesCounter>=nodes) {
                lvlNodesCounter = 0;
                actualLevel++;
            }
        }
    }

    public void printTree(BinaryTreeNode aux,int level){
        if(aux == null ) return;
        printTree(aux.left,level+1);
        System.out.println("      ".repeat(level)+aux.value);
        printTree(aux.right,level+1);
    }
}

class BinaryTreeNode{
    public int id;
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(){}
    public BinaryTreeNode(int id,int value){
        this.id = id;
        this.value = value;
    }
}


;