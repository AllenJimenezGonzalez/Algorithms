package LinkedListChapter;

public class DeleteMiddleNode {

    public static void deleteMiddleNode(int numberId){
        LinkedListCustom<Integer> llc = new LinkedListCustom<>();
        llc.add(1);
        llc.add(2);
        llc.add(3);
        llc.add(4);
        llc.add(5);
        System.out.println(llc.length);
        System.out.println(llc);

        LinkedListNode<Integer> node = llc.get(numberId);
        if(node !=null && node.index == llc.length-1){
            llc.remove(numberId);
            return;
        }
        if(node != null && node.index > llc.length-1){
            while (node.index != (llc.length-1)/2){
                 node = node.previousNode;
            }
            llc.remove(node.value);
        }

        if(node != null && node.index < llc.length-1){
            while (node.index != (llc.length-1)/2){
                node = node.nextNode;
            }
            llc.remove(node.value);
        }
        System.out.println(llc);
    }

    public static void main(String [] args){
        deleteMiddleNode(1);
    }
}
