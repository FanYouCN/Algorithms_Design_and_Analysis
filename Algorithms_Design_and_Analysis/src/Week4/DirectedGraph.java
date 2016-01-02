package Week4;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DirectedGraph {


    public DirectedGraph(String fileName,boolean rev) {
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader(fileName));
        } catch (IOException ex) {
            System.err.println("Invalid file name");
        }
        String thisLine;
        while (rd != null){
            try{
                if ((thisLine = rd.readLine()) != null) {
                    int[] edge = parseLineToIntArray(thisLine);
                    if (rev) {
                        int temp = edge[1];
                        edge[1] = edge[0];
                        edge[0] = temp;
                    }
                    if (vertexList.containsKey(edge[0]) && vertexList.containsKey(edge[1])) {
                        addEdge(edge);
                    } else if (vertexList.containsKey(edge[0])) {
                        addVertex(edge[1]);
                        addEdge(edge);
                    } else if (vertexList.containsKey(edge[1])) {
                        addVertex(edge[0]);
                        addEdge(edge);
                    } else {
                        addVertex(edge[0]);
                        addVertex(edge[1]);
                        addEdge(edge);
                    }
                } else {
                    break;
                }
            } catch (IOException ex){
                System.err.println("Invalid format");
            }
        }
    }

    private int[] parseLineToIntArray(String line) {
        int[] intArray = new int[2];
        StringTokenizer stk = new StringTokenizer(line);
        intArray[0] = Integer.parseInt(stk.nextToken());
        intArray[1] = Integer.parseInt(stk.nextToken());
        return intArray;
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private void addVertex(int vertex) {
        ArrayList<Integer> edgeList = new ArrayList<Integer>();
        vertexList.put(vertex,edgeList);
    }


    private void addEdge(int[] edge) {
        vertexList.get(edge[0]).add(edge[1]);
    }

    public int getSize() {
        return vertexList.size();
    }

    public String toString() {
        return vertexList.toString();
    }

    public Map<Integer,ArrayList<Integer>> getVertexList() {
        return vertexList;
    }

    private Map<Integer,ArrayList<Integer>> vertexList = new HashMap<Integer, ArrayList<Integer>>();
}
