package Week3;

import java.util.ArrayList;

public class Vertex {

    public Vertex(ArrayList<Integer> arrayList){
        vertex = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            edgesList.add(arrayList.get(i));
        }
    }


    public int getVertex() {
        return vertex;
    }



    public void replace(int u, int v) {
        for (int i = 0; i < edgesList.size(); i ++) {
            if (edgesList.get(i) == v) {
                edgesList.set(i,u);
            }
        }
    }

    public String toString() {
        return "v" + Integer.toString(vertex);
    }

    private int vertex;
    private ArrayList<Integer> edgesList = new ArrayList<Integer>();

}