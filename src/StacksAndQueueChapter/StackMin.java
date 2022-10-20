package StacksAndQueueChapter;

import java.util.Arrays;
import java.util.Stack;

public class StackMin {
    public static void main(String [] args){
        StackCustom<Integer> sc = new StackCustom<>();

        sc.push(1);
        sc.push(1000);
        sc.push(2);
        sc.push(3);
        sc.push(0);
        sc.push(5);

        System.out.println(sc.getMin().getValue());
        System.out.println(sc.pop().getValue());
        System.out.println(sc.getMin().getValue());

    }
}

class StackCustom<type> {
    CustomStackNodeMin<type> head = null;
    CustomStackNodeMin<type> last = null;

    public CustomStackNodeMin<type> push(type elem){
        CustomStackNodeMin<type> csnm = new CustomStackNodeMin<>(elem);
        if(head == null){
            csnm.minElement = csnm;
            head = csnm;
            last = csnm;
            return csnm;
        }
        last.nextNode = csnm;
        if ((int) csnm.getValue() < (int) last.minElement.getValue()) csnm.minElement = csnm;
        else csnm.minElement = last.minElement;
        csnm.previousNode = last;
        last = csnm;
        return csnm;
    }

    public CustomStackNodeMin<type> pop(){
        CustomStackNodeMin<type> res = last;
        last = (CustomStackNodeMin<type>) last.previousNode;
        return res;
    }

    public CustomStackNodeMin<type> peek(){
        return last;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public CustomStackNodeMin<type> getMin(){
        return last.minElement;
    }
}

class CustomStackNode<type> {
    private type value;
    public CustomStackNode<type> nextNode = null;
    public CustomStackNode<type> previousNode = null;
    public CustomStackNode(){}
    public CustomStackNode(type value){
        this.value = value;
    }
    public type getValue(){
        return this.value;
    }
    public void setValue(type value){
        this.value = value;
    }
}

class CustomStackNodeMin<type> extends CustomStackNode<type>{

    public CustomStackNodeMin<type> minElement;

    public CustomStackNodeMin(){
    }

    public CustomStackNodeMin(type value){
        super(value);
    }
    public CustomStackNodeMin(type value,CustomStackNodeMin<type> minElement){
        super(value);
        this.minElement = minElement;
    }
}
