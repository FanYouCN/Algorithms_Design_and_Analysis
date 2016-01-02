package Week4;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SCC {
    public static void main(String[] args) {
        new SCC().test();
    }

    public void test() {
        stronglyConnectedComponents(FILE_NAME);
        int listSize = SCCList.size();
        int[] sizeArray = new int[listSize];
        int n = 0;
        for (Integer size: SCCList.values()) {
            sizeArray[n++] = size;
        }
        Arrays.sort(sizeArray);
        System.out.println(Arrays.toString(sizeArray));
    }

    public void stronglyConnectedComponents(String fileName) {
        // Initialization
        DirectedGraph DGraph = new DirectedGraph(fileName,false);
        DirectedGraph RGraph = new DirectedGraph(fileName,true);
        int inputSize = DGraph.getSize();

        // Run first pass on reversed graph
        int[] firsPassOrder = new int[inputSize];
        for (int i = 0; i < inputSize; i ++) {
            firsPassOrder[i] = i + 1;
        }
        DFS firstPass = new DFS();
        firstPass.DFSLoop(RGraph,firsPassOrder);
        Map<Integer,Integer> finishTimesFirstPass = firstPass.getFinishTimes();

        // Run second pass on graph
        int[] secondPassOrder = new int[DGraph.getSize()];
        for (int i = 1; i <= inputSize; i++) {
            int node = finishTimesFirstPass.get(i);
            secondPassOrder[inputSize  - node] = i;
        }
        DFS secondPass = new DFS();
        secondPass.DFSLoop(DGraph,secondPassOrder);

        // Generate SCCs given leaders
        Map<Integer,Integer> leadersSecondPass = secondPass.getLeaders();
        for(int i = 1; i <= leadersSecondPass.size(); i++) {
            int thisLeader = leadersSecondPass.get(i);
            if (SCCList.containsKey(thisLeader)) {
                SCCList.put(thisLeader,SCCList.get(thisLeader) + 1);
            } else {
                SCCList.put(thisLeader,1);
            }
        }

    }

    private static final String FILE_NAME = "E:/Dropbox/GitHub/Algorithms_Design_and_Analysis/Algorithms_Design_and_Analysis/src/Week4/SCC.txt";
    Map<Integer,Integer> SCCList = new HashMap<Integer, Integer>();
}
