package RecursionAndDynamicProgramming;

import java.util.List;
import java.util.Stack;

public class StackOfBoxes {
    // [ W, H, D ]

    static int response = 0;

    public static void largestStackOfBoxes(List<Box> listOfBoxes, Stack<Box> stackOfElements, boolean[] flags) {
        for (int i = 0; i < listOfBoxes.size(); i++) {
            Box currentStackBox = listOfBoxes.get(i);
            Box lastStackBox = stackOfElements.isEmpty() ? null : stackOfElements.peek();
            if (!flags[i]) {
                flags[i] = true;
                if (lastStackBox == null) {
                    currentStackBox.totalHeight = currentStackBox.height;
                } else if (lastStackBox.isValidTheAboveBox(currentStackBox)) {
                    currentStackBox.totalHeight = lastStackBox.totalHeight + currentStackBox.height;
                }
                stackOfElements.push(currentStackBox);
                response = lastStackBox != null ? Math.max(lastStackBox.totalHeight, response) : response;
                largestStackOfBoxes(listOfBoxes, stackOfElements, flags);
                if (!stackOfElements.isEmpty()) stackOfElements.pop();
                flags[i] = false;
            }
        }
    }

    public static int largestStackOfBoxes(Box[] listOfBoxes, Box currentBox, boolean[] flags) {

        if (flags[flags.length - 2]) {
            return currentBox.height;
        }

        int largestHeightOfBoxes = 0;

        for (int i = 0; i < listOfBoxes.length; i++) {
            Box currentStackBox = listOfBoxes[i];
            int currentStackHeight = 0;
            if (!flags[i]) {
                flags[i] = true;
                if (currentBox == null)
                    currentStackHeight += currentStackBox.height + largestStackOfBoxes(listOfBoxes, currentStackBox, flags);
                else if (currentBox.isValidTheAboveBox(currentStackBox))
                    currentStackHeight += currentStackBox.height + largestStackOfBoxes(listOfBoxes, currentStackBox, flags);
                flags[i] = false;
            }
            largestHeightOfBoxes = Math.max(currentStackHeight, largestHeightOfBoxes);
        }

        return largestHeightOfBoxes;
    }

    public static void main(String[] args) {
        List<Box> boxList = List.of(new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3));
        //largestStackOfBoxes(boxList, new Stack<>(), new boolean[boxList.size()]);
        //System.out.println(response);
        Box[] boxListToArray = new Box[boxList.size()];
        boxList.toArray(boxListToArray);
        System.out.println(largestStackOfBoxes(boxListToArray, null, new boolean[boxList.size()]));
    }

}

class Box {
    public int height;
    public int width;
    public int depth;
    public int totalHeight;

    public Box(int width, int height, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public boolean isValidTheAboveBox(Box nextBox) {
        if (nextBox == null) return true;
        return nextBox.depth < this.depth && nextBox.height < this.height && nextBox.width < this.width;
    }
}


