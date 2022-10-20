package StacksAndQueueChapter;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> tempStack = new ArrayDeque<>();
    public void push(Integer element) {
        if (stack.isEmpty()) stack.add(element);
        else {
            if (element <= stack.peek()) {
                stack.push(element);
            } else {
                while (!stack.isEmpty() && element > stack.peek()) {
                    tempStack.push(stack.pop());
                }
                stack.push(element);
                while (!tempStack.isEmpty()) {
                    stack.push(tempStack.pop());
                }
            }
        }

    }

    public int pop(){
        return stack.pop();
    }

    public int peek(){
        return stack.isEmpty()? -1: stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        SortStack ss = new SortStack();
        ss.push(1);
        ss.push(5);
        ss.push(2);
        ss.push(999);

        while (!ss.isEmpty()){
            System.out.println(ss.pop());
        }
    }

}
