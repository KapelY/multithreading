package forkJoinPool3;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFinding extends RecursiveTask<Integer> {

    private int[] nums;
    private int lowIndex;
    private int highIndex;

    public ParallelMaxFinding(int[] nums, int lowIndex, int highIndex) {
        this.nums = nums;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    private int sequentialMaxFind() {
        int max = nums[lowIndex];

        for (int i = lowIndex; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    @Override
    protected Integer compute() {
        if (highIndex - lowIndex <= App.THRESHOLD) {
            return sequentialMaxFind();
        } else {
            int middleIndex = (lowIndex + highIndex) >> 1;

            ParallelMaxFinding parallelMaxFinding1 = new ParallelMaxFinding(nums, lowIndex, middleIndex);
            ParallelMaxFinding parallelMaxFinding2 = new ParallelMaxFinding(nums, middleIndex + 1, highIndex);

            invokeAll(parallelMaxFinding1, parallelMaxFinding2);

            return Math.max(parallelMaxFinding1.join(), parallelMaxFinding2.join());
        }
    }
}
