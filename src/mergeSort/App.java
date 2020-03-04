package mergeSort;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[30];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000) - 500;
            System.out.print(nums[i]);
        }
        MergeSort mergeSort = new MergeSort(nums);
        mergeSort.mergeSort(0, nums.length - 1);
        mergeSort.showResult();
    }
}
