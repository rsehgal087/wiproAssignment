package Day18;

public class Task7 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        
        Thread t1 = new Thread(new CounterUser(counter));
        Thread t2 = new Thread(new CounterUser(counter));
        
        t1.start();
        t2.start();
        
        ImmutableData data = new ImmutableData("Immutable Data Example");
        System.out.println(data.getData());
    }
}

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("Incremented: " + count);
    }

    public synchronized void decrement() {
        count--;
        System.out.println("Decremented: " + count);
    }
}

class CounterUser implements Runnable {
    private final Counter counter;

    public CounterUser(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
            counter.decrement();
        }
    }
}

final class ImmutableData {
    private final String data;

    public ImmutableData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

