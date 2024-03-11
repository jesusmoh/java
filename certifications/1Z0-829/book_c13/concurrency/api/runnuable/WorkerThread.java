package runnuable;

class WorkerThread implements Runnable {
    private String message;

    public WorkerThread(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
        processMessage(); // Simulate some task
        System.out.println(Thread.currentThread().getName() + " (End)");
    }

    private void processMessage() {
        try {
            Thread.sleep(2000); // Simulate time-consuming task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
