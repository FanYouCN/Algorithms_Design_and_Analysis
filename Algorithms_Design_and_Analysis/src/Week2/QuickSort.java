package Week2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        new QuickSort().solveProblem();
    }

    private void solveProblem(){
        int[] integerArray = readArrayFromFile(FILE_NAME);
        int numSwap = quickSort(integerArray);
        System.out.println(Arrays.toString(integerArray));
        System.out.println(numSwap);
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

    private int quickSort(int[] intArray){
        int inputSize = intArray.length;
        int numSwap = inputSize - 1;
        if (inputSize != 1) {
            int pivotIndex = partition(intArray);
            int[] leftArray;
            int[] rightArray;
            if (pivotIndex == 0){
                rightArray = Arrays.copyOfRange(intArray,1,inputSize);
                numSwap += quickSort(rightArray);
                System.arraycopy(rightArray,0,intArray,1,rightArray.length);
            } else if (pivotIndex == inputSize - 1){
                leftArray = Arrays.copyOfRange(intArray,0,inputSize - 1);
                numSwap += quickSort(leftArray);
                System.arraycopy(leftArray,0,intArray,0,leftArray.length);
            } else {
                leftArray = Arrays.copyOfRange(intArray,0,pivotIndex);
                rightArray = Arrays.copyOfRange(intArray,pivotIndex + 1,inputSize);
                numSwap += quickSort(leftArray);
                numSwap += quickSort(rightArray);
                System.arraycopy(leftArray,0,intArray,0,leftArray.length);
                System.arraycopy(rightArray,0,intArray,pivotIndex + 1,rightArray.length);
            }
        }
        return numSwap;
    }

    private int partition(int[] array){
        int inputSize = array.length;
        int pivot = array[0];
        int i = 1;
        for (int j = 1; j < inputSize; j++){
            if (array[j] < pivot){
                swap(array,i++,j);
            }
        }
        swap(array,0,i - 1);
        return i - 1;
    }
    private void swap(int[] array, int indexI,int indexJ){
        if (indexI != indexJ){
            int temp = array[indexI];
            array[indexI] = array[indexJ];
            array[indexJ] = temp;
        }
    }




    private static final String FILE_NAME = "E:/Dropbox/GitHub/Algorithms_Design_and_Analysis/Algorithms_Design_and_Analysis/src/Week2/QuickSort.txt";
}
