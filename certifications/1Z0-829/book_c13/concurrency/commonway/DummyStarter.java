public class DummyStarter {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t = new Thread(mr);
        t.start();
        MyThread mt = new MyThread();
        mt.start();
    }
}
