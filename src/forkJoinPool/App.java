package forkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        ForkJoinPool joinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        RecursiveAction recursiveAction = new RecursiveAction(1600);
        joinPool.invoke(recursiveAction);

        try {
            joinPool.awaitTermination(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
