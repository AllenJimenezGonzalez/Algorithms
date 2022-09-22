package TreesAndGraphsChapter;

import java.net.BindException;
import java.util.*;

public class BinaryTree{
    BinaryTreeNode ROOT;
    int treeLevel = 0;
    public BinaryTreeNode insert(int id,int value,BinaryTreeNode root,int level){
        if(ROOT == null) {
            ROOT = new BinaryTreeNode(id,value);
            return ROOT;
        }
        if(level>treeLevel) treeLevel = level;
        if(id > root.id){
            if(root.right == null) {
                BinaryTreeNode nn = new BinaryTreeNode(id,value);
                nn.parent = root;
                root.right = nn;
                return root.right;
            }
            else insert(id,value, root.right,level+1);
        }else{
            if(root.left == null) {
                BinaryTreeNode nn = new BinaryTreeNode(id,value);
                nn.parent = root;
                root.left = nn;
                return root.left;
            }
            else insert(id,value, root.left,level+1);
        }

        return null;
    }

    public HashMap<Integer,Boolean> visited = new HashMap<>();

    public void minimalTree(int [] array,int start,int end){
        if(end<start){
            return;
        }
        int mid = (end+start)/2;
        insert(mid,array[mid],ROOT,0);
        minimalTree(array,start,mid-1);
        minimalTree(array,mid+1,end);
    }
    public BinaryTreeNode minimalTreeBook (int [] arr){
        return minimalTreeBook(arr,0,arr.length-1);
    }
    public BinaryTreeNode minimalTreeBook (int [] arr,int start, int end){
        if(end<start){
            return null;
        }
        int mid = (start+end)/2;
        BinaryTreeNode n = new BinaryTreeNode(mid,arr[mid]);

        n.right = minimalTreeBook(arr,mid+1,end);
        n.left = minimalTreeBook(arr,start,mid-1);
        return n;
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


    public void nodesByLevel(BinaryTreeNode aux,HashMap<Integer,LinkedList<BinaryTreeNode>> nodesByLevel,int level){
        if(aux == null) return;
        if(!nodesByLevel.containsKey(level)) {
            nodesByLevel.put(level,new LinkedList<>());
        }

        nodesByLevel.get(level).add(aux);
        nodesByLevel(aux.left,nodesByLevel,level+1);
        nodesByLevel(aux.right,nodesByLevel,level+1);
    }

    public List<LinkedList<BinaryTreeNode>> listOfDepths(){
        HashMap<Integer,LinkedList<BinaryTreeNode>> result = new HashMap<>();
        nodesByLevel(ROOT,result,0);
        return result.values().stream().toList();
    }

    private int checkTreeHeight(BinaryTreeNode node){
        if(node == null) return -1;
        int leftHeight = checkTreeHeight(node.left);
        if (leftHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkTreeHeight(node.right);
        if (rightHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int hDiff = Math.abs(leftHeight-rightHeight);
        if(hDiff>1) return Integer.MIN_VALUE;
        else return Math.max(leftHeight,rightHeight)+1;
    }

    public boolean isBalancedTree(BinaryTreeNode node){
        if (node == null) return true;
        return checkTreeHeight(node) !=Integer.MIN_VALUE;
    }

    public int checkTreeHeightCustom(BinaryTreeNode node){
        if(node == null) return -1;

        int lh = checkTreeHeight(node.left);
        if(lh == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rh = checkTreeHeight(node.right);
        if(rh == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if(Math.abs(lh-rh)>1) return Integer.MIN_VALUE;
        else return 1;
    }

    public BinaryTreeNode minimalTreeConscious(int[] values,int start,int end){
        if(start>end) return null;
        int middle = (start+end)/2;
        BinaryTreeNode node = new BinaryTreeNode(values[middle],values[middle]);
        node.left = minimalTreeConscious(values,start,middle-1);
        node.right = minimalTreeConscious(values,middle+1,end);
        return node;
    }



    public BinaryTreeNode minimalTreeConscious(int [] arr){
        return minimalTreeConscious(arr,0,arr.length-1);
    }
    final int validationValue = Integer.MIN_VALUE + 1;
    private int isBinarySearchTreeLogic(BinaryTreeNode node){
        if(node == null) return validationValue;
        int leftWeight = isBinarySearchTreeLogic(node.left);
        int rightWeight = isBinarySearchTreeLogic(node.right);
        if(leftWeight == Integer.MIN_VALUE || rightWeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if ( (rightWeight < node.value && rightWeight != validationValue) || leftWeight > node.value) return Integer.MIN_VALUE;
        return rightWeight == validationValue && leftWeight == validationValue?node.value: rightWeight;
    }

    public boolean isBinarySearchTree(BinaryTreeNode node){
        return isBinarySearchTreeLogic(node) != Integer.MIN_VALUE;
    }

    private BinaryTreeNode leftMostNode(BinaryTreeNode node){
        if(node == null) return null;
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public BinaryTreeNode findNextSuccessor(BinaryTreeNode node){
        if(node == null) return null;

        if(node.right != null){
            return leftMostNode(node.right);
        }else{
            BinaryTreeNode actualNodeAux = node;
            BinaryTreeNode parentNode = node.parent;
            while(parentNode!=null && parentNode.left != actualNodeAux){
                actualNodeAux = parentNode;
                parentNode = actualNodeAux.parent;
            }
            return parentNode;
        }
    }


}

class BinaryTreeNode{
    public int id;
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;

    public BinaryTreeNode(){}
    public BinaryTreeNode(int id,int value){
        this.id = id;
        this.value = value;
    }
}


;