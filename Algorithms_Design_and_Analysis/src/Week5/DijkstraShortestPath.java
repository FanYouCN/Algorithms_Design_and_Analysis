package Week5;


public class DijkstraShortestPath {

    public static void main(String[] args) {
        new DijkstraShortestPath().solverProblem();
    }

    public void solverProblem() {
        DirectedLengthGraph graph = new DirectedLengthGraph(FILE_NAME);
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.dijkstraAlgorithm(graph,1);
        System.out.println(graph);
    }



    private static final String FILE_NAME = "E:/Dropbox/GitHub/Algorithms_Design_and_Analysis/Algorithms_Design_and_Analysis/src/Week5/dijkstraData.txt";

}
