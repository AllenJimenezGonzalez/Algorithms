package LinkedListChapter;

public class SumList {

    public static LinkedListCustom<Integer> sumList(LinkedListCustom<Integer> number1, LinkedListCustom<Integer> number2){
        StringBuilder number1s = new StringBuilder();
        StringBuilder number2s = new StringBuilder();
        int maxLength = Math.max(number1.length, number2.length);
        LinkedListNode<Integer> auxNum1 = number1.lastNode;
        LinkedListNode<Integer> auxNum2 = number2.lastNode;

        for(int index = maxLength ; 0 <= index; index--){
            if(index<number1.length){
                number1s.append(auxNum1.value);
                auxNum1 = auxNum1.previousNode;
            }
            if(index<number2.length){
                number2s.append(auxNum2.value);
                auxNum2 = auxNum2.previousNode;
            }
        }

        String res = String.valueOf(Integer.parseInt(number1s.toString()) + Integer.parseInt(number2s.toString()));
        LinkedListCustom<Integer> resList = new LinkedListCustom<>();
        for (char c : res.toCharArray()) {
            resList.add(Integer.parseInt(String.valueOf(c)));
        }
        return resList;
    }

    public static void main(String[] args) {
        LinkedListCustom<Integer> num1 = new LinkedListCustom<>();
        LinkedListCustom<Integer> num2 = new LinkedListCustom<>();
        num1.add(7,1,6);
        num2.add(5,9,2);
        sumList(num1,num2).print();
    }


}
