package TreesAndGraphsChapter;


public class RouteBetweenTwoNodes {

    public static boolean routeBetweenTwoNodes(Graph<Integer> graph, Integer node1, Integer node2){

        return graph.searchArc(node1, node2) != null;
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addNode(4);
        graph.addNode(7);
        graph.addNode(9);
        graph.addNode(5);
        graph.addArc(50,4,5,true);

        System.out.println(routeBetweenTwoNodes(graph,5,4));
    }

}
