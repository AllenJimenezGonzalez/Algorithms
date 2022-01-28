package LinkedListChapter;

public class KthToLast {



    public CustomLinkedListNode<Integer> getSubList(CustomLinkedListNode<Integer> list,int index){

        int counter = 0;

        while (list != null){

            if (counter == index){
                return list;
            }
            list = list.nextNode;
            counter++;
        }

        return null;

    }

}
