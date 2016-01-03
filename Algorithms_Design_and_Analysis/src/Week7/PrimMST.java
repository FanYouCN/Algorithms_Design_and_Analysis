package Week7;



public class PrimMST {

    public static void main(String[] args) {
        new PrimMST().solveProblem();
    }

    public void solveProblem() {
        GraphWithCost graph = new GraphWithCost(FILE_NAME);
        PrimAlgorithm primSolver = new PrimAlgorithm();
        System.out.println(primSolver.primAlgorithm(graph));
    }


    private static final String FILE_NAME = "E:/Dropbox/GitHub/Algorithms_Design_and_Analysis/Algorithms_Design_and_Analysis/src/Week7/edges.txt";
}
