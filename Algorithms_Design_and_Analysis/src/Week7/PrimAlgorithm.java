package Week7;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimAlgorithm {

    public long primAlgorithm(GraphWithCost graph) {
        this.graph = graph;
        long sumCost = 0;
        initialize();
        while (unprocessedNodes.size() > 0) {
            Node nodeToProcess = unprocessedNodes.poll();
            updateScore(nodeToProcess);
            sumCost += nodeToProcess.getScore();
            processedNodes.add(nodeToProcess);
        }
        return sumCost;
    }

    private void initialize() {
        Node sourceNode = graph.getNodeList().get(1);
        processedNodes.add(sourceNode);
        for (Node node:graph.getNodeList().values()) {
            unprocessedNodes.add(node);
        }
        unprocessedNodes.remove(sourceNode);
        Set<int[]> sourceNodeArcs = sourceNode.getArcs();
        for (int[] arc:sourceNodeArcs) {
            Node endNode = graph.getNodeList().get(arc[0]);
            int arcCost = arc[1];
            unprocessedNodes.remove(endNode);
            endNode.setScore(arcCost);
            unprocessedNodes.add(endNode);
        }
    }

    private void updateScore(Node nodeToProcess) {
        Set<int[]> arcList = nodeToProcess.getArcs();
        for (int[] arc: arcList) {
            Node endNode = graph.getNodeList().get(arc[0]);
            int arcCost = arc[1];
            if (!processedNodes.contains(endNode)){
                if (arcCost < endNode.getScore()) {
                    unprocessedNodes.remove(endNode);
                    endNode.setScore(arcCost);
                    unprocessedNodes.add(endNode);
                }
            }
        }
    }


    private GraphWithCost graph;
    private Set<Node> processedNodes = new HashSet<Node>();
    private PriorityQueue<Node> unprocessedNodes = new PriorityQueue<Node>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.getScore() < o2.getScore()) {
                return -1;
            } else if (o1.getScore() > o2.getScore()) {
                return 1;
            } else {
                return 0;
            }
        }
    });
}
