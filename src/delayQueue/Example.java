package delayQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Example {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayedWorker> blockingQueue = new DelayQueue<>();
        blockingQueue.put(new DelayedWorker(1000, "This is the first message"));
        blockingQueue.put(new DelayedWorker(2000, "This is the second message"));
        blockingQueue.put(new DelayedWorker(4000, "This is the third message"));

        while (!blockingQueue.isEmpty()) {
            System.out.println(blockingQueue.take().getMessage());
        }
    }
}

class DelayedWorker implements Delayed {
    private long duration;
    private String message;

    public DelayedWorker(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed otherDelayed) {
        return Long.compare(duration, ((DelayedWorker) otherDelayed).duration);
    }

    public long getDuration() {
        return duration;
    }

    public String getMessage() {
        return message;
    }
}
