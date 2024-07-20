package Day18;

import java.util.LinkedList;
import java.util.Queue;

public class Task3 {
    public static void main(String[] args) {
        final Queue<Integer> sharedQueue = new LinkedList<>();
        final int MAX_SIZE = 5;
        
        Thread producer = new Thread(new Producer(sharedQueue, MAX_SIZE));
        Thread consumer = new Thread(new Consumer(sharedQueue, MAX_SIZE));
        
        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {
    private final Queue<Integer> sharedQueue;
    private final int MAX_SIZE;

    public Producer(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.MAX_SIZE = size;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == MAX_SIZE) {
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sharedQueue.add(value);
                System.out.println("Produced: " + value);
                value++;
                sharedQueue.notify();
            }
        }
    }
}

class Consumer implements Runnable {
    private final Queue<Integer> sharedQueue;
    private final int MAX_SIZE;

    public Consumer(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.MAX_SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                while (sharedQueue.isEmpty()) {
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int value = sharedQueue.poll();
                System.out.println("Consumed: " + value);
                sharedQueue.notify();
            }
        }
    }
}
