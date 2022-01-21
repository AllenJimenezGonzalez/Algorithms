package ArraysAndStringsChapter;


public class PalindromePermutation {
    public boolean checkPalindrome(String var){
        char [] word = var.toLowerCase().replace(" ","").toCharArray();
        int finalIndex = word.length -1;
        for(int i = 0; i < word.length/2;i++){
            if(word[i]!=word[finalIndex-i]) {
                return false;
            }
        }
        return true;
    }

}
