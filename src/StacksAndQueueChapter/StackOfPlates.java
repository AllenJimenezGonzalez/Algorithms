package StacksAndQueueChapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class StackOfPlates{
    public static void main(String [] args){
        StackOfPlatesStruct<Integer> sop = new StackOfPlatesStruct<>(2);
        sop.push(1);
        sop.push(2);
        sop.push(4);
        sop.push(7);
        sop.push(8);
        sop.printStacks();
        System.out.println(sop.pop());
        sop.printStacks();
        System.out.println(sop.pop());
    }
}

class StackOfPlatesStruct<type>{
    LinkedList<Stack<type>> stacks = new LinkedList<>();
    int stackMaxSize = 10;

    public StackOfPlatesStruct(){

    }

    public StackOfPlatesStruct(int stackMaxSize){
        this.stackMaxSize = stackMaxSize;
    }

    public void push(type elem){
        if(stacks.size()>0){
            Stack<type> actualStack = stacks.peek();
            if(actualStack.size()+1>stackMaxSize){
                Stack<type> newStack = new Stack<>();
                newStack.push(elem);
                stacks.push(newStack);
            }else{
                actualStack.push(elem);
            }
        }else{
            Stack<type> newStack = new Stack<>();
            newStack.push(elem);
            stacks.push(newStack);
        }
    }

    public type pop(){
        if(stacks.size()!=0){
            Stack<type> actualStack = stacks.peek();
            if(!actualStack.isEmpty()) {
                return actualStack.pop();
            }
            else{
                stacks.pop();
                actualStack = stacks.peek();
                if(actualStack != null) return actualStack.pop();
            }
        }
        return null;
    }

    public type popAt(int index){
        if(index>=0 && stacks.get(index) != null){
            return stacks.get(index).pop();
        }
        return null;
    }

    public void printStacks(){
        for (Stack<type> stack : stacks) {
            System.out.println(Arrays.toString(stack.toArray()));
        }
    }

}



