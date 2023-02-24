package TreesAndGraphsChapter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class Ntree<T> {

    NTreeNode<T> ROOT = new NTreeNode<>();

    public void add(T value) {
        if (!ROOT.nodes.containsKey(value)) ROOT.nodes.put(value, new NTreeNode<>(value));
    }

    public void add(T key, T value) {
        NTreeNode<T> aux = search(ROOT, key);
        if (aux != null) aux.nodes.put(value, new NTreeNode<>(value));
    }

    public NTreeNode<T> search(NTreeNode<T> aux, T value) {
        if (aux.nodes.containsKey(value)) return aux.nodes.get(value);
        else {
            for (NTreeNode<T> tTreeNode : aux.nodes.values()) {
                NTreeNode<T> res = search(tTreeNode, value);
                if (res != null) return res;
            }
            return null;
        }
    }

    public NTreeNode<T> search(T value) {
        return search(ROOT, value);
    }

    private void printTree(NTreeNode<T> aux, int level) {
        if (aux != null) {
            System.out.println("      ".repeat(level) + aux.value);
            for (NTreeNode<T> value : aux.nodes.values()) {
                printTree(value, ++level);
                level--;
            }
        }
    }

    public void printTree() {
        printTree(ROOT, 0);
    }

}

class NTreeNode<T> {
    public T value;
    public HashMap<T, NTreeNode<T>> nodes = new HashMap<>();
    public boolean visited;

    public NTreeNode() {
        this.visited = false;
    }

    public NTreeNode(T value) {
        this.value = value;
        this.visited = false;
    }
}