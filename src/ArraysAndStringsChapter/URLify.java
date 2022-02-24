package ArraysAndStringsChapter;

public class URLify {
    public String getUrlFied(String url){
         StringBuilder stringBuilder = new StringBuilder();
         String [] splittedList = url.split(" ");
         for(String s: splittedList){
             stringBuilder.append(s);
             if(!s.equals(splittedList[splittedList.length-1])){
                 stringBuilder.append("%20");
             }

         }
         return stringBuilder.toString();
    }
}
