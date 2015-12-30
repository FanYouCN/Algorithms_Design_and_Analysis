package Week5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DirectedLengthGraph {

    public DirectedLengthGraph(String fileName) {
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader(fileName));
        } catch (IOException ex) {
            System.out.println("Invalid File Name");
        }
        String thisLine;
        while (rd != null) {
            try {
                thisLine = rd.readLine();
                if (thisLine != null) {
                    StringTokenizer stk = new StringTokenizer(thisLine," \t");
                    int startVertex = Integer.parseInt(stk.nextToken());
                    if (! vertexList.containsKey(startVertex)) {
                        addVertex(startVertex);
                    }
                    while (stk.hasMoreTokens()) {
                        int[] edge = parseTupleToEdge(stk.nextToken());
                        int endVertex = edge[0];
                        if (! vertexList.containsKey(endVertex)) {
                            addVertex(endVertex);
                        }
                        addEdge(startVertex,edge);

                    }
                } else {
                    break;
                }
            } catch (IOException ex) {
                System.out.println("File Error");
            }
        }
    }


    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public void addVertex(int vertex) {
        Vertex thisVertex = new Vertex(vertex);
        vertexList.put(vertex,thisVertex);
    }


    public void addEdge(int vertex,int[] edge) {
        vertexList.get(vertex).addEdge(edge);
    }

    private int[] parseTupleToEdge(String tuple) {
        int[] edge = new int[2];
        StringTokenizer stk = new StringTokenizer(tuple,",");
        edge[0] = Integer.parseInt(stk.nextToken());
        edge[1] = Integer.parseInt(stk.nextToken());
        return edge;
    }

    public Map<Integer,Vertex> getVertexList() {
        return vertexList;
    }

    public String toString() {
        String str = "";
        for (Vertex thisVertex: vertexList.values()) {
                str += thisVertex.toString() + "\n";
        }
        return str;
    }





    private Map<Integer,Vertex> vertexList = new HashMap<Integer, Vertex>();

}
