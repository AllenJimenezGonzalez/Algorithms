package ArraysAndStringsChapter;

public class IsUnique {
    public String evaluateString = "SAB";

    public boolean isAllLettersUnique(String evaluateString){
        String [] splittedString = evaluateString.split("");

        for(int x = 0; x < splittedString.length;x++){
            if(splittedString.length >=2){
                for(int y = x+1; y < splittedString.length; y++ ){
                    if(splittedString[x].equals(splittedString[y])){
                        return false;
                    }
                }
            }else{
                return true;
            }

        }
        return true;
    }

}

