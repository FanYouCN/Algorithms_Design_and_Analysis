package Week7;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Scheduling {

    public static void main(String[] args) {
        new Scheduling().solveProblemDiff();
        new Scheduling().solveProblemRatio();
    }

    public void solveProblemDiff() {
        ArrayList<int[]> jobs = readDataFromFile(FILE_NAME);
        System.out.println(scheduleDiff(jobs));
    }

    public void solveProblemRatio() {
        ArrayList<int[]> jobs = readDataFromFile(FILE_NAME);
        System.out.println(scheduleRatio(jobs));
    }

    public long scheduleDiff(ArrayList<int[]> jobs) {
        long sumProduct = 0;
        Collections.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o1[1] < o2[0] - o2[1]) {
                    return 1;
                } else if (o1[0] - o1[1] > o2[0] - o2[1]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                } else if (o1[0] > o2[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int finishTime = 0;
        for (int[] job:jobs) {
            finishTime += job[1];
            sumProduct += job[0] * finishTime;
        }
        return sumProduct;
    }

    public long scheduleRatio(ArrayList<int[]> jobs) {
        long sumProduct = 0;
        Collections.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] / (double)o1[1] < o2[0] / (double)o2[1]) {
                    return 1;
                } else if (o1[0] / (double)o1[1] > o2[0] / (double)o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int finishTime = 0;
        for (int[] job:jobs) {
            finishTime += job[1];
            sumProduct += job[0] * finishTime;
        }
        return sumProduct;
    }

    private ArrayList<int[]> readDataFromFile(String fileName) {
        ArrayList<int[]> jobs = new ArrayList<int[]>();
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
                    int[] tuple = parseTuple(thisLine);
                    jobs.add(tuple);
                } else {
                    break;
                }
            } catch (IOException ex) {
                System.err.println("Invalid file");
            }
        }
        return jobs;
    }

    private int[] parseTuple(String str) {
        int[] tuple = new int[2];
        StringTokenizer stk = new StringTokenizer(str," ");
        tuple[0] = Integer.parseInt(stk.nextToken());
        tuple[1] = Integer.parseInt(stk.nextToken());
        return tuple;
    }






    private static final String FILE_NAME = "E:/Dropbox/GitHub/Algorithms_Design_and_Analysis/Algorithms_Design_and_Analysis/src/Week7/jobs.txt";

}
