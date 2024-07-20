package Day18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Task());
        }

        executorService.shutdown();
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is performing a task.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

