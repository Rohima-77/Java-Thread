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
