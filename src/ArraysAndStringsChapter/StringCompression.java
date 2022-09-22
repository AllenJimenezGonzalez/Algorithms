package ArraysAndStringsChapter;

public class StringCompression {

    public static String stringCompression(String originalString){

        StringBuilder sb = new StringBuilder();
        int counter = 1;
        char lastChar = originalString.charAt(0);

        for (int i = 1; i < originalString.toCharArray().length; i++) {
            if(lastChar!=originalString.charAt(i)){
                sb.append(lastChar);
                sb.append(counter);
                counter=1;
                lastChar = originalString.charAt(i);
            }else {
                counter++;
            }
            if(i == originalString.length()-1){
                sb.append(lastChar);
                sb.append(counter);
            }
        }
        return sb.toString().length()>originalString.length()?originalString:sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringCompression("aaabbcnnnnnnc"));
    }

}
