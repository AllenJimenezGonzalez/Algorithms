package LinkedListChapter;

public class Intersect {

    public static LinkedListNode<Integer> intersect(LinkedListCustom<Integer> list1, LinkedListCustom<Integer> list2){
        int minLength = Math.min(list1.length, list2.length);
        LinkedListNode<Integer> longer = list1.length>list2.length? list1.head:list2.head;
        LinkedListNode<Integer> shorter = list1.length>=list2.length? list2.head:list1.head;;
        int diff = Math.abs(list1.length-list2.length);
        while (diff>0){
            longer = longer.nextNode;
            diff--;
        }
        LinkedListNode<Integer> resNode = null;
        for(int index = 0; index<minLength; index++){
            if(resNode !=null && longer.value.intValue() != shorter.value.intValue()) return null;
            if(resNode == null && longer.value.intValue() == shorter.value.intValue()){
                resNode = longer;
            }
            longer = longer.nextNode;
            shorter = shorter.nextNode;
        }
        return resNode;
    }

    public static void main(String[] args) {
        LinkedListCustom<Integer> list1 = new LinkedListCustom<>(1,2,5,6,99,100);
        LinkedListCustom<Integer> list2 = new LinkedListCustom<>(5,6,99,100);
        LinkedListNode<Integer> res = intersect(list1,list2);
        System.out.println((res!=null)?res.value:"Not intersect");
    }
}
