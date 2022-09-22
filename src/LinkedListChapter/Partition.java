package LinkedListChapter;

public class Partition {

    public static LinkedListCustom<Integer> partition(LinkedListCustom<Integer> cl,int partition){
        if(cl.get(partition) == null) return null;
        LinkedListCustom<Integer>left = new LinkedListCustom<>();
        LinkedListCustom<Integer>right = new LinkedListCustom<>();
        LinkedListNode<Integer> aux = cl.head;
        for(int index = 0; index<cl.length; index++){
            if(aux.value< partition){
                left.add(aux.value);
            }else{
                right.add(aux.value);
            }
            aux = aux.nextNode;
        }

        left.lastNode.nextNode = right.head;

        return left;
    }

    public static void main(String [] args){
        LinkedListCustom<Integer> example = new LinkedListCustom<>();
        example.add(3);
        example.add(5);
        example.add(8);
        example.add(5);
        example.add(10);
        example.add(2);
        example.add(1);
        LinkedListCustom<Integer> res = partition(example,5);
        assert res != null;
        res.print();

    }

}
