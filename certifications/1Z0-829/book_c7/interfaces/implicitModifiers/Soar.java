public interface Soar {

    int MAX_HEIGHT = 10;

    final static boolean UNDERWATER = true;

    void fly(int spedd);

    abstract void takeoff();

    public abstract double dive();

    // When compile the class some value are auto-injec

    // int MAX_HEIGHT = 10; ->> public static final

    // final static boolean UNDERWATER = true; ->> public

    // void fly(int spedd); -->> public abstrac

    // abstract void takeoff(); -->> public

    // public abstract double dive(); -->>
}
