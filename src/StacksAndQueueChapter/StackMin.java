package StacksAndQueueChapter;

import java.util.Arrays;
import java.util.Stack;

public class StackMin {
    public static void main(String [] args){
        StackCustom sc = new StackCustom();

        sc.push(5);
        sc.push(9);
        sc.push(29);
        sc.push(98);
        sc.push(2);
        System.out.println(sc.min());
        System.out.println(sc.pop().value);
        System.out.println(sc.min());

        sc.push(2290);
        sc.push(233333);
    }
}

class StackCustom extends Stack<StackNode>{
    public StackCustom() {
        super();
    }

    public StackNode push(int value) {
        StackNode item = new StackNode(value);
        if(!empty()) {
            item.minValue = Math.min(peek().minValue, item.value);
        }else{
            item.minValue = value;
        }
        return super.push(item);
    }

    @Override
    public synchronized StackNode pop() {
        return super.pop();
    }

    @Override
    public synchronized StackNode peek() {
        return super.peek();
    }

    @Override
    public boolean empty() {
        return super.empty();
    }

    @Override
    public synchronized int search(Object o) {
        return super.search(o);
    }

    public int min(){
        return peek().minValue;
    }
}

class StackNode{
    int value;
    int minValue;

    public StackNode(){}

    public StackNode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }
}

