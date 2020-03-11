package forkJoinPool3;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {
    public static int THRESHOLD = 0;

    public static void main(String[] args) {
        int[] nums = initNums();
        THRESHOLD = nums.length / Runtime.getRuntime().availableProcessors();

        SequentialMaxFinding sequentialMaxFinding = new SequentialMaxFinding();

        System.out.println(Arrays.toString(nums));
        long start = System.currentTimeMillis();
        System.out.println("Sequential max : " + sequentialMaxFinding.sequentialMaxFinding(nums, nums.length-1));
        System.out.println("Time taken : " + (System.currentTimeMillis() - start));

        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ParallelMaxFinding parallelMaxFinding = new ParallelMaxFinding(nums, 0, nums.length-1);

        start = System.currentTimeMillis();
        System.out.println("Parallel max : " + forkJoinPool.invoke(parallelMaxFinding));
        System.out.println("Time taken : " + (System.currentTimeMillis() - start));

    }

    private static int[] initNums() {
        return new Random().ints(3, 50, 100).toArray();
    }
}
