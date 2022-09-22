package TreesAndGraphsChapter;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;

public class BinaryTreeCustom<type> {

    private BinaryTreeNodeCustom<type> root;

    public BinaryTreeCustom(){}

    public void createTree(type [] list){
        for (type value : list) {
            addNode(root,value);
        }
    }

    public void createTree(ArrayList<type> list){
        for (type value : list) {
            addNode(root,value);
        }
    }

    private void addNode(BinaryTreeNodeCustom<type> node,type value){
        if(root == null){
            root = new BinaryTreeNodeCustom<>(value);
        }else{
            if(hashValue(node.value) < hashValue(value)){
                if(node.right == null){
                    BinaryTreeNodeCustom<type> newBinaryTreeNodeCustom = new BinaryTreeNodeCustom<>(value);
                    newBinaryTreeNodeCustom.parent = node;
                    node.right = newBinaryTreeNodeCustom;
                }
                else addNode(node.right,value);
            }else{
                if(node.left == null) {
                    BinaryTreeNodeCustom<type> newBinaryTreeNodeCustom = new BinaryTreeNodeCustom<>(value);
                    newBinaryTreeNodeCustom.parent = node;
                    node.left = newBinaryTreeNodeCustom;
                }
                else addNode(node.left,value);
            }
        }
    }

    public void addNode(type value){
        addNode(root,value);
    }

    public int hashValue(type value){
        if(value instanceof Integer){
            return (int) value;
        }
        else if(value instanceof String){
            return ((String) value).chars().sum();
        }
        else if(value instanceof Boolean){
            return (int) value;
        }
        else if(value instanceof Character){
            return (char) value;
        }
        else{
            return 0;
        }
    }

    private void printTree(BinaryTreeNodeCustom<type> aux,int level){
        if(aux == null ) return;
        printTree(aux.left,level+1);
        System.out.println("      ".repeat(level)+aux.value);
        printTree(aux.right,level+1);
    }

    public void printTree(){
        printTree(root,0);
    }

}

class BinaryTreeNodeCustom<type>{
    public type value;
    public BinaryTreeNodeCustom<type> left;
    public BinaryTreeNodeCustom<type>  right;
    public BinaryTreeNodeCustom<type>  parent;

    public BinaryTreeNodeCustom(){}
    public BinaryTreeNodeCustom(type value){
        this.value = value;
    }

}
