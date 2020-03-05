package mergeSort;

import java.util.Arrays;
import java.util.Random;

public class App {
    public static Random random = new Random();

    public static void main(String[] args) {
        int numOfCores = Runtime.getRuntime().availableProcessors();

        int[] numbers = createRandomArray();
        int[] tempNumbers = numbers.clone();
        MergeSort mergeSort = new MergeSort(tempNumbers);

        //System.out.println(Arrays.toString(tempNumbers));
        long startTime1 = System.currentTimeMillis();
        mergeSort.parallelMergeSort(0, tempNumbers.length-1, numOfCores);
        long endTime1 = System.currentTimeMillis();

        System.out.printf("Time taken for 100 000 000 elements parallel =>  %6d ms \n", endTime1 - startTime1);
        //System.out.println(Arrays.toString(tempNumbers)+"\n");

        tempNumbers = numbers.clone();
        mergeSort = new MergeSort(tempNumbers);
        //System.out.println(Arrays.toString(tempNumbers));
        startTime1 = System.currentTimeMillis();
        mergeSort.mergeSort(0,tempNumbers.length-1);
        endTime1 = System.currentTimeMillis();

        System.out.printf("Time taken for 100 000 000 elements sequential =>  %6d ms \n", endTime1 - startTime1);
        //System.out.println(Arrays.toString(tempNumbers));
    }

    public static int[] createRandomArray() {
        int[] a = new int[100000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10000);
        }
        return a;
    }
}
