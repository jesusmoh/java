package book_c8.funtionalInterfaces.primitives;

@FunctionalInterface
interface IntBinaryOperator {
    int operate(int a, int b);
}

public class FunctionalInterfaceWithPrimitivesExample {
    public static void main(String[] args) {
        // Define a lambda expression to implement the IntBinaryOperator interface
        IntBinaryOperator addition = (a, b) -> a + b;

        // Perform addition operation using the lambda expression
        int result = performOperation(10, 20, addition);
        System.out.println("Result of addition: " + result);
    }

    // Method to apply the IntBinaryOperator on two integer operands
    public static int performOperation(int operand1, int operand2, IntBinaryOperator operator) {
        return operator.operate(operand1, operand2);
    }
}
