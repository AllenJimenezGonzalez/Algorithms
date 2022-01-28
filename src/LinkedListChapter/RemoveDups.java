package LinkedListChapter;

import java.util.LinkedList;

public class RemoveDups {


    public LinkedList<Integer> getListRemovedDups(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(13);
        list.add(1);
        list.add(25);
        list.add(258);
        list.add(13);
        list.add(89);

        boolean flag = true;
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < list.size()-1; i++) {
            int actualNumber = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                if(actualNumber == list.get(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result.add(list.get(i));
            }
            flag = true;

        }
        return result;
    }
}
