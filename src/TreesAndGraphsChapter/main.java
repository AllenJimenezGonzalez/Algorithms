package TreesAndGraphsChapter;

public class main {
    public static void main(String [] args){
        BinaryTreeCustom<String> binaryTreeNodeCustom = new BinaryTreeCustom<>();
        binaryTreeNodeCustom.createTree(new String[]{"allen","peso","casa"});
        binaryTreeNodeCustom.addNode("prueba");
        binaryTreeNodeCustom.addNode("onomatopeya");
        binaryTreeNodeCustom.addNode(null);
        binaryTreeNodeCustom.printTree();
    }
}
