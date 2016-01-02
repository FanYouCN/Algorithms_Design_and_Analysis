package Week5;

import java.util.HashSet;
import java.util.Set;

public class Vertex {

    public Vertex(int v) {
        vertex = v;
        edgeList = new HashSet<int[]>();
    }

    public void addEdge(int[] edge) {
        edgeList.add(edge);
    }

    public int getVertex() {
        return vertex;
    }

    public Set<int[]> getEdgeList() {
        return edgeList;
    }

    public String toString() {
        String str = "";
        str += "Vertex: " + vertex;
        str += ", Shortest Path: " + greedyScore;
        return str;
    }

    public void setGreedyScore(int score) {
        greedyScore = score;
    }

    public int getGreedyScore() {
        return greedyScore;
    }






    private int vertex;
    private int greedyScore = INFINITY;
    private Set<int[]> edgeList = new HashSet<int[]>();
    private static final int INFINITY = 999999;
}
