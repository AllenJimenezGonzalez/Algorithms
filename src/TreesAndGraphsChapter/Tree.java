package TreesAndGraphsChapter;

public class Tree<T>{

    BinaryTreeNode<T> ROOT = null;

    public Tree(){

    }

    public Tree(T value){
        add(value);
    }

    @SafeVarargs
    public Tree(T ...value){
        add(value);
    }

    public void printTree(BinaryTreeNode<T> aux,int level){
        if(aux == null ) return;
        printTree(aux.leftNode,level+1);
        System.out.println("      ".repeat(level)+aux.value);
        printTree(aux.rightNode,level+1);
    }


    public void printTree(BinaryTreeNode<T> node){
        printTree(node,0);
    }

    private void add(BinaryTreeNode<T> node,T value){
        if(ROOT == null){
            ROOT = new BinaryTreeNode<>(value);
        }else{
            if( (int) value < (int) node.value){
                if(node.leftNode == null){
                    node.leftNode = new BinaryTreeNode<>(value);
                }else{
                    add(node.leftNode,value);
                }
            }else{
                if(node.rightNode == null){
                    node.rightNode = new BinaryTreeNode<>(value);
                }else{
                    add(node.rightNode,value);
                }
            }
        }
    }

    public BinaryTreeNode<T> add(T ...value){
        for (T t : value) {
            add(ROOT,t);
        }
        return ROOT;
    }

    public BinaryTreeNode<T> add(T value){
        add(ROOT,value);
        return ROOT;
    }
}

class BinaryTreeNode<T>{
    public T value;
    public BinaryTreeNode<T> leftNode;
    public BinaryTreeNode<T> rightNode;

    public BinaryTreeNode(T value){
        this.value = value;
    }
    public BinaryTreeNode(T value, BinaryTreeNode<T> leftNode,BinaryTreeNode<T> rightNode){
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}