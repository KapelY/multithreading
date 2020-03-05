package forkJoinPool3;

public class SequentialMaxFinding {
    public int sequentialMaxFinding(int[] nums, int highIndex) {

        int max = nums[0];

        for (int i = 0; i < highIndex; ++i)
            if (nums[i] > max)
                max = nums[i];

        return max;
    }
}
