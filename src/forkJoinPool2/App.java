package forkJoinPool2;

import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        ForkJoinPool joinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveTask task = new SimpleRecursiveTask(300000);
        System.out.println(joinPool.invoke(task));

    }
}
