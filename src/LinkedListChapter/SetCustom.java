package LinkedListChapter;

import java.util.HashMap;
import java.util.List;

public class SetCustom<type> {
    HashMap<Integer,type> nodes ;

    public SetCustom(){
        nodes = new HashMap<>();
    }

    public void add(type value){
        nodes.put(getHashedValue(value),value);
    }

    public type [] toArray(){
        return (type[]) nodes.values().toArray();
    }

    public List<type> toList(){
        return nodes.values().stream().toList();
    }

    public int getHashedValue(type value){
        if(value instanceof Integer){
            return (int) value;
        }
        else if(value instanceof String){
            return ((String) value).chars().sum();
        }
        else if(value instanceof Character){
            return (char) value;
        }
        else{
            return -1;
        }
    }

}
