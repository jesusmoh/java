package book_c6;

// Subclass of Vehicle in the same package
public class Car extends Vehicle {
    // Constructor
    public Car(String engineType) {
        super(engineType);
    }

    // Accessing the protected variable from the superclass
    public String getEngineType() {
        return this.engineType;
    }
}
