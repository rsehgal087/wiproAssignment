package Day18;

public class Task2 {
    public static void main(String[] args) {
        ThreadLifecycle thread = new ThreadLifecycle();
        Thread t = new Thread(thread);
        
        System.out.println("Thread state after creation: " + t.getState());
        
        t.start();
        System.out.println("Thread state after start: " + t.getState());

        try {
            Thread.sleep(100); // Let the thread run
            System.out.println("Thread state during run: " + t.getState());

            synchronized (thread) {
                thread.wait(1000);
                System.out.println("Thread state after wait: " + t.getState());
            }

            t.join();
            System.out.println("Thread state after termination: " + t.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadLifecycle implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(500);
                this.wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

