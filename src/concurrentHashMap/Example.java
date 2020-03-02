package concurrentHashMap;

import java.util.concurrent.ConcurrentMap;

public class Example {
    public static void main(String[] args) {

    }
}

class FirstWorker implements Runnable {
    private ConcurrentMap<String, Integer> map;

    public FirstWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {

    }
}
