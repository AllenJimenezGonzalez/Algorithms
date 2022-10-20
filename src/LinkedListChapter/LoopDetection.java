package LinkedListChapter;

public class LoopDetection {

    public static LinkedListNode<Character> loopDetection(LinkedListNode<Character> node){
        LinkedListNode<Character> slow = node;
        LinkedListNode<Character> faster = node;
        while (faster != null && faster.nextNode != null){
            slow = slow.nextNode;
            faster = faster.nextNode.nextNode;
            if(slow == faster) break;
        }

        if(faster == null || faster.nextNode == null) return null;
        slow = node;
        while (slow!=faster){
            slow = slow.nextNode;
            faster = faster.nextNode;
        }
        return faster;
    }

    public static void main(String[] args) {
        LinkedListCustom<Character> ll = new LinkedListCustom<>('A','B','C','D','E','C');
        LinkedListNode<Character> a = new LinkedListNode<>('A');
        LinkedListNode<Character> b = new LinkedListNode<>('B');
        LinkedListNode<Character> c = new LinkedListNode<>('C');
        LinkedListNode<Character> d = new LinkedListNode<>('D');
        LinkedListNode<Character> e = new LinkedListNode<>('E');

        a.nextNode = b;
        b.nextNode = c;
        c.nextNode = d;
        d.nextNode = e;
        e.nextNode = c;

        LinkedListNode<Character> res = loopDetection(a);
        System.out.println(res!=null? res.value:"Nothing");
    }
}
