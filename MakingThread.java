
Thread:In Java, a thread is an independent path of execution within a program. 
       It allows multiple tasks to run concurrently, enabling the program to perform several operations at the same time.

  ## Java has Six(6) life Cycle:
      1.New borne
      2.Runnable
      3.Ruuning active
      4.Blocked state
      5.Witing or Closing state
      6.Terminated or Dead state

# Making a thread in java in Two ways:
  1.By extending the Thread class
  2.By implementing the Runnable interface

BY EXTENDING THE THREAD CLASS:
  class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running.");
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();  // Starts the thread, which internally calls run()
    }
}

BY IMPLEMENTING THE RUNNABLE INTERFACE
  class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread is running.");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();  // Starts the thread
    }
}

#THREAD EXAMPLE:
  public class ThreadStateExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000); // Thread.sleep() => Timed Waiting state
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("State after creation: " + t.getState()); // NEW
        t.start();
        System.out.println("State after start: " + t.getState()); // RUNNABLE or RUNNING

        Thread.sleep(500);
        System.out.println("State after sleep(500ms): " + t.getState()); // TIMED_WAITING

        t.join();
        System.out.println("State after thread completion: " + t.getState()); // TERMINATED
    }
}

