package priorityBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Example {
    public static void main(String[] args) {
        BlockingQueue<String> bc =new PriorityBlockingQueue<>();
        new Thread(new FirstWorker(bc)).start();
        new Thread(new SecondWorker(bc)).start();
    }
}

class FirstWorker implements Runnable {
    private BlockingQueue<String> blockingQueue;

    public FirstWorker(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.put("F");
            blockingQueue.put("E");
            blockingQueue.put("D");
            Thread.sleep(1000);
            blockingQueue.put("C");
            Thread.sleep(1000);
            blockingQueue.put("B");
            blockingQueue.put("A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class SecondWorker implements Runnable {
    private BlockingQueue<String> blockingQueue;

    public SecondWorker(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println( blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
