package LinkedListChapter;

public class LinkedListCustom<type> {
    public LinkedListNode<type> head;
    public LinkedListNode<type> lastNode;
    public int length = 0;

    public LinkedListCustom(){

    }
    @SafeVarargs
    public LinkedListCustom(type ...nodes){
        add(nodes);
    }

    public LinkedListNode<type> add(type val){
        if(head == null){
            head = new LinkedListNode<>(val,length);
            lastNode = head;
            length++;
            return head;
        }

        LinkedListNode<type> newLinkedListNode = new LinkedListNode<>(val,length);
        newLinkedListNode.previousNode = lastNode;
        lastNode.nextNode = newLinkedListNode;
        lastNode = newLinkedListNode;
        length++;
        return newLinkedListNode;
    }

    public LinkedListNode<type> addSingle(type val){
        if(head == null){
            head = new LinkedListNode<>(val,length);
            lastNode = head;
            length++;
            return head;
        }

        LinkedListNode<type> newLinkedListNode = new LinkedListNode<>(val,length);
        lastNode.nextNode = newLinkedListNode;
        lastNode = newLinkedListNode;
        length++;
        return newLinkedListNode;
    }

    public LinkedListNode<type> add(type ...val){
        for (type type : val) {
            add(type);
        }
        return head;
    }

    public LinkedListNode<type> remove(type val){
        LinkedListNode<type> aux = head;
        while (aux != null){
            if(aux.value == val){
                if(aux.previousNode != null) aux.previousNode.nextNode = aux.nextNode;
                if(aux.nextNode != null) aux.nextNode.previousNode = aux.previousNode;
                if(aux == lastNode) lastNode = aux.previousNode;
                length--;
                return aux;
            }
            aux = aux.nextNode;
        }
        return null;
    }

    public LinkedListNode<type> get(type val){
        if(val == head.value) return head;
        if(val == lastNode.value) return lastNode;
        LinkedListNode<type> aux = head;
        while (aux != null){
            if(aux.value == val){
                return aux;
            }
            aux = aux.nextNode;
        }
        return null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        LinkedListNode<type> aux = head;
        sb.append('[');
        while (aux != null){
            sb.append(aux.value);
            if(aux.nextNode != null) sb.append(',');
            aux = aux.nextNode;
        }
        sb.append(']');
        return sb.toString();
    }

    public void print(){
        System.out.println(this);
    }
}

class LinkedListNode <type> {
    public type value;
    public int index;
    public LinkedListNode<type> nextNode;
    public LinkedListNode<type> previousNode;

    public LinkedListNode(){

    }
    public LinkedListNode(type value){
        this.value = value;
    }
    public LinkedListNode(type value,int index){
        this.value = value;
        this.index = index;
    }

}