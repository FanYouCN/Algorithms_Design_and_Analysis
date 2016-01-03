package Week7;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GraphWithCost {

    public GraphWithCost(String fileName) {
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader(fileName));
        } catch (IOException ex) {
            System.err.println("Invalid file name");
        }
        while (rd != null) {
            String thisLine;
            try {
                thisLine = rd.readLine();
                if (thisLine != null) {
                    int[] thisArc = parseLine(thisLine);
                    int headNode = thisArc[0];
                    int endNode = thisArc[1];
                    int arcCost = thisArc[2];
                    if (! nodeList.containsKey(headNode)) {
                        Node node = new Node(headNode);
                        nodeList.put(headNode,node);
                    }
                    if (! nodeList.containsKey(endNode)) {
                        Node node = new Node(endNode);
                        nodeList.put(endNode,node);
                    }
                    nodeList.get(headNode).addArc(new int[]{endNode,arcCost});
                    nodeList.get(endNode).addArc(new int[]{headNode,arcCost});
                } else {
                    break;
                }
            } catch (IOException ex) {
                System.err.println("Invalid file");
            }
        }
    }

    private int[] parseLine(String str) {
        StringTokenizer stk = new StringTokenizer(str);
        int[] tuple = new int[3];
        tuple[0] = Integer.parseInt(stk.nextToken());
        tuple[1] = Integer.parseInt(stk.nextToken());
        tuple[2] = Integer.parseInt(stk.nextToken());
        return tuple;
    }

    public String toString() {
        String str = "";
        for (Node node: nodeList.values()) {
            str += node.toString() + "\n";
        }
        return str;
    }

    public Map<Integer,Node> getNodeList() {
        return nodeList;
    }

    private Map<Integer,Node> nodeList = new HashMap<Integer, Node>();
}
