package StacksAndQueueChapter;

import java.util.Arrays;

public class ThreeInOne {
    public static void main(String [] args){
        StackStructure<Integer> stackStructure = new StackStructure<Integer>(9);
        stackStructure.insert(1,1);
        stackStructure.insert(2,1);
        stackStructure.insert(3,1);
        stackStructure.insert(4,2);
        stackStructure.insert(5,2);
        stackStructure.insert(6,2);
        stackStructure.insert(7,3);
        stackStructure.insert(8,3);
        stackStructure.insert(0,3);
        stackStructure.printStacks();
    }
}

class StackStructure<type>{
    public type [] stackArray;
    int size;
    int quarterSize = 0;
    int indexStack1 = 0;
    int indexStack2 = 0;
    int indexStack3 = 0;

    public StackStructure(int size){
        stackArray = (type[]) new Object[size];
        this.size = size;
        this.quarterSize = size/3;
        this.indexStack2 = quarterSize;
        this.indexStack3 = quarterSize*2;
    }

    public void insert(type data,int stackId){
        if(stackId == 1 && indexStack1<quarterSize){
            stackArray[indexStack1] = data;
            indexStack1++;
        }else if (stackId == 2 && indexStack2<quarterSize*2){
            stackArray[indexStack2] = data;
            indexStack2++;
        }else if(stackId == 3 && indexStack3<stackArray.length){
            stackArray[indexStack3] = data;
            indexStack3++;
        }else{
            System.out.printf("\nLa pila %d esta llena",stackId);
        }
    }

    public void printStacks(){
        for (int i = 0; i < stackArray.length; i++) {
            if(i==0){
                System.out.println("\n----Stack 1----");
            }
            else if(i==quarterSize){
                System.out.println("\n----Stack 2----");
            }else if(i == quarterSize*2){
                System.out.println("\n----Stack 3----");
            }
            System.out.println(stackArray[i]);
        }
    }

}
