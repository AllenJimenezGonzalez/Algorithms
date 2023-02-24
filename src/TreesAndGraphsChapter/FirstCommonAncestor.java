package TreesAndGraphsChapter;

import javax.swing.text.Position;
import java.util.Objects;

class Result {
    BinaryTreeNode<Integer> node;
    Boolean isAncestor;

    public Result(BinaryTreeNode<Integer> node, Boolean isAncestor) {
        this.node = node;
        this.isAncestor = isAncestor;
    }
}

class ResultNary {
    NTreeNode<Integer> node;
    Boolean isAncestor;

    public ResultNary(NTreeNode<Integer> node, Boolean isAncestor) {
        this.node = node;
        this.isAncestor = isAncestor;
    }
}

public class FirstCommonAncestor {
    Ntree<Integer> nTree = new Ntree<>();

    private Result firstCommonAncestorHelper(BinaryTreeNode<Integer> root, Integer node1, Integer node2) {
        if (root == null) return new Result(null, false);

        if (root.value.equals(node1) && root.value.equals(node2)) return new Result(root, true);

        Result leftSearch = firstCommonAncestorHelper(root.leftNode, node1, node2);
        if (leftSearch.isAncestor) return leftSearch;

        Result rightSearch = firstCommonAncestorHelper(root.rightNode, node1, node2);
        if (rightSearch.isAncestor) return rightSearch;

        if (leftSearch.node != null && rightSearch.node != null) {
            return new Result(root, true);
        } else if (root.value.equals(node1) || root.value.equals(node2)) {
            boolean isAncestor = leftSearch.node != null || rightSearch.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(leftSearch.node != null ? leftSearch.node : rightSearch.node, false);
        }

    }

    private BinaryTreeNode<Integer> firstCommonAncestor(BinaryTreeNode<Integer> root, Integer node1, Integer node2) {
        Result res = firstCommonAncestorHelper(root, node1, node2);
        return res.isAncestor ? res.node : null;
    }

    private NTreeNode<Integer> firstCommonAncestor(NTreeNode<Integer> aux, Integer node1, Integer node2) {
        NTreeNode<Integer> validator = null;
        for (NTreeNode<Integer> value : aux.nodes.values()) {
            validator = firstCommonAncestor(value, node1, node2);
            if (validator != null) return validator;
        }
        if (nTree.search(aux, node2) != null && nTree.search(aux, node1) != null) return aux;
        return null;
    }

    private ResultNary firstCommonAncestorNaryHelper(NTreeNode<Integer> node, Integer node1, Integer node2) {
        if (node == null) return new ResultNary(null, false);

        //if (node.value.equals(node1) && node.value.equals(node2)) return new ResultNary(node, true);

        ResultNary node1Search = new ResultNary(null, false);
        ResultNary node2Search = new ResultNary(null, false);

        for (NTreeNode<Integer> value : node.nodes.values()) {
            if (!value.visited) {
                value.visited = true;
                node1Search = firstCommonAncestorNaryHelper(value, node1, node2);
                if (value.value.equals(node1)) node1Search.node = value;
                if (node1Search.node != null) break;
            }
        }

        for (NTreeNode<Integer> value : node.nodes.values()) {
            if (!value.visited) {
                value.visited = true;
                node2Search = firstCommonAncestorNaryHelper(value, node1, node2);
                if (value.value.equals(node2)) node2Search.node = value;
                if (node2Search.node != null) break;
            }
        }

        if (node1Search.isAncestor || node2Search.isAncestor) return node1Search.isAncestor ? node1Search : node2Search;

        if (node1Search.node != null && node2Search.node != null) return new ResultNary(node, true);

        if (node.value != null && node.value.equals(node1) || node.value != null && node.value.equals(node2)) {
            boolean isAncestor = node1Search.node != null || node2Search.node != null;
            return new ResultNary(node, isAncestor);
        }

        return node1Search.node != null ? node1Search : node2Search;
    }

    public NTreeNode<Integer> firstCommonAncestorTest(NTreeNode<Integer> node, Integer node1, Integer node2) {
        ResultNary rsnary = firstCommonAncestorNaryHelper(node, node1, node2);
        return rsnary.isAncestor ? rsnary.node : new NTreeNode<>();
    }

    public NTreeNode<Integer> firstCommonAncestor(Integer node1, Integer node2) {
        NTreeNode<Integer> res = firstCommonAncestor(nTree.ROOT, node1, node2);
        return res == null ? new NTreeNode<>() : res;
    }


    public static void main(String[] args) {
        FirstCommonAncestor fcsf = new FirstCommonAncestor();
        fcsf.nTree.add(1);
        fcsf.nTree.add(2);
        fcsf.nTree.add(3);
        fcsf.nTree.add(4);
        fcsf.nTree.add(4, 5);
        fcsf.nTree.add(5, 6);
        fcsf.nTree.add(5, 9);
        fcsf.nTree.add(6, 7);
        fcsf.nTree.add(9, 200);
        fcsf.nTree.add(7, 15);
        fcsf.nTree.add(7, 18);
        fcsf.nTree.add(200, 300);
        fcsf.nTree.printTree();

        System.out.println("Result :" + fcsf.firstCommonAncestor(300, 5).value);
        System.out.println("Resp :" + fcsf.firstCommonAncestorTest(fcsf.nTree.ROOT, 18, 15).value);

        Tree<Integer> btn = new Tree<>(200, 10, 9, 30, 50, 90, 600, 300, 400, 800);
        btn.printTree(btn.ROOT);
        BinaryTreeNode<Integer> res = fcsf.firstCommonAncestor(btn.ROOT, 15, 18);
        System.out.println("Result " + (res != null && res.value != null ? res.value : "null"));
    }

}

