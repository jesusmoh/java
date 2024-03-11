
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionExample {
    public static void main(String[] args) {
        // Checked Exception (FileNotFoundException)
        try {
            File file = new File("example.txt");
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception: " + e.getMessage());
        }

        // Unchecked Exception (ArithmeticException)
        try {
            int result = 10 / 0; // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception: " + e.getMessage());
        }

        // Error (StackOverflowError)
        try {
            recursiveMethod();
        } catch (StackOverflowError e) {
            System.out.println("Stack overflow error: " + e.getMessage());
        }
    }

    public static void recursiveMethod() {
        recursiveMethod();
    }
}