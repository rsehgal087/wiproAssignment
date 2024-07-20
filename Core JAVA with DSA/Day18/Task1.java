package Day18;

public class Task1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter());
        Thread thread2 = new Thread(new NumberPrinter());

        thread1.start();
        thread2.start();
    }
}

class NumberPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

