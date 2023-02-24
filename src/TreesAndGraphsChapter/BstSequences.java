package TreesAndGraphsChapter;

import java.util.*;

public class BstSequences {

    HashMap<Integer, LinkedList<Integer>> nodesByLevel = new HashMap<>();

    public void getNodesByLevel(BinaryTreeNode<Integer> node, int level) {
        if (node == null) return;
        if (nodesByLevel.containsKey(level)) nodesByLevel.get(level).add(node.value);
        else {
            LinkedList<Integer> nll = new LinkedList<>();
            nll.add(node.value);
            nodesByLevel.put(level, nll);
        }
        getNodesByLevel(node.leftNode, level + 1);
        getNodesByLevel(node.rightNode, level + 1);
    }

    public Integer[] swap(Integer[] list, int indexA, int indexB) {
        int hold = list[indexA];
        list[indexA] = list[indexB];
        list[indexB] = hold;
        return list;
    }

    public void permute(Integer[] list, ArrayList<LinkedList<Integer>> res, int l, int r) {
        if (l == r) {
            res.add(new LinkedList<>(Arrays.asList(list)));
        } else {
            for (int index = l; index <= r; index++) {
                list = swap(list, l, index);
                permute(list, res, l + 1, r);
                list = swap(list, l, index);
            }
        }
    }

    public void bstSequences(BinaryTreeNode<Integer> root) {
        getNodesByLevel(root, 0);
        ArrayList<LinkedList<Integer>> res = null;
        ArrayList<LinkedList<Integer>> tempRes = new ArrayList<>();
        for (int i = nodesByLevel.size() - 1; i >= 0; i--) {
            ArrayList<LinkedList<Integer>> localRes = new ArrayList<>();
            LinkedList<Integer> rawSender = nodesByLevel.get(i);
            Integer[] localSender = new Integer[rawSender.size()];
            for (int i1 = 0; i1 < rawSender.size(); i1++) localSender[i1] = rawSender.get(i1);
            permute(localSender, localRes, 0, localSender.length - 1);
            if (res == null) {
                res = localRes;
            } else {

                for (LinkedList<Integer> re : res) {
                    for (LinkedList<Integer> localRe : localRes) {
                        LinkedList<Integer> mixRes = new LinkedList<>();
                        mixRes.addAll(localRe);
                        mixRes.addAll(re);
                        tempRes.add(mixRes);
                    }
                }

            }
        }


        for (LinkedList<Integer> re : tempRes) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    public static void main(String[] args) {
        Tree<Integer> root = new Tree<>(2, 1, 3);
        BstSequences bstSequences = new BstSequences();
        bstSequences.bstSequences(root.ROOT);
    }

}
