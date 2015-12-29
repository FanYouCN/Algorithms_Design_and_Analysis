package Week4;


import java.util.*;

public class DFS {


    public void DFSLoop(DirectedGraph graph, int[] order) {
        currentFinishingTime = 0;
        currentLeader = 0;
        exploredNodes = new HashSet<Integer>();
        for (int thisNode : order) {
            if (!exploredNodes.contains(thisNode)) {
                currentLeader = thisNode;
                DepthFirstSearch(graph,thisNode);
            }
        }

    }

    public void DepthFirstSearch(DirectedGraph graph, int node) {
        exploredNodes.add(node);
        // System.out.println("current "+ currentLeader+ ", " + exploredNodes.size() + " visited");
        leaders.put(node,currentLeader);
        ArrayList<Integer> nodeEdgeList = graph.getVertexList().get(node);
        for (int thisEdgeEndNode: nodeEdgeList) {
            if (!exploredNodes.contains(thisEdgeEndNode)) {
                DepthFirstSearch(graph,thisEdgeEndNode);
            }
        }
        finishTimes.put(node,++currentFinishingTime);
    }

    public Map<Integer,Integer> getFinishTimes() {
        return finishTimes;
    }

    public Map<Integer,Integer> getLeaders() {
        return leaders;
    }

    private Set<Integer> exploredNodes;
    private int currentFinishingTime;
    private int currentLeader;
    private Map<Integer,Integer> finishTimes = new HashMap<Integer, Integer>();
    private Map<Integer,Integer> leaders = new HashMap<Integer, Integer>();
}
