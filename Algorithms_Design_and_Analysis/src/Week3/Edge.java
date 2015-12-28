package Week3;

public class Edge {

    public Edge(int u, int v) {
        edge[0] = u;
        edge[1] = v;
    }

    public int[] getEdge() {
        return edge;
    }

    public void replace(int u, int v) {
        if (edge[0] == v) {
            edge[0] = u;
        } else if (edge[1] == v) {
            edge[1] = u;
        }
    }

    public boolean selfLoop() {
        return (edge[0] == edge[1]);
    }

    public String toString() {
        return "(" + Integer.toString(edge[0]) + "," + Integer.toString(edge[1]) + ")";
    }

    private int[] edge = new int[2];
}
