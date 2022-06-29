package StacksAndQueueChapter;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> tempStack = new ArrayDeque<>();

    public void add (Integer value){
        boolean addFlag = true;
        while (!stack.isEmpty()) {
            tempStack.add(stack.pop());
        }
        while (!tempStack.isEmpty()){
            int stackInt = tempStack.pop();
            if(value<stackInt && addFlag){
                stack.add(value);
                addFlag = false;
            }
            stack.add(stackInt);
        }
        if (addFlag) stack.add(value);
        //if(stack.isEmpty() && tempStack.isEmpty()) stack.add(value);
    }

    public int pop(){
        return stack.isEmpty()?-1:stack.pop();
    }

    public int peek(){
        return stack.isEmpty()?-1:stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String [] args){
        SortStack ss = new SortStack();

        ss.add(4);
        ss.add(98);
        ss.add(1);
        ss.add(400);
        ss.add(345);
        ss.add(2055);
        ss.add(0);
        ss.add(2054);
        System.out.println(ss.stack);
        System.out.println(ss.pop());
        System.out.println(ss.pop());
    }

}
