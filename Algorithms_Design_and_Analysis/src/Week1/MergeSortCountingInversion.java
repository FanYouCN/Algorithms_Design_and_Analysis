package Week1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortCountingInversion {
    public static void main(String[] args) {
        new MergeSortCountingInversion().solveProblem();
    }

    private void solveProblem(){
        int[] integerArray = readArrayFromFile(FILE_NAME);
        int[] sortedArray = mergeSort(integerArray);
        System.out.println(Arrays.toString(sortedArray));
        System.out.println(numInversion);
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

    public int[] mergeSort(int[] inputArray){
        int inputSize = inputArray.length;
        int midIndex = inputSize / 2;
        if (inputSize <= 1){
            return inputArray;
        } else {
            int[] sortedArray = new int[inputSize];
            int[] firstHalfArray = Arrays.copyOfRange(inputArray,0,midIndex);
            int[] secondHalfArray = Arrays.copyOfRange(inputArray,midIndex,inputSize);
            int[] sortedFirst = mergeSort(firstHalfArray);
            int[] sortedSecond = mergeSort(secondHalfArray);
            for (int i = 0; i < inputSize; i++){
                if (sortedFirst == null){
                    if(sortedSecond != null){
                        sortedArray[i] = sortedSecond[0];
                        sortedSecond = delFirstElement(sortedSecond);
                    }
                } else if (sortedSecond == null){
                    sortedArray[i] = sortedFirst[0];
                    sortedFirst = delFirstElement(sortedFirst);
                } else if (sortedFirst[0] < sortedSecond[0]){
                    sortedArray[i] = sortedFirst[0];
                    sortedFirst = delFirstElement(sortedFirst);
                } else {
                    sortedArray[i] = sortedSecond[0];
                    sortedSecond = delFirstElement(sortedSecond);
                    numInversion += sortedFirst.length;
                }

            }
            return sortedArray;
        }
    }

    private int[] delFirstElement(int[] array){
        if (array.length == 1) return null;
        else return Arrays.copyOfRange(array,1,array.length);
    }

    private long numInversion = 0;

    private static final String FILE_NAME = "E:/Dropbox/GitHub/Algorithms_Design_and_Analysis/Algorithms_Design_and_Analysis/src/Week1/IntegerArray.txt";
}


