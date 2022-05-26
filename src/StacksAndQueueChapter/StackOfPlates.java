package StacksAndQueueChapter;

import java.util.ArrayList;

public class StackOfPlates{
    public static void main(String [] args){
        StackOfPlatesStruct stackOfPlatesStruct = new StackOfPlatesStruct(3);
        stackOfPlatesStruct.push(2);
        stackOfPlatesStruct.push(3);
        stackOfPlatesStruct.push(9);
        stackOfPlatesStruct.push(89);
        System.out.println(stackOfPlatesStruct.pop());
        System.out.println(stackOfPlatesStruct.pop());
        System.out.println(stackOfPlatesStruct.pop());
        stackOfPlatesStruct.push(6);
        stackOfPlatesStruct.printAllStacks();


    }
}

class StackOfPlatesStruct {
    int actualStack = 0;
    ArrayList<CustomStack> stacksOfPlates = new ArrayList<>();
    int maxStackSize = 1;

    public StackOfPlatesStruct(int maxStackSize){
        this.maxStackSize = maxStackSize;
    }

    public void push(int item){

        if(stacksOfPlates.size() == 0) {
            stacksOfPlates.add(new CustomStack(maxStackSize));
            if(stacksOfPlates.get(actualStack).canAdd()){
                stacksOfPlates.get(actualStack).push(item);
            }else{
                actualStack++;
                stacksOfPlates.add(actualStack, new CustomStack(maxStackSize));
                stacksOfPlates.get(actualStack).push(item);
            }
        }else{
            if(stacksOfPlates.get(actualStack).canAdd()){
                stacksOfPlates.get(actualStack).push(item);
            }else{
                actualStack++;
                stacksOfPlates.add(actualStack, new CustomStack(maxStackSize));
                stacksOfPlates.get(actualStack).push(item);
            }
        }
    }

    public int pop(){
        if (stacksOfPlates.get(actualStack).canPop()) {
            return stacksOfPlates.get(actualStack).pop();
        }else{
            if(actualStack-1>=0) {
                actualStack--;
            }
            return stacksOfPlates.get(actualStack).pop();
        }
    }

    public int popAt(int stackIndex){
        if(stackIndex>=0 && stackIndex<=actualStack){
            return stacksOfPlates.get(stackIndex).pop();
        }else{
            return -1;
        }
    }

    public void printAllStacks(){
        for (int i = 0; i < stacksOfPlates.size(); i++) {
            System.out.println("----------------- Stack ID: "+i+" -------------------");
            for (int i1 : stacksOfPlates.get(i).stack) {
                System.out.println(i1);
            }
        }
    }

}

class CustomStack{

    int [] stack;
    int index = 0;

    public CustomStack(int size){
        stack = new int[size];
    }

    public boolean canAdd(){
        return index<stack.length;
    }

    public boolean push(int item){
        if(stack != null && canAdd()) {
            stack[index] = item;
            index++;
            return true;
        }else{
            return false;
        }

    }

    public boolean canPop(){
        return index > 0;
    }

    public int pop (){
        if(stack!=null) {

            if(index-1>=0) {
                index--;
            }
            return stack[index];

        }else{
            return -1;
        }
    }

}
