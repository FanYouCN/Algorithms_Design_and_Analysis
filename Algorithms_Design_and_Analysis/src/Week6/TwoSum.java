package Week6;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TwoSum {

    public static void main(String[] args) {
        new TwoSum().solveProblem();
    }

    public void solveProblem() {
        long[] longIntArray = readArrayFromFile(FILE_NAME);
        System.out.println(countTwoSum(-10000,10000,longIntArray));
    }

    public int countTwoSum(int lowerBound,int upperBound,long[] intArray) {
        int count = 0;
        Set<Long> processed = new HashSet<Long>();
        Set<Integer> targets = new HashSet<Integer>();
        for (int target = lowerBound;target <= upperBound; target++) targets.add(target);
        for (Long n:intArray) {
            Iterator<Integer> iterator = targets.iterator();
            while (iterator.hasNext()) {
                int target = iterator.next();
                if (processed.contains(target - n) && (n != target - n)) {
                    count += 1;
                    iterator.remove();
                }
            }
            processed.add(n);
            System.out.println(processed.size());
        }
        return count;
    }

    private long[] readArrayFromFile(String filename){
        ArrayList<Long> allNumbersArrayList = new ArrayList<Long>();
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
                    long number = Long.parseLong(thisLine);
                    allNumbersArrayList.add(number);
                } else break;
            } catch (IOException ex){
                System.err.println("Invalid format");
            }
        }
        int arraySize = allNumbersArrayList.size();
        long[] allNumbersArray = new long[arraySize];
        for (int i = 0; i < arraySize; i++){
            allNumbersArray[i] = allNumbersArrayList.get(i);
        }
        return allNumbersArray;
    }



    private static final String FILE_NAME = "E:/Dropbox/GitHub/Algorithms_Design_and_Analysis/Algorithms_Design_and_Analysis/src/Week6/2sum.txt";
}
