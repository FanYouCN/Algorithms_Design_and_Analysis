package Week5;




import java.util.*;

public class DijkstraAlgorithm {

    public void dijkstraAlgorithm(DirectedLengthGraph inputGraph, int source) {
        graph = inputGraph;
        initialize(source);

        while(unvisitedVertex.size() > 0) {
            Vertex nextVertex = unvisitedVertex.poll();
            processedVertex.add(nextVertex);
            updateGreedyScore(nextVertex);
        }
    }

    private void updateGreedyScore(Vertex vertex) {
        Set<int[]> vertexEdgeList = vertex.getEdgeList();
        for (int[] edge: vertexEdgeList) {
            Vertex endVertex = graph.getVertexList().get(edge[0]);
            if (!processedVertex.contains(endVertex)) {
                if (endVertex.getGreedyScore() > vertex.getGreedyScore() + edge[1]) {
                    unvisitedVertex.remove(endVertex);
                    endVertex.setGreedyScore(vertex.getGreedyScore() + edge[1]);
                    unvisitedVertex.add(endVertex);
                }
            }
        }
    }

    private void initialize( int source) {
        Map<Integer,Vertex> vertexList = graph.getVertexList();
        for (Vertex thisVertex:vertexList.values()) {
            unvisitedVertex.add(thisVertex);
        }

        Vertex sourceVertex = graph.getVertexList().get(source);
        sourceVertex.setGreedyScore(0);
        unvisitedVertex.remove(sourceVertex);
        Set<int[]> sourceEdgeList = sourceVertex.getEdgeList();
        for (int[] edge: sourceEdgeList) {
            Vertex endVertex = graph.getVertexList().get(edge[0]);
            unvisitedVertex.remove(endVertex);
            endVertex.setGreedyScore(edge[1]);
            unvisitedVertex.add(endVertex);
        }
    }

    private PriorityQueue<Vertex> unvisitedVertex = new PriorityQueue<Vertex>(new Comparator<Vertex>() {
        @Override
        public int compare(Vertex v1, Vertex v2) {
            if (v1.getGreedyScore() < v2.getGreedyScore()) {
                return -1;
            } else if (v1.getGreedyScore() > v2.getGreedyScore()) {
                return 1;
            } else {
                return 0;
            }
        }
    });

    private Set<Vertex> processedVertex = new HashSet<Vertex>();
    private DirectedLengthGraph graph;

}


