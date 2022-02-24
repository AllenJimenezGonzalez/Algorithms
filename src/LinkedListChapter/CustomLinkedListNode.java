package LinkedListChapter;

public class CustomLinkedListNode<type> {

    private type value;
    public CustomLinkedListNode<type> nextNode = null;
    public CustomLinkedListNode<type> previousNode = null;

    public CustomLinkedListNode(){}
    public CustomLinkedListNode(type value){
        this.value = value;
    }

    public type getValue(){
        return this.value;
    }
    public void setValue(type value){
        this.value = value;
    }



}
