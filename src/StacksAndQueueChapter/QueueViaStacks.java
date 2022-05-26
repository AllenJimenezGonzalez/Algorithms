package StacksAndQueueChapter;

import java.util.*;

public class QueueViaStacks{

    public static void main(String [] args){
        QueueStacks<Integer> queue = new QueueStacks<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.pop());
    }



}

class QueueStacks<type>{
    Deque<type> stack1 = new ArrayDeque<>();
    Deque<type> stack2 = new ArrayDeque<>();

    public QueueStacks(){}

    public void add(type element){
        if(stack1.isEmpty()){
            stack2.add(element);
            while (!stack1.isEmpty()){
                stack2.add(stack1.peek());
            }
        }else{
            stack1.add(element);
            while (!stack2.isEmpty()){
                stack1.add(stack2.peek());
            }
        }
    }

    public type pop(){
        return stack1.isEmpty()?stack2.peek():stack1.peek();
    }
}
