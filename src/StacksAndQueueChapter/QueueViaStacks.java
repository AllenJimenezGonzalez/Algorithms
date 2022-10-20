package StacksAndQueueChapter;

import java.util.*;

public class QueueViaStacks{

    public static void main(String [] args){
        QueueStacks<Integer> queue = new QueueStacks<>(1,2,3,4,5,6);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        queue.add(999);
        System.out.println(queue.pop());
    }



}

class QueueStacks<type>{
    Stack<type> newElements = new Stack<>();
    Stack<type> holdElements = new Stack<>();

    public QueueStacks(){}
    @SafeVarargs
    public QueueStacks(type ...elems){
        for (type elem : elems) {
            newElements.push(elem);
        }
    }

    public void add(type elem){
        newElements.push(elem);
    }

    public type peek(){
        fill();
        return holdElements.peek();
    }

    public type pop(){
        fill();
        return holdElements.pop();
    }

    public void fill(){
        if(holdElements.isEmpty()) {
            while (!newElements.isEmpty()) {
                holdElements.push(newElements.pop());
            }
        }
    }

}
