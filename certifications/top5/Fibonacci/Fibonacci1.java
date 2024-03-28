package Fibonacci;

public class Fibonacci1 {
    public static void main(String[] args) {

        System.out.print("Enter the number of terms: ");
        int n = 9;

        int first = 0, second = 1;
        System.out.print("Fibonacci Series up to " + n + " terms: ");

        for (int i = 1; i <= n; ++i) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }

    }
}