package LinkedListChapter;

public class Palindrome {

    public static boolean palindrome(LinkedListCustom<Character> list){
        LinkedListNode<Character> aux1 = list.head;
        LinkedListNode<Character> aux2 = list.lastNode;

        for(int index = 0; index < list.length/2;index++){
            if(aux1.value != aux2.value) return false;
            aux1 = aux1.nextNode;
            aux2 = aux2.previousNode;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListCustom<Character> list = new LinkedListCustom<>();
        list.add('a','n','n','a');
        list.print();
        System.out.println(palindrome(list));
    }
}
