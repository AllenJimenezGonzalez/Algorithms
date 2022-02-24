package ArraysAndStringsChapter;

public class StringCompression {

    public String getCompressedString(String val){
        StringBuilder lastValue = new StringBuilder();

        char [] lettersArray = val.toCharArray();
        char actualChar = '.';
        int counter = 0;
        for (char c : lettersArray) {
            if(actualChar == '.'){
                actualChar = c;
            }

            if(c != actualChar){
                lastValue.append(actualChar);
                lastValue.append(counter);
                counter = 1;
                actualChar = c;
            }else{
                counter++;
            }

        }
        lastValue.append(actualChar);
        lastValue.append(counter);

        return lastValue.toString();
    }

}
