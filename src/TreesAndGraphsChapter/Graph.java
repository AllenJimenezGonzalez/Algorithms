package TreesAndGraphsChapter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {

    GraphNode<T> rootNode;
    public GraphNode<T> lastNode;
    public GraphArc<T> lastArc;


    public boolean addNode(T value){
        GraphNode<T> nGn = new GraphNode<>(value);
        if(rootNode == null){
            lastNode = nGn;
            rootNode = nGn;
        }

        lastNode.nextNode = nGn;
        nGn.prevNode = lastNode;
        lastNode = nGn;

        return true;
    }

    public boolean addArc(T value,T originNode,T destinationNode,boolean directed){
        GraphNode<T> oNode = searchNode(originNode);
        GraphNode<T> dNode = searchNode(destinationNode);
        if (oNode == null || dNode == null) return false;
        addArc(value,oNode,dNode);
        if(directed){
            addArc(value,dNode,oNode);
        }
        return true;
    }

    private void addArc(T value,GraphNode<T> oNode,GraphNode<T> dNode ){
        GraphArc<T> newArc = new GraphArc<T>(value,oNode,dNode);
        if(oNode.arcs == null) oNode.arcs = newArc;
        else{
            newArc.prevArc = lastArc;
            lastArc.nextArc = newArc;
        }
        lastArc = newArc;
    }


    public GraphArc<T> removeArc(T originNode,T destinationNode){
        GraphArc<T> sArc = searchArc(originNode,destinationNode);
        if(sArc == null) return null;
        if(sArc.prevArc == null){
            GraphNode<T> node = searchNode(originNode);
            node.arcs = sArc.nextArc;
            return sArc;
        }
        sArc.prevArc = sArc.nextArc;
        return sArc;
    }

    public GraphNode<T> searchNode(T value){
        GraphNode<T> aux = rootNode;
        while (aux != null){
            if(aux.value.equals(value)) return aux;
            aux = aux.nextNode;
        }
        return null;
    }

    public GraphArc<T> searchArc(T originNode,T destinationNode){
        GraphNode<T> oNode = searchNode(originNode);
        GraphNode<T> dNode = searchNode(destinationNode);
        if(oNode == null || dNode == null) return null;
        GraphArc<T> auxArc = oNode.arcs;
        while (auxArc!=null){
            if(auxArc.destinationNode == dNode){
                return auxArc;
            }
            auxArc = auxArc.nextArc;
        }
        return null;
    }

}

class GraphNode<T>{
    public T value;
    public GraphArc<T> arcs;
    public GraphNode<T> nextNode;
    public GraphNode<T> prevNode;

    public GraphNode (T value){
        this.value = value;
    }
}

class GraphArc<T>{
    public T value;
    public GraphArc<T> nextArc;
    public GraphArc<T> prevArc;
    public GraphNode<T> originNode;
    public GraphNode<T> destinationNode;

    public GraphArc(){}

    public GraphArc(T value,GraphNode<T> originNode,GraphNode<T> destinationNode){
        this.value = value;
        this.originNode = originNode;
        this.destinationNode = destinationNode;
    }
}