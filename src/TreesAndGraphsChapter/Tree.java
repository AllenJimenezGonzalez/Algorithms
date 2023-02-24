package TreesAndGraphsChapter;

import java.util.LinkedList;

public class Tree<T> {

    BinaryTreeNode<T> ROOT = null;
    public int TREE_SIZE = 0;
    public LinkedList<T> FLAT_TREE = new LinkedList<>();

    public Tree() {

    }

    public Tree(T value) {
        add(value);
    }

    @SafeVarargs
    public Tree(T... value) {
        add(value);
    }

    public void printTree(BinaryTreeNode<T> aux, int level) {
        if (aux == null) return;
        printTree(aux.rightNode, level + 1);
        System.out.println("      ".repeat(level) + aux.value);
        printTree(aux.leftNode, level + 1);
    }


    public void printTree(BinaryTreeNode<T> node) {
        printTree(node, 0);
    }

    private void add(BinaryTreeNode<T> node, T value) {
        if (ROOT == null) {
            TREE_SIZE++;
            FLAT_TREE.add(value);
            ROOT = new BinaryTreeNode<>(value);
        } else {
            if ((int) value < (int) node.value) {
                if (node.leftNode == null) {
                    TREE_SIZE++;
                    FLAT_TREE.add(value);
                    node.leftNode = new BinaryTreeNode<>(value, node);
                } else {
                    add(node.leftNode, value);
                }
            } else {
                if (node.rightNode == null) {
                    TREE_SIZE++;
                    FLAT_TREE.add(value);
                    node.rightNode = new BinaryTreeNode<>(value, node);
                } else {
                    add(node.rightNode, value);
                }
            }
        }
    }

    public BinaryTreeNode<T> add(T... value) {
        for (T t : value) {
            add(ROOT, t);
        }
        return ROOT;
    }

    public BinaryTreeNode<T> add(T value) {
        add(ROOT, value);
        return ROOT;
    }

    public BinaryTreeNode<T> search(BinaryTreeNode<T> aux, T value) {
        if (aux == null) return null;
        if ((int) aux.value == (int) value) return aux;
        if ((int) value > (int) aux.value) return search(aux.rightNode, value);
        else return search(aux.leftNode, value);
    }

    public BinaryTreeNode<T> search(T value) {
        return search(ROOT, value);
    }
}

class BinaryTreeNode<T> {
    public T value;
    public BinaryTreeNode<T> leftNode;
    public BinaryTreeNode<T> rightNode;
    public BinaryTreeNode<T> parent;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> parent) {
        this.value = value;
        this.parent = parent;
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> leftNode, BinaryTreeNode<T> rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}




