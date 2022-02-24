package ArraysAndStringsChapter;

public class StringRotation {

    public boolean isSubString(String s1,String s2){
        if(s2.length() > s1.length()) return false;
        int [] letterCountS1 = new int[256];
        int [] letterCountS2 = new int[256];
        for(char c: s1.toCharArray()){
            letterCountS1[c]++;
        }

        for(char c: s2.toCharArray()){
            letterCountS2[c]++;
        }

        for(int i = 0; i < 256;i++){
            if(letterCountS2[i] != 0 && letterCountS1[i] == 0 || letterCountS2[i] > letterCountS1[i] ) return false;
        }

        return true;
    }

}
