package Week3;



public class KargerMinCut {

    public static void main(String[] args) {
        new KargerMinCut().test();
    }

    public void test() {
        Graph graph = new Graph(FILE_NAME);
        int minCut = kargerMinCut(graph);
        System.out.println(minCut);
    }

    public int randomContraction(Graph graph) {
        while (graph.getSize() > 2) {
            Edge edge = graph.chooseRandomEdge();
            graph.contractVertices(edge);
        }
        return graph.getEdgeNum();
    }


    public int kargerMinCut(Graph graph) {
        int inputSize = graph.getSize();
        int numIter = (int)(inputSize * inputSize * Math.log(inputSize));
        int minCut = numIter;
        while (numIter >0 ) {
            System.out.println(numIter);
            Graph tempGraph = new Graph(FILE_NAME);
            int tempMinCut = randomContraction(tempGraph);
                    if (tempMinCut < minCut) {
                minCut = tempMinCut;
            }
            numIter -= 1;
        }
        return minCut;
    }

    private static final String FILE_NAME = "E:/Dropbox/GitHub/Algorithms_Design_and_Analysis/Algorithms_Design_and_Analysis/src/Week3/kargerMinCut.txt";
}
