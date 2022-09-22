package ArraysAndStringsChapter;

public class StringRotation {

    public static boolean isRotation(String s1,String s2){

        if(s1.length() == s2.length()){
            s1 = s1.repeat(2);
            char [] s2Letters = s2.toCharArray();
            int s2Index = 0;
            for (char c : s1.toCharArray()) {
                if(s2Index>0 && c != s2Letters[s2Index]) return false;
                if(c == s2Letters[s2Index]) s2Index++;
                if(s2Index == s2.length()-1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle","erbottlewat"));
    }

}
