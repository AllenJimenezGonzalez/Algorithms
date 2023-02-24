package TreesAndGraphsChapter;

import java.util.*;

public class BuildOrder {


    private static void createGraph(Graph<String> graph,String [] projects, String [][] dependencies,HashMap<String,Integer> nodesCounter ){
        for (String project : projects) {
            graph.addNode(project);
            nodesCounter.put(project,0);
        }

        for (String[] dependency : dependencies) {
            String originNode = dependency[0];
            String destinyNode = dependency[1];
            graph.addArc("arc", originNode, destinyNode, false);
            GraphNode<String> dNode = graph.searchNode(destinyNode);
            int dependenciesCounter = 1 + dNode.arcsLength + nodesCounter.getOrDefault(originNode, 0);
            nodesCounter.put(destinyNode, dependenciesCounter);
        }
    }

    public static String buildOrder(String [] projects, String [][] dependencies){
        Graph<String> graph = new Graph<>();
        HashMap<String,Integer> nodesCounter = new HashMap<>();
        String [] res = new String[500];

        createGraph(graph,projects,dependencies,nodesCounter);

        boolean valid = false;

        for (String s : nodesCounter.keySet()) {
            if(nodesCounter.get(s) == 0){
                valid = true;
            }
            StringBuilder sb = new StringBuilder();
            if(res[nodesCounter.get(s)] != null)
                sb.append(res[nodesCounter.get(s)]);
            sb.append(s);
            sb.append(" , ");
            res[nodesCounter.get(s)] = sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        for (String re : res) {
            if(re != null && !re.equals("")){
                sb.append(re);
            }
        }

        if(valid) return sb.toString();
        return null;

    }

    // --------------------------------------------------------------------------------------------

    private static Project createProjectGraph(String [] projects, String [][] dependencies){
        Project graph = new Project();
        for (String projectName : projects) {
            graph.addNode(projectName);
        }
        for (String[] dependency : dependencies) {
            String originNode = dependency[0];
            String destinyNode = dependency[1];
            graph.addArc("arc", originNode,destinyNode);
        }
        graph.print();
        return graph;
    }

    private static boolean dfsSearch(ProjectNode node,Stack<ProjectNode> projectNodeStack){
        if(node.state == State.DEPENDANT) return false;

        if(node.state == State.BLANK){
            node.state = State.DEPENDANT;
            ProjectArc auxArc = node.arcs;
            while (auxArc != null){
                if(!dfsSearch(auxArc.destinationNode,projectNodeStack)) return false;
                auxArc = auxArc.nextArc;
            }
            node.state = State.COMPLETED;
            projectNodeStack.push(node);
        }
        return true;
    }

    public static String buildOrderRecursive(String [] projects, String [][] dependencies){
        ProjectNode auxNode = createProjectGraph(projects,dependencies).rootNode;

        Stack<ProjectNode> projectNodeStack = new Stack<>();
        while (auxNode != null){
            if(auxNode.state == State.BLANK)
                if(!dfsSearch(auxNode,projectNodeStack)) return "null";
            auxNode = auxNode.nextNode;
        }

        StringBuilder sb = new StringBuilder();
        while (!projectNodeStack.isEmpty()){
            sb.append(projectNodeStack.pop().value);
            if(projectNodeStack.size() != 0) sb.append(" , ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = buildOrder(new String[]{"a","b","c","d","e","f"}, new String[][]{{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}});
        //System.out.println(res);
        String res2 = buildOrderRecursive(new String[]{"a","b","c","d","e","f"}, new String[][]{{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}});
        System.out.println(res2);
    }

}



class Project{
    ProjectNode rootNode;
    public ProjectNode lastNode;

    
    public boolean addNode(String value){
        ProjectNode nGn = new ProjectNode(value);
        if(rootNode == null){
            lastNode = nGn;
            rootNode = nGn;
        }

        lastNode.nextNode = nGn;
        nGn.prevNode = lastNode;
        lastNode = nGn;

        return true;
    }

    public boolean addArc(String value,String originNode,String destinationNode){
        ProjectNode oNode = searchNode(originNode);
        ProjectNode dNode = searchNode(destinationNode);
        if (oNode == null || dNode == null) return false;
        addArc(value,oNode,dNode);
        dNode.arcsLength++;
        return true;
    }

    private void addArc(String value,ProjectNode oNode,ProjectNode dNode ){
        ProjectArc newArc = new ProjectArc(value,oNode,dNode);
        if(oNode.arcs == null) oNode.arcs = newArc;
        else{
            newArc.prevArc = oNode.lastArc;
            oNode.lastArc.nextArc = newArc;
        }
        oNode.lastArc = newArc;
    }


    public ProjectArc removeArc(String originNode,String destinationNode){
        ProjectArc sArc = searchArc(originNode,destinationNode);
        if(sArc == null) return null;
        if(sArc.prevArc == null){
            ProjectNode node = searchNode(originNode);
            node.arcs = sArc.nextArc;
            return sArc;
        }
        sArc.prevArc = sArc.nextArc;
        return sArc;
    }

    public ProjectNode searchNode(String value){
        ProjectNode aux = rootNode;
        while (aux != null){
            if(aux.value.equals(value)) return aux;
            aux = aux.nextNode;
        }
        return null;
    }

    public ProjectArc searchArc(String originNode,String destinationNode){
        ProjectNode oNode = searchNode(originNode);
        ProjectNode dNode = searchNode(destinationNode);
        if(oNode == null || dNode == null) return null;
        ProjectArc auxArc = oNode.arcs;
        while (auxArc!=null){
            if(auxArc.destinationNode == dNode){
                return auxArc;
            }
            auxArc = auxArc.nextArc;
        }
        return null;
    }


    public void print(){
        ProjectNode aux = rootNode;
        while (aux != null){
            System.out.println("Nodo: "+ aux.value);
            ProjectArc auxArc = aux.arcs;
            while (auxArc != null){
                System.out.println("     "+auxArc.destinationNode.value );
                auxArc = auxArc.nextArc;
            }
            aux = aux.nextNode;
        }



    }
}

enum State {
    BLANK,
    DEPENDANT,
    COMPLETED
}

class ProjectNode{
    public String value;
    public ProjectArc arcs;
    public ProjectArc lastArc;
    public ProjectNode nextNode;
    public ProjectNode prevNode;
    public int arcsLength=0;
    public State state = State.BLANK;

    public ProjectNode (String value){
        this.value = value;
    }

}

class ProjectArc{
    public String value;
    public ProjectArc nextArc;
    public ProjectArc prevArc;
    public ProjectNode originNode;
    public ProjectNode destinationNode;

    public ProjectArc(){}

    public ProjectArc( String value,ProjectNode originNode,ProjectNode destinationNode){
        this.value = value;
        this.originNode = originNode;
        this.destinationNode = destinationNode;
    }
}
