package ArraysAndStringsChapter;

import java.util.Arrays;

public class CheckPermutations {

    public int [] getCharList(char []  list ){
        int [] charactersList = new int[256];
        for (char c : list) {
            charactersList[Character.getNumericValue(c)] += 1;
        }
        return charactersList;
    }

    public boolean compare (String var1, String var2) {
        int [] charPositions1 = getCharList(var1.replace(" ","").toCharArray());
        int [] charPositions2 = getCharList(var2.replace(" ","").toCharArray());

        for(int index = 0; index < 256; index++){
            if(charPositions1[index] != charPositions2[index]){
                return false;
            }
        }
        return true;
    }




}
