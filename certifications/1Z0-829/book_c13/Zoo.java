package book_c13;

public class Zoo {

    public static void cleaningUp() {

        try {
            System.out.println("cleaning up process");
            Thread.sleep(5_000);
        } catch (Exception e) {
        } finally {
            System.out.println("cleaning up process completed");
        }

    }

    public static void main(String[] args) {
        System.out.println("1 Main method finished");
        var job = new Thread(Zoo::cleaningUp);
        job.setDaemon(true);
        job.start();

        System.out.println("2 Main method finished");
        // System.exit(0);
    }

}