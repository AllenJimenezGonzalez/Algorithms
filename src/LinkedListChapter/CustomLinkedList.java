package LinkedListChapter;

public class CustomLinkedList {
    public CustomLinkedListNode<Integer> root = null;
    CustomLinkedListNode<Integer> lastNode = null;
    private int listSize = 0;

    public CustomLinkedList(){}

    public void add(int number){

        listSize++;

        if(root == null){
            root = new CustomLinkedListNode<Integer>(number);
            lastNode = root;
        }else{
            CustomLinkedListNode<Integer> newEntry = new CustomLinkedListNode<>(number);
            newEntry.previousNode = lastNode;
            lastNode.nextNode = newEntry;
            lastNode = newEntry;
        }

    }

    public void add(int number,int index){
        listSize++;

        if(index<=listSize && index>=0){
            if(root == null){
                root = new CustomLinkedListNode<Integer>(number);
                lastNode = root;
            }else{
                CustomLinkedListNode <Integer> iterator = root;
                for (int i = 0; i < listSize; i++){
                    iterator = iterator.nextNode;
                    if(i==index){
                        CustomLinkedListNode<Integer> newEntry = new CustomLinkedListNode<>(number);
                        newEntry.nextNode = iterator;
                        newEntry.previousNode = iterator.previousNode;
                        iterator.previousNode.nextNode = newEntry;
                    }
                }
            }
        }else{
            System.out.println("No se puede insertar en un index mayor al numero de elementos actuales de la lista");
        }

    }

    public void printList(){
        CustomLinkedListNode<Integer> iterator = root;
        System.out.print("[");
        while(iterator!=null){
            System.out.print(iterator.getValue());
            System.out.print(",");
            iterator = iterator.nextNode;
        }
        System.out.print("]");
    }

    public void remove(int index){
        if(index < listSize && index >=0){
            CustomLinkedListNode<Integer> iterator = root;
            for(int i = 0; i <= index; i++){
                iterator = iterator.nextNode;
            }
            iterator.previousNode.nextNode = iterator.nextNode;
            iterator.nextNode.previousNode = iterator.previousNode;
        }
    }


    public CustomLinkedListNode<Integer> getDeletedMiddleList(){
        int middle = listSize/2;
        CustomLinkedListNode<Integer> iterator = root;
        for(int i = 0; i<middle;i++){
            iterator = iterator.nextNode;
        }
        iterator.previousNode.nextNode = iterator.nextNode;
        iterator.nextNode.previousNode = iterator.previousNode;
        return root;
    }

    public CustomLinkedListNode<Integer> partition(int piv){
        CustomLinkedListNode<Integer> res = null;
        CustomLinkedListNode<Integer> iterator = root;
        CustomLinkedListNode<Integer> iterator2 = null;
        for(int i = 0; i < listSize; i++){
            if(iterator.getValue()<piv){
                if(res == null){
                    res = new CustomLinkedListNode<>(iterator.getValue());
                    iterator2 = res;
                }else{
                    CustomLinkedListNode<Integer> ne = new CustomLinkedListNode<>(iterator.getValue());
                    iterator2.nextNode = ne;
                    ne.previousNode = iterator2;
                    iterator2 = ne;
                }
            }
            iterator = iterator.nextNode;
        }

        iterator = root;
        for(int i = 0; i < listSize; i++){
            if(iterator.getValue()>=piv){
                if(res == null){
                    res = new CustomLinkedListNode<>(iterator.getValue());
                    iterator2 = res;
                }else{
                    CustomLinkedListNode<Integer> ne = new CustomLinkedListNode<>(iterator.getValue());
                    iterator2.nextNode = ne;
                    ne.previousNode = iterator2;
                    iterator2 = ne;
                }
            }
            iterator = iterator.nextNode;
        }

        return res;
    }


    public int get(int index){
        if (root != null && index<=listSize) {
            CustomLinkedListNode <Integer> iterator = root;
            for (int i = 0; i < listSize; i++){
                iterator = iterator.nextNode;
                if(i==index){
                    return iterator.getValue();
                }
            }
        }
        return -1;
    }

    public int size(){
        return this.listSize;
    }

}
