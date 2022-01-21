package ArraysAndStringsChapter;

public class OneAway {

    public int absVal (int n) {
        return (n<0?n*-1:n);
    }

    public boolean detectChanges(String phrase1, String phrase2){
        int [] letters1 = new int[256];
        int [] letters2 = new int[256];
        char [] phrase1Descomposed = phrase1.replace(" ","").toCharArray();
        char [] phrase2Descomposed = phrase2.replace(" ","").toCharArray();

        for(char letter: phrase1Descomposed ){
            letters1[Character.getNumericValue(letter)]++;
        }

        for(char letter: phrase2Descomposed ){
            letters2[Character.getNumericValue(letter)]++;
        }


        int matchesCount = 0;
        for(int index = 0; index < 256 ; index ++){
            matchesCount+=absVal(letters1[index] - letters2[index]);
        }
        return !(matchesCount >2);


    }
}
