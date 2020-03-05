package forkJoinPool2;

import forkJoinPool.RecursiveAction;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {
    private int work;

    public SimpleRecursiveTask(int work) {
        this.work = work;
    }

    @Override
    protected Integer compute() {
        if (work > 100) {
            System.out.println("Starting splitting tasks!!!" + work);
            SimpleRecursiveTask simpleRecursiveTask = new SimpleRecursiveTask(work /2);
            SimpleRecursiveTask simpleRecursiveTask1 = new SimpleRecursiveTask(work /2);

            simpleRecursiveTask.fork();
            simpleRecursiveTask1.fork();
            int solution = 0;
            solution += simpleRecursiveTask.join();
            solution += simpleRecursiveTask1.join();
            return solution;
        } else {
            System.out.println(" ok " + work);
            return work;
        }
    }
}
