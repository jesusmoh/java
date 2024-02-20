package book_c7.polimorfismo;

// Interface defining a shape
interface Shape {
    void draw();
}

// Circle class implementing the Shape interface
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

// Square class implementing the Shape interface
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

public class Main {
    public static void main(String[] args) {
        // Polymorphism without inheritance using interfaces
        Shape shape1 = new Circle();
        Shape shape2 = new Square();

        // Calling draw method on different shapes
        shape1.draw();
        shape2.draw();
    }
}
