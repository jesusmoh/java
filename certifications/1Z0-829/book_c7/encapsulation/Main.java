package book_c7.encapsulation;

//In Java, an anonymous class is a local class without a name

public class Main {
    public static void main(String[] args) {
        // Creating an anonymous class that implements the Runnable interface
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is a runnable task.");
            }
        };

        // Anonymous classes are useful when you need to create a class that is used
        // only once and does not need to be reused.

        // Using the anonymous class
        Thread myThread = new Thread(myRunnable);
        myThread.start();
    }
}
