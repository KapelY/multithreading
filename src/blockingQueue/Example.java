package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

class FirstWorker implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public FirstWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int number = 0;
        while (true) {
            try {
                number = blockingQueue.take();
                System.out.println("Taking number" + number);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class SecondWorker implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public SecondWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                blockingQueue.put(counter);
                System.out.println("Putting number" + counter++);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class Example {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        FirstWorker firstWorker = new FirstWorker(blockingQueue);
        SecondWorker secondWorker = new SecondWorker(blockingQueue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }
}
