package ArraysAndStringsChapter;

public class IsUnique {
    public static boolean isUnique(String value){
        int [] letters = new int[128];
        for (char c : value.toLowerCase().toCharArray()){
            letters[c]++;
            if(letters[c]>1) return false;
        }
        return true;
    }

    public static void main(String [] args) {
        System.out.println(isUnique("ad$"));
        System.out.println(isUnique("un camello un dia me dijo algo"));
        System.out.println(isUnique("abcdefghijkm n l o p q  yz "));
    }
}

