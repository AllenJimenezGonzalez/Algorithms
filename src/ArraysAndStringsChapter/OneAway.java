package ArraysAndStringsChapter;

public class OneAway {

    public static boolean oneWay(String word1,String word2){
        if(word1.length() == word2.length()){
            int differences = 0;
            for (int i = 0; i < word1.length(); i++) {
                if(word1.charAt(i) != word2.charAt(i)) differences++;
            }
            return differences<2;
        }
        String bigWord = word1.length()>word2.length()? word1:word2;
        String smallWord = word1.equals(bigWord)?word2:word1;
        int bigIndex = 0;
        int smallIndex = 0;
        boolean differenceFlag = false;
        while(smallIndex < smallWord.length() && bigIndex< bigWord.length()){
            if(bigWord.charAt(bigIndex) != smallWord.charAt(smallIndex)){
                if(differenceFlag) return false;
                differenceFlag =true;
            }else{
                differenceFlag = false;
            }
            if(!differenceFlag) smallIndex++;
            bigIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneWay("pale","ple"));
        System.out.println(oneWay("ple","pale"));
        System.out.println(oneWay("pales","pale"));
        System.out.println(oneWay("pale","bale"));
        System.out.println(oneWay("pale","bake"));
        System.out.println(oneWay("Allnn","Allne"));
    }
}
