package Week6;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Median {

    public static void main(String[] args) {
        new Median().solveProblem();
    }

    public void solveProblem() {
        int[] intArray = readArrayFromFile(FILE_NAME);
        System.out.println(sumMedians(intArray));
    }

    public long sumMedians(int[] intArray) {
        long sumMedian = 0;
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        PriorityQueue<Integer> right = new PriorityQueue<Integer>();
        for (int n:intArray) {
            if (left.size() == 0 || n <= left.peek()) {
                left.add(n);
            } else {
                right.add(n);
            }
            if (left.size() - right.size() == 2) {
                right.add(left.poll());
            } else if (left.size() - right.size() == -1) {
                left.add(right.poll());
            }
            sumMedian += left.peek();
        }
        return sumMedian;
    }

    private int[] readArrayFromFile(String filename){
        ArrayList<Integer> allNumbersArrayList = new ArrayList<Integer>();
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader(filename));
        } catch (IOException ex){
            System.err.println("Invalid file name.");
        }
        String thisLine;
        while (rd != null){
            try{
                if ((thisLine = rd.readLine()) != null){
                    int number = Integer.parseInt(thisLine);
                    allNumbersArrayList.add(number);
                } else break;
            } catch (IOException ex){
                System.err.println("Invalid format");
            }
        }
        int arraySize = allNumbersArrayList.size();
        int[] allNumbersArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++){
            allNumbersArray[i] = allNumbersArrayList.get(i);
        }
        return allNumbersArray;
    }

    private static final String FILE_NAME = "E:/Dropbox/GitHub/Algorithms_Design_and_Analysis/Algorithms_Design_and_Analysis/src/Week6/Median.txt";
}
