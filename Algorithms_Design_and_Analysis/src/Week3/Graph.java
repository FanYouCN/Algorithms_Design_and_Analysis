package Week3;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph{

    public int getSize() {
        return vertices.size();
    }


    public void contractVertices(Edge e) {
        int u = e.getEdge()[0];
        int v = e.getEdge()[1];
        for (int i = 0; i < edgesList.size(); i++) {
            Edge edge = edgesList.get(i);
            edge.replace(u,v);
            edgesList.set(i,edge);
        }
        for (Map.Entry<Integer,Vertex> currentVertex: vertices.entrySet()) {
            currentVertex.getValue().replace(u,v);
            vertices.put(currentVertex.getKey(),currentVertex.getValue());
        }
        vertices.remove(v);
        removeSelfLoop();
    }

    public void removeSelfLoop() {
        Iterator<Edge> iter = edgesList.iterator();
        while (iter.hasNext()) {
            Edge edge = iter.next();
            if (edge.selfLoop()) {
                iter.remove();
            }
        }
    }


    public Edge chooseRandomEdge() {
        int randomEdgeIndex = rgen.nextInt(edgesList.size());
        return edgesList.get(randomEdgeIndex);
    }

    public int getEdgeNum() {
        return edgesList.size();
    }

    public Graph(String fileName) {
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader(fileName));
        } catch (IOException ex){
            System.err.println("Invalid file name.");
        }
        String thisLine;
        while (rd != null){
            try{
                if ((thisLine = rd.readLine()) != null){
                    StringTokenizer stk = new StringTokenizer(thisLine," \t");
                    ArrayList<Integer> node = new ArrayList<Integer>();
                    while (stk.hasMoreTokens()) {
                        node.add(Integer.parseInt(stk.nextToken()));
                    }
                    Vertex v = new Vertex(node);
                    for (int i = 1; i < node.size();i ++) {
                        if (node.get(0) < node.get(i)) {
                            Edge thisEdge = new Edge(node.get(0),node.get(i));
                            if (! edgesList.contains(thisEdge)) {
                                edgesList.add(thisEdge);
                            }
                        }
                    }
                    vertices.put(v.getVertex(),v);
                } else break;
            } catch (IOException ex){
                System.err.println("Invalid format");
            }
        }
    }

    private Map<Integer,Vertex> vertices = new HashMap<Integer,Vertex>();
    private ArrayList<Edge> edgesList = new ArrayList<Edge>();
    private Random rgen = new Random();


}
