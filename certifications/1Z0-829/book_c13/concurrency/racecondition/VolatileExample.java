
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileExample {
    private final ReentrantLock lock = new ReentrantLock();

    private volatile int sharedVariable = 0;
    private AtomicInteger atomicSharedVariable = new AtomicInteger(0);// with atomic you don't need sincronized
    private long sharedVariable2 = 0;
    private int sharedResource3 = 0;

    public void performTask() {
        lock.lock();
        try {
            sharedResource3++;
            System.out.println("Task performed by Thread: " + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }

    public int getSharedResource() {
        return sharedResource3;
    }

    public synchronized void incrementSharedVariable2() {
        sharedVariable++;
    }

    public synchronized int getSharedVariable2() {
        return sharedVariable;
    }

    public void incrementSharedVariable() {
        sharedVariable2++; // Not thread-safe due to lack of atomicity
    }

    public void incrementAtomicSharedVariable() {
        atomicSharedVariable.getAndIncrement(); // Atomic operation
    }

    public int getSharedVariable() {
        return sharedVariable;
    }

    public int getAtomicSharedVariable() {
        return atomicSharedVariable.get();
    }

    public static void main(String[] args) {

    }
}
