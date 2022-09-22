package LinkedListChapter;

import java.util.*;

public class RemoveDuplicated {

    public static List<Integer> removeDuplicatedElementsCustom(List<Integer> ol){
        SetCustom<Integer> sc = new SetCustom<>();
        for (Integer integer : ol) {
            sc.add(integer);
        }
        return sc.toList();
    }

    public static List<Integer> removeDuplicatedElements(List<Integer> originalList){
        Set<Integer> res = new HashSet<>(originalList);
        return res.stream().toList();
    }

    public static List<Integer> kthToLast(List<Integer> originalList,int kthElement){
        List<Integer> returnList = new ArrayList<>();
        for (int i = kthElement; i < originalList.size(); i++) {
            returnList.add(originalList.get(i));
        }
        return returnList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 1, 2, 5, 102, 12, 13);

        System.out.println(list);
        System.out.println(removeDuplicatedElements(list));
        System.out.println(removeDuplicatedElementsCustom(list));

        System.out.println(kthToLast(list,6));
    }
}
