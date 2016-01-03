package Week7;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Node {

    public Node(int node) {
        this.node = node;
    }


    public int getNode() {
        return node;
    }

    public Set<int[]> getArcs() {
        return arcs;
    }

    public void addArc(int[] arc) {
        arcs.add(arc);
    }

    public void setScore(int length) {
        score = length;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        String str = "";
        str += "Node: " + node + ", Arcs: ";
        for (int[] arc: arcs) {
            str += Arrays.toString(arc);
        }
        return str;
    }

    private int node;
    private Set<int[]> arcs = new HashSet<int[]>();
    private int score = 9999999;
}
