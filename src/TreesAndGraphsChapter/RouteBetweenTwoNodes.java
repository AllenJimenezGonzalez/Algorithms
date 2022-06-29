package TreesAndGraphsChapter;

import java.util.ArrayList;

public class RouteBetweenTwoNodes {
    
    public static void main(String [] args){
        Graph graph = new Graph();
        graph.insertNode("A");
        graph.insertNode("V");
        graph.insertArc("A","V");
        System.out.println(graph.isRoute("A","V"));
    }

    
}
