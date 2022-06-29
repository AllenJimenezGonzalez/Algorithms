package TreesAndGraphsChapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph{
    public HashMap<String,Node> nodes;

    public Graph(){
        nodes = new HashMap<>();
    }

    public boolean insertNode(String id){
        if (!nodes.containsKey(id)){
            nodes.put(id,new Node(id));
            return true;
        }
        return false;
    }

    public boolean insertArc(String origin,String destiny){
        if(nodes.containsKey(origin) && nodes.containsKey(destiny)){
            Node originNode = nodes.get(origin);
            if(!originNode.arcs.containsKey(destiny)){
                originNode.arcs.put(destiny,nodes.get(destiny));
                return true;
            }
        }
        return false;
    }

    public boolean isRoute(String origin,String destiny){
        if(nodes.containsKey(origin) && nodes.containsKey(destiny)){
            return nodes.get(origin).arcs.containsKey(destiny);
        }
        return false;
    }

}

class Node{
    public String id;
    public String value;
    public HashMap<String,Node> arcs;
    public boolean visited;

    public Node(){
        arcs = new HashMap<>();
    }

    public Node(String id){
        this.id = id;
        arcs = new HashMap<>();
    }

    public Node(String id, String value, boolean visited) {
        this.id = id;
        this.value = value;
        this.visited = visited;
        arcs = new HashMap<>();
    }
}
