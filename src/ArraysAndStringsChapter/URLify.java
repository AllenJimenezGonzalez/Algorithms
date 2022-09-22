package ArraysAndStringsChapter;

public class URLify {
    public static String urlify(String originalUrl){
        char [] result = new char[originalUrl.length()*3];
        int arrayIndex = 0;
        for (int i = 0; i < originalUrl.toCharArray().length; i++,arrayIndex++) {
            if(originalUrl.charAt(i) == ' '){
                result[arrayIndex] = '%';
                result[arrayIndex+1]='2';
                result[arrayIndex+2]='0';
                arrayIndex+=2;
            }else{
                result[arrayIndex] = originalUrl.charAt(i);
            }
        }
        return String.valueOf(result).substring(0,arrayIndex);
    }

    public static void main(String[] args) {
        System.out.println(urlify("Hola Testing url"));
    }
}
